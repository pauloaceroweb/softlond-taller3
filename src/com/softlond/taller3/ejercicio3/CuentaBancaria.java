package com.softlond.taller3.ejercicio3;

public interface CuentaBancaria {

    double consultarSaldo();

    void depositar(double monto);

    void retirar(double monto);
}
