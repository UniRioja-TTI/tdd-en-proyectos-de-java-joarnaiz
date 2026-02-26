package com.tt1.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ToDoTest {
    private ToDo tarea;
    @BeforeEach
    void setUp() {
        tarea = new ToDo();
    }
    @AfterEach
    void tearDown() {
    }
    @Test
    void getSetNombre() {
        tarea.setNombre("Tarea 1");
        assertEquals("Tarea 1", tarea.getNombre());
    }
    @Test
    void getSetDescripcion() {
        tarea.setDescripcion("Tarea tt1");
        assertEquals("Tarea tt1", tarea.getDescripcion());
    }
    @Test
    void getSetFechaLimite() {
        LocalDate fechaLimite = LocalDate.of(2020, 1, 1);
        tarea.setFechaLimite(fechaLimite);
        assertEquals(fechaLimite, tarea.getFechaLimite());
    }
    @Test
    void getSetCompletado() {
        tarea.setCompletado(true);
        assertEquals(true, tarea.getCompletado());
    }
}