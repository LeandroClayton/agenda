package leandro.projeto.agenda;

import io.github.hugoperlin.navigatorfx.BaseAppNavigator;
import io.github.hugoperlin.navigatorfx.ScreenRegistryFXML;
import leandro.projeto.agenda.controllers.AlterarAgenda;
import leandro.projeto.agenda.controllers.CadastrarAgenda;
import leandro.projeto.agenda.controllers.Principal;

public class App extends BaseAppNavigator{

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
                o -> new CadastrarAgenda()));

        registraTela("ALTERAR_AGENDA", new ScreenRegistryFXML(App.class, 
            "alterar_agenda.fxml", 
                o -> new AlterarAgenda()));
    }
    
}
