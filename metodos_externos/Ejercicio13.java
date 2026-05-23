package metodos_externos;

/* ESTRATEGIA:
   Se recorre el arbol binario de busqueda completo usando recursion.
   Si el arbol recibido esta vacio, se devuelve 0 porque no hay hojas para contar.
   Para cada nodo no vacio, se verifica si es una hoja y si es par. Si cumple, suma 1.
   Si el nodo no es una hoja par, se continua el recorrido por ambos subarboles y se suman
   las cantidades obtenidas. El resultado final es la cantidad de hojas con valor par.
*/

import tda.ABBTDA;

public class Ejercicio13 {

    public int cantidadDeHojasPar(ABBTDA abb) { // COMPLEJIDAD LINEAL
        // Si el arbol esta vacio, suma 0
        if (abb.arbolVacio()) {
            return 0;
        }
        boolean esHoja = abb.hijoIzq().arbolVacio() && abb.hijoDer().arbolVacio();
        // Si el arbol es hoja y su raiz par, suma 1
        if (esHoja && abb.raiz() % 2 == 0) {
            return 1;
        }
        // Si no esta vacio ni es hoja, recorremos los subarboles
        return cantidadDeHojasPar(abb.hijoIzq()) + cantidadDeHojasPar(abb.hijoDer());
    }

}
