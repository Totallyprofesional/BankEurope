/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankeurope.models.cuentas; 
 
public class CuentaDigital extends CuentaBancaria {
    private double valor;
    
    public CuentaDigital (int saldo, int monto, int creditoPremium, double valor){ 
        super(saldo, monto);
        
        // Cuenta Digital tiene 500.000 de crédito
        this.saldo = 500000;
        this.valor =  saldo * 0.03;
    }     

    @Override 
    public void mostrarCuenta() { 
        System.out.println("Cuenta Digital: " + numeroCuenta);
        System.out.println("Saldo: " + saldo);
    }
    
    // Cobra porcentaje de saldo por giro
    @Override
    public void girarSaldo(int valor) {
        this.saldo += valor;
    }
    
    @Override
    public void calcularInteres(){
        if (saldo > 700000){
            this.saldo += saldo * 0.1;      
        }
    }
    

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    public int getSaldo() {
        return saldo;
    }
}
