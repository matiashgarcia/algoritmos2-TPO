import imple.Pila;
import tda.PilaTDA;

/* ESTRATEGIA:
   Se usa una estructura enlazada mediante nodos para representar la multipila.
   Cada nodo guarda un valor entero y una referencia al siguiente nodo.
   La variable tope apunta al primer nodo de la multipila.
   Para apilar una pila recibida por parametro, primero se invierte en una pila auxiliar para poder agregar sus valores respetando el orden original.
   Luego se insertan los valores al inicio de la estructura enlazada, actualizando el tope en cada insercion.
   Durante este proceso se vuelve a reconstruir la pila recibida para que no quede modificada.
   Para desapilar, se compara el tope de la multipila con los valores de la pila recibida.
   Si todos los valores recibidos coinciden con los primeros valores de la multipila, se eliminan esos nodos.
   Si no coinciden completamente, no se modifica la multipila.
   La pila recibida se restaura usando una pila auxiliar.
   Para obtener el tope, se recorren como maximo la cantidad de nodos indicada y se usa una pila auxiliar para devolverlos preservando el orden.
*/

public class MultiPila implements MultiPilaTDA{

    class Nodo{
        private int valor;
        private Nodo sig;
    }

    private Nodo tope;

    @Override
    public void inicializarPila() { // Complejidad constante
        tope = null;
    }

    @Override
    public void apilar(PilaTDA valores) { // Complejidad lineal
        PilaTDA inversa = new Pila();
        inversa.inicializarPila();
        // Se invierte el orden para que luego al agregar quede ordenada
        while(!valores.pilaVacia()){ 
            inversa.apilar(valores.tope()); 
            valores.desapilar();           
        }
        // Agrego la pila en orden
        while(!inversa.pilaVacia()){ 
            Nodo nuevo = new Nodo();
            nuevo.sig = tope;
            nuevo.valor = inversa.tope();
            tope = nuevo;
            valores.apilar(inversa.tope());
            inversa.desapilar();
        }
    }

    @Override
    public void desapilar(PilaTDA valores) { // Complejidad lineal
        PilaTDA inversa = new Pila();
        inversa.inicializarPila();
        Nodo aux = tope;
        int i = 0;
        // Veo si coinciden todos los topes y guardo cantidad de iteraciones
        while(aux != null && !valores.pilaVacia() && aux.valor == valores.tope()){ // Complejidad lineal
            aux = aux.sig;
            inversa.apilar(valores.tope());
            valores.desapilar();
            i++;
        }
        // Si quedo vacia significa que todos los topes de ambas pilas coincidieron
        if(valores.pilaVacia()){
            // Procedo a desapilar
            for(int j = 0; j<i; j++){ 
                tope = tope.sig;
            }
        }
        // Me aseguro que queda la pila de valores intacta
        while(!inversa.pilaVacia()){ 
            valores.apilar(inversa.tope());
            inversa.desapilar();
        }
    }

    @Override
    public PilaTDA tope(int cantidad) { // Complejidad lineal
        PilaTDA topes = new Pila();
        topes.inicializarPila();
        PilaTDA inversa = new Pila();
        inversa.inicializarPila();
        Nodo aux = tope;
        int i = 0;
        // La condicion por la que corta determina la cantidad de topes a devolver
        while(aux != null && i < cantidad ){
            inversa.apilar(aux.valor);
            aux = aux.sig;
            i++;
        }
        while(!inversa.pilaVacia()){ 
            topes.apilar(inversa.tope());
            inversa.desapilar();
        }
        return topes;
    }


    @Override
    public boolean pilaVacia() { // Complejidad constante
        return tope == null;
    }

}
