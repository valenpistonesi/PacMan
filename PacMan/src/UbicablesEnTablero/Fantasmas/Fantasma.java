package UbicablesEnTablero.Fantasmas;



import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Interfaces.EntidadConMovimiento;
import Interfaces.EntidadRepresentable;
import Interfaces.SuscriptorUbicacionEstado;
import UbicablesEnTablero.Jugador;
import UbicablesEnTablero.Fantasmas.SrategyComportamiento.ComportamientoAgresivo;
import UbicablesEnTablero.Fantasmas.SrategyComportamiento.ComportamientoMiedo;
import UbicablesEnTablero.Fantasmas.SrategyComportamiento.Contexto;
import UbicablesEnTablero.Fantasmas.SrategyComportamiento.InterfazComportamiento;
import Utilidades.CuadruplaBooleana;
import Utilidades.DuplaDoble;

public abstract class Fantasma implements EntidadRepresentable,EntidadConMovimiento,SuscriptorUbicacionEstado{
    protected DuplaDoble parUbicacion;
    protected JLabel repGrafica; 
    protected double multiplicadorDeVelocidad = 0.2;
    protected DuplaDoble ubicacionBase;
    protected int puntosParaElJugador; 

    protected ImageIcon imagen;
    protected ImageIcon ojos;
    protected ImageIcon miedo;
   
    protected DuplaDoble pacmanUbicacion;
    protected int pacmanDireccion;

    protected Contexto contenerdorComportamiento;
    protected ComportamientoMiedo comportamientoPeligro;
    protected InterfazComportamiento comportamientoDefault;
    protected ComportamientoAgresivo comportamientoAtaque;

    protected boolean escapandoDeJugador;
    protected boolean volverABase;


    public Fantasma(int x, int y){
        puntosParaElJugador = 500;
        ubicacionBase = new DuplaDoble(x,y);
        parUbicacion = new DuplaDoble();
        parUbicacion.setX(x);
        parUbicacion.setY(y);
        contenerdorComportamiento = new Contexto();
        comportamientoAtaque= new ComportamientoAgresivo();
        comportamientoPeligro = new ComportamientoMiedo();
        volverABase = false;
        ojos = new ImageIcon("./src/assets/ghosts/ojosdefantasma.png");
        miedo = new ImageIcon("./src/assets/ghosts/blueghost.png");
    }
    
    public abstract void CrearRepGrafica(int sizeCelda);

    public JLabel getRepGrafica(){
        return repGrafica;
    }

    public DuplaDoble getUbicacion(){
        return parUbicacion;

    }

    public boolean objetoSolido(){
        return false;

    }

    public void notificacionDireccion(int i){
        pacmanDireccion = i;
    }

    public void notificacionUbicacion(DuplaDoble d){
        pacmanUbicacion = d;

    }

    public void volverABase(double velocidad){
        int[] direccionesDeseadas = contenerdorComportamiento.obtenerDirecciones(parUbicacion, ubicacionBase, pacmanDireccion);
        int direccion = direccionesDeseadas[0];
        double x = parUbicacion.getX();
        double y = parUbicacion.getY();
        switch(direccion){
            case 0:{ 
                x=x + velocidad;//DERECHA
                y = Math.round(y);
            }
            break;
            case 1:{  
                 y = y + velocidad;//ABAJO
                 x = Math.round(x);
            }
            break;
            case 2:{
                x =x - velocidad;//IZQUIERDA
                y = Math.round(y);
            }
            break;
            case 3:{
                x = Math.round(x);
                y = y - velocidad;//ARRIBA
            }    
            break; }
        parUbicacion.setX(x);
        parUbicacion.setY(y);

        if(Math.round(parUbicacion.getX()) ==Math.round(ubicacionBase.getX()) && Math.round(parUbicacion.getY()) ==Math.round(ubicacionBase.getY())){
           volverABase=false;  
           escapandoDeJugador = false;   
           repGrafica.setIcon(imagen);
           contenerdorComportamiento.setComportamiento(comportamientoDefault);}

    }

    @Override
    public void moverse(double velocidad,CuadruplaBooleana c) {
        if(volverABase)
            volverABase(velocidad);
        else{
            int direccion;
            int[] direccionesDeseadas = contenerdorComportamiento.obtenerDirecciones(parUbicacion, pacmanUbicacion, pacmanDireccion);
            if(!c.getDireccion(direccionesDeseadas[0]))
                direccion = direccionesDeseadas[0];
            else 
                if(!c.getDireccion(direccionesDeseadas[1]))
                    direccion =direccionesDeseadas[1];
                else
                    direccion = direccionesDeseadas[2];
            double x = parUbicacion.getX();
            double y = parUbicacion.getY();
            switch(direccion){
                case 0:{
                    if(c.getDireccion(0)== false){
                        x=x + velocidad*multiplicadorDeVelocidad;//DERECHA
                        y = Math.round(y);}
                }
                break;
                case 1:{
                    if(c.getDireccion(1)== false){
                        y = y + velocidad*multiplicadorDeVelocidad;//ABAJO
                        x = Math.round(x);}
                }
                break;
                case 2:{
                    if(c.getDireccion(2)== false){
                        x =x - velocidad*multiplicadorDeVelocidad;//IZQUIERDA
                        y = Math.round(y);}
                }
                break;
                case 3:{
                    if(c.getDireccion(3)== false){
                        x = Math.round(x);
                        y = y - velocidad*multiplicadorDeVelocidad;}//ARRIBA
                }    
                break; }

                parUbicacion.setX(x);
                parUbicacion.setY(y);
        }
    }

    public void colisionConJugador(Jugador j){
       
        if(!volverABase){
                volverABase = true;
            if(escapandoDeJugador){
                repGrafica.setIcon(ojos);
                contenerdorComportamiento.setComportamiento(comportamientoAtaque);
                j.obtenerPuntos(puntosParaElJugador);}
            else{ 
                contenerdorComportamiento.setComportamiento(comportamientoAtaque);
                repGrafica.setIcon(ojos);
                j.perderVida();
            }
        }
    }

    public void notificacionEstadoPeligro(boolean s){
        if(s){
            escapandoDeJugador = true;
            repGrafica.setIcon(miedo);
            contenerdorComportamiento.setComportamiento(comportamientoPeligro);
        } else{
            escapandoDeJugador = false;
            repGrafica.setIcon(imagen);
            contenerdorComportamiento.setComportamiento(comportamientoDefault);
        }
    }



}

