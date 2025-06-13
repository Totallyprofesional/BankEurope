/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankeurope.models.cuentas.tipos;    
 
import bankeurope.models.cuentas.CuentaBancaria;

public class CuentaCorriente extends CuentaBancaria {  
 
    public CuentaCorriente (int saldo, int monto){ 
        super(saldo, monto);     
    } 

    @Override
    public void mostrarCuenta() {
        System.out.println("Cuenta Corriente: " + numeroCuenta);
        System.out.println("Saldo: " + saldo);
    } 
     
    // Giro normal 
    @Override
    public void girarSaldo(int monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor que 0");
        }
        if (monto > this.saldo) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        this.saldo -= monto;
    }
    
    @Override
    public void calcularInteres(){ 
        if (saldo > 100000){
            this.saldo += saldo * 0.1; 
        }
    }
    
}