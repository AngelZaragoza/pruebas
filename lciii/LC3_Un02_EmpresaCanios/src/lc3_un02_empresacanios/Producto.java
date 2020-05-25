package lc3_un02_empresacanios;

/**
 *
 * @author Zaragoza Angel Gabriel
 */
//Punto 2:
public class Producto {

    private String descripcion;
    private Material[] materiales;

    //CONSTRUCTORES
    public Producto() {
    }

    //Punto 3:
    public Producto(String descripcion, int cantElementos) {
        this.descripcion = descripcion;
        materiales = new Material[cantElementos];
    }

    public String getDescripcion() {
        return descripcion;
    }

    //METODOS
    //Punto 4:
    public void agregarMaterial(Material mat) {
        for (int i = 0; i < materiales.length; i++) {
            if (materiales[i] == null) {
                materiales[i] = mat;
                break;
            }

        }
    }

    //Punto 5:
    public float costoTotal() {
        float acumCosto = 0;
        for (int i = 0; i < materiales.length; i++) {
            if (materiales[i] != null) {
                acumCosto += materiales[i].getValorUnitario();
            } else {
                break;
            }
        }
        return acumCosto;
    }

    //Punto 6:
    public boolean usaMaterial(int codigoMat) {
        for (int i = 0; i < materiales.length; i++) {
            if (materiales[i] != null) {
                if (materiales[i].getCodigo() == codigoMat) {
                    return true;
                }
            }
        }
        return false;
    }

    //Punto 7:
    public Material[] materialesCostoMenorA(float valor) {
        //Buscamos la posición del último elemento cargado 
        //para recuperar la cantidad de materiales cargados
        int tamanio = 0;
        for (int i = (materiales.length - 1); i >= 0; i--) {
            if (materiales[i] != null) {
                tamanio = i + 1;
                break;
            }
        }        
        
        //Si conseguimos elementos, creamos un arreglo con esa cantidad
        //y recorremos el arreglo original para llenar el auxiliar
        Material[] matCostoMenor = new Material[tamanio];

        int j = 0;      //Controla el indice del arreglo matCostoMenor
        boolean posi = false;   //Marca si encuentra al menos una coincidencia
        for (int i = 0; i < tamanio; i++) {
            if (materiales[i].getValorUnitario() < valor) {
                matCostoMenor[j] = materiales[i];
                j++;
                posi = true;
            }
        }
        
        //Si encuentra una coincidencia retorna el arreglo, sino null
        if (posi)
            return matCostoMenor;
        else {
            System.out.println("\tNo hay resultados");
            return null;
        }            
    }

    //Punto 8:
    public int[] matPorRangoPrecio() {
        int[] rangoPrecios = {0, 0, 0, 0};
        float precio;
        for (int i = 0; i < materiales.length; i++) {
            if (materiales[i] != null) {
                precio = materiales[i].getValorUnitario();
                if (precio > 30) {
                    rangoPrecios[3]++;
                } else if (precio <= 30 && precio > 20) {
                    rangoPrecios[2]++;
                } else if (precio <= 20 && precio > 10) {
                    rangoPrecios[1]++;
                } else if (precio <= 10 && precio > 0) {
                    rangoPrecios[0]++;
                }
            }
        }
        return rangoPrecios;
    }

    @Override
    public String toString() {
        String cadena;
        cadena = "Producto: " + descripcion + " - Materiales:";
        for (int i = 0; i < materiales.length; i++) {
            if (materiales[i] != null) {
                cadena += "\n\t" + materiales[i].toString();
            } else {
                break;
            }
        }
        return cadena;
    }
}
