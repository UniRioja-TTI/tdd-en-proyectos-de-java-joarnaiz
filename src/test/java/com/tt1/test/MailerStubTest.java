package com.tt1.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailerStubTest {
    private MailerStub mailer;
    @BeforeEach
    void setUp() {
        mailer = new MailerStub();
    }
    @AfterEach
    void tearDown() {
    }
    @Test
    void enviarCorreo() {
        String mensaje = "Mensaje de correo";
        String correo = "correo@gmail.com";

        boolean enviado = mailer.enviarCorreo(correo, mensaje);
        assertTrue(enviado,"El metodo debe devolver true");
    }
    @Test
    void enviarCorreoDatosNoVacíos(){
        boolean resultado = mailer.enviarCorreo("", "");
        assertTrue(resultado,"Asi también devuelve true");
    }
}