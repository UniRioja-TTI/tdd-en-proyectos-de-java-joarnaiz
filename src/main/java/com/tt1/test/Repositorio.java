package com.tt1.test;

import java.util.List;

public class Repositorio implements IRepositorio{

    private IDBStub dbs;

    public Repositorio(IDBStub dbs) {
        this.dbs = dbs;
    }
    public ToDo encontrar(int id){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public void marcarCompletado(ToDo td){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public List<ToDo> tareasSinCompletar(){throw new UnsupportedOperationException("Clase aún no implementada.");}
    public void almacenar(ToDo td){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public void almacenar(String email){
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
}
