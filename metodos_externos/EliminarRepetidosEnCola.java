package metodos_externos;

import imple.Cola;
import imple.Conjunto;
import tda.ColaTDA;
import tda.ConjuntoTDA;

/* ESTRATEGIA:
   Se recorre la cola recibida para construir una nueva cola sin elementos repetidos.
   Se usa un conjunto auxiliar para guardar los valores que ya fueron encontrados.
   Si el valor actual todavia no pertenece al conjunto, se agrega a la cola resultado y tambien al conjunto.
   Si el valor ya pertenece al conjunto, no se agrega a la cola resultado.
   Como para recorrer la cola es necesario desacolarla, cada valor tambien se guarda en una cola auxiliar.
   Al finalizar el recorrido, se reconstruye la cola original pasando nuevamente los valores desde la cola auxiliar.
   La cola resultado conserva el orden de la primera aparicion de cada elemento.
*/

public class EliminarRepetidosEnCola {

    public ColaTDA eliminarRepetidosEnCola(ColaTDA cola) { // COMPLEJIDAD POLINOMICA
        ColaTDA aux = new Cola();
        aux.inicializarCola();
        ColaTDA resultado = new Cola();
        resultado.inicializarCola();
        ConjuntoTDA repetidos = new Conjunto();
        repetidos.inicializarConjunto();
        // Recorro la cola
        while (!cola.colaVacia()) {
            int valor = cola.primero();
            if (!repetidos.pertenece(valor)) {
                resultado.acolar(valor);
                repetidos.agregar(valor);
            }
            aux.acolar(valor);
            cola.desacolar();
        }
        // Vuelvo a llenar la cola original
        while (!aux.colaVacia()) {
            cola.acolar(aux.primero());
            aux.desacolar();
        }
        return resultado;
    }

}
