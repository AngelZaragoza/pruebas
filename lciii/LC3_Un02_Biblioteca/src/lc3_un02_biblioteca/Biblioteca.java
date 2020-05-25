
package lc3_un02_biblioteca;

/**
 *
 * @author Zaragoza Angel Gabriel
 */
public class Biblioteca {
    private Libro[] libros;
    
    //CONSTRUCTORES
    public Biblioteca (int cantidad) {
        libros = new Libro[cantidad];
    }
    
    public void agregarLibro(Libro nuevoLibro) {
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] == null)
            {
                libros[i] = nuevoLibro;
                break;
            }            
        }       
        
    }
    
    //Devuelve un valor que representa la posicion de un Libro en el arreglo
    public int existeLibro(String titulo) {
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null) {
                if (libros[i].getTitulo().equals(titulo)) {
                    return i;
                }
            } else {
                break;
                //Cortamos método aquí para que no siga recorriendo arreglo
            }            
        }
        return -1;
    }
    
    public void agregarPrestamo(String titulo, Prestamo prestamo) {
        int i = existeLibro(titulo);
        if (i >= 0) {
            libros[i].agregarPrestamo(prestamo);
        }
    }
            
    public String listadoSolicitantes(String titulo) {
        String solicitantes = "\tEl Libro no existe o no está cargado";
        int i = existeLibro(titulo);

        if (i >= 0) {
            solicitantes = "Solicitantes de " + titulo + "\n";
            solicitantes += libros[i].listadoSolicitantes();
            return solicitantes;                
        }               
        
        return solicitantes;        
    }
    
    public void registrarExtravio(String titulo, String confirma) {
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null){
                if (libros[i].getTitulo().equals(titulo)) {
                    if (confirma.equals("s") || confirma.equals("S")) {
                        libros[i].registrarExtravio();
                        break;
                    } else {
                        
                    }
                }
            }                
            
        }
    }
    
    public int[] estadoLibros() {
        int [] estadoLibros = {0,0,0};
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null) {
                switch(libros[i].getEstado()) {
                    case 1:
                        estadoLibros[0]++;
                        break;
                    case 2:
                        estadoLibros[1]++;
                        break;
                    case 3:
                        estadoLibros[2]++;
                        break;
                }                    
            }            
        }
        
        return estadoLibros;
    }
    
    public float sumaPrecioExtraviados() {
        float totalExt = 0;
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null) {
                if(libros[i].getEstado() == 3)
                    totalExt += libros[i].getPrecio();
            }            
        }
        
        return totalExt;
    }
    
    @Override
    public String toString() {
        String cadena = "Lista de Libros en poder de la Biblioteca:\n";
        for (int i = 0; i < libros.length; i++) {            
            if (libros[i] != null) {
                cadena += "\t" + libros[i].toString() + "\n";
            }            
        }   
        
        return cadena;
    }
}
