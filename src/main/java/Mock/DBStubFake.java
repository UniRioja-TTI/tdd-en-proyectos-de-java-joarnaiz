package Mock;

import com.tt1.test.IDBStub;
import com.tt1.test.ToDo;

import java.util.List;
import java.util.Set;

public class DBStubFake implements IDBStub {

    public boolean createTarea = false;
    public boolean createEmail= false;
    public boolean update = false;
    public boolean delete = false;
    public boolean read= false;
    @Override
    public void CREATE(ToDo td) {
        this.createTarea = true;
    }
    @Override
    public void DELETE(ToDo td) {
    this.delete = true;
    }
    @Override
    public void UPDATE(ToDo td) {
        this.update = true;
    }
    @Override
    public ToDo READ(ToDo td) {
        this.read = true;
        return td;
    }
    @Override
    public List<ToDo> READALL() {
        this.read = true;
        ToDo tareaFalsa = new ToDo();
        tareaFalsa.setNombre("Tarea de prueba");
        return List.of(tareaFalsa);
    }
    @Override
    public void CREATE(String email) {
        this.createEmail = true;
    }
    @Override
    public Set<String> READALLEmail() {
        String emailFalso = "falso@falso.com";
        return Set.of(emailFalso);
    }
}
