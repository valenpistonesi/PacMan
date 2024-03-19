package Interfaces;

import javax.swing.JLabel;

import Utilidades.DuplaDoble;

public interface EntidadRepresentable {
    
    public void CrearRepGrafica(int sizeCelda);

    public JLabel getRepGrafica();

    public boolean objetoSolido();

    public DuplaDoble getUbicacion();
    

    
}