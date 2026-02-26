package com.tt1.test;

import java.util.*;

public class DBStub{

    private Map<String,ToDo> listaTareas; //Mapa
    private Set<String> listaEmail;

    public DBStub(){
        listaTareas = new HashMap<>();
        listaEmail = new HashSet<>();
    }

    public void CREATE(ToDo td){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public void DELETE(ToDo td){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public void UPDATE(ToDo td){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public ToDo READ(ToDo td){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public List<ToDo> READALL(){throw new UnsupportedOperationException("Clase aún no implementada.");}
    public void CREATE(String email){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
}
