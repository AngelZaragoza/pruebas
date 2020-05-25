package lc3_un02_veterinaria;

/**
 *
 * @author Zaragoza Angel Gabriel
 */
public class Cliente {
    private int codigo;
    private String nombre;
    private int antiguedad;
    private Mascota mascota;
    
    //CONTRUCTORES
    public Cliente()
    {}

    public Cliente(int codCliente, String nombreCliente, int antigCliente) {
        this.codigo = codCliente;
        this.nombre = nombreCliente;
        this.antiguedad = antigCliente;
        this.mascota = null;
    }
    
    //GETTERS Y SETTERS
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public void agregarMascota (int codigo, String nombre, int edad) {
        mascota = new Mascota(codigo, nombre, edad);        
    }
    
    public void agregarMascota (Mascota masc) {
        mascota = masc;
    }
    
    
    @Override
    public String toString() {
        return "Cód: " + codigo + " - Nombre: " + nombre +
                " - Antigüedad: " + antiguedad + " años." +
                "\n Mascota: " + mascota.toString();
    }
    
    
}
