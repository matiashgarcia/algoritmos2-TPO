package metodos_externos;
import imple.Conjunto;
import imple.Pila;
import tda.ConjuntoTDA;
import tda.PilaTDA;

/* ESTRATEGIA:
   Se recorre la pila recibida para detectar que elementos aparecen mas de una vez.
   Se usa un conjunto auxiliar llamados vistos para guardar los valores que ya aparecieron al menos una vez.
   Se usa otro conjunto llamado repetidos para guardar los valores que vuelven a aparecer.
   Como los conjuntos no permiten repetidos, si un valor aparece mas de dos veces queda guardado una sola vez en el conjunto de repetidos.
   Como para recorrer la pila es necesario desapilarla, cada valor se guarda tambien en una pila auxiliar.
   Al finalizar el recorrido, se reconstruye la pila original desapilando la auxiliar y apilando nuevamente en la pila recibida.
*/

public class Ejercicio7 {
    
    public ConjuntoTDA elementosRepetidosEnPila(PilaTDA pila){ // COMPLEJIDAD POLINOMICA
        ConjuntoTDA vistos = new Conjunto();
        vistos.inicializarConjunto();
        ConjuntoTDA repetidos = new Conjunto();
        repetidos.inicializarConjunto();
        PilaTDA aux = new Pila();
        aux.inicializarPila();
        // Recorro pila
        while(!pila.pilaVacia()){
            int valor = pila.tope();
            if(vistos.pertenece(valor)){
                repetidos.agregar(valor);
            }
            else{
                vistos.agregar(valor);
            }
            aux.apilar(valor);
            pila.desapilar();
        }
        // Vuelvo a llenar la pila original
        while(!aux.pilaVacia()){
            pila.apilar(aux.tope());
            aux.desapilar();
        }
        return repetidos;
    }

}
