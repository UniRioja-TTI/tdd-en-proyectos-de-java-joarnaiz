package com.tt1.test;

import java.time.LocalDate;
import java.util.List;

public class Servicio {

    private Repositorio repositorio;
    private MailerStub mailer;

    public Servicio(Repositorio repositorio, MailerStub mailer)
    {
        this.repositorio = repositorio;
        this.mailer = mailer;
    }

    public void crearToDo(String nombre, LocalDate fechaLimite){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public void agregarCorreo(String c){throw new UnsupportedOperationException("Clase aún no implementada.");}

    public void marcarFinalizado(int id){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public List<ToDo> toDoSinCompletar(){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }


}
