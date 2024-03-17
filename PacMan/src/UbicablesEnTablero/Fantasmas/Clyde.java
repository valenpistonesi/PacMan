package UbicablesEnTablero.Fantasmas;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Interfaces.UbicableEnTablero;

public class Clyde implements UbicableEnTablero{
    private double parUbicacion[];
    private JLabel repGrafica;
    private ImageIcon imagen;

    public Clyde(int x, int y){
        parUbicacion = new double[2];
        parUbicacion[0] = x;
        parUbicacion[1]= y;
    }
    
    public void CrearRepGrafica(int sizeCelda){
        imagen = new ImageIcon("src/assets/fantasmas/clyde.png");
        repGrafica = new JLabel(); 
        repGrafica.setSize(new Dimension(sizeCelda,sizeCelda));
        repGrafica.setForeground(Color.blue);
        repGrafica.setIcon(imagen);

    }

    public JLabel getRepGrafica(){
        return repGrafica;
    }

    public double[] getUbicacion(){
        return parUbicacion;

    }
}
