package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Interfaces.EntidadConMovimiento;
import Interfaces.UbicableEnTablero;
import Logica.Tablero;

public class GUI extends JFrame {
    public final int SIZE_CELDA = 32;
    private final int ALTO_PANEL_VIDAS = 50;
    private final int MARGEN_IZQUIERDO = 50;
    private final int MARGEN_SUPERIOR = 50;

    private Tablero tablero;
    private int cantCeldasTablero;
    private LinkedList<EntidadConMovimiento> entidadesMoviles;



    private JPanel panelPrinc;
    private JPanel panelStats;


    public GUI(Tablero t){
        super("PacMan");
        
        tablero = t;
        cantCeldasTablero = t.cantCeldas();
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();//hace que entre mejor 
        this.setLocationRelativeTo(null); 
        this.setSize(SIZE_CELDA*cantCeldasTablero+MARGEN_IZQUIERDO*2,SIZE_CELDA*cantCeldasTablero+MARGEN_IZQUIERDO*2);
        //this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.BLACK);
        this.getContentPane().add(new PanelVidas(cantCeldasTablero));
        panelPrinc = new PanelBase(cantCeldasTablero);
        this.getContentPane().add(panelPrinc);

        /*JLabel j = new JLabel();
        j.setText("chau");
        j.setBounds(1,200,50,50);
        j.setForeground(Color.GREEN);
        panelPrinc.add(j);*/

        t.cargarTablero();
        agregarElementosGUI();
        
    }

    public void agregarElementosGUI(){
        UbicableEnTablero e;
        for(int i = 0; i<cantCeldasTablero; i++){
            for(int j = 0; j < cantCeldasTablero; j++){
                e =tablero.getEntidad(i, j);
                System.out.println("a crear "+i+"   "+j);
                if(e!= null){
                    if(e.getRepGrafica()!= null){}
                        e.CrearRepGrafica(SIZE_CELDA);
                        System.out.println("creado  "+convertirValorX(i)+"   "+convertirValorY(j));
                        e.getRepGrafica().setLocation(convertirValorX(i),convertirValorY(j));
                        panelPrinc.add(e.getRepGrafica());}

            }
        }
        repaint();
        entidadesMoviles =tablero.obtenerEntidadesMobiles();
    }

    //convierte un valor de x del tablero a ubicacion en la gui
    public int convertirValorX(int i){
        return i*SIZE_CELDA+MARGEN_IZQUIERDO;
    }

    //convierte un valor de y del tablero a ubicacion en la gui
    public int convertirValorY(int i){  
        return i*SIZE_CELDA+MARGEN_SUPERIOR;
    }



   public class PanelBase extends JPanel{

        public PanelBase(int tamanoTablero){
            this.setVisible(true);
            this.setBounds(0,0,SIZE_CELDA*cantCeldasTablero+MARGEN_IZQUIERDO*2 , SIZE_CELDA*cantCeldasTablero+MARGEN_IZQUIERDO*2); 
            this.setPreferredSize(new Dimension(600,600));
            this.setLayout(null);
            this.setBackground(Color.DARK_GRAY);
        }


    
    }

    public class PanelVidas extends JPanel {

        public PanelVidas(int cantCelda){
            this.setBounds(0,0,SIZE_CELDA*cantCeldasTablero+MARGEN_IZQUIERDO*2 , 50);
            this.setBackground(Color.blue);

        }
        
    }

    
}
