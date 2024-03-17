package Logica;

import GUI.GUI;

class TimerJuego extends Thread {
    private int tiempo;
    private GUI graficos;
    private Tablero tablero;

    public TimerJuego(GUI g, Tablero t) {
        this.graficos = g;
        this.tablero = t;
        tiempo = 500;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("no paro de mandar mensajes soy re denso");

                Thread.sleep(tiempo); // Esperar el tiempo especificado
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}