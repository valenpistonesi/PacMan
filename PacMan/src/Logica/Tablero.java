package Logica;

import java.util.LinkedList;
import Interfaces.UbicableEnTablero;
import Interfaces.EntidadConMovimiento;

public class Tablero{
    private final int sizeTablero = 15;
    private final int velocidadDeJuego = 1;

    private UbicableEnTablero [][] tablero;
    private LinkedList <EntidadConMovimiento> entidades;

    public Tablero(){
        tablero = new UbicableEnTablero[sizeTablero][sizeTablero];
    }

}