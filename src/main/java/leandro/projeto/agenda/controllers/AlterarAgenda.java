package leandro.projeto.agenda.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import leandro.projeto.agenda.App;

public class AlterarAgenda {

    @FXML
    private ListView<?> lstAgendas;

    @FXML
    private TextArea taDescricao;

    @FXML
    void alterarAgenda(ActionEvent event) {

    }

    @FXML
    void descreverAgenda(MouseEvent event) {

    }

    @FXML
    void excluirAgenda(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {
        App.popScreen();
    }

}
