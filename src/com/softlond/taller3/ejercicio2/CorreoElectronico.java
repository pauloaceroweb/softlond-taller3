package com.softlond.taller3.ejercicio2;

public abstract class CorreoElectronico extends NotificacionAbstracta {

    private String asunto;

    public CorreoElectronico(String destinatario, String contenido, String asunto) {
        super(destinatario, contenido);
        this.asunto = asunto;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto() {
        this.asunto = asunto;
    }

}

