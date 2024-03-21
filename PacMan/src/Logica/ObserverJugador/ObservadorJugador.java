package Logica.ObserverJugador;

import java.util.LinkedList;

import java.util.Iterator;

import Interfaces.SuscriptorPuntaje;
import Interfaces.SuscriptorUbicacionEstado;
import Utilidades.DuplaDoble;

public class ObservadorJugador {
    private LinkedList<SuscriptorPuntaje> suscriptosPuntaje;
    private LinkedList<SuscriptorUbicacionEstado> suscriptosUbicacionEstado;

    public ObservadorJugador(){
        suscriptosPuntaje = new LinkedList<SuscriptorPuntaje>();
        suscriptosUbicacionEstado = new LinkedList<SuscriptorUbicacionEstado>();
    }

    public void suscribirseUbicacion(SuscriptorUbicacionEstado s){
        suscriptosUbicacionEstado.addLast(s);
    }

    public void suscribirsePuntaje(SuscriptorPuntaje s){
        suscriptosPuntaje.addLast(s);
    }

    public void notificarDireccion(int i){
        Iterator<SuscriptorUbicacionEstado> it = suscriptosUbicacionEstado.iterator();
        while(it.hasNext()){
            it.next().notificacionDireccion(i);
        }
    }

    public void notificarUbicacion(DuplaDoble d){
        Iterator<SuscriptorUbicacionEstado> it = suscriptosUbicacionEstado.iterator();
        while(it.hasNext()){
            it.next().notificacionUbicacion(d);
        }
    }

    public void notificacionEstadoPeligro(boolean b){
        Iterator<SuscriptorUbicacionEstado> it = suscriptosUbicacionEstado.iterator();
        while(it.hasNext()){
            it.next().notificacionEstadoPeligro(b);
        }
    }

    public void notificarPerididaVida() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'notificarPerididaVida'");
    }

    public void notificarPuntosObtenidos(int puntosParaElJugador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'notificarPuntosObtenidos'");
    }


    
}
