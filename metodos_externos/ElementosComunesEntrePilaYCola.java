package metodos_externos;

import imple.Cola;
import imple.Conjunto;
import imple.Pila;
import tda.ColaTDA;
import tda.ConjuntoTDA;
import tda.PilaTDA;

/* ESTRATEGIA:
   Se buscan los elementos que aparecen tanto en la pila como en la cola.
   Primero se recorre la cola y se guardan sus valores en un conjunto auxiliar.
   Mientras se recorre la cola, tambien se guardan sus valores en una cola auxiliar para poder reconstruirla al final.
   Luego se recorre la pila. Por cada valor de la pila, se consulta si pertenece al conjunto de los valores de la cola.
   Si pertenece, se agrega al conjunto de comunes.
   Como el resultado es un conjunto, cada valor comun queda guardado una sola vez aunque aparezca repetido.
   Mientras se recorre la pila, tambien se guardan sus valores en una pila auxiliar para poder reconstruirla al final.
   Finalmente se restauran la pila y la cola originales usando sus estructuras auxiliares.
*/

public class ElementosComunesEntrePilaYCola { 

    public ConjuntoTDA elementosComunesEntrePilaYCola(PilaTDA pila, ColaTDA cola){ // COMPLEJIDAD POLINOMICA
        ConjuntoTDA comunes = new Conjunto();
        PilaTDA pilaAux = new Pila();
        ColaTDA colaAux = new Cola();
        ConjuntoTDA conjCola = new Conjunto();
        comunes.inicializarConjunto();
        pilaAux.inicializarPila();
        colaAux.inicializarCola();
        conjCola.inicializarConjunto();

        // Pasamos los elementos de la cola a un conjunto
        while(!cola.colaVacia()){
            conjCola.agregar(cola.primero());
            colaAux.acolar(cola.primero());
            cola.desacolar();
        }
        // Recorremos la pila 
        while(!pila.pilaVacia()){
            int valor = pila.tope();
            // Si hay elemento en comun, se lo guarda
            if(conjCola.pertenece(valor)){
                comunes.agregar(valor);
            }
            pilaAux.apilar(valor);
            pila.desapilar();
        }
        // Volvemos a llenar la pila original
        while(!pilaAux.pilaVacia()){
            pila.apilar(pilaAux.tope());
            pilaAux.desapilar();
        }
        // Volvemos a llenar la cola original
        while(!colaAux.colaVacia()){
            cola.acolar(colaAux.primero());
            colaAux.desacolar();
        }
        return comunes;
    }
}
