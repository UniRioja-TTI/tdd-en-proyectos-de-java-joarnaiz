package Mock;

import com.tt1.test.IDBStub;
import com.tt1.test.ToDo;

import java.util.List;
import java.util.Set;

public class DBStubFake implements IDBStub {
    @Override
    public void CREATE(ToDo td) {}
    @Override
    public void DELETE(ToDo td) {}
    @Override
    public void UPDATE(ToDo td) {}
    @Override
    public ToDo READ(ToDo td) {
        return td;
    }
    @Override
    public List<ToDo> READALL() {
        ToDo tareaFalsa = new ToDo();
        tareaFalsa.setNombre("Tarea de prueba");
        return List.of(tareaFalsa);
    }
    @Override
    public void CREATE(String email) {}
    @Override
    public Set<String> READALLEmail() {
        String emailFalso = "falso@falso.com";
        return Set.of(emailFalso);
    }
}
