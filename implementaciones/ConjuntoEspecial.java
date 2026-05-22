/* ESTRATEGIA:
   Se usa un arreglo para guardar los datos.
   Se usa una variable entera para indicar la cantidad de posiciones usadas del arreglo.
   Para agregar se recorre primero el arreglo. Si no se lo encuentra se lo agrega en la utlima posicion. 
   Para sacar se recorre el arreglo en busca del valor. Si existe, se lo saca sobreescribiendolo con el valor presente en la ultima posicion del arreglo.
   Para elegir, si no esta vacio el arreglo, se elige un numero random en el rango de elementos disponibles del arreglo.
   Para determinar si un valor pertenece, se lo busca recorriendo todo el arreglo.
   Para los metodos que devuelven un objeto Respuesta, este se crea en cada metodo y se modifica de acuerdo a las condiciones preestablecidas en el TDA.
*/

public class ConjuntoEspecial implements ConjuntoEspecialTDA {

    private int indice;
    private int[] arr;

    @Override
    public void inicializarConjunto() { // Complejidad constante
        indice = 0;
        arr = new int[100];
    }

    @Override
    public Respuesta agregar(int valor) { // Complejidad lineal
        Respuesta respuesta = new Respuesta();
        // Asumimos que el valor pertence y no lo agregamos
        respuesta.error = true;
        // Si no pertenece, lo agregamos y actualizamos respuesta
        if (!pertenece(valor)) {
            arr[indice] = valor;
            indice++;
            respuesta.error = false;
        }
        return respuesta;
    }

    @Override
    public Respuesta sacar(int valor) { // Complejidad lineal
        Respuesta respuesta = new Respuesta();
        // Asumimos que el valor no esta y no lo podemos sacar
        respuesta.error = true;
        int i = 0;
        while(i < indice && arr[i] != valor)
            i++;
        // Si encontramos el valor, lo sacamos y actualizamos respuesta
        if(i < indice){
            arr[i] = arr[indice-1];
            indice--;
            respuesta.error = false;
        }
        return respuesta;
    }

    @Override
    public Respuesta elegir() { // Complejidad constante
        Respuesta respuesta = new Respuesta();
        // Asumimos que no tiene valores y no podemos elegir
        respuesta.error = true;
        // Si hay valores para elegir, elegimos y actualizamos respuesta
        if(!conjuntoVacio()){
            respuesta.error = false;
            int random = (int) (Math.random() * indice);
            respuesta.rta = arr[random];
        }
        return respuesta;

    }

    @Override
    public boolean pertenece(int valor) { // Complejidad lineal
        int i = 0;
        while (i < indice && arr[i] != valor)
            i++;
        return i < indice;
    }

    @Override
    public boolean conjuntoVacio() { // Complejidad constante
        return indice == 0;
    }

}
