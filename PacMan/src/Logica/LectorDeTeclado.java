package Logica;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import UbicablesEnTablero.Jugador;

public class LectorDeTeclado implements KeyListener{
    Jugador pacMan;

    public LectorDeTeclado(){

        }
    
    public void FlechaDireccional(KeyEvent e){
        int tecla = e.getKeyCode();
        if(tecla == KeyEvent.VK_LEFT){
            pacMan.direccionar(2);

        }
        if(tecla == KeyEvent.VK_RIGHT){
            pacMan.direccionar(0);

        }
        if(tecla == KeyEvent.VK_UP){
            pacMan.direccionar(3);

        }
        if(tecla == KeyEvent.VK_DOWN){
            pacMan.direccionar(1);

        }
    }




    public void asignar(Jugador pacMan) {
        this.pacMan = pacMan;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        FlechaDireccional(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
