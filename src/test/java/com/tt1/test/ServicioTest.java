package com.tt1.test;

import Mock.MailerFake;
import Mock.RepositorioFake;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServicioTest {

    private Servicio servicio;
    private IRepositorio repositorio;
    private IDBStub db;
    private IEmail mailer;

    private Servicio servicioUnitario;
    private RepositorioFake repoFake;
    private MailerFake emailFake;

    @BeforeEach
    void setUp() {
        db = new DBStub();
        repositorio = new Repositorio(db);
        mailer = new MailerStub();
        servicio = new Servicio(repositorio,mailer);

        repoFake = new RepositorioFake();
        emailFake = new MailerFake();
        servicioUnitario = new Servicio(repoFake,emailFake);
    }

    @Test
    void crearToDo() {
        servicio.crearToDo("test", LocalDate.now());
        List<ToDo> todas = db.READALL();

        assertEquals(1, todas.size(),"Deberia solo haber una");
        assertEquals("test",todas.get(0).getNombre(),"Deberian ser iguales");
    }

    @Test
    void agregarCorreo() {
        servicio.agregarCorreo("hola@hola.com");
        assertTrue(db.READALLEmail().contains("hola@hola.com"));
    }

    @Test
    void marcarFinalizado() {
        ToDo tarea = new ToDo();
        tarea.setCompletado(false);
        db.CREATE(tarea);
        int id = tarea.getId();

        servicio.marcarFinalizado(id);
        assertTrue(db.READ(tarea).getCompletado(),"Deberia estar completada");
    }

    @Test
    void toDoSinCompletar() {
        ToDo t1 = new ToDo(); t1.setCompletado(false); db.CREATE(t1);
        ToDo t2 = new ToDo(); t2.setCompletado(true);  db.CREATE(t2);

        List<ToDo> pendientes = servicio.toDoSinCompletar();

        assertEquals(1, pendientes.size(), "Solo debería devolver la tarea incompleta");
        assertFalse(pendientes.get(0).getCompletado());
    }

    @Test
    void crearToDoUnitario() {
        String nombre = "Nueva Tarea";
        LocalDate fecha = LocalDate.now();

        servicioUnitario.crearToDo(nombre, fecha);
        assertTrue(repoFake.almacenarTareaLlamado, "El servicio debería haber llamado al método almacenar del repositorio");
    }

    @Test
    void agregarCorreoUnitario() {
        String correo = "test@unidad.com";
        servicioUnitario.agregarCorreo(correo);

        assertTrue(repoFake.almacenarEmailLlamado, "El servicio debería haber guardado el email en el repositorio");
        assertTrue(emailFake.enviarCorreo("d","m"), "El servicio debería devolver true");
    }

    @Test
    void marcarFinalizadoUnitario() {

        servicioUnitario.marcarFinalizado(1);
        assertTrue(repoFake.encontrarLlamado, "El servicio debería haber buscado la tarea primero");
        assertTrue(repoFake.marcarCompletadoLlamado, "El servicio debería haber ordenado marcarla como completada");

    }

    @Test
    void toDoSinCompletarUnitario() {

        List<ToDo> pendientes = servicioUnitario.toDoSinCompletar();

        assertEquals(1, pendientes.size(), "Solo debería devolver la tarea incompleta");
        assertFalse(pendientes.get(0).getCompletado());
    }
}