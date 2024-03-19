package UbicablesEnTablero.Fantasmas;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Interfaces.EntidadConMovimiento;
import Interfaces.EntidadRepresentable;
import Utilidades.DuplaDoble;

public abstract class Fantasma implements EntidadRepresentable,EntidadConMovimiento{
    private DuplaDoble parUbicacion;
    private JLabel repGrafica;
    private ImageIcon imagen;

    public Fantasma(int x, int y){
        parUbicacion = new DuplaDoble();
        parUbicacion.setX(x);
        parUbicacion.setY(y);
    }
    
    public abstract void CrearRepGrafica(int sizeCelda);

    public JLabel getRepGrafica(){
        return repGrafica;
    }

    public DuplaDoble getUbicacion(){
        return parUbicacion;

    }

    public boolean objetoSolido(){
        return false;

    }



}

