import imple.Pila;
import tda.PilaTDA;

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
    public void apilar(PilaTDA valores) { // Complejidad polinomica
        PilaTDA inversa = new Pila();
        inversa.inicializarPila();
        // Se invierte el orden para que luego al agregar quede ordenada
        while(!valores.pilaVacia()){ // Complejidad lineal
            inversa.apilar(valores.tope()); 
            valores.desapilar();           
        }
        // Agrego la pila en orden
        while(!inversa.pilaVacia()){ // Complejidad lineal
            Nodo nuevo = new Nodo();
            nuevo.sig = tope;
            nuevo.valor = inversa.tope();
            tope = nuevo;
            valores.apilar(inversa.tope());
            inversa.desapilar();
        }
    }

    @Override
    public void desapilar(PilaTDA valores) { // Complejidad polinomica
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
            for(int j = 0; j<i; j++){ // Complejidad lineal
                tope = tope.sig;
            }
        }
        // Me aseguro que queda la pila de valores intacta
        while(!inversa.pilaVacia()){ // Complejidad lineal
            valores.apilar(inversa.tope());
            inversa.desapilar();
        }
    }

    @Override
    public PilaTDA tope(int cantidad) { // Complejidad polinomica
        PilaTDA topes = new Pila();
        topes.inicializarPila();
        PilaTDA inversa = new Pila();
        inversa.inicializarPila();
        Nodo aux = tope;
        int i = 0;
        // La condicion por la que corta determina la cantidad de topes a devolver
        while(aux != null && i < cantidad ){ // Complejidad lineal
            inversa.apilar(aux.valor);
            aux = aux.sig;
            i++;
        }
        while(!inversa.pilaVacia()){ // Complejidad lineal
            topes.apilar(inversa.tope());
            inversa.desapilar();
        }
        return topes;
    }


    @Override
    public boolean pilaVacia() {
        return tope == null;
    }

}
