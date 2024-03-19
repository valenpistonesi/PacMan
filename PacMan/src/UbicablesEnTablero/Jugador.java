package UbicablesEnTablero;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import Interfaces.EntidadConMovimiento;
import Interfaces.EntidadRepresentable;
import Utilidades.CuadruplaBooleana;
import Utilidades.DuplaDoble;

import java.awt.Dimension;

public class Jugador implements EntidadRepresentable, EntidadConMovimiento { 
    private final double multiplicadorDeVelocidad = 0.5;

    private int direccion;
    private DuplaDoble parUbicacion;
    JLabel repGrafica;
    ImageIcon[] imagen; 
    int animationCounter;
   
 
    public Jugador(double x, double y){
        parUbicacion = new DuplaDoble();
        parUbicacion.setX(x);
        parUbicacion.setY(y);;
        direccion = 0;
        imagen = new ImageIcon[12];
        animationCounter = 0;
    }

      
    public void direccionar(int i){
        if(i <=3){
           direccion = i;
        }
        else System.out.println("direccion erronea");
    }

    public void moverse(double velocidad, CuadruplaBooleana c){
        double x = parUbicacion.getX();
        double y = parUbicacion.getY();
        switch(direccion){
            case 0:{
                if(c.getDireccion(0)== false){
                    x=x + velocidad*multiplicadorDeVelocidad;//DERECHA
                    y = Math.round(y);
                    repGrafica.setIcon(imagen[animationCounter+3*direccion]);}
            }
            break;
            case 1:{
                if(c.getDireccion(1)== false){
                    y = y + velocidad*multiplicadorDeVelocidad;//ABAJO
                    x = Math.round(x);
                    repGrafica.setIcon(imagen[animationCounter+3*direccion]);}
            }
            break;
            case 2:{
                if(c.getDireccion(2)== false){
                    x =x - velocidad*multiplicadorDeVelocidad;//IZQUIERDA
                    y = Math.round(y);
                    repGrafica.setIcon(imagen[animationCounter+3*direccion]);}
            }
            break;
            case 3:{
                if(c.getDireccion(3)== false){
                    x = Math.round(x);
                    y = y - velocidad*multiplicadorDeVelocidad;//ARRIBA
                    repGrafica.setIcon(imagen[animationCounter+3*direccion]);}
            }    
            break; }

            parUbicacion.setX(x);
            parUbicacion.setY(y);
            System.out.println(x+ " "+ y);



        animationCounter++;    
        if(animationCounter>= 3){
            animationCounter= 0;
        }

    }

    @Override
    public void actualizarPosicionGrafica() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarPosicionGrafica'");
    }

    @Override
    public void CrearRepGrafica(int sizeCelda) {
        for (int i = 0; i<3; i++){   
            imagen[i] = new ImageIcon("src/assets/PacMan/right/"+(i+1)+".png");
        }
        for (int i = 0; i<3; i++){
            imagen[i+3*1] = new ImageIcon("src/assets/PacMan/down/"+(i+1)+".png");
        }
        for (int i = 0; i<3; i++){
            imagen[i+3*2] = new ImageIcon("src/assets/PacMan/left/"+(i+1)+".png");
        }
        for (int i = 0; i<3; i++){
            imagen[i+3*3] = new ImageIcon("src/assets/PacMan/up/"+(i+1)+".png");
        }

        repGrafica = new JLabel(); 
        repGrafica.setSize(new Dimension(sizeCelda,sizeCelda));
        repGrafica.setForeground(Color.blue);
        repGrafica.setIcon(imagen[0]);}

    @Override
    public JLabel getRepGrafica() {
        System.out.println("repGrafica");
        return repGrafica;
    }

    @Override
    public DuplaDoble getUbicacion() {
       return parUbicacion;
    }

    public boolean objetoSolido(){
        return false;
    }
}
