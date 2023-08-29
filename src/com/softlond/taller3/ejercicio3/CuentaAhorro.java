package com.softlond.taller3.ejercicio3;

import javax.swing.*;

public class CuentaAhorro extends CuentaAbstracta {

    private double tasaInteres;
    private double interesAplicado;

    public CuentaAhorro(String titular, double saldoInicial, double tasaInteres) {
        super(titular, saldoInicial);
        this.tasaInteres = tasaInteres;
        this.interesAplicado = 0.0;
    }

    @Override
    public void depositar(double monto) {
        saldo += monto;
    }

    @Override
    public void retirar(double monto) {
        if (monto <= saldo) {
            saldo -= monto;
        } else  {
            JOptionPane.showMessageDialog(null, "Fondos Insuficientes.");
        }
    }

    public double getInteresAplicado() {
        return interesAplicado;
    }
    public void calcularInteres() {
        interesAplicado = consultarSaldo() * tasaInteres / 100;
        depositar(interesAplicado);
    }
}
