/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cuentabancaria;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class CuentaBancaria {

    public String titular;
    public double saldo;
    public int numeroTransacciones = 0; // Se agrega para contar las transacciones

    public void consignar() {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuánto es lo que quiere consignar?: ");

        double valor = sc.nextDouble();

        if (valor <= 0) {
            System.out.println("El monto a consignar debe ser mayor a cero.");
            return;
        }

        this.saldo = this.saldo + valor;
        this.numeroTransacciones++; // Incrementa al consignar
        System.out.println("Consignación exitosa. Nuevo saldo: " + this.saldo + "$");
    }

    public void retirar() {
        Scanner sc1 = new Scanner(System.in);

        System.out.print("¿Cuánto desea retirar?: ");

        double retiro = sc1.nextDouble();

        if (retiro <= 0) {
            System.out.println("El monto a retirar debe ser mayor a cero.");
            return;
        }

        if (retiro > this.saldo) {
            System.out.println("Fondos insuficientes para realizar el retiro.");
            return;
        }

        this.saldo = this.saldo - retiro;
        this.numeroTransacciones++; // Incrementa al retirar
        System.out.println("Retiro exitoso. Nuevo saldo: " + this.saldo + "$");
    }

    // Reto: Método transferir que retira de esta cuenta y consigna en la destino
    public void transferir(CuentaBancaria destino, double monto) {
        if (monto <= 0) {
            System.out.println("El monto a transferir debe ser mayor a cero.");
            return;
        }

        if (monto > this.saldo) {
            System.out.println("Fondos insuficientes para realizar la transferencia.");
            return;
        }

        this.saldo -= monto;
        destino.saldo += monto;
        this.numeroTransacciones++;
        destino.numeroTransacciones++;
        System.out.println("Transferencia exitosa de " + monto + "$ a " + destino.titular);
    }

    // Reto: Método que devuelve el saldo mediante un return
    public double consultarSaldo() {
        return this.saldo;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria();
        cuenta1.titular = "Diego";
        cuenta1.saldo = 20000;

        CuentaBancaria cuenta2 = new CuentaBancaria();
        cuenta2.titular = "Sofia";
        cuenta2.saldo = 100000;

        System.out.println("El nombre del titular es: " + cuenta1.titular + " y tiene " + cuenta1.saldo + "$");

        cuenta1.consignar();

        System.out.println("El nombre del titular es: " + cuenta1.titular + " y tiene " + cuenta1.saldo + "$");

        cuenta1.retirar();

        System.out.println("El nombre del titular es: " + cuenta1.titular + " y tiene " + cuenta1.saldo + "$");

        System.out.println("Cuentas disponibles: " + cuenta1.titular + " y tiene " + cuenta1.saldo + "$" + ", " + cuenta2.titular + " y tiene " + cuenta2.saldo + "$");

        // Explicación Etapa 4:
        // Las operaciones sobre cuenta1 no alteran a cuenta2 porque en Java cada objeto instanciado con 'new' reserva su propia área de memoria independiente.

        // Demostración de Retos Adicionales:
        System.out.println("\n--- Probando Transferencia ---");
        cuenta1.transferir(cuenta2, 5000);

        System.out.println("\n--- Probando consultarSaldo() ---");
        System.out.println("Saldo devuelto por consultarSaldo() para " + cuenta1.titular + ": " + cuenta1.consultarSaldo() + "$");
        System.out.println("Saldo devuelto por consultarSaldo() para " + cuenta2.titular + ": " + cuenta2.consultarSaldo() + "$");

        System.out.println("\n--- Número de transacciones ---");
        System.out.println("Transacciones realizas por " + cuenta1.titular + ": " + cuenta1.numeroTransacciones);
        System.out.println("Transacciones realizas por " + cuenta2.titular + ": " + cuenta2.numeroTransacciones);
    }
}