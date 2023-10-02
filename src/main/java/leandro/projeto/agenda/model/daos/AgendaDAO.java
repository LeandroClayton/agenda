package leandro.projeto.agenda.model.daos;

import com.github.hugoperlin.results.Resultado;

import leandro.projeto.agenda.model.entities.Agenda;

public interface AgendaDAO {
    

    public Resultado criarAgenda(Agenda agenda);
    public Resultado listarAgenda();
    public Resultado atualizarAgenda(int id);
    public Resultado deletarAgenda(int id);
}
