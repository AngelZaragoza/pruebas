package lc3_un02_biblioteca;

import java.util.Scanner;

/**
 *
 * @author Zaragoza Angel Gabriel
 */
public class LC3_Un02_Biblioteca {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);        
        String titulo;
        int opcion;

        System.out.println("SISTEMA BIBLIOTECA");
        System.out.println("------------------");
        System.out.println("1 - Datos precargados para ver demo");
        System.out.println("2 - Ejecución normal");
        System.out.print("Elija qué desea hacer: -> ");
        opcion = teclado.nextInt();

        if (opcion == 1) {
            //Para hacer pruebas y no estar cargando libros por cada ejecución
            Biblioteca biblioDemo = new Biblioteca(10);

            //Nuevos Libros
            Libro l1 = new Libro("La Isla del Tesoro", 150, 1, 10);
            Libro l2 = new Libro("Insomnia", 270, 1, 10);
            Libro l3 = new Libro("Rio Sagrado", 220, 3, 10);
            Libro l4 = new Libro("Escrito en las Estrellas", 130, 1, 10);
            Libro l5 = new Libro("The Stand", 550, 2, 10);

            //Prestamos libro 1
            Prestamo p1 = new Prestamo("Angel", 5, true);
            Prestamo p2 = new Prestamo("Lelia", 3, true);
            Prestamo p3 = new Prestamo("Gabriel", 8, true);
            l1.agregarPrestamo(p1);
            l1.agregarPrestamo(p2);
            l1.agregarPrestamo(p3);

            //Prestamos libro 2
            Prestamo p4 = new Prestamo("María", 7, false);
            Prestamo p5 = new Prestamo("Luis", 4, true);
            Prestamo p6 = new Prestamo("Matías", 11, false);
            l2.agregarPrestamo(p4);
            l2.agregarPrestamo(p5);
            l2.agregarPrestamo(p6);

            //Prestamos libro 3
            Prestamo p7 = new Prestamo("Teresa", 6, false);
            l3.agregarPrestamo(p7);

            //Prestamos libro 4
            Prestamo p8 = new Prestamo("Diego", 4, true);
            Prestamo p9 = new Prestamo("Jennifer", 9, true);
            Prestamo p10 = new Prestamo("Martín", 15, true);
            l4.agregarPrestamo(p8);
            l4.agregarPrestamo(p9);
            l4.agregarPrestamo(p10);

            //Prestamos libro 5
            Prestamo p11 = new Prestamo("Pablo", 10, true);
            Prestamo p12 = new Prestamo("Erica", 3, true);
            Prestamo p13 = new Prestamo("Eliana", 12, true);
            Prestamo p14 = new Prestamo("Freddy", 14, false);
            l5.agregarPrestamo(p11);
            l5.agregarPrestamo(p12);
            l5.agregarPrestamo(p13);
            l5.agregarPrestamo(p14);

            //Agregamos libros con préstamos cargados al objeto Biblioteca
            biblioDemo.agregarLibro(l1);
            biblioDemo.agregarLibro(l2);
            biblioDemo.agregarLibro(l3);
            biblioDemo.agregarLibro(l4);
            biblioDemo.agregarLibro(l5);

            biblioDemo.registrarExtravio("Rio Sagrado", "s");

            System.out.println("Cargados 5 Libros de Prueba");
            System.out.println(biblioDemo.toString());
            
            
            System.out.println("Listar solicitantes de 3 libros:");
            System.out.println("--------------------------------");
            teclado.nextLine();
            for (int i = 0; i < 3; i++) {

                System.out.print("Ingrese Título del Libro -> ");                
                titulo = teclado.nextLine();

                System.out.println(biblioDemo.listadoSolicitantes(titulo));

            }
                        
            //Mostrar informaciones varias
            librosPorEstado(biblioDemo);
            
            System.out.println("Costo de reposición de Libros Extraviados: " 
                                + biblioDemo.sumaPrecioExtraviados());

        } else if (opcion == 2) {
            
            //Para crear el objeto Biblioteca                
            Biblioteca biblioNormal;
            int cantLibros = 0;

            while (cantLibros <= 0) {                
                System.out.println("Ingrese cantidad de Libros de la Biblioteca");
                cantLibros = teclado.nextInt();
                if (cantLibros <= 0)
                    System.out.println("Ingrese una cantidad positiva");                
            } 
            
            biblioNormal = new Biblioteca(cantLibros);

            //Variables auxiliares                
            String titLibro;
            int estadoLibro, cantPrestamos;
            float precioLibro;
            boolean carga = false; //Flag para controlar carga de libros
            
            do {                
                System.out.println("MENU DE OPCIONES");
                System.out.println("----------------");
                System.out.println("1 - Agregar Libro");
                System.out.println("2 - Agregar Préstamo de Libro");
                System.out.println("3 - Cantidad de Libros por Estado");
                System.out.println("4 - Libros Extraviados: Costo de Reposición");
                System.out.println("5 - Libros Prestados: Solicitantes por Libro");
                System.out.println("98 - Registrar Extravío de Libro");
                System.out.println("99 - Listar Libros Cargados");
                System.out.println("-----------------------------------------");
                System.out.print("Ingrese opción. \" 0 \" para Salir -> ");
                opcion = teclado.nextInt();
                
                switch (opcion) {
                    case 0:
                        System.out.println("--------** Programa terminado **---------");
                        break;
                    case 1:
                        if (cantLibros > 0) {
                            System.out.print("Libro - Ingrese TITULO -> ");
                            teclado.nextLine();
                            titLibro = teclado.nextLine();
                            System.out.print("Libro - Ingrese PRECIO -> ");
                            precioLibro = teclado.nextFloat();
                            System.out.println("Estado del Libro:");
                            System.out.println("1: Disponible");
                            System.out.println("2: Prestado");
                            System.out.println("3: Extraviado");
                            System.out.print("Ingrese ESTADO. -> ");
                            estadoLibro = teclado.nextInt();
                            System.out.print("Libro - PRESTAMOS MAXIMOS -> ");
                            cantPrestamos = teclado.nextInt();
                            
                            //Creamos Un Libro y agregamos a la Biblioteca
                            Libro nuevoLibro = new Libro(titLibro, precioLibro, estadoLibro, cantPrestamos);
                            biblioNormal.agregarLibro(nuevoLibro);
                            
                            //Confirmamos agregado, restamos contador y activamos flag
                            System.out.println("Agregado " + nuevoLibro.toString());
                            cantLibros--;
                            carga = true;
                        } else {
                            System.out.println("Cant. Máxima de Libros cargada");
                        }
                        break;
                    case 2:
                        if (carga) {
                            System.out.print("Ingrese Libro a Prestar -> ");
                            teclado.nextLine();
                            titLibro = teclado.nextLine();
                            
                            if (biblioNormal.existeLibro(titLibro) >= 0) {

                                boolean devuelto = false;
                                System.out.print("Préstamo - NOMBRE Solicitante -> ");
                                teclado.nextLine();
                                String solic = teclado.nextLine();
                                System.out.print("Préstamo - Cantidad de DIAS-> ");
                                int cantDias = teclado.nextInt();
                                System.out.print("Préstamo - 1: LLEVA 2: DEVUELVE -> ");
                                estadoLibro = teclado.nextInt();
                                if (estadoLibro == 2)
                                    devuelto = true;
                                
                                //Creamos Préstamo y agregamos al Libro
                                Prestamo nvoPres = new Prestamo(solic, cantDias, devuelto);
                                biblioNormal.agregarPrestamo(titLibro, nvoPres);
                                
                            } else {
                                System.out.println("\tEl Libro no existe o no está cargado");
                            }                            
                        } else {
                            noHayCarga();
                        }
                        break;                        
                    
                    case 3:
                        if (carga)
                            librosPorEstado(biblioNormal);
                        else
                            noHayCarga();
                        break;
                    
                    case 4:
                        if (carga)
                            System.out.println("Costo de reposición de Libros Extraviados: " 
                                                + biblioNormal.sumaPrecioExtraviados());
                        else
                            noHayCarga();
                        break;
                    
                    case 5:
                        if (carga) {
                            System.out.print("Ingrese Título del Libro -> ");                
                            teclado.nextLine();
                            titLibro = teclado.nextLine();
                            biblioNormal.listadoSolicitantes(titLibro);
                        } else {
                            noHayCarga();
                        }
                        break;
                        
                    case 98:
                        System.out.println("A implementar");
                        break;
                    
                    case 99:
                        if (carga)
                            biblioNormal.toString();
                        else
                            noHayCarga();
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
            System.out.println("Opción Inválida");
        }            

    }
    
    //METODOS AUXILIARES
    public static void noHayCarga() {        
        System.out.println("\tError. No se han cargado Libros");
    }
    
    public static void librosPorEstado(Biblioteca biblio) {
        int[] estadoLibros = biblio.estadoLibros();
        System.out.println("Cantidad de Libros por Estado:");
        System.out.println("\tDisponibles: " + estadoLibros[0]);
        System.out.println("\tPrestados: " + estadoLibros[1]);
        System.out.println("\tExtraviados: " + estadoLibros[2]);
}

}
