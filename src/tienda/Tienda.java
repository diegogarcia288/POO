/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tienda;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Tienda {
    
    public String nombre;
    public double precio;
    public int stock;
    
    public void registrarVenta (){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("¿Cuánto se vendió? ");
        
        int vent = sc.nextInt();
        
        if (vent <= 0) {
            return;
        }
        
        this.stock = this.stock - vent;
    
    }
    
    public void reponer (){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("¿Cuanto va a reponer? ");
        
        int rep = sc.nextInt();
        
        if(rep <= 0) {
            return;
        }
        
        this.stock = this.stock + rep;
    }
    
    public void mostrarInformacion(){
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tienda p1 = new Tienda();
        p1.nombre = "Arroz";
        p1.precio = 6300;
        p1.stock = 1000;
        
        p1.registrarVenta ();
        
        System.out.print("Actualmente hay " + p1.stock + "de " + p1.nombre);
        
        p1.reponer ();
        System.out.print("Se ha aumentado el stock: " + p1.stock);
        
        p1.mostrarInformacion();
        System.out.print("Actualmente hay " + p1.nombre + " a un precio de " + p1.precio + " y hay " + p1.stock );
        
        
    }
    
}
