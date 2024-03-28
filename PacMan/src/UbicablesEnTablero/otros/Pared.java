package UbicablesEnTablero.otros;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Interfaces.EntidadRepresentable;
import UbicablesEnTablero.Jugador;
import UbicablesEnTablero.Fantasmas.Inky;
import Utilidades.DuplaDoble;

public class Pared implements EntidadRepresentable{
    private DuplaDoble parUbicacion;
    private JLabel repGrafica;
    private ImageIcon imagen;

    public Pared(int x, int y){
        parUbicacion = new DuplaDoble();
        parUbicacion.setX(x);
        parUbicacion.setY(y);
    }
    
    public void CrearRepGrafica(int sizeCelda){
    	InputStream is =Pared.class.getResourceAsStream("pared.png");
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

    public boolean objetoSolido(){
        return true;
    }

    @Override
    public void colisionConJugador(Jugador j) {
        System.out.println("no me deberia chocar una pared");
    }
}
