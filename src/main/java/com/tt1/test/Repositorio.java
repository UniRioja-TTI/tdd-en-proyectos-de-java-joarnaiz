package com.tt1.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Repositorio implements IRepositorio{

    private IDBStub dbs;

    public Repositorio(IDBStub dbs) {
        this.dbs = dbs;
    }
    public ToDo encontrar(int id){
        for(ToDo t : dbs.READALL()){
            if(t.getId() == id){
                return t;
            }
        }
        return null;
    }

    public void marcarCompletado(ToDo td){
        td.setCompletado(true);
        dbs.UPDATE(td);
    }

    public List<ToDo> tareasSinCompletar(){
        List<ToDo> sinC = new ArrayList<ToDo>();
        for (ToDo t : dbs.READALL()){
            if(!t.getCompletado()){
                sinC.add(t);
            }
        }
        return sinC;
    }
    public void almacenar(ToDo td){
        dbs.CREATE(td);
    }
    public void almacenar(String email){
        dbs.CREATE(email);
    }
    public Set<String> listaCorreos(){
        return dbs.READALLEmail();
    }
}
