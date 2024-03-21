package UbicablesEnTablero.Fantasmas.SrategyComportamiento;

import Utilidades.DuplaDoble;

public class ComportamientoAgresivo implements InterfazComportamiento{
    //ignora la direccion en la que se mueve el personaje y va directamente hacia el
    public int[] direccionar(DuplaDoble miUbicacion, DuplaDoble pacUbicacion, int pacDireccion) {
        int[] dir = new int[3];
        double dx = miUbicacion.getX()-pacUbicacion.getX();
        double dy = miUbicacion.getY()-pacUbicacion.getY();

        if(Math.abs(dx)>= Math.abs(dy)){//distancia mas larga
            // dx es MAYOR
            if(dx >= 0){
                dir[0] = 2;
                if(dy>= 0){
                    dir[1] = 3;
                    dir[2] = 1;}
                else{
                    dir[1] = 1;
                    dir[2] = 3;
                }
            }
            else{
                dir[0] = 0;
                if(dy>= 0){
                    dir[1] = 3;
                    dir[2] = 1;}
                else{
                    dir[1] = 1;
                    dir[2] = 3;
                }
            }
        }
        else{//dy es mayor
            if(dy >= 0){
                dir[0] = 3;
                if(dx>= 0){
                    dir[1] = 2;
                    dir[2] = 0;}
                else{
                    dir[1] = 0;
                    dir[2] = 2;
                }
            }
            else{
                dir[0] = 1;
                if(dx>= 0){
                    dir[1] = 2;
                    dir[2] = 0;}
                else{
                    dir[1] = 0;
                    dir[2] = 2;
                }
            }

        }
        return dir;
    }
}
