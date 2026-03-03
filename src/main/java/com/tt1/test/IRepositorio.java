package com.tt1.test;

import java.util.List;
import java.util.Set;

public interface IRepositorio {
    public ToDo encontrar(int id);
    public void marcarCompletado(ToDo td);
    public List<ToDo> tareasSinCompletar();
    public void almacenar(ToDo td);
    public void almacenar(String email);
    public Set<String> listaCorreos();
}
