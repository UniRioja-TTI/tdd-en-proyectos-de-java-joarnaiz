package com.tt1.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DBStubTest {
    private DBStub db;
    @BeforeEach
    void setUp() {
        db = new DBStub();
    }
    @AfterEach
    void tearDown() {
    }
    @Test
    void CREATE() {
        ToDo tarea = new ToDo();
        db.CREATE(tarea);

        ToDo resultado = db.READ(tarea);

        assertNotNull(resultado,"No deberia devolver null");
        assertEquals(tarea.getId(), resultado.getId(), "Deberian ser iguales");
    }
    @Test
    void DELETE() {
        ToDo tarea = new ToDo();
        db.CREATE(tarea);
        assertNotNull(db.READ(tarea), "No deberia devolver null");

        db.DELETE(tarea);
        assertNull(db.READ(tarea), "Deberia devolver null");
    }
    @Test
    void UPDATE() {
        ToDo tarea = new ToDo();
        db.CREATE(tarea);

        tarea.setNombre("Test");
        db.UPDATE(tarea);
        assertNotNull(db.READ(tarea), "No deberia devolver null");
        assertEquals("Test", db.READ(tarea).getNombre());
        assertSame(tarea, db.READ(tarea), "Deberian ser iguales");
    }
    @Test
    void READ() {
        ToDo tarea = new ToDo();
        db.CREATE(tarea);

        ToDo resultado = db.READ(tarea);

        assertNotNull(resultado,"No deberia devolver null");
    }
    @Test
    void READALL() {
        ToDo tarea1 = new ToDo();
        ToDo tarea2 = new ToDo();
        ToDo tarea3 = new ToDo();

        db.CREATE(tarea1);
        db.CREATE(tarea2);
        db.CREATE(tarea3);

        assertEquals(3, db.READALL().size(), "Deberian ser iguales");
    }
    @Test
    void testCorreo() {
        String correo = "hola@gmail.com";
        db.CREATE(correo);
        Set<String> correos = db.READALLEmail();

        assertNotNull(correos, "Deberia no ser nula");
        assertTrue(correos.contains(correo), "Deberia estar el correo en la lisra");

    }
}