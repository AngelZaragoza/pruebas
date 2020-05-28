package lc3_parcial2019_mna;

/**
 *
 * @author Zaragoza Angel Gabriel
 */
public class Folleto {

    private Articulo ofertas[];
    private String fechaInicio;

    //CONSTRUCTORES
    public Folleto(String fecha, int cantArticulos) {
        ofertas = new Articulo[cantArticulos];
        fechaInicio = fecha;
    }

    //METODOS
    public void agregarOferta(Articulo oferta) {
        for (int i = 0; i < ofertas.length; i++) {
            if (ofertas[i] == null) {
                ofertas[i] = oferta;
                System.out.println("Oferta agregada: " + ofertas[i].getNombre());
                break;
            }
        }
    }

    //Devuelve la posición en el vector de un artículo buscando su código
    public int buscaArticulo(int nroArt) {
        int codigo = -1;
        for (int i = 0; i < ofertas.length; i++) {
            if(ofertas[i] != null) {
                if(ofertas[i].getNumero() == nroArt) {
                    codigo = i;
                    return codigo;
                }
            } else {
                break;
            }            
        }
        //Si no encuentra coincidencia, devuelve -1
        return codigo;        
    }

    //Devuelve la cantidad de ofertas de más de 5 días
    public int ofertasMasDeCincoDias() {
        int cant = 0;
        for (int i = 0; i < ofertas.length; i++) {
            if (ofertas[i] != null) {
                if (ofertas[i].getDiasOferta() > 5)
                    cant++;                
            } else {
                break;
            }
        }
        return cant;
    }
    
    //Devuelve la cantidad de ofertas con descuento mayor a $20
    public int descuentoMasDe20() {
        int cant = 0;
        for (int i = 0; i < ofertas.length; i++) {
            if (ofertas[i] != null) {
                float dif = ofertas[i].getPrecioRegular() - ofertas[i].getPrecioOferta();
                if (dif > 20)
                    cant++;                
            } else {
                break;
            }
        }
        return cant;
    }
    //Devuelve la cantidad total de unidades en oferta (stock)
    public int unidadesEnOferta() {
        int cant = 0;
        for (int i = 0; i < ofertas.length; i++) {
            if (ofertas[i] != null)
                cant += ofertas[i].getStock();
            else
                break;
        }
        
        return cant;
    }
    
    public String recaudacionPorArticulo(int nroArt) {
        //Si no encuentra coincidencias al terminar el método, devuelve esta cadena
        String cadena = "El artículo ingresado no existe en las ofertas";
        
        int art = buscaArticulo(nroArt);
        //Si encuentra coincidencia, arma una cadena con el resultado
        if(art >= 0) {
            float monto = ofertas[art].getPrecioOferta() * ofertas[art].getStock();
            cadena = "Monto a recaudar por la venta de "
                    + ofertas[art].getNombre() + ": $" + monto;
            return cadena;
        }        
        return cadena;
    }

    @Override
    public String toString() {
        String cadena;
        cadena = "Folleto de Ofertas desde " + fechaInicio + ":";
        for (int i = 0; i < ofertas.length; i++) {
            if(ofertas[i] != null) 
                cadena += "\n\t" + ofertas[i].toString();
            else
                break;
        }
        
        return cadena;
                
    }
    
    

}
