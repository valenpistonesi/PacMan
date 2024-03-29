package Logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class LectorDeNiveles {
    private Tablero tablero;
    public LectorDeNiveles(Tablero t){
        tablero = t;
    }

    public void readFile(int i){ 
    	
        //File archivo = new File("./src/niveles/nivel"+i+".txt");
        File archivo = convertirISaFile(LectorDeNiveles.class.getResourceAsStream("nivel"+i+".txt"));
        FileReader scanner;
        
        try {
            scanner = new FileReader(archivo);
            BufferedReader b = new BufferedReader(scanner);    
            char letraActual;
            int x = 0;
            int y = 0;
            String palabra = b.readLine();    
            if(true){
  
                int sizeTablero = Integer.parseInt(b.readLine());
                while(y<sizeTablero){
                    x = 0;
                    palabra =b.readLine();
                    int length = palabra.length();
                    for(int j=0;j<length;j++){
                        letraActual = palabra.charAt(j);
                        if(letraActual != '[' && letraActual != ']'){
                            //+System.out.println(x+" "+y);
                            switch (letraActual){                     
                                case '@': tablero.agregarProtagonista(x,y);break;                    
                                case 't': tablero.agregarPared(x, y); break;
                                case 'b': tablero.agregarBlinky(x,y); break;
                                case 'c': tablero.agregarClyde(x,y); break;
                                case 'i' : tablero.agregarInky(x,y); break;
                                case 'p' :tablero.agregarPinky(x,y);break;
                                case 's' :tablero.agregarStrawberry(x,y);break;
                                case '.': tablero.agregarPunto(x,y);break;
                                case 'a': tablero.agregarManzana(x,y); break;
                                default:{}
                            }
                            x++;
                        }
                    }
                    y++;
                }
            }
            b.close();
        } catch (IOException e) {
            e.printStackTrace();
        }   
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
