package leandro.projeto.agenda.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.github.hugoperlin.results.Resultado;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import leandro.projeto.agenda.App;
import leandro.projeto.agenda.model.entities.Agenda;
import leandro.projeto.agenda.model.entities.Email;
import leandro.projeto.agenda.model.entities.Telefone;
import leandro.projeto.agenda.model.repositories.RepositorioAgenda;

public class CadastrarAgenda implements Initializable {


    @FXML
    private Button btAlteracaoEmail;

    @FXML
    private Button btAlteracaoTelefone;

    @FXML
    private Button btExclusaoEmail;

    @FXML
    private Button btAddTelefone;
        
    @FXML
    private Button btAddEmail;

    @FXML
    private Button btExclusaoTelefone;

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
            tfEmail.clear();
            tfNomeAgenda.clear();
            tfTelefone.clear();
        } else{
            alerta = new Alert(AlertType.ERROR, resultado.comoErro().getMsg());
            alerta.showAndWait();
        }
    }

    @FXML
    void adicionarEmail(ActionEvent event) {
        lstEmail.setVisible(true);
        String nvEmail = tfEmail.getText();
        
        if (nvEmail.isBlank() || nvEmail.isEmpty()) {
            Alert alerta = new Alert(AlertType.ERROR, "Não são permitidos emails em branco");
            alerta.showAndWait();
            return;
        }

        Email email = new Email(nvEmail);
        lstEmail.getItems().add(email);
        tfEmail.clear();
    }

    @FXML
    void adicionarTelefone(ActionEvent event) {
        lstTelefone.setVisible(true);
        String nvTelefone = tfTelefone.getText();
        
        if (nvTelefone.isBlank() || nvTelefone.isEmpty()) {
            Alert alerta = new Alert(AlertType.ERROR, "Não são permitidos telefones em branco");
            alerta.showAndWait();
            return;
        }

        

        Telefone telefone = new Telefone(nvTelefone);
        lstTelefone.getItems().add(telefone);
        tfTelefone.clear();
    }

    @FXML
    void alterarEmail(ActionEvent event) {
        int index = lstEmail.getSelectionModel().getSelectedIndex();
        String nvEmail = tfEmail.getText();
        
        if (nvEmail.isBlank() || nvEmail.isEmpty()) {
            Alert alerta = new Alert(AlertType.CONFIRMATION);
            alerta.setTitle("Confirmação de exclusão");
            alerta.setContentText("Deseja excluir o email " + lstEmail.getItems().get(index) + "?");
            Optional<ButtonType> opcao = alerta.showAndWait();
            if (opcao.get() == ButtonType.OK) {
                lstEmail.getItems().remove(index);
                atualizarLstViewEmail(lstEmail);
                return;
            }
        }

        Email email = new Email(nvEmail);
        lstEmail.getItems().remove(index);
        lstEmail.getItems().add(index, email);
        btAlteracaoEmail.setDisable(true);
        btExclusaoEmail.setDisable(true);
        btAddEmail.setDisable(false);
        tfEmail.clear();
    }

    @FXML
    void alterarTelefone(ActionEvent event) {

    }

    @FXML
    void excluirEmail(ActionEvent event) {
        int index = lstEmail.getSelectionModel().getSelectedIndex();

        Alert alerta = new Alert(AlertType.CONFIRMATION);
        alerta.setTitle("Confirmação de exclusão");
        alerta.setContentText("Deseja excluir o email " + lstEmail.getItems().get(index) + "?");
        Optional<ButtonType> opcao = alerta.showAndWait();

        if (opcao.get() != ButtonType.OK) {
            return;
        }

        lstEmail.getItems().remove(index);
        atualizarLstViewEmail(lstEmail);

        tfEmail.clear();
        btAddEmail.setDisable(false);
        btAlteracaoEmail.setDisable(true);
        btExclusaoEmail.setDisable(true);
    }

    @FXML
    void excluirTelefone(ActionEvent event) {

    }

    @FXML
    void selecionarEmail(MouseEvent event) {
        tfEmail.setText(lstEmail.getSelectionModel().getSelectedItem().getEmail());   
        btAlteracaoEmail.setDisable(false);
        btExclusaoEmail.setDisable(false);
        btAddEmail.setDisable(true);
    }

    @FXML
    void selecionarTelefone(MouseEvent event) {
        tfTelefone.setText(lstTelefone.getSelectionModel().getSelectedItem().getTelefone());   
        btAlteracaoTelefone.setDisable(false);
        btExclusaoTelefone.setDisable(false);
        btAddTelefone.setDisable(true);
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
        } else{
            lstEmail.getItems().clear();
            lstTelefone.getItems().clear(); 
        }
    }   

    private static void atualizarLstViewEmail(ListView<Email> lstView){
        List<Email> lstItems = new ArrayList<>();
        lstItems.addAll(lstView.getItems());
        lstView.getItems().clear();
        lstView.getItems().addAll(lstItems);
    }

        private static void atualizarLstViewTelefone(ListView<Telefone> lstView){
        List<Telefone> lstItems = (List<Telefone>)lstView.getItems();
        lstItems.addAll(lstView.getItems());
        lstView.getItems().clear();
        lstView.getItems().addAll(lstItems);
    }

}
