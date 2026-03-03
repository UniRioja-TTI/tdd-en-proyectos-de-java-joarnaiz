package com.tt1.test;

import java.util.*;

public class DBStub implements IDBStub{

    private Map<Integer,ToDo> listaTareas;
    private Set<String> listaEmail;

    public DBStub(){
        listaTareas = new HashMap<>();
        listaEmail = new HashSet<>();
    }

    public void CREATE(ToDo td){
        listaTareas.put(td.getId(), td);
    }
    public void DELETE(ToDo td){
        listaTareas.remove(td.getId());
    }
    public void UPDATE(ToDo td){
        listaTareas.put(td.getId(), td);
    }
    public ToDo READ(ToDo td){
        return listaTareas.get(td.getId());
    }
    public List<ToDo> READALL(){return new ArrayList<>(listaTareas.values());}
    public void CREATE(String email){
        listaEmail.add(email);
    }
    public Set<String>READALLEmail(){return listaEmail;}
}
