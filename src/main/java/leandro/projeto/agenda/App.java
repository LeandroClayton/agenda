package leandro.projeto.agenda;

import io.github.hugoperlin.navigatorfx.BaseAppNavigator;
import io.github.hugoperlin.navigatorfx.ScreenRegistryFXML;
import leandro.projeto.agenda.controllers.AlterarAgenda;
import leandro.projeto.agenda.controllers.CadastrarAgenda;
import leandro.projeto.agenda.controllers.Principal;
import leandro.projeto.agenda.model.daos.AgendaDAO;
import leandro.projeto.agenda.model.daos.EmailDAO;
import leandro.projeto.agenda.model.daos.FabricaConexoes;
import leandro.projeto.agenda.model.daos.JDBCAgendaDAO;
import leandro.projeto.agenda.model.daos.JDBCEmailDAO;
import leandro.projeto.agenda.model.daos.JDBCTelefoneDAO;
import leandro.projeto.agenda.model.daos.TelefoneDAO;
import leandro.projeto.agenda.model.repositories.RepositorioAgenda;
import leandro.projeto.agenda.model.repositories.RepositorioEmail;
import leandro.projeto.agenda.model.repositories.RepositorioTelefone;

public class App extends BaseAppNavigator{

   
    private EmailDAO emailDAO = new JDBCEmailDAO(FabricaConexoes.getInstance());
    private RepositorioEmail repositorioEmail = new RepositorioEmail(emailDAO);

    private TelefoneDAO telefoneDao = new JDBCTelefoneDAO(FabricaConexoes.getInstance());
    private RepositorioTelefone repositorioTelefone = new RepositorioTelefone(telefoneDao);

    private AgendaDAO agendaDAO = new JDBCAgendaDAO(FabricaConexoes.getInstance());
    private RepositorioAgenda repositorioAgenda = new RepositorioAgenda(agendaDAO, repositorioEmail, repositorioTelefone);


    @Override
    public String getAppTitle() {
        return "Agenda";
    }

    @Override
    public String getHome() {
        return "PRINCIPAL";
    }

    @Override
    public void registrarTelas() {
        registraTela("PRINCIPAL", new ScreenRegistryFXML(App.class, 
            "principal.fxml",
                o -> new Principal()));

        registraTela("CADASTRAR_AGENDA", new ScreenRegistryFXML(App.class, 
            "cadastrar_agenda.fxml", 
                o -> new CadastrarAgenda(repositorioAgenda)));

        registraTela("ALTERAR_AGENDA", new ScreenRegistryFXML(App.class, 
            "alterar_agenda.fxml", 
                o -> new AlterarAgenda()));
    }
    
}
