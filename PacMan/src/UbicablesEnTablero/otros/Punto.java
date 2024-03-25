
package UbicablesEnTablero.otros;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Interfaces.EntidadRepresentable;
import UbicablesEnTablero.Jugador;
import Utilidades.DuplaDoble;

public class Punto implements EntidadRepresentable{
    protected DuplaDoble parUbicacion;
    protected JLabel repGrafica;
    protected ImageIcon imagen;
    protected int puntos;

    public Punto(int x, int y){
        parUbicacion = new DuplaDoble();
        parUbicacion.setX(x);
        parUbicacion.setY(y);
        puntos = 100;
        imagen = new ImageIcon("./src/assets/other/dot.png");
    }
    
    public void CrearRepGrafica(int sizeCelda){
        
        repGrafica = new JLabel(); 
        repGrafica.setSize(new Dimension(sizeCelda,sizeCelda));
        repGrafica.setForeground(Color.blue);
        repGrafica.setIcon(imagen);

    }

    public JLabel getRepGrafica(){
        return repGrafica;
    }

    public DuplaDoble getUbicacion(){
        return parUbicacion;

    }

    public boolean objetoSolido(){
        return false;
    }

    @Override
    public void colisionConJugador(Jugador j) {
        j.obtenerPuntos(puntos);
        j.disminuirCantObjetivos();
        repGrafica.setIcon(null);
    }
}
