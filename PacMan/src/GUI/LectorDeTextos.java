package GUI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class LectorDeTextos {

    public LectorDeTextos(){
    }

    public static void agregarPuntaje(String nombre, int puntaje) {
        File file = new File("src/GUI/Puntajes/puntajes.txt");
        TreeMap<Integer, String> puntajes = new TreeMap<>();
        try {
            if (file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    puntajes.put(Integer.parseInt(parts[1]), parts[0]);
                }
                br.close();
            }
            puntajes.put(puntaje, nombre);
            BufferedWriter escritor = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<Integer, String> entry : puntajes.entrySet()) {
                escritor.write(entry.getValue() + "," + entry.getKey() + "\n");
            }
            escritor.close();
            System.out.println("Puntaje de " + nombre + " agregado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al agregar el puntaje: " + e.getMessage());
        }
    }

    public String obtenerPuntajes(){

        StringBuilder puntajesStringBuilder = new StringBuilder();
            File file = new File("src/GUI/Puntajes/puntajes.txt");
            TreeMap<Integer, String> puntajes = new TreeMap<Integer,String>();
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    String[] partes = line.split(",");
                    puntajes.put(Integer.parseInt(partes[1]), partes[0]);
                }
                br.close();
                NavigableMap<Integer,String> map =puntajes.descendingMap();
                int i = 1;
                for (Map.Entry<Integer, String> entry : map.entrySet()) {
                    puntajesStringBuilder.append(i+".").append(entry.getValue()).append(": ").append(entry.getKey()).append("\n");
                    i++;
                }
            } catch (IOException e) {
                System.out.println("Error al obtener los puntajes: " + e.getMessage());
            }

            return puntajesStringBuilder.toString();
    }
}
    

