package leandro.projeto.agenda.model.repositories;

import java.util.ArrayList;

import com.github.hugoperlin.results.Resultado;

import leandro.projeto.agenda.model.daos.AgendaDAO;
import leandro.projeto.agenda.model.entities.Agenda;
import leandro.projeto.agenda.model.entities.Email;
import leandro.projeto.agenda.model.entities.Telefone;

public class RepositorioAgenda {

    private AgendaDAO daoAgenda;
    private RepositorioEmail repositorioEmail;
    private RepositorioTelefone repositorioTelefone;





    public RepositorioAgenda(AgendaDAO daoAgenda, RepositorioEmail repositorioEmail,
            RepositorioTelefone repositorioTelefone) {
        this.daoAgenda = daoAgenda;
        this.repositorioEmail = repositorioEmail;
        this.repositorioTelefone = repositorioTelefone;
    }





    public Resultado cadastrarAgenda(String nome, ArrayList<Telefone> telefones, ArrayList<Email> emails){

        if (nome.isEmpty() || nome.isBlank()) {
            return Resultado.erro("Não é permitido nome vazio!!");
        }

        if (telefones.isEmpty()) {
            return Resultado.erro("Insira algum telefone!!");
        }
        
        if (emails.isEmpty()) {
            return Resultado.erro("Insira algum telefone!!");
        }

        Agenda agenda = new Agenda(nome, emails, telefones);

        Resultado retorno = daoAgenda.criarAgenda(agenda);

        if (retorno.foiErro()) {
            return retorno;
        }
        agenda = (Agenda)retorno.comoSucesso().getObj();

        for (Email email : emails) {
            Resultado resultado = repositorioEmail.cadastrarEmail(email.getEmail(), agenda);
            if (resultado.foiErro()) {
                return resultado;
            }
        }

        for (Telefone telefone : telefones) {
            Resultado resultado = repositorioTelefone.cadastrarTelefone(telefone.getTelefone(), agenda);
            if (resultado.foiErro()) {
                return resultado;
            }
        }

        return retorno;
    }
    
}
