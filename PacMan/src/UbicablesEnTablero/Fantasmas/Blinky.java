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
import Utilidades.DuplaDoble;

public class Blinky extends Fantasma{

    public Blinky(int x, int y){
        super(x, y);
        comportamientoDefault = new ComportamientoAgresivo();
        contenerdorComportamiento.setComportamiento(comportamientoDefault);
    }
    
    public void CrearRepGrafica(int sizeCelda){
    	InputStream is = Blinky.class.getResourceAsStream("blinky.png");
    	try {
    		imagen = new ImageIcon (ImageIO.read(is));
		} catch (IOException e) {
			e.printStackTrace();
		}
        repGrafica = new JLabel(); 
        repGrafica.setSize(new Dimension(sizeCelda,sizeCelda));
        repGrafica.setForeground(Color.blue);;
        repGrafica.setIcon(imagen);

    }

    public JLabel getRepGrafica(){
        return repGrafica;
    }

    public DuplaDoble getUbicacion(){
        return parUbicacion;

    }

   

    
}

