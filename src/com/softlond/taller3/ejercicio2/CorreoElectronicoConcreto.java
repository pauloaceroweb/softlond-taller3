package com.softlond.taller3.ejercicio2;

import javax.swing.*;

public class CorreoElectronicoConcreto  extends  CorreoElectronico {

    public CorreoElectronicoConcreto(String destinatario, String contenido, String asunto) {
        super(destinatario, contenido, asunto);
    }

    @Override
    public void enviar() {
        JOptionPane.showMessageDialog(null, "Enviando correo electrónico:\n" +
                "Destinatario: " + getDestinatario() + "\n" +
                "Asunto: " + getAsunto() + "\n" +
                "Contenido: " + getContenido());
    }
}
