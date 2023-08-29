package com.softlond.taller3.ejercicio1;

import javax.swing.*;

public class FigurasController {
    public void run() {

        try {
            String figuraSeleccionada = JOptionPane.showInputDialog("Seleccione una figura: Circulo, Triangulo o Cuadrado");

            if (figuraSeleccionada == null) {
                JOptionPane.showMessageDialog(null, "Operación Cancelada");
                return;
            }

            FiguraGeometrica figuraGeometrica;

            switch (figuraSeleccionada.toLowerCase()) {
                case "circulo":
                    double radio = obtenerValorNumerico("Ingrese el radio del círculo:");
                    figuraGeometrica = new Circulo(radio);
                    break;
                case "triangulo":
                    double ladoA = obtenerValorNumerico("Ingrese el lado A del triángulo:");
                    double ladoB = obtenerValorNumerico("Ingrese el lado B del triángulo:");
                    double ladoC = obtenerValorNumerico("Ingrese el lado C del triángulo:");
                    figuraGeometrica = new Triangulo(ladoA, ladoB, ladoC);
                    break;
                case "cuadrado":
                    double lado = obtenerValorNumerico("Ingrese el lado del cuadrado:");
                    figuraGeometrica = new Cuadrado(lado);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Figura no reconocida.");
                    return;
            }

            JOptionPane.showMessageDialog(null, "Área: " + figuraGeometrica.calcularArea()
                    + "\nPerímetro: " + figuraGeometrica.calcularPerimetro()
            );
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido.");
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e.getMessage());
        }
    }

    private double obtenerValorNumerico(String mensaje) {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(mensaje);
                if (input == null) {
                    JOptionPane.showMessageDialog(null, "Operación Cancelada");
                    System.exit(0); // Salir del programa si se cancela
                }
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido.");
            }
        }
    }
}