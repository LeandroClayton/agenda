package leandro.projeto.agenda.model.entities;

public class Email {
    

    private String email;
    
    public Email(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return email;
    }
    
    
    
}
