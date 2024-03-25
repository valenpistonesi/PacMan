package UbicablesEnTablero.Fantasmas;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import UbicablesEnTablero.Fantasmas.SrategyComportamiento.ComportamientoAgresivo;
import UbicablesEnTablero.Fantasmas.SrategyComportamiento.ComportamientoEmboscada;
import UbicablesEnTablero.Fantasmas.SrategyComportamiento.ComportamientoMiedo;
import Utilidades.DuplaDoble;

public class Inky extends Fantasma{
    private int DISTANCIA_AGRESION = 3;

    public Inky(int x, int y){
        super(x, y);
        comportamientoDefault = new ComportamientoEmboscada();
        contenerdorComportamiento.setComportamiento(comportamientoDefault);
        comportamientoAtaque=new ComportamientoAgresivo();
        comportamientoPeligro = new ComportamientoMiedo();
        imagen = new ImageIcon("./src/assets/ghosts/inky.png");
    }
    
    public void CrearRepGrafica(int sizeCelda){
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


    @Override
    public void notificacionUbicacion(DuplaDoble d) {
        super.notificacionUbicacion(d);
        double dx = parUbicacion.getX() -d.getX();
        double dy = parUbicacion.getY() -d.getY();
        double distancia = Math.sqrt(dx*dx + dy*dy);
        if(!volverABase && !escapandoDeJugador){
            if(distancia < DISTANCIA_AGRESION)
            contenerdorComportamiento.setComportamiento(comportamientoAtaque);
            else contenerdorComportamiento.setComportamiento(comportamientoDefault);}
    }
}
