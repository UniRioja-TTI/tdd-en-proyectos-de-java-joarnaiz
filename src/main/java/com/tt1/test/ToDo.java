package com.tt1.test;

import java.io.Serializable;
import java.time.LocalDate;

public class ToDo implements Serializable {
    private static int contadorIds= 1;
    private int id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaLimite; //String año mes dia
    private boolean completado;

    public ToDo(){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public ToDo(String nombre,LocalDate fechal){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public int getId() { throw new UnsupportedOperationException("Clase aún no implementada.");}

    public String getNombre(){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public void setNombre(String n){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public String getDescripcion(){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public void setDescripcion(String s){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public LocalDate getFechaLimite(){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public void setFechaLimite(LocalDate fechaLimite) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public Boolean getCompletado(){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public void setCompletado(Boolean c){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
}
