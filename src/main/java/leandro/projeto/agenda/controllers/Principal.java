package leandro.projeto.agenda.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import leandro.projeto.agenda.App;

public class Principal {

    @FXML
    void alterarAgenda(ActionEvent event) {
        App.pushScreen("ALTERAR_AGENDA");
    }

    @FXML
    void cadastrarAgenda(ActionEvent event) {
        App.pushScreen("CADASTRAR_AGENDA");
    }

}
