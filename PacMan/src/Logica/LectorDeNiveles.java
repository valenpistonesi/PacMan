package Logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LectorDeNiveles {
    private Tablero tablero;
    public LectorDeNiveles(Tablero t){
        tablero = t;
    }

    public void readFile(int i){ 
        File archivo = new File("src/niveles/nivel"+i+".txt");
        FileReader scanner;
        
        try {
            scanner = new FileReader(archivo);
            BufferedReader b = new BufferedReader(scanner);    
            char letraActual;
            int x = 0;
            int y = 0;
            String palabra = b.readLine();
            System.out.println(palabra);    
            //while ( (palabra = b.readLine()) != null&&palabra != "Layout:") {}
            if(true){
                //System.out.println("SE ENTRO EN EL IF");
                int sizeTablero = Integer.parseInt(b.readLine());
                System.out.println(sizeTablero);
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
                                //case 'o': tablero.agregarPuntoGrande(x,y); break;
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
}
