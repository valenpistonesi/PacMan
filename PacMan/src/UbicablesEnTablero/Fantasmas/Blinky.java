package UbicablesEnTablero.Fantasmas;

import java.awt.Color;
import java.awt.Dimension;

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
        imagen = new ImageIcon("PacMan/src/assets/ghosts/blinky.png");
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

