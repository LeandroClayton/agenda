package leandro.projeto.agenda.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import leandro.projeto.agenda.App;
import leandro.projeto.agenda.model.entities.Email;
import leandro.projeto.agenda.model.entities.Telefone;

public class CadastrarAgenda {

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

    @FXML
    void adicionarEmail(ActionEvent event) {

    }

    @FXML
    void adicionarTelefone(ActionEvent event) {

    }

    @FXML
    void cadastrarAgenda(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {
        App.popScreen();
    }

}
