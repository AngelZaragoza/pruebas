
package lc3_un03_clasesHerencia;

/**
 *
 * @author Zaragoza Angel Gabriel
 */
public abstract class Cuenta {
    protected int nroCuenta;
    protected float saldo;
    protected String titular;
    
    //CONSTRUCTORES
    public Cuenta () {
        nroCuenta = 0;
        saldo = 0;
        titular = "";
    }

    public Cuenta(int nroCuenta, float saldo, String titular) {
        this.nroCuenta = nroCuenta;
        this.saldo = saldo;
        this.titular = titular;
    }
    
    //GETTERS Y SETTERS

    public int getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public float getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
    
    
    //METODOS
    public void depositarImp(float importe) {
        saldo += importe;
        System.out.println("Depósito exitoso. Saldo disponible: $" + saldo);
    }
    
    public abstract void extraerImp(float importe);
    
    @Override
    public String toString() {
        return "Nro: " + nroCuenta + " - Titular: " + titular + " - Saldo: " + saldo;
    }
    
    
    
}

