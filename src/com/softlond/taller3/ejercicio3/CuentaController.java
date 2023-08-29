package com.softlond.taller3.ejercicio3;

import javax.swing.*;

public class CuentaController {
    public void mostrarMenu() {
        int opcion;
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                        MENU CUENTAS
                        Ingrese el tipo de cuenta a consultar:
                        1. Cuenta de Ahorro
                        2. Cuenta Corriente
                        3. Salir
                        """));

                switch (opcion) {
                    case 1 -> ingresarDatosCuentaAhorro();
                    case 2 -> ingresarDatosCuentaCorriente();
                    case 3 -> JOptionPane.showMessageDialog(null, "Saliendo del menú cuentas. ¡Hasta luego!");
                    default ->
                            JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, ingrese una opción correcta.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.");
                opcion = 0; // Reiniciar la opción para que el bucle no continúe con la opción anterior inválida
            }
        } while (opcion != 3);
    }

    private void ingresarDatosCuenta(String tipoCuenta) {
        try {
            String titular = JOptionPane.showInputDialog("Ingrese el nombre del titular de la cuenta:");
            String saldoInicialStr = JOptionPane.showInputDialog("Ingrese el saldo inicial de la " + tipoCuenta + ":");

            if (saldoInicialStr == null) {
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
                return;
            }

            double saldoInicial = Double.parseDouble(saldoInicialStr);

            if (tipoCuenta.equals("cuenta de ahorro")) {
                String tasaInteresStr = JOptionPane.showInputDialog("Ingrese la tasa de interés de la cuenta de ahorro:");
                if (tasaInteresStr == null) {
                    JOptionPane.showMessageDialog(null, "Operación cancelada.");
                    return;
                }

                double tasaInteres = Double.parseDouble(tasaInteresStr);

                CuentaAhorro cuentaAhorro = new CuentaAhorro(titular, saldoInicial, tasaInteres);
                realizarOperaciones(cuentaAhorro);
            } else if (tipoCuenta.equals("cuenta corriente")) {
                String sobregiroStr = JOptionPane.showInputDialog("Ingrese el límite de sobregiro de la cuenta corriente:");
                if (sobregiroStr == null) {
                    JOptionPane.showMessageDialog(null, "Operación cancelada.");
                    return;
                }

                double sobregiro = Double.parseDouble(sobregiroStr);

                String comisionSobregiroStr = JOptionPane.showInputDialog("Ingrese la comisión por sobregiro de la cuenta corriente (%):");
                if (comisionSobregiroStr == null) {
                    JOptionPane.showMessageDialog(null, "Operación cancelada.");
                    return;
                }

                double comisionSobregiro = Double.parseDouble(comisionSobregiroStr);

                CuentaCorriente cuentaCorriente = new CuentaCorriente(titular, saldoInicial, sobregiro, comisionSobregiro);
                realizarOperaciones(cuentaCorriente);
            } else {
                JOptionPane.showMessageDialog(null, "Tipo de cuenta no reconocido.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido.");
        }
    }

    private void ingresarDatosCuentaAhorro() {
        ingresarDatosCuenta("cuenta de ahorro");
    }

    private void ingresarDatosCuentaCorriente() {
        ingresarDatosCuenta("cuenta corriente");
    }


    private void realizarOperaciones(CuentaAbstracta cuenta) {
        boolean continuar = true;

        while (continuar) {
            try {
                double monto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a depositar o retirar:"));

                int operacion = Integer.parseInt(JOptionPane.showInputDialog("""
                    Seleccione la operación:
                    1. Depositar
                    2. Retirar
                    3. Salir
                    """));

                switch (operacion) {
                    case 1 -> {
                        cuenta.depositar(monto);
                        if (cuenta instanceof CuentaAhorro) {
                            ((CuentaAhorro) cuenta).calcularInteres();
                        }
                    }
                    case 2 -> {
                        cuenta.retirar(monto);
                        if (cuenta instanceof CuentaCorriente) {
                            ((CuentaCorriente) cuenta).aplicarComision();
                        }
                    }
                    case 3 -> {
                        JOptionPane.showMessageDialog(null, "Saliendo de las operaciones.");
                        continuar = false;
                    }
                    default ->
                            JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, seleccione una opción válida.");
                }

                if (continuar) {
                    mostrarInformacionCuenta(cuenta);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido.");
            }
        }
    }

    private void mostrarInformacionCuenta(CuentaAbstracta cuenta) {
        double saldo = cuenta.consultarSaldo();
        String tipoCuenta = cuenta instanceof CuentaAhorro ? "Cuenta de Ahorro" : "Cuenta Corriente";
        String comisionOInteres = cuenta instanceof CuentaAhorro ? "Interés aplicado" : "Comisión aplicada";
        double comisionOInteresAplicado = cuenta instanceof CuentaAhorro ? ((CuentaAhorro) cuenta).getInteresAplicado() : ((CuentaCorriente) cuenta).getComisionAplicada();
        String informacionCuenta = "Información de la cuenta:\n" +
                "Tipo de cuenta: " + tipoCuenta + "\n" +
                "Titular: " + cuenta.getTitular() + "\n" +
                comisionOInteres + ": " + comisionOInteresAplicado + "\n" +
                "Saldo: " + saldo;

        JOptionPane.showMessageDialog(null, informacionCuenta);
    }


}