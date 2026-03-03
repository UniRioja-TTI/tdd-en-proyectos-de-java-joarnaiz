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
        this.id = contadorIds;
        contadorIds++;
    }

    public ToDo(String nombre,LocalDate fechal){
        this.nombre = nombre;
        this.fechaLimite = fechal;
        this.id = contadorIds;
        contadorIds++;
    }

    public int getId() { return id; }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String n){
        nombre = n;
    }

    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String s){
        descripcion = s;
    }

    public LocalDate getFechaLimite(){
        return fechaLimite;
    }
    public void setFechaLimite(LocalDate fecha) {
        fechaLimite = fecha;
    }

    public Boolean getCompletado(){
        return completado;
    }
    public void setCompletado(Boolean c){
        completado = c;
    }
}
