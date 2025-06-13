/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankeurope;

import java.util.List; 
import java.util.Scanner;
import java.util.InputMismatchException; 

import bankeurope.managers.BankManager;
import bankeurope.models.clientes.Cliente; 
import bankeurope.models.cuentas.CuentaBancaria;
import bankeurope.models.cuentas.tipos.CuentaCorriente; 
import bankeurope.models.cuentas.tipos.CuentaAhorro; 
import bankeurope.models.cuentas.tipos.CuentaDigital;  
 
public class Menu { 
    private Scanner sc;  
    private BankManager bankManager; 
    private Cliente clienteActual;
    private CuentaBancaria CuentaActual;  
    private CuentaBancaria CuentaCorriente;   
    private CuentaBancaria CuentaAhorro; 
    private CuentaBancaria CuentaDigital;  
    
    public Menu(Scanner sc, BankManager bankManager, Cliente clienteActual, CuentaBancaria CuentaActual, CuentaBancaria CuentaCorriente, CuentaBancaria CuentaAhorro, CuentaBancaria CuentaDigital) {
        this.sc = sc; 
        this.bankManager = BankManager.getInstancia();
        this.clienteActual = clienteActual;
        this.CuentaActual = CuentaActual;
        this.CuentaCorriente = CuentaCorriente;
        this.CuentaAhorro = CuentaAhorro;
        this.CuentaDigital = CuentaDigital;
    } 
     
    public void mostrarMenu() {
        int opcion = 0;
        
        do {
            System.out.println("\n===== Bienvenido al menú Bank Europe =====");
            System.out.println("Clientes: " + bankManager.getCantidadClientes());
            System.out.println("\n=======================================");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Ver datos cliente");
            System.out.println("3. Depositar en cuenta");
            System.out.println("4. Girar desde cuenta");
            System.out.println("5. Consultar saldo");
            System.out.println("6. Salir");
            System.out.print("\n Ingrese una opción: ");          
               
            try {
                opcion = sc.nextInt(); 
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Valor no válido");
                sc.nextLine();
            }
             
            switch (opcion) {
                case 1:
                    tipoCuenta(sc);            
                    break;
                case 2:
                    verDatosCliente(sc);
                    break;
                case 3:  
                    depositarCuenta(sc);  
                    break;
                case 4:
                    girarCuenta(sc);
                    break; 
                case 5:
                    consultarSaldo(sc);
                    break;
                case 6:
                    System.out.println("Saliendo del menú");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }         
        } while (opcion != 6); 
        
        sc.close();
    } 
     
    public void tipoCuenta(Scanner sc) {    
    int saldo = 0;
    int monto = 0;
    int creditoPremium = 0;  
    double valor = 0;
    int tipo = 0;
    
        do {
            System.out.println("\n Tipos de cuenta"); 
            System.out.println("");
            System.out.println("1) Cuenta Normal");
            System.out.println("2) Cuenta Ahorro");
            System.out.println("3) Cuenta Premium");
            System.out.println("4) Salir");
            System.out.println("\n Elija una opción");
               
            try {
                tipo = sc.nextInt(); 
                sc.nextLine(); 
            } catch (InputMismatchException e) {
                System.out.println("Valor no válido");
                sc.nextLine();
            } 
     
            switch (tipo) {
                case 1:
                    CuentaActual = new CuentaCorriente(saldo, monto);       
                    registrarCliente(sc);
                    return;
                case 2:
                    CuentaActual = new CuentaAhorro(saldo, monto);         
                    registrarCliente(sc);
                    return;
                case 3:
                    CuentaActual = new CuentaDigital(saldo, monto, creditoPremium, valor);
                    registrarCliente(sc);
                    return;
                case 4:     
                    System.out.println("Saliendo del menú");
                    return;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }     
        } while (tipo != 4); 
    }

    public void registrarCliente(Scanner sc) {    
        
        System.out.println("\n===== Registro de cliente =====");
        System.out.print("Ingrese rut (sin guión y puntos): "); 
        String rut = sc.nextLine();
        
        if (bankManager.buscarCliente(rut) != null) {
            System.out.println("Error: Ya existe un cliente con ese RUT");
            return;
        } 
        
        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese apellido paterno: ");
        String apellidoPaterno = sc.nextLine();
        System.out.print("Ingrese apellido materno: ");
        String apellidoMaterno = sc.nextLine();
        System.out.print("Ingrese domicilio: ");
        String domicilio = sc.nextLine();
        System.out.print("Ingrese comuna: ");
        String comuna = sc.nextLine();    
        System.out.print("Ingrese teléfono: ");
        int teléfono = sc.nextInt();
          
        try {     
            Cliente nuevoCliente = new Cliente(rut, nombre, apellidoPaterno, apellidoMaterno, domicilio, comuna, teléfono);      
            
            if (nuevoCliente.registrarCliente() && bankManager.agregarCliente(nuevoCliente)) {         
                
                clienteActual = nuevoCliente;              
                CuentaActual.mostrarCuenta();              
            }   
            
            } catch (IllegalArgumentException e) { 
                System.out.println("Error: " + e.getMessage());          
        } 
    }  
       
    public void verDatosCliente(Scanner sc) {
        System.out.print("Ingrese RUT del cliente: ");
        String rut = sc.nextLine();
        
        Cliente ClienteActual= bankManager.buscarCliente(rut);
        
        if ( ClienteActual != null) {
            System.out.println("Abriendo cuenta:"); 
            ClienteActual.mostrarDatos();
            CuentaActual.mostrarCuenta();
        } else {
            System.out.println("No se encontró ningún cliente con ese RUT");
        } 
    }
   
    private void depositarCuenta(Scanner sc) {
        verDatosCliente(sc);
        
        int monto = 0; 
        
        try {
            System.out.println("\n Ingrese monto");
            monto = sc.nextInt();
            CuentaActual.depositarSaldo(monto);  
            System.out.println("Saldo actual: " + CuentaActual.getSaldo());
        } catch (InputMismatchException e) {
            System.out.println("Valor no válido");
        }    
    }
        
    private void girarCuenta(Scanner sc) {
        verDatosCliente(sc);
        
        int monto = 0;
        
        try {
            System.out.println("Ingrese monto");
            monto = sc.nextInt();
            CuentaActual.girarSaldo(monto);  
            System.out.println("Saldo actual: " + CuentaActual.getSaldo());
        } catch (InputMismatchException e) {
            System.out.println("Valor no válido");
        }   
    } 
        
    private void consultarSaldo(Scanner sc) {
        System.out.print("Ingrese RUT del cliente: ");
        String rut = sc.nextLine();
        
        Cliente nuevoCliente = bankManager.buscarCliente(rut);
        if (nuevoCliente != null) {  
            System.out.println("Saldo actual: " + CuentaActual.getSaldo());
        } else {
            System.out.println("No se encontró ningún cliente con ese RUT");
        }   
    }
}

  