package com.tt1.test;

public class MailerStub implements IEmail {

    public MailerStub(){}
    public boolean enviarCorreo(String d, String m){
        return true;
    }
}
