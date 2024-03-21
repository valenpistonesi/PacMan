package Interfaces;

import javax.swing.JLabel;

import UbicablesEnTablero.Jugador;
import Utilidades.CuadruplaBooleana;
import Utilidades.DuplaDoble;

public interface EntidadConMovimiento {

    public void actualizarPosicionGrafica();

    public void moverse(double velocidad,CuadruplaBooleana c);

    public DuplaDoble getUbicacion();

    public JLabel getRepGrafica();

    public void colisionConJugador(Jugador j);


    
}
