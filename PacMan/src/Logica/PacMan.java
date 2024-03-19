package Logica;

import GUI.GUI;

public class PacMan {
    Tablero tablero;
    GUI gui; 
    TimerJuego timer;
    public static void main(String[] args) throws Exception {
        Tablero tablero = new Tablero();
        
        GUI gui = new GUI(tablero);

        TimerJuego timer = new TimerJuego(gui,tablero);
        
        
        //ejecucion----------------
        boolean continuar= true;
        int maxLevel = tablero.getMaxLevel();
        int levelActual = 1;
        while(continuar && levelActual <= maxLevel){
            tablero.cargarTablero(levelActual);
            gui.agregarElementosGUI();

            timer.run();


        }
        System.out.println("fin del codigo");
    }

    public void cicloDeJuego(){
        
    }
}
