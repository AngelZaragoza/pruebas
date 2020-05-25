
package lc3_un03_clasesHerencia;

/**
 *
 * @author Zaragoza Angel Gabriel
 */
public class CajaAhorro extends Cuenta{
    
    //CONSTRUCTOR
    //No creamos un constructor vacio ya que esta clase no agrega atributos
    public CajaAhorro(int nroCuenta, float saldo, String titular) { 
        super(nroCuenta,saldo,titular);
    }
    
            
    //METODOS    
        
    @Override
    public void extraerImp(float importe) {
        if (saldo >= importe) {
            saldo -= importe;
            System.out.println("Extracción exitosa. Saldo disponible: $" + saldo);            
        } else {
            System.out.println("Error. Saldo insuficiente: $" + saldo);
        }            
    }
    
    @Override
    public String toString() {
        return "Caja de Ahorro " + super.toString();
    }
}
