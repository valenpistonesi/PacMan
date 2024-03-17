package UbicablesEnTablero.Fantasmas;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Interfaces.UbicableEnTablero;

public abstract class Fantasma implements UbicableEnTablero{
    private double parUbicacion[];
    private JLabel repGrafica;
    private ImageIcon imagen;

    public Fantasma(int x, int y){
        parUbicacion = new double[2];
        parUbicacion[0] = x;
        parUbicacion[1]= y;
    }
    
    public abstract void CrearRepGrafica(int sizeCelda);

    public JLabel getRepGrafica(){
        return repGrafica;
    }

    public double[] getUbicacion(){
        return parUbicacion;

    }
}

