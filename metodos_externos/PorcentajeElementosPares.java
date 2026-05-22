package metodos_externos;

/* ESTRATEGIA:
   Se recorre la pila recibida para contar la cantidad total de elementos y la cantidad de elementos pares.
   Como para recorrer una pila es necesario desapilarla, cada elemento consultado se guarda en una pila auxiliar.
   Una vez terminado el conteo, se reconstruye la pila original desapilando la auxiliar y apilando nuevamente en la pila recibida.
   Si la pila recibida estaba vacia, se devuelve 0 para evitar dividir por cero.
   Finalmente se calcula el porcentaje haciendo cantidad de pares sobre cantidad total, multiplicado por 100.
*/

import imple.Pila;
import tda.PilaTDA;

public class PorcentajeElementosPares {
    
    public float porcentajeElementosPares(PilaTDA pila){ // COMPLEJIDAD LINEAL
        float cantTotal = 0;
        float cantPares = 0;
        PilaTDA aux = new Pila();
        aux.inicializarPila();
        // Recorro la pila
        while(!pila.pilaVacia()){
            if(pila.tope() % 2 == 0)
                cantPares++;
            cantTotal++;
            aux.apilar(pila.tope());
            pila.desapilar();
        }
        // Vuelvo a llenar la pila original
        while(!aux.pilaVacia()){
            pila.apilar(aux.tope());
            aux.desapilar();
        }
        if(cantTotal == 0){
            return 0;
        }
        return (cantPares / cantTotal) * 100;        
    }
    
}
