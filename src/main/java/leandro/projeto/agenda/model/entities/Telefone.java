package leandro.projeto.agenda.model.entities;

public class Telefone {
    
    private String telefone;
    private Agenda agenda;



    
    public Telefone(String telefone, Agenda agenda) {
        this.telefone = telefone;
        this.agenda = agenda;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Agenda getAgenda() {
        return agenda;
    }
    
    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }


    
}
