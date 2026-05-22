/* ESTRATEGIA:
   Se usa una ColaPrioridadTDA para guardar los pares clave-valor.
   La clave se guarda como el valor acolado y el valor asociado se guarda como prioridad.
   Para agregar se recorre la cola buscando la clave. Los elementos que se desacolan durante la busqueda se guardan en una cola auxiliar.
   Si la clave se encuentra, se elimina. Luego se agrega el nuevo par clave-valor.
   Finalmente se vuelven a acolar en la cola original los elementos guardados en la cola auxiliar.
   Para eliminar se realiza una busqueda similar: se pasan los elementos previos a una cola auxiliar, se elimina la clave si se encuentra y despues se restaura la cola original.
   Para recuperar se busca la clave pasando temporalmente elementos a una cola auxiliar, se toma el valor asociado a la prioridad y luego se restaura la cola.
   Para obtener las claves se recorren todos los elementos de la cola, se agregan las claves a un conjunto y se reconstruye la cola original con una auxiliar.
*/

import imple.ColaPrioridad;
import imple.Conjunto;
import tda.ColaPrioridadTDA;
import tda.ConjuntoTDA;
import tda.DiccionarioSimpleTDA;

public class DiccionarioSimpleConColaPrioridad implements DiccionarioSimpleTDA {

    ColaPrioridadTDA cola;

    @Override
    public void inicializarDiccionario() { // Complejidad constante
        cola = new ColaPrioridad();
        cola.inicializarCola();
    }

    @Override
    public void agregar(int clave, int valor) { // Complejidad polinomica
        ColaPrioridadTDA aux = new ColaPrioridad();
        aux.inicializarCola();
        // Busco la clave y voy guardando lo que elimino para agregarlo despues
        while(!cola.colaVacia() && cola.primero() != clave){
            aux.acolarPrioridad(cola.primero(), cola.prioridad());
            cola.desacolar();
        }
        // Si encontre la clave, la elimino
        if(!cola.colaVacia()){
            cola.desacolar();
        }
        // Haya encontrado o no la clave, agrego la nueva clave-valor
        cola.acolarPrioridad(clave, valor);
        // Vuelvo a agregar lo que elimine en la cola original
        while(!aux.colaVacia()){
            cola.acolarPrioridad(aux.primero(), aux.prioridad());
            aux.desacolar();
        }
    }


    @Override
    public void eliminar(int clave) { // Complejidad polinomica
        ColaPrioridadTDA aux = new ColaPrioridad();
        aux.inicializarCola(); 
        // Busco la clave y voy guardando lo que elimino para agregarlo despues
        while(!cola.colaVacia() && cola.primero() != clave){
            aux.acolarPrioridad(cola.primero(), cola.prioridad());
            cola.desacolar();
        }
        // Si encontre la clave, la elimino
        if(!cola.colaVacia()){
            cola.desacolar();
        }
        // Vuelvo a agregar lo que elimine en la cola original
        while(!aux.colaVacia()){
            cola.acolarPrioridad(aux.primero(), aux.prioridad());
            aux.desacolar();
        }
    }

    @Override
    public ConjuntoTDA claves() { // Complejidad polinomica
        ConjuntoTDA claves = new Conjunto();
        claves.inicializarConjunto();
        ColaPrioridadTDA aux = new ColaPrioridad();
        aux.inicializarCola();
        while(!cola.colaVacia()){
            claves.agregar(cola.primero());
            aux.acolarPrioridad(cola.primero(), cola.prioridad());
            cola.desacolar();
        }
        while(!aux.colaVacia()){
            cola.acolarPrioridad(aux.primero(), aux.prioridad());
            aux.desacolar();
        }
        return claves;
    }

    @Override
    public int recuperar(int clave) { // Complejidad polinomica
        ColaPrioridadTDA aux = new ColaPrioridad();
        aux.inicializarCola(); 
        // Busco la clave
        while(!cola.colaVacia() && cola.primero() != clave){
            aux.acolarPrioridad(cola.primero(), cola.prioridad());
            cola.desacolar();
        }
        // Guardo el valor a recuperar, asumiendo que existe
        int valor = cola.prioridad();
        // Vuelvo a agregar lo que elimine en la cola original
        while(!aux.colaVacia()){
            cola.acolarPrioridad(aux.primero(), aux.prioridad());
            aux.desacolar();
        }
        return valor;
    }

}
