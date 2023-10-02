package leandro.projeto.agenda.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.github.hugoperlin.results.Resultado;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import leandro.projeto.agenda.App;
import leandro.projeto.agenda.model.entities.Agenda;
import leandro.projeto.agenda.model.entities.Email;
import leandro.projeto.agenda.model.entities.Telefone;
import leandro.projeto.agenda.model.repositories.RepositorioAgenda;

public class CadastrarAgenda implements Initializable {

    @FXML
    private ListView<Email> lstEmail;

    @FXML
    private ListView<Telefone> lstTelefone;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfNomeAgenda;

    @FXML
    private TextField tfTelefone;

    private RepositorioAgenda repositorioAgenda;
    private Agenda agenda;

    

    

    public CadastrarAgenda(RepositorioAgenda repositorioAgenda, Agenda agenda) {
        this.repositorioAgenda = repositorioAgenda;
        this.agenda = agenda;
    }

    public CadastrarAgenda(RepositorioAgenda repositorioAgenda) {
        this.repositorioAgenda = repositorioAgenda;
    }

    @FXML
    void adicionarEmail(ActionEvent event) {

    }

    @FXML
    void adicionarTelefone(ActionEvent event) {

    }

    @FXML
    void cadastrarAgenda(ActionEvent event) {
        String nomeAgenda = tfNomeAgenda.getText();
        String stremail = tfEmail.getText();
        String strtelefone = tfTelefone.getText();
        ArrayList<Telefone> telefones = new ArrayList<>();
        ArrayList<Email> emails = new ArrayList<>();

        if (!lstTelefone.isVisible()) {
            Telefone telefone = new Telefone(strtelefone);
            telefones.add(telefone);
        } else{
            telefones.addAll(lstTelefone.getItems());
        }

        if (!lstEmail.isVisible()) {
            Email email = new Email(stremail);
            emails.add(email);
        } else{
            emails.addAll(lstEmail.getItems());
        }


        Resultado resultado = repositorioAgenda.cadastrarAgenda(nomeAgenda, telefones, emails);
        Alert alerta;

        if (resultado.foiSucesso()) {
            alerta = new Alert(AlertType.INFORMATION, resultado.comoSucesso().getMsg());
            alerta.showAndWait();
        } else{
            alerta = new Alert(AlertType.ERROR, resultado.comoErro().getMsg());
            alerta.showAndWait();
        }
    }

    @FXML
    void voltar(ActionEvent event) {
        App.popScreen();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        if(agenda != null){
            tfNomeAgenda.setText(agenda.getNome());
            lstEmail.getItems().clear();
            lstEmail.getItems().addAll(agenda.getEmails());
            lstTelefone.getItems().clear();
            lstTelefone.getItems().addAll(agenda.getTelefones());
        }
    }

}
