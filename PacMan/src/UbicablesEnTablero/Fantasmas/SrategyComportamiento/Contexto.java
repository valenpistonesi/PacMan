package UbicablesEnTablero.Fantasmas.SrategyComportamiento;

import Utilidades.DuplaDoble;

public class Contexto {
    InterfazComportamiento comportamientoActual;

    public Contexto(){}

    public void setComportamiento(InterfazComportamiento ic){
        comportamientoActual = ic;
    }

    public int[] obtenerDirecciones(DuplaDoble miUbicacion,DuplaDoble pacUbicacion, int pacDireccion){
        return comportamientoActual.direccionar(miUbicacion, pacUbicacion, pacDireccion);
    }


    
}
