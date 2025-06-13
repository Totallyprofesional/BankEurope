/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bankeurope;
 
import java.util.Scanner; 
import bankeurope.managers.BankManager;
import bankeurope.models.clientes.Cliente;   
import bankeurope.models.cuentas.CuentaBancaria; 
import bankeurope.models.cuentas.tipos.CuentaCorriente;  
import bankeurope.models.cuentas.tipos.CuentaAhorro;  
import bankeurope.models.cuentas.tipos.CuentaDigital;

public class BankEurope {
    public static Scanner sc = new Scanner(System.in);
    public static BankManager bankManager;   
    public static Cliente clienteActual; 
    public static CuentaBancaria CuentaActual;  
    public static CuentaCorriente CuentaCorriente;  
    public static CuentaAhorro CuentaAhorro;
    public static CuentaDigital CuentaDigital;   
 
    public static void main(String[] args) {
        System.out.println("Menú Bank Europe");
             
        Menu menu = new Menu(sc, bankManager, clienteActual, CuentaActual, CuentaCorriente, CuentaAhorro, CuentaDigital);  
        menu.mostrarMenu(); 
    }  
}  
                    