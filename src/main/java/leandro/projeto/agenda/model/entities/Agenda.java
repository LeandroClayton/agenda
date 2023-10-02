package leandro.projeto.agenda.model.entities;

import java.util.ArrayList;

public class Agenda {
    

    private int id;
    private String nome;
    private ArrayList<Email> emails;
    private ArrayList<Telefone> telefones;



    public Agenda(int id, String nome, ArrayList<Email> emails, ArrayList<Telefone> telefones) {
        this.id = id;
        this.nome = nome;
        this.emails = emails;
        this.telefones = telefones;
    }
    

    
    public Agenda(String nome, ArrayList<Email> emails, ArrayList<Telefone> telefones) {
        this.nome = nome;
        this.emails = emails;
        this.telefones = telefones;
    }



    public ArrayList<Email> getEmails() {
        return emails;
    }

    public void setEmails(ArrayList<Email> emails) {
        this.emails = emails;
    }

    public ArrayList<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(ArrayList<Telefone> telefones) {
        this.telefones = telefones;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }



    
}
