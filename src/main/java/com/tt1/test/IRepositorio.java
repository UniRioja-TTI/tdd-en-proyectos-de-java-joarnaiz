package com.tt1.test;

import java.util.List;

public interface IRepositorio {
    public ToDo encontrar(int id);
    public void marcarCompletado(ToDo td);
    public List<ToDo> tareasSinCompletar();
    public void almacenar(ToDo td);
    public void almacenar(String email);
}
