package leandro.projeto.agenda.model.repositories;

import com.github.hugoperlin.results.Resultado;

import leandro.projeto.agenda.model.daos.TelefoneDAO;
import leandro.projeto.agenda.model.entities.Agenda;
import leandro.projeto.agenda.model.entities.Telefone;

public class RepositorioTelefone {
    
    private TelefoneDAO telefoneDao;

    public RepositorioTelefone(TelefoneDAO telefoneDao) {
        this.telefoneDao = telefoneDao;
    }




    public Resultado cadastrarTelefone(String telefone, Agenda agenda){
        
        if (telefone.isEmpty() || telefone.isBlank()) {
            return Resultado.erro("Emails vazios não são permitidos!!");
        } else if(telefone.length() > 11){
            return Resultado.erro("Telefone inválido!!");
        }

        
        Telefone novoTelefone = new Telefone(telefone);

        return telefoneDao.criarTelefone(novoTelefone, agenda.getId());
    }
}
