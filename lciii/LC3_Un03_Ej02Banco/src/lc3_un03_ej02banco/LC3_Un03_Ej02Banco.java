package lc3_un03_ej02banco;

import java.util.Scanner;
import lc3_un03_clasesHerencia.CajaAhorro;
import lc3_un03_clasesHerencia.Cuenta;
import lc3_un03_clasesHerencia.CuentaCorriente;

/**
 *
 * @author Zaragoza Angel Gabriel
 */
public class LC3_Un03_Ej02Banco {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        boolean carga = false;       

        //OBJETOS DE PRUEBA   
        Cuenta c1 = new CajaAhorro(357, 3500, "Angel");
        CajaAhorro c2 = new CajaAhorro(358, 15000, "María");
        Cuenta c3 = new CuentaCorriente(456, 27500, "Diego", -10000);

        System.out.println(c1.getTitular());
        System.out.println(c2.getSaldo());        

        System.out.println(c1.toString());
        System.out.println(c3.toString());

        //INICIO DEL PROGRAMA
        int cantCuentas = 0;
        Banco banco;

        while (cantCuentas <= 0) {
            System.out.print("Ingrese cantidad de Cuentas en total del Banco -> ");
            cantCuentas = teclado.nextInt();

        }
        
        //Creamos objeto banco, y si hay lugar, agregamos las cuentas de prueba
        banco = new Banco(cantCuentas);
        int nroCuenta;
        
        if (cantCuentas >= 3) {
            banco.agregarCuenta(c1);
            banco.agregarCuenta(c2);
            banco.agregarCuenta(c3);
            cantCuentas -= 3;
            carga = true;
        }
        
        do {
            System.out.println("MENU DE OPCIONES");
            System.out.println("----------------");
            System.out.println("1 - Alta de Caja de Ahorro");
            System.out.println("2 - Alta de Cuenta Corriente");
            System.out.println("3 - Caja de Ahorro - Consulta de Saldo");
            System.out.println("4 - Caja de Ahorro - Depósito");
            System.out.println("5 - Caja de Ahorro - Extracción");
            System.out.println("6 - Cuenta Corriente - Consulta de Saldo");
            System.out.println("7 - Cuenta Corriente - Depósito");
            System.out.println("8 - Cuenta Corriente - Extracción");
            System.out.println("97 - Listado de Cuentas Totales");
            System.out.println("98 - Listado de Cajas de Ahorro");
            System.out.println("99 - Listado de Cuentas Corrientes");
            System.out.println("-----------------------------------------");
            System.out.print("Ingrese opción. \" 0 \" para Salir -> ");
            opcion = teclado.nextInt();
            
            switch (opcion) {
                case 0:
                    System.out.println("--------** Programa terminado **---------");
                    break;
                case 1:
                    if (cantCuentas > 0) {
                        //Agrega Caja de Ahorro pasando parámetro "1"
                        //al método altaCuenta
                        banco.agregarCuenta(altaCuenta(1));
                        carga = true;                        
                    }
                    break;
                case 2:
                    if (cantCuentas > 0) {
                        //Agrega Cuenta Corriente pasando parámetro "2"
                        //al método altaCuenta
                        banco.agregarCuenta(altaCuenta(2));
                        carga = true;                        
                    }
                    break;
                case 3:
                    if (carga) {
                        System.out.print("Ingrese Nro de Caja de Ahorro -> ");
                        nroCuenta = teclado.nextInt();
                        System.out.println(banco.consultaSaldo(nroCuenta, 1));
                    } else
                        noHayCarga();
                    break;
                case 4:                    
                    if (carga) {
                        System.out.print("Ingrese Nro de Caja de Ahorro -> ");
                        nroCuenta = teclado.nextInt();
                        System.out.print("Ingrese Importe -> ");
                        float importe = teclado.nextFloat();
                        banco.depositar(nroCuenta, 1, importe);
                    } else
                        noHayCarga();
                    break;
                case 5:
                    if (carga) {
                        System.out.print("Ingrese Nro de Caja de Ahorro -> ");
                        nroCuenta = teclado.nextInt();
                        System.out.print("Ingrese Importe -> ");
                        float importe = teclado.nextFloat();
                        banco.extraer(nroCuenta, 1, importe);
                    } else
                        noHayCarga();
                    break;
                case 6:
                    if (carga) {
                        System.out.print("Ingrese Nro de Cuenta Corriente -> ");
                        nroCuenta = teclado.nextInt();
                        System.out.println(banco.consultaSaldo(nroCuenta, 2));
                    } else
                        noHayCarga();
                    break;
                case 7:
                    if (carga) {
                        System.out.print("Ingrese Nro de Cuenta Corriente -> ");
                        nroCuenta = teclado.nextInt();
                        System.out.print("Ingrese Importe -> ");
                        float importe = teclado.nextFloat();
                        banco.depositar(nroCuenta, 2, importe);
                    } else
                        noHayCarga();
                    break;
                case 8:
                    if (carga) {
                        System.out.print("Ingrese Nro de Cuenta Corriente -> ");
                        nroCuenta = teclado.nextInt();
                        System.out.print("Ingrese Importe -> ");
                        float importe = teclado.nextFloat();
                        banco.extraer(nroCuenta, 2, importe);
                    } else
                        noHayCarga();
                    break;
                case 97:
                    System.out.println("Listado de Cuentas Totales");
                    banco.listaCuentas(3);
                    break;
                case 98:
                    System.out.println("Listado de Cajas de Ahorro");
                    banco.listaCuentas(1);
                    break;
                case 99:
                    System.out.println("Listado de Cuentas Corrientes");
                    banco.listaCuentas(2);
                    break;                    
                default:
                    System.out.println("Opción inválida.");
            }
                
            //Esta línea es para agregar una pausa entre pantallas
            if (opcion != 0) {
                System.out.print("\tEnter para continuar...");
                teclado.nextLine();
                teclado.nextLine();
            }
            
        } while (opcion != 0);
        
        
    }
    
    //Crea y devuelve el objeto Cuenta que corresponda según elección de usuario
    public static Cuenta altaCuenta(int tipoCta) {
        Scanner tec = new Scanner(System.in);
        Cuenta c;
        
        //Pedimos datos al usuario
        System.out.print("Titular - Ingrese Nombre -> ");        
        String titular = tec.nextLine();
        System.out.print("Cuenta - Ingrese Número -> ");
        int nroCuenta = tec.nextInt();
        System.out.print("Saldo inicial de la Cuenta -> ");
        float saldo = tec.nextFloat();
        
        if (tipoCta == 1) {        
            c = new CajaAhorro(nroCuenta, saldo, titular);
        } else  {
            System.out.print("Saldo máximo en descubierto -> ");
            float acuerdo = tec.nextFloat();
            //Ponemos el valor del "acuerdo" en negativo para facilitar cálculos
            if (acuerdo > 0)
                acuerdo *= -1;
            c = new CuentaCorriente(nroCuenta, saldo, titular, acuerdo);
        }
        return c;
    }    
    
    //Este método no lo pude implementar. Será para la próxima
    /*
    public static void operacion(int tipoOperacion) {
        Scanner tec = new Scanner(System.in);
        
        System.out.print("Ingrese Número de Cta. -> ");
        int nroCuenta = tec.nextInt();
        System.out.print("Ingrese Importe -> ");
        float importe = tec.nextFloat();
        
    }
    */
    
    public static void noHayCarga() {        
        System.out.println("\tError. No se han cargado Cuentas");
    }
    

}
