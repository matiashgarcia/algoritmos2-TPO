/* ESTRATEGIA:
   Se usa un arreglo de objetos Elemento para guardar los pares clave-valor junto con su factor de modificacion.
   Se usa una variable entera para indicar la cantidad de posiciones usadas del arreglo.
   Para agregar se recorre primero el arreglo buscando la clave. Si existe y el valor cambia, se actualiza el valor y se incrementa el factor de modificacion.
   Si la clave no existe, se agrega un nuevo elemento en la ultima posicion disponible con factor de modificacion en 0.
   Para eliminar se recorre el arreglo buscando la clave. Si existe, se elimina sobreescribiendola con el elemento presente en la ultima posicion del arreglo.
   Para recuperar el valor o el factor de modificacion se recorre el arreglo hasta encontrar la clave, que se supone existente.
   Para obtener las claves se recorre el arreglo y se agregan todas las claves a un conjunto.
*/

import imple.Conjunto;
import tda.ConjuntoTDA;

public class DiccionarioSimpleMod implements DiccionarioSimpleModTDA{

    class Elemento{
        private int clave;
        private int valor;
        private int facMod;
    }
    private Elemento [] elementos;
    private int indice;

    @Override
    public void inicializarDiccionario() { // Complejidad constante
        elementos = new Elemento[100];
        indice = 0;
    }

    @Override
    public void agregar(int clave, int valor) { // Complejidad lineal
        int i = 0;
        // Recorro arreglo buscando la clave
        while(i < indice && elementos[i].clave != clave){
            i++;
        }
        // Si encuentro la clave
        if(i<indice){
            // Si el valor es distinto, entonces lo actualizo y aumento un factor de modificacion
            if(elementos[i].valor != valor){
                elementos[i].valor = valor;
                elementos[i].facMod++;
            }
        }
        // Si no la encuentro, creo un nuevo elemento e inicio el factor de modificacion
        else{
            Elemento nuevo = new Elemento();
            nuevo.clave = clave;
            nuevo.valor = valor;
            nuevo.facMod = 0;
            elementos[indice] = nuevo;
            indice++;
        }
    }
    
    @Override
    public void eliminar(int clave) { // Complejidad lineal
        int i = 0;
        while(i < indice && elementos[i].clave != clave){
            i++;
        }
        if(i<indice){
            elementos[i] = elementos[indice-1];
            indice--;
        }
    }    
    
    @Override
    // Se supone existente la clave
    public int recuperar(int clave) { // Complejidad lineal
        int i = 0;
        while(i < indice && elementos[i].clave != clave){
            i++;
        }
        return elementos[i].valor;
    }
    @Override
    // Se supone existente la clave
    public int recuperarMod(int clave) { // Complejidad lineal
        int i = 0;
        while(i < indice && elementos[i].clave != clave){
            i++;
        }
        return elementos[i].facMod;
    }
    
    @Override
    public ConjuntoTDA claves() { // Complejidad polinomica
        ConjuntoTDA claves = new Conjunto();
        claves.inicializarConjunto();
        int i = 0;
        while(i < indice){
            claves.agregar(elementos[i].clave); // Complejidad lineal
            i++;
        }
        return claves;
    }

}
