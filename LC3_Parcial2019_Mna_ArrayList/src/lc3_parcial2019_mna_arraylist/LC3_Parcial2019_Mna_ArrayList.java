
package lc3_parcial2019_mna_arraylist;

import java.util.Scanner;

/**
 *
 * @author Zaragoza Angel Gabriel
 */
public class LC3_Parcial2019_Mna_ArrayList {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean carga = false;
        int opcion, cantOferta;
        int numProd, diasOferta, stock;
        String fecha, nomProd;
        float precioReg, precioOfe;
        Folleto ofertas;

        System.out.print("Ingrese la Fecha de inicio de la Oferta -> ");
        fecha = teclado.nextLine();
        System.out.print("Ingrese Cantidad de artículos en Oferta -> ");
        cantOferta = teclado.nextInt();
        
        if (cantOferta > 0) {
            //Creamos el vector con la cantidad de ofertas
            ofertas = new Folleto(fecha, cantOferta);
            
            
            //Cargamos art. de prueba sólo si el usuario especificó una cant. mayor
            if (cantOferta > 5) {
                Articulo a1 = new Articulo(1, "Pan Lactal", 60, 45, 5, 50);
                Articulo a2 = new Articulo(2, "Harina", 45, 30, 10, 70);
                Articulo a3 = new Articulo(3, "Bocado", 290, 250, 7, 100);
                Articulo a4 = new Articulo(4, "Yerba Mate", 140, 115, 3, 40);
                Articulo a5 = new Articulo(5, "Queso Mantecoso", 320, 305, 3, 150);               

                ofertas.agregarOferta(a1);
                ofertas.agregarOferta(a2);
                ofertas.agregarOferta(a3);
                ofertas.agregarOferta(a4);
                ofertas.agregarOferta(a5);
                carga = true;
                cantOferta -= 5;
            }
            
            do {
                System.out.println("MENU DE OPCIONES");
                System.out.println("1- Agregar Oferta");
                System.out.println("2- Listar Ofertas Cargadas");
                System.out.println("3- Listar Ofertas de más de 5 días");
                System.out.println("4- Listar Total de Stock Ofertado");
                System.out.println("5- Listar Ofertas con descuento > $20");
                System.out.println("6- Monto a Recaudar por Artículo");
                System.out.println("----------------------------------------");
                System.out.print("Ingrese opción. \"0\" para terminar -> ");
                opcion = teclado.nextInt();
                
                //Verificamos la opción elegida
                switch (opcion) {
                    case 0:
                        System.out.println("--------** Programa terminado **---------");
                        break;
                        
                    case 1:
                        //Pedimos datos al usuario y agregamos la oferta
                        //La verificación es por si se logró cargar los art. de prueba
                        if (cantOferta > 0) {
                            System.out.print("Cód. Producto -> ");
                            numProd = teclado.nextInt();
                            System.out.print("Nombre Producto -> ");
                            teclado.nextLine();
                            nomProd = teclado.nextLine();
                            System.out.print("Precio Regular -> ");
                            precioReg = teclado.nextFloat();
                            System.out.print("Precio Oferta -> ");
                            precioOfe = teclado.nextFloat();
                            System.out.print("Días en Oferta -> ");
                            diasOferta = teclado.nextInt();
                            System.out.print("Stock Producto -> ");
                            stock = teclado.nextInt();
                            Articulo art = new Articulo(numProd, nomProd, precioReg, precioOfe, diasOferta, stock);
                            ofertas.agregarOferta(art);
                            cantOferta--;
                            carga = true;
                        } else {
                            System.out.println("Cant. máxima de Ofertas cargada");
                        }
                        break;
                        
                    case 2:
                        if(carga)
                            System.out.println(ofertas.toString());
                        else
                            noHayCarga();
                        break;
                    case 3:
                        if(carga) {
                            ofertasCinco(ofertas);
                        } else
                            noHayCarga();
                        break;
                    
                    case 4:
                        if(carga) {
                            unidadesOferta(ofertas);
                        } else
                            noHayCarga();
                        break;
                        
                    case 5:
                        if(carga) {
                            descuentoMasde20(ofertas);
                        } else
                            noHayCarga();
                        break;
                        
                    case 6:
                        if(carga) {
                            recaudPorArticulo(ofertas);
                        } else
                            noHayCarga();
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
                //Esta línea es para agregar una pausa entre pantallas
                if (opcion != 0) {
                    System.out.print("\tEnter para continuar...");
                    teclado.nextLine();
                    teclado.nextLine();
                }

            } while(opcion != 0);
            
            System.out.println("\n");
            //Punto 1:
            ofertasCinco(ofertas);

            //Punto 2:
            unidadesOferta(ofertas);

            //Punto 3:
            descuentoMasde20(ofertas);

            //Punto 4:
            recaudPorArticulo(ofertas);
        }
    }
    
    //METODOS AUXILIARES
    public static void noHayCarga() {
        System.out.println("\tError. No se han cargado Ofertas");
    }
    
    public static void ofertasCinco (Folleto ofertas) {
        System.out.println("Cant. de artículos ofertados por más de 5 días: "
                    + ofertas.ofertasMasDeCincoDias());
    }
    
    public static void unidadesOferta(Folleto ofertas) {
        System.out.println("Total unidades a la venta (stock): "
                            + ofertas.unidadesEnOferta());
    }
    
    public static void descuentoMasde20(Folleto ofertas) {
        System.out.println("Cant. de artículos con descuento superior a $20: "
                            + ofertas.descuentoMasDe20());
    }
    
    public static void recaudPorArticulo(Folleto ofertas) {
        Scanner teclado = new Scanner(System.in);
        int numProd;
        System.out.println("Monto a recaudar por la venta de determinado artículo");
        System.out.print("Ingrese el código del artículo -> ");
        numProd = teclado.nextInt();
        System.out.println(ofertas.recaudacionPorArticulo(numProd));
    }

}
