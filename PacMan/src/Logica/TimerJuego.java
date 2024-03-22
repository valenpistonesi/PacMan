package Logica;

import GUI.GUI;

class TimerJuego extends Thread {
    private int tiempo;
    private GUI graficos;
    private Tablero tablero;
    private boolean juegoContinua;

    public TimerJuego(GUI g, Tablero t) {
        this.graficos = g;
        this.tablero = t;
        tiempo = 100;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public void run() {
        juegoContinua = true;
        while (juegoContinua) {
            try {
                tablero.moverEntidades();
                graficos.actualizarPosiciones();


                Thread.sleep(tiempo); // Esperar el tiempo especificado
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void detenerJuego(){
        juegoContinua = false;

    }
}