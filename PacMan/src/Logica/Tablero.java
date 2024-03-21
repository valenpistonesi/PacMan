package Logica;

import java.util.Iterator;
import java.util.LinkedList;


import Interfaces.EntidadRepresentable;
import Interfaces.SuscriptorUbicacionEstado;
import Logica.ObserverJugador.ObservadorJugador;
import UbicablesEnTablero.otros.*;
import Utilidades.CuadruplaBooleana;
import Utilidades.DuplaDoble;
import UbicablesEnTablero.Jugador;
import UbicablesEnTablero.Fantasmas.*;
import Interfaces.EntidadConMovimiento;

public class Tablero{
    private final int SIZE_TABLERO = 20;
    private final int VELOCIDAD_JUEGO = 1;
    private final int MAX_LEVEL = 3;

    private LectorDeTeclado lectorTeclado;
    private EntidadRepresentable [][] tablero;
    private LinkedList <EntidadConMovimiento> entidadesMobiles;
    private EstadoDeJuego estado;
    private LectorDeNiveles lectorNiveles;
    private Jugador pacMan;
    private ObservadorJugador observerJugador;

    public Tablero(){
        tablero = new EntidadRepresentable[SIZE_TABLERO][SIZE_TABLERO];
        lectorNiveles = new LectorDeNiveles(this);
        entidadesMobiles =new LinkedList<EntidadConMovimiento>(); 
        lectorTeclado = new LectorDeTeclado();
        observerJugador = new ObservadorJugador();
    }

    public void moverEntidades(){
        Iterator<EntidadConMovimiento> it =  entidadesMobiles.iterator();
        EntidadConMovimiento e;
        DuplaDoble dup;
        CuadruplaBooleana c;
        while(it.hasNext()){
            e = it.next();
            dup = e.getUbicacion();
            c = ObtenerContexto((int)Math.round(dup.getX()),(int)Math.round(dup.getY()));
            //c.print();
            e.moverse(VELOCIDAD_JUEGO, c);
        }
        //control de colisiones
    }

    public CuadruplaBooleana ObtenerContexto(int x, int y){  
        CuadruplaBooleana c = new CuadruplaBooleana();
        if(x >= 0 && x < cantCeldas()-1){
            if(tablero[x+1][y] != null){
                c.setDireccion(tablero[x+1][y].objetoSolido(), 0);}
            else c.setDireccion(false, 0);}
        if(y >= 0+1 && y < cantCeldas()){
            if(tablero[x][y+1] != null){
                c.setDireccion(tablero[x][y+1].objetoSolido(), 1);}
            else c.setDireccion(false, 1);}
        if(x >= 0+1 && x < cantCeldas()){
            if(tablero[x-1][y] != null){
                c.setDireccion(tablero[x-1][y].objetoSolido(), 2);}
            else c.setDireccion(false, 2);}
        if(y>=0 && y<cantCeldas()-1){
            if(tablero[x][y-1] != null){
                c.setDireccion(tablero[x][y-1].objetoSolido(), 3);}
            else c.setDireccion(false, 3);}

        return c;
    }

    public int cantCeldas(){
        return SIZE_TABLERO;
    }

    public EntidadRepresentable getEntidad(int x, int y){
        return tablero[x][y];
    }

    public void LimpiarTablero(){
        //eliminar la tabla, sacar elementos de gui y poder empezar de cero
    }


    public void cargarTablero(int i){
        lectorNiveles.readFile(i);
    }

    public LinkedList<EntidadConMovimiento> obtenerEntidadesMobiles() {
        return entidadesMobiles;
    }

    public void agregarPared(int x, int y){
        tablero[x][y] = new Pared(x,y);
    }
    public void agregarPunto(int x, int y){
        tablero[x][y] = new Punto(x,y);
    }

    public void agregarBlinky(int x, int y) {
        tablero[x][y] = new Blinky(x,y);
        entidadesMobiles.addLast((EntidadConMovimiento)tablero[x][y]);
        observerJugador.suscribirseUbicacion((SuscriptorUbicacionEstado)tablero[x][y]);}

    public void agregarClyde(int x, int y) {
        tablero[x][y] = new Clyde(x,y);
        entidadesMobiles.addLast((EntidadConMovimiento)tablero[x][y]);
        observerJugador.suscribirseUbicacion((SuscriptorUbicacionEstado)tablero[x][y]);}
        
    public void agregarInky(int x, int y) {
        tablero[x][y] = new Inky(x,y);
        entidadesMobiles.addLast((EntidadConMovimiento)tablero[x][y]);
        observerJugador.suscribirseUbicacion((SuscriptorUbicacionEstado)tablero[x][y]);}

    public void agregarPinky(int x, int y) {
        tablero[x][y] = new Pinky(x,y);
        entidadesMobiles.addLast((EntidadConMovimiento)tablero[x][y]);
        observerJugador.suscribirseUbicacion((SuscriptorUbicacionEstado)tablero[x][y]);}

    public void agregarStrawberry(int x, int y) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agregarStrawberry'");
    }

    public void agregarProtagonista(int x, int y) {
       pacMan = new Jugador(x,y);
       tablero[x][y] = pacMan;
       entidadesMobiles.addFirst(pacMan);
       lectorTeclado.asignar(pacMan);
       pacMan.setObserver(observerJugador);
    }

    public int getMaxLevel(){
        return MAX_LEVEL;
    }

    public LectorDeTeclado getLectorDeTeclado(){
        return lectorTeclado;
    }

    public void removerDelTablero(int x, int y){
        tablero[x][y] = null;
    }

    public void removerEntidadesMobilesDeTablero(){
        Iterator<EntidadConMovimiento> it =  entidadesMobiles.iterator();
        EntidadConMovimiento e;
        DuplaDoble dup;
        while(it.hasNext()){
            e = it.next();
            removerDelTablero((int)Math.round(e.getUbicacion().getX()),(int)Math.round(e.getUbicacion().getY()));


        }
    }
}
