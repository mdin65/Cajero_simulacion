package org.example;
import java.util.Scanner;

public class Cajero {

    private static final int saldo_inicial= 100000;
    private static int saldo = saldo_inicial;
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Ejecuta el menú principal del programa y gestiona la interacción con el usuario.
     */
    public static void menu() {
        // TODO: Implementar el código para gestionar la interacción con el usuario.

            int opcion;
            do {
                mostrarOpciones();
                opcion = obtenerOpcion();
                ejecutarOpcion(opcion);
            } while (opcion != 6);
        }

        private static int obtenerOpcion() {
            return Integer.parseInt(scanner.nextLine());
        }

        private static void mostrarOpciones() {
            // TODO: Implementar el código para mostrar las opciones del menú en pantalla.
            System.out.println("\n============Bienvenido=================");
            System.out.println("1. retirar Dinero ");
            System.out.println("2. depositar Dinero ");
            System.out.println("3  Consultar Saldo ");
            System.out.println("4. salir");
        }

        private static void ejecutarOpcion(int opcion) {
            // TODO: Implementar la lógica para ejecutar la opción seleccionada.
            switch (opcion) {
                case 1 :
                    System.out.print("Ingresa el monto a retirar: ");
                    int montoRetiro = scanner.nextInt();
                    retirar(montoRetiro);
                case 2 :
                    System.out.print("Ingresa el monto a depositar: ");
                    int montoDeposito = scanner.nextInt();
                    depositar(montoDeposito);

                case 3 :
                    obtenerSaldo();

                case 4: System.out.println("  Hasta luego...");
                default : System.out.println(" Opcion invalida...");
            }

        }
    public static void montopositivo(int monto){
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo.");
        }
    }

    public static void multiplode1000(int monto){
        if (monto % 1000 != 0) {
            throw new IllegalArgumentException("El monto debe ser múltiplo de 1000.");
        }
    }
    public static void validarSaldo(int monto){
        if (monto > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
    }

    public static void retirar(int montoRetiro) {
        // TODO: Validar monto positivo
        // TODO: Validar múltiplo de 1000

        // TODO: Validar que el saldo sea suficiente
        // TODO: Restar el monto del saldo si todo es válido

        try {
            montopositivo(montoRetiro);
            multiplode1000(montoRetiro);
            validarSaldo(montoRetiro);
            saldo -= montoRetiro;
            System.out.println("Has retirado: " + montoRetiro);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void depositar(int montoDeposito) {
        // TODO: Validar monto positivo
        // TODO: Validar múltiplo de 1000
        // TODO: Sumar el monto al saldo si es válido

        try {
            montopositivo(montoDeposito);
            multiplode1000(montoDeposito);
            saldo += montoDeposito;
            System.out.println("Has Depositado: " + montoDeposito);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Retorna el saldo disponible en la cuenta Simulada.
     * @return Saldo actual.
     */
    public static int obtenerSaldo() {
        // TODO: Retornar el valor actual del saldo
        return saldo;
    }

    /**
     * Reinicia el saldo a un valor inicial fijo (usado en pruebas).
     */
    public static void reiniciarSaldo() {
        // TODO: Restablecer el valor del saldo a su valor original
        saldo= saldo_inicial;
        System.out.println("El saldo se ha reiniciado");
    }
}