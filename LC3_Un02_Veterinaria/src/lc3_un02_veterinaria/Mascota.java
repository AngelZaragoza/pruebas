package lc3_un02_veterinaria;

/**
 *
 * @author Zaragoza Angel Gabriel
 */
public class Mascota {
    private int codigo;
    private String nombre;
    private int edad;
    
    //CONSTRUCTORES
    public Mascota()
    {}

    public Mascota(int codigo, String nombre, int edad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
    }
    
    //GETTERS Y SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
    @Override
    public String toString() {
        return "Nombre: " + nombre + " - Edad: " + edad;
    }
}
