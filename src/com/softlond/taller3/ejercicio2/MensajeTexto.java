package com.softlond.taller3.ejercicio2;

public abstract class MensajeTexto extends NotificacionAbstracta {

    private String numeroDestino;

    public MensajeTexto(String destinatario, String contenido, String numeroDestino) {
        super(destinatario, contenido);
        this.numeroDestino = numeroDestino;
    }

    public String getNumeroDestino() {
        return numeroDestino;
    }

    public void setNumeroDestino(String numeroDestino) {
        this.numeroDestino = numeroDestino;
    }

}

