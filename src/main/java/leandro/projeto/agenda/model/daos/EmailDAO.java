package leandro.projeto.agenda.model.daos;

import com.github.hugoperlin.results.Resultado;

import leandro.projeto.agenda.model.entities.Email;

public interface EmailDAO {
    

    public Resultado criarEmail(Email email, int idAgenda);
    public Resultado listarEmail();
    public Resultado alterarEmail(String email);

}
