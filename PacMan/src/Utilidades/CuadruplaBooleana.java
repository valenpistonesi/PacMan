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

    public void print(){
        System.out.println("lado derecho"+lados[0]+"lado abajo"+lados[1]+"lado izq"+lados[2]+"lado arriba"+lados[3]);
    }
}
