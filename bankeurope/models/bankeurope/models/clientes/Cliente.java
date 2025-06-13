/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankeurope.models.clientes;

import bankeurope.models.cuentas.CuentaBancaria;

public class Cliente implements InfoClientes {
    private String rut;
    private String nombre; 
    private String apellidoPaterno; 
    private String apellidoMaterno;
    private String domicilio; 
    private String comuna; 
    private int teléfono;    
    private CuentaBancaria cuenta;  

    public Cliente(String rut, String nombre, String apellidoPaterno, String apellidoMaterno, String domicilio, String comuna, int teléfono) {
        if (!validarRut(rut)) {
            throw new IllegalArgumentException("RUT no válido");
        }
        
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno; 
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.teléfono = teléfono;
    }
    
    private boolean validarRut(String rut) {
        if (rut == null || rut.isEmpty()) {
            return false;
        } else {  
        return rut.length() == 9;
        }
    }
    
    public boolean registrarCliente() {       
        if (validarRut(rut)) { 
            System.out.println("\n Cliente registrado correctamente: " + nombre + " " + apellidoPaterno + " " + apellidoMaterno);
            return true;
        } 
        return false;    
    }
    
    @Override
    public void mostrarDatos() {
        System.out.println("\n========== Datos del cliente ==========");
        System.out.println("RUT: " + this.rut);
        System.out.println("Nombre completo: " + nombre + "" + apellidoPaterno + "" + apellidoMaterno);
        System.out.println("Domicilio: " + this.domicilio); 
        System.out.println("Comuna: " + this.comuna);
        System.out.println("Teléfono: " + this.teléfono); 
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public CuentaBancaria getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }
    
}
