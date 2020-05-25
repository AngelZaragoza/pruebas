
package lc3_un03_clasesHerencia;

/**
 *
 * @author Zaragoza Angel Gabriel
 */
public class CuentaCorriente extends Cuenta {
    private float acuerdo;
    
    //CONSTRUCTORES
    public CuentaCorriente() {
        super();
        this.acuerdo = 0;
    }

    public CuentaCorriente(int nroCuenta, float saldo, String titular, float acuerdo) {
        super(nroCuenta, saldo, titular);
        this.acuerdo = acuerdo;
    }
    
    //GETTERS Y SETTERS

    public float getAcuerdo() {
        return acuerdo;
    }

    public void setAcuerdo(float acuerdo) {
        this.acuerdo = acuerdo;
    }
    
    
    //METODOS
    
    @Override
    public void extraerImp(float importe) {
        float saldoFin = saldo - importe;
        
        if (saldoFin >= acuerdo) {
            saldo = saldoFin;
            System.out.println("Extracción exitosa. Saldo disponible: $" + saldo);            
        } else {
            System.out.println("Error. Saldo insuficiente: " + saldo);
            System.out.println("Máximo Descubierto disponible: $" + acuerdo);            
        }            
    }
    
    @Override
    public String toString() {
        return "Cta. Cte. " + super.toString() + 
                "\n\tDescubierto disponible: $ " + acuerdo;
    }
        
}
