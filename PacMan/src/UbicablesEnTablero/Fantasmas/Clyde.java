package UbicablesEnTablero.Fantasmas;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Utilidades.CuadruplaBooleana;
import Utilidades.DuplaDoble;

public class Clyde extends Fantasma {
    private DuplaDoble parUbicacion;
    private JLabel repGrafica;
    private ImageIcon imagen;

    public Clyde(int x, int y){
        super(x, y);
    }
    
    public void CrearRepGrafica(int sizeCelda){
        imagen = new ImageIcon("src/assets/ghosts/clyde.png");
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

    @Override
    public void actualizarPosicionGrafica() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarPosicionGrafica'");
    }

    @Override
    public void moverse(double c,CuadruplaBooleana i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moverse'");
    }
    
}
