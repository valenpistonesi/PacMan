package Utilidades;

public class CuadruplaBooleana {
    private boolean[] lados;

    public CuadruplaBooleana(){
        lados = new boolean[4];
    }

    public void setDireccion(boolean b,int i){
        lados[i] = b;
    }
    public boolean getDireccion(int i){
        return lados[i];

    }
}
