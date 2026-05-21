import imple.ColaPrioridad;
import tda.ColaPrioridadTDA;
import tda.ConjuntoTDA;
import tda.DiccionarioSimpleTDA;

public class DiccionarioSimpleConColaPrioridad implements DiccionarioSimpleTDA {

    ColaPrioridadTDA cola;

    @Override
    public void inicializarDiccionario() {
        cola = new ColaPrioridad();
    }

    @Override
    public void agregar(int clave, int valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agregar'");
    }

    @Override
    public void eliminar(int clave) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public ConjuntoTDA claves() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'claves'");
    }



    @Override
    public int recuperar(int clave) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'recuperar'");
    }

}
