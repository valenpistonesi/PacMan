package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import Interfaces.EntidadConMovimiento;
import Interfaces.EntidadRepresentable;
import Logica.Tablero;
import Utilidades.DuplaDoble;

public class GUI extends JFrame {
    public final int SIZE_CELDA = 32;
    private final int ALTO_PANEL_VIDAS = 50;
    private final int MARGEN_IZQUIERDO = 50;
    private final int MARGEN_SUPERIOR = 50;
    public final int CANT_VIDAS = 5;

    private Tablero tablero;
    private int cantCeldasTablero;


    private PanelBase panelPrinc;
    private PanelVidas panelStats;
    private LectorDeTextos lectorScores;

    private ReproductorDeSonidos reproductorSonidos;


    public GUI(Tablero t){
        super("PacMan");
        
        tablero = t;
        cantCeldasTablero = t.cantCeldas();
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();//hace que entre mejor 
        this.setLocationRelativeTo(null); 
        this.setSize(SIZE_CELDA*cantCeldasTablero+MARGEN_IZQUIERDO*2,SIZE_CELDA*cantCeldasTablero+MARGEN_IZQUIERDO*2);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.BLACK);
        panelStats =new PanelVidas(cantCeldasTablero);
        this.getContentPane().add(panelStats);
        panelPrinc = new PanelBase(cantCeldasTablero);
        this.getContentPane().add(panelPrinc);
        this.addKeyListener(tablero.getLectorDeTeclado());
        lectorScores = new LectorDeTextos();
        reproductorSonidos = new ReproductorDeSonidos();

        
        
    }

    public void mostrarMensajeDerrota(int i){
        reproductorSonidos.reproducir(reproductorSonidos.getClipMuriendo());
        JOptionPane.showMessageDialog(this, "perdiste sos malaso", getTitle(), 1);
        String nombre =JOptionPane.showInputDialog(null,"Ingresa tu nombre");
        LectorDeTextos.agregarPuntaje(nombre, i);
        JOptionPane.showMessageDialog(this,"Puntajes mas altos:\n"+lectorScores.obtenerPuntajes(),getTitle(),1);
    }

    public void actualizarPosiciones(){
        LinkedList<EntidadConMovimiento> lista =tablero.obtenerEntidadesMobiles();
        Iterator<EntidadConMovimiento> it = lista.iterator(); 
        EntidadConMovimiento ecm;
        while(it.hasNext()){
            ecm = it.next();
            DuplaDoble ubi =ecm.getUbicacion();
            ecm.getRepGrafica().setLocation(convertirValorX(ubi.getX()),convertirValorY(ubi.getY()));
            
        }
    }

    public void agregarElementosGUI(){
        EntidadRepresentable e;
        for(int i = 0; i<cantCeldasTablero; i++){
            for(int j = 0; j < cantCeldasTablero; j++){
                e =tablero.getEntidad(i, j);
                //System.out.println("a crear "+i+"   "+j);
                if(e!= null){
                    e.CrearRepGrafica(SIZE_CELDA);
                    e.getRepGrafica().setLocation(convertirValorX(i),convertirValorY(j));
                    panelPrinc.add(e.getRepGrafica());}

            }
        }
        tablero.removerEntidadesMobilesDeTablero();
        repaint();
        reproductorSonidos.reproducir(reproductorSonidos.getClipInicio());
    }

    public void limpiarGui(){
        EntidadRepresentable e;
        for(int i = 0; i<cantCeldasTablero; i++){
            for(int j = 0; j < cantCeldasTablero; j++){
                e =tablero.getEntidad(i, j);
                if(e!= null){
                    panelPrinc.remove(e.getRepGrafica());
                }
            }
        }
        Iterator<EntidadConMovimiento> it = tablero.obtenerEntidadesMobiles().iterator();
        while (it.hasNext()){
            panelPrinc.remove((it.next()).getRepGrafica());
        }
        repaint();
    }

    //convierte un valor de x del tablero a ubicacion en la gui
    public int convertirValorX(double i){ 
        double toReturn =i*SIZE_CELDA+MARGEN_IZQUIERDO;
        return (int) Math.round(toReturn);
    }

    //convierte un valor de y del tablero a ubicacion en la gui
    public int convertirValorY(double i){  
        double toReturn =i*SIZE_CELDA+MARGEN_SUPERIOR;
        return (int) Math.round(toReturn);
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

    public void setVidas(int v){
        panelStats.setVidas(v);
    }

    public void setScore(int s){
        panelStats.setScore(s);
        reproductorSonidos.reproducir(reproductorSonidos.getClipComiendo());
    }

    public class PanelVidas extends JPanel {

        private ImageIcon vidaCompleta;
        private ImageIcon vidaVacia;
        private final int SIZE_VIDA = 40;
        
        private JLabel[] contenedoresDeVidas;
        private JLabel labelScore;

        public PanelVidas(int cantCelda){
            this.setBounds(0,0,SIZE_CELDA*cantCeldasTablero+MARGEN_IZQUIERDO*2 , ALTO_PANEL_VIDAS);
            this.setBackground(Color.blue);
            this.setLayout(null);
            vidaCompleta= new ImageIcon("src/assets/vidas/corazonLleno.png");
            vidaVacia = new ImageIcon("src/assets/vidas/corazonVacio.png");
            generarVidas(CANT_VIDAS);

            labelScore = new JLabel("Puntaje Total: 0");
            labelScore.setLocation(0,0);
            labelScore.setForeground(Color.WHITE);
            labelScore.setSize(new Dimension(200,50));
            //labelScore.setIcon(vidaCompleta);
            this.add(labelScore);
        }

        public void setScore(int i){
            labelScore.setText("Puntaje Total: "+i);
        }

        private void generarVidas(int vidas){
            contenedoresDeVidas = new JLabel[vidas];
            int largo = this.getSize().width- 30;
            JLabel jl;
            for(int i = 0; i<contenedoresDeVidas.length; i++){
                largo-= SIZE_VIDA;
                jl = new JLabel();
                jl.setSize(new Dimension(SIZE_VIDA,SIZE_VIDA));
                jl.setIcon(vidaCompleta);
                this.add(jl);
                jl.setLocation(largo,0);
                contenedoresDeVidas[i]= jl;
            }
        }

        public void setVidas(int c){
            if(c<=CANT_VIDAS){ 
                c = CANT_VIDAS - c;
                for(int i = 0; i< CANT_VIDAS; i++){
                    if(c>0){
                        contenedoresDeVidas[i].setIcon(vidaVacia);
                        c--;}
                    else contenedoresDeVidas[i].setIcon(vidaCompleta);
                }
            }
        }

    }

	public void mostrarMensajeVictoria(int i) {
        JOptionPane.showMessageDialog(this, "ganaste buenisimo", getTitle(), 1);
        String nombre =JOptionPane.showInputDialog(null,"Ingresa tu nombre");
        LectorDeTextos.agregarPuntaje(nombre, i);
        JOptionPane.showMessageDialog(this,"Puntajes mas altos:\n"+lectorScores.obtenerPuntajes(),getTitle(),1);
    }

    class ReproductorDeSonidos{
        private Clip pacManComiendo;
        private Clip pacManMuriendo;
        private Clip inicioDelJuego;

        public ReproductorDeSonidos(){
            AudioInputStream audioInput;
            try {
                audioInput = AudioSystem.getAudioInputStream(new File("src/assets/sonidos/pmchomp.wav"));
                pacManComiendo = AudioSystem.getClip();
                pacManComiendo.open(audioInput);
                audioInput = AudioSystem.getAudioInputStream(new File("src/assets/sonidos/pmdeath.wav"));
                pacManMuriendo = AudioSystem.getClip();
                pacManMuriendo.open(audioInput);
                audioInput = AudioSystem.getAudioInputStream(new File("src/assets/sonidos/pmringtone.wav"));
                inicioDelJuego = AudioSystem.getClip();
                inicioDelJuego.open(audioInput);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void reproducir(Clip c){
            if(c!= null&& !c.isRunning()){
                c.setFramePosition(0);
                c.start();
            }
        }

        public Clip getClipComiendo(){
            return pacManComiendo;
        }

        public Clip getClipMuriendo(){
            return pacManMuriendo;
        }
        public Clip getClipInicio(){
            return inicioDelJuego;
        }
    }
}
