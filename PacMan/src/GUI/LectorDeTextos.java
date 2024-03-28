package GUI;

import java.io.*;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class LectorDeTextos {

    public LectorDeTextos(){
    }

    public static void agregarPuntaje(String nombre, int puntaje) {
        //File file = new File("./src/GUI/Puntajes/puntajes.txt");
    	
    	InputStream inputStream = LectorDeTextos.class.getResourceAsStream("puntajes.txt");

        // Convertir InputStream a Reader
        Reader reader = new InputStreamReader(inputStream);

        TreeMap<Integer, String> puntajes = new TreeMap<>();
        try {
         
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                puntajes.put(Integer.parseInt(parts[1]), parts[0]);
            }
            br.close();
            puntajes.put(puntaje, nombre);
            OutputStream outputStream = new FileOutputStream("./src/GUI/puntajes.txt");
            Writer writer = new OutputStreamWriter(outputStream);
            BufferedWriter escritor = new BufferedWriter(writer);
                        
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
        //File file = new File("./src/GUI/Puntajes/puntajes.txt");
        InputStream inputStream = LectorDeTextos.class.getResourceAsStream("puntajes.txt");
        Reader reader = new InputStreamReader(inputStream);
        TreeMap<Integer, String> puntajes = new TreeMap<Integer,String>();
        try {
            BufferedReader br = new BufferedReader(reader);
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
    
    public static File convertirISaFile(InputStream inputStream) {
        try {
            File toReturn = File.createTempFile("tempfile", ".tmp");
            try (FileOutputStream fileOutputStream = new FileOutputStream(toReturn)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                }
            }

            return toReturn;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

    

