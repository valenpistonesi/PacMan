package UbicablesEnTablero.otros;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import UbicablesEnTablero.Fantasmas.Inky;

public class Frutilla extends Punto{

    public Frutilla(int x, int y){
        super(x, y);
        puntos = 1000;
        InputStream is =Frutilla.class.getResourceAsStream("strawberry.png");
    	try {
    		imagen = new ImageIcon (ImageIO.read(is));
		} catch (IOException e) {
			e.printStackTrace();
		}

    }
    
}
