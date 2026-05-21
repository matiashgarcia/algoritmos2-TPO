public class ConjuntoEspecial implements ConjuntoEspecialTDA {

    private int indice;
    private int[] arr;

    @Override
    public void inicializarConjunto() {
        indice = 0;
        arr = new int[100];
    }

    @Override
    public Respuesta agregar(int valor) {
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
    public Respuesta sacar(int valor) {
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
    public Respuesta elegir() {
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
    public boolean pertenece(int valor) {
        int i = 0;
        while (i < indice && arr[i] != valor)
            i++;
        return i < indice;
    }

    @Override
    public boolean conjuntoVacio() {
        return indice == 0;
    }

}
