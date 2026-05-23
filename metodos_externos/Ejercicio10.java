package metodos_externos;

/* ESTRATEGIA:
   Se recorre la pila recibida para construir un diccionario simple donde cada clave es un valor de la pila.
   El valor asociado a cada clave representa la cantidad de veces que ese numero aparece en la pila.
   Se usa un conjunto auxiliar de claves visitadas para saber si un valor ya fue agregado al diccionario.
   Si la clave ya fue visitada, se recupera su valor actual en el diccionario y se actualiza sumando una aparicion.
   Si la clave aparece por primera vez, se agrega al conjunto de visitadas y se guarda en el diccionario con valor 1.
   Como para recorrer la pila es necesario desapilarla, cada valor tambien se guarda en una pila auxiliar.
   Al finalizar el recorrido, se reconstruye la pila original desapilando la auxiliar y apilando nuevamente en la pila recibida.
*/

import imple.Conjunto;
import imple.DiccionarioSimple;
import imple.Pila;
import tda.ConjuntoTDA;
import tda.DiccionarioSimpleTDA;
import tda.PilaTDA;

public class Ejercicio10 {

    public DiccionarioSimpleTDA diccionarioSimpleAPartirDePila(PilaTDA pila){ // COMPLEJIDAD POLINOMICA
        DiccionarioSimpleTDA resultado = new DiccionarioSimple();
        resultado.inicializarDiccionario();
        PilaTDA aux = new Pila();
        aux.inicializarPila();
        ConjuntoTDA clavesVisitadas = new Conjunto();
        clavesVisitadas.inicializarConjunto();

        // Se recorre la pila
        while(!pila.pilaVacia()){
            int clave = pila.tope();
            // Si la clave ya existe, recupero el valor y sumo una aparicion mas
            if(clavesVisitadas.pertenece(clave)){
                int valor = resultado.recuperar(clave);
                resultado.agregar(clave, valor+1);
            }
            // Si la clave no existe, la agrego al conjunto de clavesVisitadas y al diccionario resultado
            else{
                clavesVisitadas.agregar(clave);
                resultado.agregar(clave, 1);
            }
            aux.apilar(clave);
            pila.desapilar();
        }
        // Vuelvo a llenar la pila original
        while(!aux.pilaVacia()){
            pila.apilar(aux.tope());
            aux.desapilar();
        }
        return resultado;
    }

}
