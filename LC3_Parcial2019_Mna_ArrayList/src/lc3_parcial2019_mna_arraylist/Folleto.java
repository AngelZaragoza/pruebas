
package lc3_parcial2019_mna_arraylist;

import java.util.ArrayList;

/**
 *
 * @author Zaragoza Angel Gabriel
 */
public class Folleto {
    private ArrayList<Articulo> ofertas;
    private String fechaInicio;
    
    //CONSTRUCTOR

    public Folleto(String fechaInicio, int cantArticulos) {
        this.ofertas = new ArrayList<>(cantArticulos);
        this.fechaInicio = fechaInicio;
    }
    
    //METODOS
    //Agrega oferta al ArrayList
    public void agregarOferta(Articulo oferta) {
        ofertas.add(oferta);
        int i = ofertas.indexOf(oferta);
        System.out.println("Oferta agregada: " + ofertas.get(i).getNombre());
        
    }
    
    //Devuelve la cantidad de ofertas de más de 5 días
    public int ofertasMasDeCincoDias() {
        int cant = 0;
        int prueba = 0;
        for (Articulo art : ofertas) {
            prueba++;
            if(art.getDiasOferta() > 5)
                cant++;
        }        
        System.out.println("Cantidad de pasadas " + prueba);
        return cant;
    }
    
    //Devuelve la cantidad total de unidades en oferta (stock)
    public int unidadesEnOferta() {
        int cant = 0;
        //Recorremos con for mejorado y acumulamos cantidad
        for (Articulo art : ofertas) {
            cant += art.getStock();
        }
        
        //Este código lo puse sólo para comprobar el for común,
        //y al parecer no hace falta comprobar nulls. Debo leer más
        /*
        int prueba = 0;
        for (int i = 0; i < ofertas.size(); i++) {
            prueba += ofertas.get(i).getStock();            
        }
        System.out.println("Cantidad de prueba: " + prueba);
        
        */
        return cant;
    }
    
    //Devuelve la cantidad de ofertas con descuento mayor a $20
    public int descuentoMasDe20() {
        int cant = 0;
        for (Articulo oferta : ofertas) {
            float dif = oferta.getPrecioRegular() - oferta.getPrecioOferta();
            if(dif > 20)
                cant++;
        }
        
        return cant;
    }
    
    public String recaudacionPorArticulo(int nroArt) {
        //Si no encuentra coincidencias al terminar el método, devuelve esta cadena
        String cadena = "El artículo ingresado no existe en las ofertas";
        
        //Crea un Articulo nulo, y lo inicializa solo si se encuentra el nroArt
        Articulo art = null;        
        for (Articulo oferta : ofertas) {
            if (oferta.getNumero() == nroArt) {
                art = oferta;
                break;
            }
        }
        
        //Si se encontró coincidencia, arma una cadena con el resultado
        if (art != null) {
            float monto = art.getPrecioOferta() * art.getStock();
            cadena = "Monto a recaudar por la venta de "
                    + art.getNombre() + ": $" + monto;            
        }        
        
        return cadena;
    }
    
    @Override
    public String toString() {
        String cadena;
        cadena = "Folleto de Ofertas desde " + fechaInicio + ":";
        for (Articulo oferta : ofertas) {
            cadena += "\n\t" + oferta.toString();
        }
        
        return cadena;
                
    }
    
}
