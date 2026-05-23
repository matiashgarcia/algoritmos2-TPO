package metodos_externos;

/* ESTRATEGIA:
   Se recorre un diccionario multiple para construir una cola con todos sus valores, sin repetirlos.
   Primero se obtiene el conjunto de claves del diccionario.
   Para cada clave, se recupera el conjunto de valores asociados a esa clave.
   Se usa un conjunto auxiliar llamado repetidos para registrar que valores ya fueron agregados a la cola resultado.
   Si un valor todavia no pertenece a ese conjunto, se acola en la cola resultado y se agrega al conjunto de repetidos.
   Si el valor ya fue agregado anteriormente, se ignora para evitar duplicados en la cola resultado.
   Los conjuntos de claves y valores se consumen con elegir y sacar para poder recorrerlos hasta que queden vacios.
*/

import imple.Cola;
import imple.Conjunto;
import tda.ColaTDA;
import tda.ConjuntoTDA;
import tda.DiccionarioMultipleTDA;

public class Ejercicio11 {

    public ColaTDA pasarValoresDeDiccionarioMultipleACola(DiccionarioMultipleTDA dic){ // COMPLEJIDAD POLINOMICA
        ColaTDA colaResultado = new Cola();
        colaResultado.inicializarCola();
        ConjuntoTDA repetidos = new Conjunto();
        repetidos.inicializarConjunto();
        ConjuntoTDA claves = dic.claves();
        
        // Recorro las claves del diccionario
        while(!claves.conjuntoVacio()){
            int clave = claves.elegir();
            ConjuntoTDA valores = dic.recuperar(clave);
            // Recorro los valores asociados a la clave
            while(!valores.conjuntoVacio()){
                int valor = valores.elegir();
                // Si no esta repetido el valor, lo agrego a la cola resultado y al conjunto de repetidos
                if(!repetidos.pertenece(valor)){
                    colaResultado.acolar(valor);
                    repetidos.agregar(valor);
                }
                valores.sacar(valor);
            }
            claves.sacar(clave);
        }
        return colaResultado;
    }
}
