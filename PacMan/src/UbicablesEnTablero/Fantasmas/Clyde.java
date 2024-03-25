package UbicablesEnTablero.Fantasmas;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import UbicablesEnTablero.Fantasmas.SrategyComportamiento.ComportamientoAgresivo;
import UbicablesEnTablero.Fantasmas.SrategyComportamiento.ComportamientoMiedo;
import UbicablesEnTablero.Fantasmas.SrategyComportamiento.ComportamientoPerdido;
import Utilidades.CuadruplaBooleana;
import Utilidades.DuplaDoble;

public class Clyde extends Fantasma {
    private int DISTANCIA_AGRESION = 3;
    private int tiempoParaAleatorizarMovimiento;
    private int[] direccionesActuales;
    private final int DISTANCIA_SEPARACION_MAXIMA = 10;

    public Clyde(int x, int y){
        super(x, y);
        comportamientoDefault = new ComportamientoPerdido();
        comportamientoAtaque=new ComportamientoAgresivo();
        comportamientoPeligro = new ComportamientoMiedo();
        contenerdorComportamiento.setComportamiento(comportamientoDefault);
        tiempoParaAleatorizarMovimiento =0;
    }
    
    public void CrearRepGrafica(int sizeCelda){
        imagen = new ImageIcon("PacMan/src/assets/ghosts/clyde.png");
        repGrafica = new JLabel(); 
        repGrafica.setSize(new Dimension(sizeCelda,sizeCelda));
        repGrafica.setForeground(Color.blue);
        repGrafica.setIcon(imagen);

    }

    public JLabel getRepGrafica(){
        return repGrafica;
    }

    public DuplaDoble getUbicacion(){
        return parUbicacion;

    }

    public void moverse(double velocidad,CuadruplaBooleana c) {
        if(volverABase)
            volverABase(velocidad);
        else{
            int direccion;
            if(tiempoParaAleatorizarMovimiento == 0){
                direccionesActuales = contenerdorComportamiento.obtenerDirecciones(parUbicacion, pacmanUbicacion, pacmanDireccion);
                tiempoParaAleatorizarMovimiento = 5;}
            else tiempoParaAleatorizarMovimiento--;

            if(!c.getDireccion(direccionesActuales[0]))
                direccion = direccionesActuales[0];
            else 
                if(!c.getDireccion(direccionesActuales[1]))
                    direccion =direccionesActuales[1];
                else
                    direccion = direccionesActuales[2];
            double x = parUbicacion.getX();
            double y = parUbicacion.getY();
            switch(direccion){
                case 0:{
                    if(c.getDireccion(0)== false){
                        x=x + velocidad*multiplicadorDeVelocidad;//DERECHA
                        y = Math.round(y);}
                }
                break;
                case 1:{
                    if(c.getDireccion(1)== false){
                        y = y + velocidad*multiplicadorDeVelocidad;//ABAJO
                        x = Math.round(x);}
                }
                break;
                case 2:{
                    if(c.getDireccion(2)== false){
                        x =x - velocidad*multiplicadorDeVelocidad;//IZQUIERDA
                        y = Math.round(y);}
                }
                break;
                case 3:{
                    if(c.getDireccion(3)== false){
                        x = Math.round(x);
                        y = y - velocidad*multiplicadorDeVelocidad;}//ARRIBA
                }    
                break; }

                parUbicacion.setX(x);
                parUbicacion.setY(y);
        }
    }

    @Override
    public void notificacionUbicacion(DuplaDoble d) {
        super.notificacionUbicacion(d);
        double dx = parUbicacion.getX() -d.getX();
        double dy = parUbicacion.getY() -d.getY();
        double distancia = Math.sqrt(dx*dx + dy*dy);
        if(!volverABase && !escapandoDeJugador)
            if(((distancia < DISTANCIA_AGRESION)|| (distancia>DISTANCIA_SEPARACION_MAXIMA))&& !volverABase)
            contenerdorComportamiento.setComportamiento(comportamientoAtaque);
            else contenerdorComportamiento.setComportamiento(comportamientoDefault);
    }
    
}
