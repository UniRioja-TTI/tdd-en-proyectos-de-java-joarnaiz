package Mock;

import com.tt1.test.DBStub;
import com.tt1.test.IDBStub;
import com.tt1.test.IRepositorio;
import com.tt1.test.ToDo;

import java.util.List;
import java.util.Set;

public class RepositorioFake implements IRepositorio {

    public boolean encontrarLlamado = false;
    public boolean marcarCompletadoLlamado = false;
    public boolean almacenarTareaLlamado = false;
    public boolean almacenarEmailLlamado = false;

    @Override
    public ToDo encontrar(int id) {
        this.encontrarLlamado = true;
        ToDo tareaFalsa = new ToDo();
        return tareaFalsa;
    }
    @Override
    public void marcarCompletado(ToDo td) {
        this.marcarCompletadoLlamado = true;
    }

    @Override
    public List<ToDo> tareasSinCompletar() {
        ToDo tareaFalsa = new ToDo();
        tareaFalsa.setCompletado(false);
        return List.of(tareaFalsa);
    }
    @Override
    public void almacenar(ToDo td) {
        this.almacenarTareaLlamado = true;
    }
    @Override
    public void almacenar(String email) {
        this.almacenarEmailLlamado = true;
    }

    @Override
    public Set<String> listaCorreos() {
        return Set.of();
    }
}
