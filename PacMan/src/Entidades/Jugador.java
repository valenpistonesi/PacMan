package Entidades;

public class Jugador { 
    private final double multiplicadorDeVelocidad = 1;

    private int direccion;
    private double[] parUbicacion;
   
 
    public Jugador(double x, double y){
        parUbicacion = new double[2];
        parUbicacion[0] = x;
        parUbicacion[1] = y;
    }
    
    public void direccionar(int i){
        if(i <=3)
           direccion = i;
        else System.out.println("direccion erronea");
    }

    public void mover(int velocidad){
        switch(direccion){
            case 0:parUbicacion[0] = parUbicacion[0] + velocidad*multiplicadorDeVelocidad;//DERECHA
            break;
            case 1:parUbicacion[1] = parUbicacion[1] - velocidad*multiplicadorDeVelocidad;//ABAJO
            break;
            case 2:parUbicacion[2] = parUbicacion[0] - velocidad*multiplicadorDeVelocidad;//IZQUIERDA
            break;
            case 3:parUbicacion[1] = parUbicacion[1] + velocidad*multiplicadorDeVelocidad;//ARRIBA
            break;
            
        }

    }
}
