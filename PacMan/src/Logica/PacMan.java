package Logica;

import GUI.GUI;

public class PacMan {
    public static void main(String[] args) throws Exception {
        Tablero t = new Tablero();
        
        GUI g = new GUI(t);
        System.out.println("Hello, World!");
        
    }
}
