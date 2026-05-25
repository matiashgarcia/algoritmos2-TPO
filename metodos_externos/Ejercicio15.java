package metodos_externos;

/* ESTRATEGIA:
   Se obtiene el conjunto de vertices del grafo y se lo recorre completo.
   Para cada vertice del grafo, se verifica si existe una arista que sale desde el vertice v
   recibido por parametro hacia ese vertice. Si existe, se incrementa la cantidad de aristas salientes.
   Tambien se verifica si existe una arista que sale desde ese vertice hacia v. Si existe,
   se incrementa la cantidad de aristas entrantes.
   Al finalizar el recorrido, se devuelve la resta entre la cantidad de aristas salientes
   y la cantidad de aristas entrantes, que corresponde al grado del vertice.
*/

import tda.ConjuntoTDA;
import tda.GrafoTDA;

public class Ejercicio15 {

    public int gradoDelVertice(GrafoTDA grafo, int v){ // Complejidad polinomica
        ConjuntoTDA vertices = grafo.vertices();
        int salientes = 0;
        int entrantes = 0;
        // Por cada vertice
        while(!vertices.conjuntoVacio()){
            int vertice = vertices.elegir(); 
            // Si sale una arista de v, sumo 1 en salientes
            if(grafo.existeArista(v, vertice)){
                salientes++;
            }
            // Si llega una arista a v, sumo 1 en entrantes
            if(grafo.existeArista(vertice, v)){
                entrantes++;
            }
            vertices.sacar(vertice);
        }
        return salientes - entrantes;
    }

}
