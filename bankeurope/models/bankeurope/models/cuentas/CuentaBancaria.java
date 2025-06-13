/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankeurope.models.cuentas;

import java.time.LocalDate; 
 
public abstract class CuentaBancaria { 
    protected LocalDate fechaCreacion;   
    protected int contadorCuenta = 100000000;   
    protected int numeroCuenta; 
    protected int saldo; 
    protected int monto;

    public CuentaBancaria(int saldo, int monto) {
        this.numeroCuenta = ++contadorCuenta;
        this.saldo = saldo; 
        this.monto = monto;
        this.fechaCreacion = LocalDate.now();
    } 
  
    public abstract void mostrarCuenta(); 
      
    public abstract void girarSaldo(int monto);
     
    public abstract void calcularInteres();  
    
    public void depositarSaldo(int monto) {
        this.saldo += monto;
    } 

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public int getSaldo() {
        return saldo;
    }
    
}