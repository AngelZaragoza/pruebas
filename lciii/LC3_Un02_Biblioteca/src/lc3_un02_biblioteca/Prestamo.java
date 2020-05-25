
package lc3_un02_biblioteca;

/**
 *
 * @author Zaragoza Angel Gabriel
 */
public class Prestamo {
    private String solicitante;
    private int cantidadDias;
    private boolean devuelto;
    
    //CONSTRUCTORES
    public Prestamo ()
    {}

    public Prestamo(String solicitante, int cantidadDias, boolean devuelto) {
        this.solicitante = solicitante;
        this.cantidadDias = cantidadDias;
        this.devuelto = devuelto;
    }
    
    //GETTERS Y SETTERS

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public int getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(int cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }
    
    
    @Override
    public String toString() {
        String cadena;
        cadena = "Solic.: " + solicitante + " - Días: " + cantidadDias;
        if (devuelto)
            cadena += " - Devuelto";
        else
            cadena += " - NO Devuelto";
        
        return cadena;
                
    }
    
}
