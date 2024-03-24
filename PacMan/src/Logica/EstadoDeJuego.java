package Logica;

import GUI.GUI;
import Interfaces.SuscriptorPuntaje;

public class EstadoDeJuego implements SuscriptorPuntaje{
    protected final int VIDAS_MAXIMAS = 5;
    protected int cantDeObjetivos;
    protected int puntaje;
    protected int cantDeVidas;
    protected GUI PanelEstado;
    protected TimerJuego timer;
    protected boolean pasarDeNivelalCompletarObjetivos;

    public EstadoDeJuego(GUI g){
        PanelEstado = g;
        puntaje = 0;
        pasarDeNivelalCompletarObjetivos = true;
    }

    public void estadoInicial(int i){
        cantDeVidas = PanelEstado.CANT_VIDAS;
        PanelEstado.setVidas(cantDeVidas);
        cantDeObjetivos = i;
    }

    @Override
    public void notificacionDisminucionCantDeObjetivos() {
        cantDeObjetivos--;
        if(cantDeObjetivos == 0)
        timer.detenerJuego();
    }

    @Override
    public void notificacionPuntaje(int puntos) {
        puntaje += Math.abs(puntos - Math.round(puntos*timer.getTiempo()*0.001));
        PanelEstado.setScore(puntaje);
    }

    @Override
    public void notificacionPerdidaDeVida() {
        cantDeVidas--;
        PanelEstado.setVidas(cantDeVidas);
        if(cantDeVidas == 0){
            pasarDeNivelalCompletarObjetivos = false;
            timer.detenerJuego();
            PanelEstado.mostrarMensajeDerrota(puntaje);
        }
    }

    public void pasarTimer(TimerJuego timer) {
        this.timer = timer;
    }

    public boolean getPasarDeNivel() {
        return pasarDeNivelalCompletarObjetivos;
    }

	public void reiniciarPuntaje() {
		puntaje = 0;}

    public int getPuntaje(){
        return puntaje;
    }

}
