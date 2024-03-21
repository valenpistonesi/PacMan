package Interfaces;

import javax.swing.JLabel;

import UbicablesEnTablero.Jugador;
import Utilidades.DuplaDoble;

public interface EntidadRepresentable {
    
    public void CrearRepGrafica(int sizeCelda);

    public JLabel getRepGrafica();

    public boolean objetoSolido();

    public DuplaDoble getUbicacion();

    public void colisionConJugador(Jugador j);
    

    
}