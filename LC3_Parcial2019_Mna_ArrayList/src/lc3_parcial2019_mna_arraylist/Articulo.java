
package lc3_parcial2019_mna_arraylist;

/**
 *
 * @author Zaragoza Angel Gabriel
 */
public class Articulo {
        private int numero;
    private String nombre;
    private float precioRegular;
    private float precioOferta;
    private int diasOferta;
    private int stock;
    
    //CONSTRUCTORES
    public Articulo ()
    {}

    public Articulo(int numero, String nombre, float precioRegular, float precioOferta, int diasOferta, int stock) {
        this.numero = numero;
        this.nombre = nombre;
        this.precioRegular = precioRegular;
        this.precioOferta = precioOferta;
        this.diasOferta = diasOferta;
        this.stock = stock;
    }    

    
    //GETTERS Y SETTERS
    public int getNumero() {
        return numero;
    }
   
    public String getNombre() {
        return nombre;
    }
    
    public float getPrecioRegular() {
        return precioRegular;
    }
    
    public float getPrecioOferta() {
        return precioOferta;
    }

    public int getDiasOferta() {
        return diasOferta;
    }
    
    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "Art: " + numero + " - Nombre: " + nombre + " - Precio Regular $" + precioRegular + " - Precio Oferta $" + precioOferta;
    }

}
