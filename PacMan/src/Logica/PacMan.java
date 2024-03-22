package Logica;

import GUI.GUI;

public class PacMan {
    public static void main(String[] args) throws Exception {
        Tablero tablero = new Tablero();
        
        GUI gui = new GUI(tablero);

        TimerJuego timer = new TimerJuego(gui,tablero);

        EstadoDeJuego estado = new EstadoDeJuego(gui);
        
        tablero.agregarEstado(estado);
        estado.pasarTimer(timer);

        //ejecucion----------------
        int maxLevel = tablero.getMaxLevel();
        int levelActual = 1;
        while(estado.getPasarDeNivel()&& levelActual <= maxLevel){
            tablero.cargarTablero(levelActual);
            gui.agregarElementosGUI();

            timer.run();
            
            gui.limpiarGui();
            tablero.LimpiarTablero();
            


        }

        if(estado.getPasarDeNivel())
            gui.mostrarMensajeVictoria();
        System.out.println("fin del codigo");
    }

    public void cicloDeJuego(){
        
    }
}
