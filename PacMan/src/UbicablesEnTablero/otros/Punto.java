
package UbicablesEnTablero.otros;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Interfaces.EntidadRepresentable;
import Utilidades.DuplaDoble;

public class Punto implements EntidadRepresentable{
    private DuplaDoble parUbicacion;
    private JLabel repGrafica;
    private ImageIcon imagen;

    public Punto(int x, int y){
        parUbicacion = new DuplaDoble();
        parUbicacion.setX(x);
        parUbicacion.setY(y);;
    }
    
    public void CrearRepGrafica(int sizeCelda){
        imagen = new ImageIcon("src/assets/other/dot.png");
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
}
