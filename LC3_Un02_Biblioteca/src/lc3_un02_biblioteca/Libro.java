
package lc3_un02_biblioteca;

/**
 *
 * @author Zaragoza Angel Gabriel
 */
public class Libro {
    private String titulo;
    private float precio;
    private int estado;
    private Prestamo [] prestamos;
    
    //CONSTRUCTORES
    public Libro ()
    {}

    public Libro(String titulo, float precio, int estado, int cantPrestamos) {
        this.titulo = titulo;
        this.precio = precio;
        this.estado = estado;
        prestamos = new Prestamo[cantPrestamos];
    }
        
    //GETTERS

    public String getTitulo() {
        return titulo;
    }

    public float getPrecio() {
        return precio;
    }

    public int getEstado() {
        return estado;
    }
    
    
    //METODOS    
    public int agregarPrestamo(Prestamo nuevoPrest) {
        if (prestamos[prestamos.length-1] == null) {
            for (int i = 0; i < prestamos.length; i++) {
                if (prestamos[i] == null)
                {
                    prestamos[i] = nuevoPrest;
                    break;
                }            
            }
            if (nuevoPrest.isDevuelto())
                estado = 1;
            else
                estado = 2;
            return 1;
        }
        return -1;
    }
    
    public String listadoSolicitantes() {
        String cadena = "";
        for (int i = 0; i < prestamos.length; i++) {
            if (prestamos[i] != null) 
                cadena += "\t" + prestamos[i].getSolicitante() + "\n";
            else
                break;
                //Cortamos método aquí para que no siga recorriendo arreglo
        }    
        return cadena;
    }
    
    public void registrarExtravio() {        
        this.estado = 3;
    }
    
    
    @Override
    public String toString() {
        String cadena;
        cadena = "Título: " + titulo + " - Estado: ";
        switch(estado) {
            case 1:
                cadena += "Disponible";
                break;
            case 2:
                cadena += "Prestado";
                break;
            case 3:
                cadena += "Extraviado";
                break;
        }
        
        return cadena;
    }
    
    
}
