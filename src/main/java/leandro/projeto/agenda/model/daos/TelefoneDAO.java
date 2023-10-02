package leandro.projeto.agenda.model.daos;

import com.github.hugoperlin.results.Resultado;

import leandro.projeto.agenda.model.entities.Telefone;

public interface TelefoneDAO {
    
    public Resultado criarTelefone(Telefone telefone, int idAgenda);
    public Resultado listarTelefone();
    public Resultado alterarTelefone(String telefone);
}
