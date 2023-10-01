package leandro.projeto.agenda.model.entities;

public class Email {
    

    private String email;
    private Agenda agenda;



    
    public Email(String email, Agenda agenda) {
        this.email = email;
        this.agenda = agenda;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Agenda getAgenda() {
        return agenda;
    }
    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    
}
