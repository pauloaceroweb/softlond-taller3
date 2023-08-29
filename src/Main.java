import com.softlond.taller3.ejercicio1.FigurasController;
import com.softlond.taller3.ejercicio2.NotificacionController;
import com.softlond.taller3.ejercicio3.CuentaController;
import com.softlond.taller3.ejercicio4.Baraja;
import com.softlond.taller3.ejercicio4.Carta;
import com.softlond.taller3.ejercicio4.CartaPoker;
import com.softlond.taller3.ejercicio4.JuegoDeCartas;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        int opcion;
        do {
            try {
                opcion = obtenerOpcion();
                switch (opcion) {
                    case 1 -> {
                        JOptionPane.showMessageDialog(null, "Figuras Geométricas");
                        FigurasController figurasController = new FigurasController();
                        figurasController.run();
                    }
                    case 2 -> {
                        JOptionPane.showMessageDialog(null, "Sistema de Notificaciones");
                        NotificacionController notificacionController = new NotificacionController();
                        notificacionController.mostrarMenu();
                    }
                    case 3 -> {
                        JOptionPane.showMessageDialog(null, "Banco y Cuentas");
                        CuentaController cuentaController = new CuentaController();
                        cuentaController.mostrarMenu();
                    }
                    case 4 -> {
                        JOptionPane.showMessageDialog(null, "Juego de Cartas");
                        JuegoDeCartas juegoDeCartas = new JuegoDeCartas();
                        juegoDeCartas.run();
                    }
                    case 5 -> JOptionPane.showMessageDialog(null, "Tienda en Línea");
                    case 6 -> JOptionPane.showMessageDialog(null, "Animales y Sonidos");
                    case 7 -> JOptionPane.showMessageDialog(null, "Formas Geométricas y Áreas");
                    case 8 -> JOptionPane.showMessageDialog(null, "Empleados y Salarios");
                    case 9 -> JOptionPane.showMessageDialog(null, "Instrumentos Musicales");
                    case 10 -> JOptionPane.showMessageDialog(null, "Figuras en Lienzo");
                    case 11 -> JOptionPane.showMessageDialog(null, "Gracias por utilizar el programa. ¡Hasta luego!");
                    default -> JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, ingrese una opción válida.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.");
                opcion = 0;
            }
        } while (opcion != 11);
    }

    private static int obtenerOpcion() {
        String input = JOptionPane.showInputDialog("""
                MENU PRINCIPAL
                Ingrese el número del Ejercicio a ver:
                1. Figuras Geométricas
                2. Sistema de notificaciones
                3. Banco y Cuentas
                4. Juego de Cartas
                5. Tienda en línea
                6. Animales y Sonidos
                7. Formas Geométricas y Áreas
                8. Empleados y Salarios
                9. Instrumentos Musicales
                10. Figuras en un Lienzo
                11. Salir del Sistema
                """);
        if (input == null) {
            JOptionPane.showMessageDialog(null, "Operación Cancelada");
            System.exit(0);
        }
        return Integer.parseInt(input);
    }

}