package metodos_externos;

/* ESTRATEGIA:
   Se recorre el arbol binario de busqueda completo usando recursion.
   Si el arbol recibido esta vacio, se devuelve 0 porque no hay elementos para sumar.
   Para cada nodo no vacio, se calcula la suma de los elementos impares del hijo izquierdo
   y del hijo derecho. Luego se revisa la raiz del nodo actual: si es impar, se agrega a la suma;
   si es par, se ignora. El resultado final es la suma de todos los valores impares encontrados.
*/

import tda.ABBTDA;

public class Ejercicio12 {

    public int sumaElementosImparesDeABB(ABBTDA abb) { // COMPLEJIDAD LINEAL
        // Caso base: si el arbol esta vacio, suma 0
        if (abb.arbolVacio()) {
            return 0;
        }

        // Sumo recursivamente los elementos impares de ambos subarboles
        int suma = sumaElementosImparesDeABB(abb.hijoIzq())
                + sumaElementosImparesDeABB(abb.hijoDer());

        // Si la raiz actual es impar, la agrego al resultado
        if (abb.raiz() % 2 != 0) {
            suma += abb.raiz();
        }

        return suma;
    }
}
