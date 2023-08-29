package com.softlond.taller3.ejercicio2;

public abstract class NotificacionPush extends NotificacionAbstracta {

    private String dispositivo;

    public NotificacionPush(String destinatario, String contenido, String dispositivo) {
        super(destinatario, contenido);
        this.dispositivo = dispositivo;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

}
