package metodos_externos;

import imple.Conjunto;
import tda.ConjuntoTDA;
import tda.GrafoTDA;

/* ESTRATEGIA:
   Se crea un conjunto para guardar los vertices puente encontrados.
   Luego se obtiene el conjunto de vertices del grafo y se lo recorre completo.
   Para cada vertice p, se verifica si existe una arista que va desde el origen o hasta p
   y otra arista que va desde p hasta el destino d. Si ambas aristas existen, entonces p
   cumple la definicion de vertice puente y se agrega al conjunto puentes.
   Al finalizar el recorrido, se devuelve el conjunto con todos los vertices puente encontrados.
*/

public class Ejercicio14 {

    public ConjuntoTDA encontrarVerticesPuente(GrafoTDA grafo, int o, int d){ // Complejidad polinomica
        ConjuntoTDA puentes = new Conjunto();
        puentes.inicializarConjunto();
        ConjuntoTDA vertices = grafo.vertices();
        // Recorro los vertices
        while(!vertices.conjuntoVacio()){
            int vertice = vertices.elegir();
            // Si es vertice puente, lo agrego al conjunto de puentes
            if(grafo.existeArista(o, vertice) && grafo.existeArista(vertice, d)){
                puentes.agregar(vertice);
            }
            vertices.sacar(vertice);
        }
        return puentes;
    }
}
