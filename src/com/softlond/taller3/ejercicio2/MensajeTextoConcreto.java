package com.softlond.taller3.ejercicio2;

import javax.swing.*;

public class MensajeTextoConcreto extends MensajeTexto {

    public MensajeTextoConcreto(String destinatario, String contenido, String numeroDestino) {
        super(destinatario, contenido, numeroDestino);
    }

    @Override
    public void enviar() {
        JOptionPane.showMessageDialog(null, "Enviando mensaje de texto:\n" +
                "Destinatario: " + getDestinatario() + "\n" +
                "Número de destino: " + getNumeroDestino() + "\n" +
                "Contenido: " + getContenido());
    }
}
