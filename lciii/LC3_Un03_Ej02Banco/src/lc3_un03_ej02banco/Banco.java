package lc3_un03_ej02banco;

import lc3_un03_clasesHerencia.Cuenta;
import lc3_un03_clasesHerencia.CajaAhorro;
import lc3_un03_clasesHerencia.CuentaCorriente;

/**
 *
 * @author Zaragoza Angel Gabriel
 */
public class Banco {

    private Cuenta[] cuentas;

    //CONSTRUCTORES
    public Banco() {
    }

    public Banco(int cantCuentas) {
        cuentas = new Cuenta[cantCuentas];
    }

    
    //METODOS
    public void agregarCuenta(Cuenta nuevaCuenta) {
        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i] == null) {
                cuentas[i] = nuevaCuenta;
                break;
            }
        }
    }

    public int existeCuenta(int nroCuenta, int tipoCuenta) {
        for (int i = 0; i < cuentas.length; i++) {
            if(cuentas[i] != null) {
                if (cuentas[i].getNroCuenta() == nroCuenta) {
                    //Si encuentra coincidencias retorna la posicion en el arreglo
                    
                    if (tipoCuenta == 1 && cuentas[i] instanceof CajaAhorro)
                        return i;
                    if (tipoCuenta == 2 && cuentas[i] instanceof CuentaCorriente)
                        return i;
                }
            }            
        }
        //Si no hay coincidencia retorna -1
        return -1;
    }
    
    public void depositar(int nroCuenta, int tipoCuenta, float importe) {        
        int cta = existeCuenta(nroCuenta, tipoCuenta);
        if (cta != -1)
            cuentas[cta].depositarImp(importe);
        else
            System.out.println("\tLa cuenta no existe o no especificó el tipo correcto");
        
    }
    
    public void extraer(int nroCuenta, int tipoCuenta, float importe) {
        int cta = existeCuenta(nroCuenta, tipoCuenta);
        if (cta != -1)
            cuentas[cta].extraerImp(importe);
        else
            System.out.println("\tLa cuenta no existe o no especificó el tipo correcto");
    }
    
    public String consultaSaldo (int nroCuenta, int tipoCuenta) {
        String mensaje = "La cuenta no existe";
        int cta = existeCuenta(nroCuenta, tipoCuenta);
        if (cta != -1)
            mensaje = "El saldo de la cuenta nro " + nroCuenta + 
                      " es de $ " + cuentas[cta].getSaldo();
        return mensaje;
    }
        
    
    public void listaCuentas(int tipoCta) {
        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i] != null) {
                if (tipoCta == 3) {
                    System.out.println(cuentas[i].toString());
                } else {
                    if (tipoCta == 1 && cuentas[i] instanceof CajaAhorro)
                        System.out.println(cuentas[i].toString());
                    if (tipoCta == 2 && cuentas[i] instanceof CuentaCorriente)
                        System.out.println(cuentas[i].toString());
                    
                }
            } else {
                break;
            }
        }

    }

}
