package com.tt1.test;

import java.time.LocalDate;
import java.util.List;

public class Servicio {

    private IRepositorio repositorio;
    private IEmail mailer;

    public Servicio(IRepositorio repositorio,IEmail mailer) {
        this.repositorio = repositorio;
        this.mailer = mailer;
    }

    public void crearToDo(String nombre, LocalDate fechaLimite){
        verificarAlertas();
        ToDo tarea = new ToDo();
        tarea.setNombre(nombre);
        tarea.setFechaLimite(fechaLimite);

        repositorio.almacenar(tarea);
    }

    public void agregarCorreo(String c){
        verificarAlertas();
        repositorio.almacenar(c);}

    public void marcarFinalizado(int id){
        verificarAlertas();
        ToDo tarea = repositorio.encontrar(id);
        if (tarea != null) {
            tarea.setCompletado(true);
            repositorio.marcarCompletado(tarea);
        }
    }

    public List<ToDo> toDoSinCompletar(){
        verificarAlertas();
        return repositorio.tareasSinCompletar();
    }

    private void verificarAlertas() {
        List<ToDo> pendientes = repositorio.tareasSinCompletar();
        LocalDate hoy = LocalDate.now();
        boolean hayRetrasados = false;
        for (ToDo t : pendientes) {
            if (t.getFechaLimite() != null && t.getFechaLimite().isBefore(hoy)) {
                hayRetrasados = true;
                break;
            }
        }
        if (hayRetrasados) {
            for (String email : repositorio.listaCorreos()) {
                mailer.enviarCorreo(email, "Alerta: Hay tareas pendientes cuya fecha límite ha pasado.");
            }
        }
    }

}
