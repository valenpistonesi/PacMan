package Logica;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LectorDeTeclado extends KeyAdapter {
    
    public void FlechaDireccional(KeyEvent e){
        int tecla = e.getKeyCode();
        if(tecla == KeyEvent.VK_LEFT){}
        if(tecla == KeyEvent.VK_RIGHT){}
        if(tecla == KeyEvent.VK_UP){}
        if(tecla == KeyEvent.VK_DOWN){}
    }
    
}
