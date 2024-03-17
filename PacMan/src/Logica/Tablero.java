package Logica;

import java.util.LinkedList;
import Interfaces.UbicableEnTablero;
import UbicablesEnTablero.otros.Pared;
import Interfaces.EntidadConMovimiento;

public class Tablero{
    private final int sizeTablero = 20;
    private final int velocidadDeJuego = 1;

    private LectorDeTeclado lectorTeclado;
    private TimerJuego timer;
    private UbicableEnTablero [][] tablero;
    private LinkedList <EntidadConMovimiento> entidades;
    private EstadoDeJuego estado;
    private LectorDeNiveles lectorNiveles;

    public Tablero(){
        tablero = new UbicableEnTablero[sizeTablero][sizeTablero];
        lectorNiveles = new LectorDeNiveles(this);
    }

    public int cantCeldas(){
        return sizeTablero;
    }

    public UbicableEnTablero getEntidad(int x, int y){
        return tablero[x][y];
    }


    public void cargarTablero(){
        for (int i = 0; i< sizeTablero; i++){
            tablero[i][0] = new Pared(i,0);
        }
        for (int i = 0; i< sizeTablero; i++){
            tablero[0][i] = new Pared(i,sizeTablero-1);
        }
        for (int i = 0; i< sizeTablero; i++){
            tablero[cantCeldas()-1][i] = new Pared(0,i);
        }
        for (int i = 0; i< sizeTablero; i++){
            tablero[i][cantCeldas()-1] = new Pared(sizeTablero-1,i);
        }

        for(int i = 0; i<sizeTablero; i++){
            for(int j = 0; j<sizeTablero; j++){
                if(tablero[i][j] != null){
                    tablero[i][j].CrearRepGrafica(32);
                }
            }
        }


    }

    public LinkedList<EntidadConMovimiento> obtenerEntidadesMobiles() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerEntidadesMobiles'");
    }

    public void agregarPared(int x, int y){
        
    }

}