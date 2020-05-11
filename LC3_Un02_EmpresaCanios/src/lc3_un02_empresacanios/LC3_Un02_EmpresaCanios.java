package lc3_un02_empresacanios;

import java.util.Scanner;

/**
 *
 * @author Zaragoza Angel Gabriel
 */
public class LC3_Un02_EmpresaCanios {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingrese el NOMBRE del Producto ->: ");
        String nomProd = teclado.nextLine();
        System.out.print("Ingrese la CANTIDAD de Materiales del producto ->: ");
        int mats = teclado.nextInt();

        if (mats > 0) {
            //Si hay un nro. positivo de materiales, creamos el Producto
            Producto prod = new Producto(nomProd, mats);
            int codMat;
            String nomMat;
            float precioMat;
            boolean carga = false; //Flag para controlar carga de material

            int opcion;
            do {
                System.out.println("MENU DE OPCIONES - Producto: " + prod.getDescripcion());
                System.out.println("----------------");
                System.out.println("4 - Agregar Material");
                System.out.println("5 - Costo Total del Producto");
                System.out.println("6 - Chequear si Material integra Producto");
                System.out.println("7 - Listar Materiales por debajo de Precio");
                System.out.println("8 - Contar Materiales por Rango de Precio");
                System.out.println("99 - Listar Detalles de Producto");
                System.out.println("-----------------------------------------");
                System.out.print("Ingrese opción. \" 0 \" para Salir -> ");
                opcion = teclado.nextInt();
                
                System.out.println("\n\n\n\n\n\n");

                switch (opcion) {
                    case 0:
                        System.out.println("--------** Programa terminado **---------");
                        break;

                    case 4:
                        if (mats > 0) {
                            System.out.print("Material - Ingrese COD. -> ");
                            codMat = teclado.nextInt();
                            System.out.print("Material - Ingrese DESCRIPCION -> ");
                            teclado.nextLine();
                            nomMat = teclado.nextLine();
                            System.out.print("Material - Ingrese PRECIO UNIT. -> ");
                            precioMat = teclado.nextFloat();

                            //Creamos objeto Material y llamamos método agregar
                            Material mat = new Material(codMat, nomMat, precioMat);
                            prod.agregarMaterial(mat);

                            //Confirmamos agregado, restamos contador y activamos flag
                            System.out.println("Agregado " + mat.toString());
                            mats--;
                            carga = true;
                        } else {
                            System.out.println("Cant. Máxima de Materiales cargada");
                        }
                        break;

                    case 5:
                        if (carga) {
                            float costoTotal = prod.costoTotal();                            
                            System.out.println("Costo Total de " + prod.getDescripcion()
                                                + ": $ " + costoTotal);                             
                        } else {
                            noHayCarga();
                        }
                        break;

                    case 6:
                        if (carga) {
                            System.out.print("Material - Buscar COD. -> ");
                            codMat = teclado.nextInt();
                            if (prod.usaMaterial(codMat)) {
                                System.out.println("\tEl Material FORMA parte de "
                                        + prod.getDescripcion());
                            } else {
                                System.out.println("\tEl Material NO FORMA parte de "
                                        + prod.getDescripcion());
                            }
                        } else {
                            noHayCarga();
                        }
                        break;

                    case 7:
                        if (carga) {
                            System.out.print("Material - PRECIO MENOR A -> ");
                            precioMat = teclado.nextFloat();
                            Material[] matBajoPrecio = prod.materialesCostoMenorA(precioMat);
                            
                            //Verificamos que el arreglo devuelto no sea null
                            if (matBajoPrecio != null) {
                                
                                for (int i = 0; i < matBajoPrecio.length; i++) {
                                    if (matBajoPrecio[i] != null)
                                        System.out.println("\t" + matBajoPrecio[i].toString());                                
                                }
                            }
                        } else {
                            noHayCarga();
                        }
                        break;
                    
                    case 8:
                        if (carga) {
                            int rangoPrecios [] = prod.matPorRangoPrecio();
                            System.out.println("Cant. de Materiales por Precio:");
                            System.out.println("Entre $00,00 y $10,00: " + rangoPrecios[0]);
                            System.out.println("Entre $10,00 y $20,00: " + rangoPrecios[1]);
                            System.out.println("Entre $20,00 y $30,00: " + rangoPrecios[2]);
                            System.out.println("\tMás de $30,00: " + rangoPrecios[3]);
                        } else {
                            noHayCarga();
                        }
                        break;
                        
                    case 99:                        
                        System.out.println(prod.toString());
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }
                if (opcion != 0) {
                    System.out.print("\tEnter para continuar...");
                    teclado.nextLine();
                    teclado.nextLine();
                }

            } while (opcion != 0);

        } else {
            System.out.println("No puede haber un Producto sin Materiales");
            System.out.println("--------** Programa terminado **---------");
        }

    }
    
    //Imprime mensaje de error
    public static void noHayCarga() {        
        System.out.println("\tError. No se han cargado Materiales");
    }

}
