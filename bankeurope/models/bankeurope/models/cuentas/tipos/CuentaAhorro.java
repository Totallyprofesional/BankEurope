/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankeurope.models.cuentas.tipos;  
import bankeurope.models.cuentas.CuentaBancaria;
import java.time.LocalDate; 
 
public class CuentaAhorro extends CuentaBancaria {
    private LocalDate fechaCreación; 
     
    public CuentaAhorro (int saldo, int monto){ 
        super(saldo, monto);
        this.fechaCreación = LocalDate.now();
    }   
 
    @Override
    public void mostrarCuenta() {
        System.out.println("Cuenta Ahorro: " + numeroCuenta);
        System.out.println("Saldo: " + saldo);
    } 
   
    // Bloquea giro hasta 6 meses desde creacion de la cuenta
    @Override
    public void girarSaldo(int valor) {  
        relojRetiro(valor);    
    }
    
    public void relojRetiro (int monto){    
        LocalDate día = LocalDate.now();
        LocalDate fechaRetiro = fechaCreación.plusMonths(6);
        
        if (día == fechaRetiro){
           this.saldo -= monto; 
        } else { 
            System.out.println("No se puede girar saldo. Fecha de retiro: " + fechaRetiro);
        }          
    }
    
    @Override
    public void calcularInteres(){
        if (saldo > 100000){
            this.saldo += saldo * 0.2;      
        }
        
    }
    
}

