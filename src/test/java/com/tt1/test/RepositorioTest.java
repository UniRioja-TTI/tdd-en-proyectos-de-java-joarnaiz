package com.tt1.test;

import Mock.DBStubFake;
import Mock.RepositorioFake;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositorioTest {
    private Repositorio repo;
    private IDBStub db;

    private Repositorio repoUnitarios;
    private IDBStub dbFake;

    @BeforeEach
    void setUp() {
        db = new DBStub();
        repo= new Repositorio(db);
        dbFake = new DBStubFake();
        repoUnitarios = new Repositorio(dbFake);
    }
    @Test
    void encontrar() {
        ToDo tarea = new ToDo();
        int id = tarea.getId();
        db.CREATE(tarea);
        ToDo r = repo.encontrar(id);

        assertNotNull(r,"Deberia encontrar la tarea");
        assertEquals(id,r.getId(),"El ID deberia coincidir");
    }
    @Test
    void marcarCompletado() {
        ToDo tarea = new ToDo();
        tarea.setCompletado(false);
        db.CREATE(tarea);

        repo.marcarCompletado(tarea);

        ToDo nuevaT = db.READ(tarea);
        assertTrue(nuevaT.getCompletado(),"Deberia estar completada");
    }

    @Test
    void almacenar() {
        ToDo tarea = new ToDo();
        tarea.setNombre("Test");
        repo.almacenar(tarea);
        assertNotNull(db.READ(tarea),"La tarea deberia haberse guardado");
    }
    @Test
    void testAlmacenar() {
        String correo = "test@test.com";
        repo.almacenar(correo);

        assertTrue(db.READALLEmail().contains(correo),"El correo deberia estar");

    }

    @Test
    void encontrarUnitario() {
        ToDo tarea = new ToDo();
        int id = tarea.getId();
        dbFake.CREATE(tarea);
        ToDo r = repoUnitarios.encontrar(id);

        assertNotNull(r,"Deberia encontrar la tarea");
        assertEquals(id,r.getId(),"El ID deberia coincidir");
    }
    @Test
    void marcarCompletadoUnitario() {
        ToDo tarea = new ToDo();
        tarea.setCompletado(false);
        dbFake.CREATE(tarea);

        repoUnitarios.marcarCompletado(tarea);

        ToDo nuevaT = dbFake.READ(tarea);
        assertTrue(nuevaT.getCompletado(),"Deberia estar completada");
    }

    @Test
    void almacenarUnitario() {
        ToDo tarea = new ToDo();
        tarea.setNombre("Test");
        repoUnitarios.almacenar(tarea);

        assertNotNull(dbFake.READ(tarea),"La tarea deberia haberse guardado");
    }
    @Test
    void testAlmacenarUnitario() {
        String correo = "test@test.com";
        repoUnitarios.almacenar(correo);

        assertTrue(dbFake.READALLEmail().contains(correo),"El correo deberia estar");

    }
}