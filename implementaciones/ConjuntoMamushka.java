/* ESTRATEGIA:
   Se usa un arreglo para guardar los datos.
   Se usa una variable entera para indicar la cantidad de posiciones usadas del arreglo.
   Para guardar se agrega el dato directamente en la ultima posicion disponible, ya que este TDA permite repetidos.
   Para sacar se recorre el arreglo en busca del valor. Si existe, se elimina una aparicion sobreescribiendola con el valor presente en la ultima posicion del arreglo.
   Para elegir se elige un numero random en el rango de elementos disponibles del arreglo.
   Para determinar cuantas veces pertenece un valor, se recorre todo el arreglo contando sus apariciones.
   Para saber si esta vacio se verifica si no hay posiciones usadas en el arreglo.
*/

public class ConjuntoMamushka implements ConjuntoMamushkaTDA {

    private int [] arr;
    private int indice;

    @Override
    public void inicializar() { // Complejidad constante
        arr = new int[100];
        indice = 0;        
    }

    @Override
    public void guardar(int dato) { // Complejidad constante
        arr[indice] = dato;
        indice++;        
    }

    @Override
    public void sacar(int dato) { // Complejidad lineal
        int i = 0;
        while(i < indice && arr[i] != dato)
            i++;
        if(i<indice){
            arr[i] = arr[indice-1];
            indice--;
        }  
    }

    @Override
    public int elegir() { // Complejidad constante
        int random = (int) (Math.random() * indice);
        return arr[random];
    }

    @Override
    public int perteneceCant(int dato) { // Complejidad lineal
        int cantidad = 0;
        for(int i = 0; i<indice; i++){
            if(arr[i] == dato)
                cantidad++;
        }
        return cantidad;
    }

    @Override
    public boolean estaVacio() { // Complejidad constante
        return indice == 0;
    }

}
