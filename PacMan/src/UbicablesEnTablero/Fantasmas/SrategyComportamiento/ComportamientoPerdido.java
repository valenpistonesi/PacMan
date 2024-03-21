package UbicablesEnTablero.Fantasmas.SrategyComportamiento;

import java.util.Random;

import Utilidades.DuplaDoble;

public class ComportamientoPerdido implements InterfazComportamiento{

    @Override
    public int[] direccionar(DuplaDoble miUbicacion, DuplaDoble pacUbicacion, int pacDireccion) {
        int[] direcciones = new int[3];
        Random random = new Random();
        
        for (int i = 0; i < direcciones.length; i++) {
            int numeroAleatorio;
            boolean repetido;
            do {
                repetido = false;
                numeroAleatorio = random.nextInt(3) + 0; 
                for (int j = 0; j < i; j++) {
                    if (direcciones[j] == numeroAleatorio) {
                        repetido = true;
                        break;
                    }
                }
            } while (repetido);
            direcciones[i] = numeroAleatorio;
        }
        
        return direcciones;
    }
    
    
}
