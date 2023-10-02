package leandro.projeto.agenda.model.repositories;

import com.github.hugoperlin.results.Resultado;

import leandro.projeto.agenda.model.daos.EmailDAO;
import leandro.projeto.agenda.model.entities.Agenda;
import leandro.projeto.agenda.model.entities.Email;

public class RepositorioEmail {
    
    private EmailDAO daoEmail;



    public RepositorioEmail(EmailDAO emailDAO) {
        this.daoEmail = emailDAO;
    }



    public Resultado cadastrarEmail(String email, Agenda agenda){

        if (email.isEmpty() || email.isBlank()) {
            return Resultado.erro("Emails vazios não são permitidos!!");
        }

        Email novoEmail = new Email(email);

        return daoEmail.criarEmail(novoEmail, agenda.getId());


    }
}
