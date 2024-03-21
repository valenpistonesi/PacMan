package UbicablesEnTablero.Fantasmas.SrategyComportamiento;

import Utilidades.DuplaDoble;

public class ComportamientoPredictivo implements InterfazComportamiento {
    private final int DISTANCIA_PREDICTIVA = 5;

    public int[] direccionar(DuplaDoble miUbicacion, DuplaDoble pacUbicacion, int pacDireccion) {
        int[] dir = new int[3];
        double dx = 0;
        double dy=0;
        switch(pacDireccion){
            case 0:{
                dx = miUbicacion.getX()-(pacUbicacion.getX()+DISTANCIA_PREDICTIVA);
                dy = miUbicacion.getY()-pacUbicacion.getY();
            }
            break;
            case 1:{
                dx = miUbicacion.getX()-pacUbicacion.getX();
                dy = miUbicacion.getY()-(pacUbicacion.getY()+DISTANCIA_PREDICTIVA);
            }
            break;
            case 2:{
                dx = miUbicacion.getX()-(pacUbicacion.getX()-DISTANCIA_PREDICTIVA);
                dy = miUbicacion.getY()-pacUbicacion.getY();
            }
            break;
            case 3:{
                dx = miUbicacion.getX()-pacUbicacion.getX();
                dy = miUbicacion.getY()-(pacUbicacion.getY()-DISTANCIA_PREDICTIVA);
            }
            break;

        }
        

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
