package com.softlond.taller3.ejercicio2;

import javax.swing.*;

public class NotificacionPushConcreto extends NotificacionPush {

    public NotificacionPushConcreto(String destinatario, String contenido, String dispositivo) {
        super(destinatario, contenido, dispositivo);
    }

    @Override
    public void enviar() {
        JOptionPane.showMessageDialog(null, "Enviando notificación push:\n" +
                "Destinatario: " + getDestinatario() + "\n" +
                "Dispositivo: " + getDispositivo() + "\n" +
                "Contenido: " + getContenido());
    }
}
