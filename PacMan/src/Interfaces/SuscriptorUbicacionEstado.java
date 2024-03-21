package Interfaces;

import Utilidades.DuplaDoble;

public interface SuscriptorUbicacionEstado {
    public void notificacionDireccion(int i);
    public void notificacionUbicacion(DuplaDoble d);
    public void notificacionEstadoPeligro(boolean b);
}
    

