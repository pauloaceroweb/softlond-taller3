package com.softlond.taller3.ejercicio2;

import javax.swing.*;

public class NotificacionController {
    public void mostrarMenu() {
        int opcion;
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                        MENU NOTIFICACIONES
                        Ingrese el tipo de notificación a enviar:
                        1. Correo Electrónico
                        2. Mensaje de Texto
                        3. Notificación Push
                        4. Salir
                        """));

                switch (opcion) {
                    case 1 -> enviarCorreo();
                    case 2 -> enviarMensajeTexto();
                    case 3 -> enviarNotificacionPush();
                    case 4 -> JOptionPane.showMessageDialog(null, "Saliendo del menú de notificaciones. ¡Hasta luego!");
                    default -> JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, ingrese una opción válida.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.");
                opcion = 0;
            }
        } while (opcion != 4);
    }

    private void enviarCorreo() {
        String destinatario = JOptionPane.showInputDialog("Ingrese el destinatario del correo:");
        String asunto = JOptionPane.showInputDialog("Ingrese el asunto del correo:");
        String contenido = JOptionPane.showInputDialog("Ingrese el contenido del correo:");

        if (destinatario != null && asunto != null && contenido != null) {
            CorreoElectronicoConcreto correo = new CorreoElectronicoConcreto(destinatario, contenido, asunto);
            correo.enviar();
        } else {
            JOptionPane.showMessageDialog(null, "Operación Cancelada");
        }
    }

    private void enviarMensajeTexto() {
        String destinatario = JOptionPane.showInputDialog("Ingrese el destinatario del mensaje:");
        String numeroDestino = JOptionPane.showInputDialog("Ingrese el número de destino:");
        String contenido = JOptionPane.showInputDialog("Ingrese el contenido del mensaje:");

        if (destinatario != null && numeroDestino != null && contenido != null) {
            MensajeTextoConcreto mensaje = new MensajeTextoConcreto(destinatario, contenido, numeroDestino);
            mensaje.enviar();
        } else {
            JOptionPane.showMessageDialog(null, "Operación Cancelada");
        }
    }

    private void enviarNotificacionPush() {
        String destinatario = JOptionPane.showInputDialog("Ingrese el destinatario de la notificación:");
        String dispositivo = JOptionPane.showInputDialog("Ingrese el dispositivo de destino:");
        String contenido = JOptionPane.showInputDialog("Ingrese el contenido de la notificación:");

        if (destinatario != null && dispositivo != null && contenido != null) {
            NotificacionPushConcreto notificacionPush = new NotificacionPushConcreto(destinatario, contenido, dispositivo);
            notificacionPush.enviar();
        } else {
            JOptionPane.showMessageDialog(null, "Operación Cancelada");
        }
    }

}
