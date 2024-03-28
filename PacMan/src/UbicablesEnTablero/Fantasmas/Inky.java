package UbicablesEnTablero.Fantasmas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
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
    }
    
    public void CrearRepGrafica(int sizeCelda){
    	InputStream is =Inky.class.getResourceAsStream("inky.png");
    	try {
    		imagen = new ImageIcon (ImageIO.read(is));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
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
