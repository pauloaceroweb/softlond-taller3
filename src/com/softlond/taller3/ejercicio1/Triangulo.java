package com.softlond.taller3.ejercicio1;

public class Triangulo implements FiguraGeometrica {
    private double ladoA;
    private double ladoB;

    private double ladoC;

    public Triangulo(double ladoA, double ladoB, double ladoC) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }

    @Override
    public double calcularArea() {
        double s = (ladoA + ladoB + ladoC) / 2; //Se halla el semiperímetro
        return Math.sqrt(s * (s - ladoA) * (s - ladoB) * (s - ladoC));
    }

    @Override
    public double calcularPerimetro() {
        return ladoA + ladoB + ladoC;
    }
}
