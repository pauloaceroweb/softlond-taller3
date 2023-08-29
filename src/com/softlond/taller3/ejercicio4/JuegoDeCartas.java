package com.softlond.taller3.ejercicio4;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JuegoDeCartas {
    private List<Carta> cartas;

    public JuegoDeCartas() {
        cartas = new ArrayList<>();
        inicializarBaraja();
    }

    private void inicializarBaraja() {
        String[] palos = {"Corazones", "Diamantes", "Tréboles", "Picas"};
        String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (String palo : palos) {
            for (String valor : valores) {
                cartas.add(new CartaPoker(palo, valor));
            }
        }
    }

    public void barajar() {
        Collections.shuffle(cartas);
    }

    public Carta sacarCarta() {
        if (cartas.isEmpty()) {
            return null;
        }
        return cartas.remove(0);
    }

    public void run() {
        barajar();
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Cartas sacadas:\n");

        // Ejemplo de juego: sacar y mostrar varias cartas
        for (int i = 0; i < 5; i++) {
            Carta carta = sacarCarta();
            if (carta != null) {
                mensaje.append(carta.valorNumerico()).append(" de ").append(((CartaPoker) carta).getPalo()).append("\n");
            } else {
                mensaje.append("No quedan más cartas en la baraja.\n");
            }
        }

        JOptionPane.showMessageDialog(null, mensaje.toString());
    }
}









