package com.softlond.taller3.ejercicio3;

public abstract class CuentaAbstracta  implements CuentaBancaria {

    protected String titular;
    protected double saldo;

    public CuentaAbstracta(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public String getTitular() {
        return titular;
    }

    public double consultarSaldo() {
        return saldo;
    }

}
