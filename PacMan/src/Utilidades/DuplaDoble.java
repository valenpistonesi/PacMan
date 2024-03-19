package Utilidades;

public class DuplaDoble {
    private double[] dup;

    public DuplaDoble(){
        dup = new double[2];
    }

    public DuplaDoble(double x, double y){
        dup = new double[2];
        dup[0]=x;
        dup[1] =y;
    }

    public double getX(){
        return dup[0];
    }
    public double getY(){
        return dup[1];
    }
    public void setX(double i){
        dup[0]= i;
    }
    public void setY(double i){
        dup[1]= i;
    }

    


    
}
