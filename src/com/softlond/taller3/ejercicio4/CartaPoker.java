package com.softlond.taller3.ejercicio4;

import javax.swing.*;

public class CartaPoker implements Carta {
    private String palo;
    private String valor;

    public CartaPoker(String palo, String valor) {
        this.palo = palo;
        this.valor = valor;
    }

    @Override
    public void mostrarCarta() {
        JOptionPane.showMessageDialog(null, valor + " de " + palo);
    }

    @Override
    public int valorNumerico() {
        switch (valor) {
            case "A":
                return 1;
            case "J":
            case "Q":
            case "K":
                return 10;
            default:
                return Integer.parseInt(valor);
        }
    }

    public String getPalo() {
        return palo;
    }
}
