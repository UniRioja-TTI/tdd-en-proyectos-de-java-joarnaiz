package com.tt1.test;

import java.util.List;
import java.util.Set;

public interface IDBStub {
    public void CREATE(ToDo td);
    public void DELETE(ToDo td);
    public void UPDATE(ToDo td);
    public ToDo READ(ToDo td);
    public List<ToDo> READALL();
    public void CREATE(String email);
    public Set<String> READALLEmail();
}
