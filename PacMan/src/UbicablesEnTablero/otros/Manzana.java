package UbicablesEnTablero.otros;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import UbicablesEnTablero.Jugador;
import UbicablesEnTablero.Fantasmas.Inky;

public class Manzana extends Punto {
    public Manzana(int x, int y){
        super(x, y);
        puntos = 200;
        InputStream is =Manzana.class.getResourceAsStream("apple.png");
    	try {
    		imagen = new ImageIcon (ImageIO.read(is));
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    public void colisionConJugador(Jugador j){
        super.colisionConJugador(j);
        j.asustarFantasmas(30);
    }
    
}
