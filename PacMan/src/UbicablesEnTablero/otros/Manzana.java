package UbicablesEnTablero.otros;

import javax.swing.ImageIcon;

import UbicablesEnTablero.Jugador;

public class Manzana extends Punto {
    public Manzana(int x, int y){
        super(x, y);
        puntos = 200;
        imagen = new ImageIcon("./src/assets/other/apple.png");

    }

    public void colisionConJugador(Jugador j){
        super.colisionConJugador(j);
        j.asustarFantasmas(30);
    }
    
}
