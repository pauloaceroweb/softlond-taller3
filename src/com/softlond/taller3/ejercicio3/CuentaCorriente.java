package com.softlond.taller3.ejercicio3;

import javax.swing.*;

public class CuentaCorriente extends CuentaAbstracta {
    private double limiteSobregiro;
    private double comisionSobregiro;
    private double comisionAplicada;

    public CuentaCorriente(String titular, double saldoInicial, double limiteSobregiro, double comisionSobregiro) {
        super(titular, saldoInicial);
        this.comisionSobregiro = comisionSobregiro;
        this.limiteSobregiro = limiteSobregiro;
        this.comisionAplicada = 0.0;
    }

    @Override
    public void depositar(double monto) {
        saldo += monto;
    }

    @Override
    public void retirar(double monto) {
        if (monto <= saldo + limiteSobregiro) {
            saldo -= monto;
            if (saldo < 0) {
                saldo -= comisionSobregiro;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fondos Insuficientes.");
        }
    }

    public double getComisionAplicada() {
        return comisionAplicada;
    }

    public void aplicarComision() {
        if (consultarSaldo() < 0) {
            comisionAplicada = Math.abs(consultarSaldo()) * comisionSobregiro / 100;
            retirar(comisionAplicada);
        }
    }
}
