package com.softlond.taller3.ejercicio2;

public abstract class NotificacionAbstracta implements Notificacion {
   private String destinatario;
   private String contenido;

   public NotificacionAbstracta (String destinatario, String contenido) {
       this.destinatario = destinatario;
       this.contenido = contenido;
   }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

}
