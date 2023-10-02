package leandro.projeto.agenda.model.entities;

public class Telefone {
    
    private String telefone;



    
    public Telefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return telefone;
    }


    
}
