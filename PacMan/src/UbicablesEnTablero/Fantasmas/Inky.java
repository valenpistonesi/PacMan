package UbicablesEnTablero.Fantasmas;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Utilidades.CuadruplaBooleana;
import Utilidades.DuplaDoble;

public class Inky extends Fantasma{
    private DuplaDoble parUbicacion;
    private JLabel repGrafica;
    private ImageIcon imagen;

    public Inky(int x, int y){
        super(x, y);
    }
    
    public void CrearRepGrafica(int sizeCelda){
        imagen = new ImageIcon("src/assets/ghosts/inky.png");
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
    public void moverse(double v,CuadruplaBooleana i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moverse'");
    }
}
