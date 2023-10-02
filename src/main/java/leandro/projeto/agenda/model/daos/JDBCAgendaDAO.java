package leandro.projeto.agenda.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.github.hugoperlin.results.Resultado;

import leandro.projeto.agenda.model.entities.Agenda;

public class JDBCAgendaDAO implements AgendaDAO {

    private FabricaConexoes fabrica;
    


    public JDBCAgendaDAO(FabricaConexoes fabrica) {
        this.fabrica = fabrica;
    }

    @Override
    public Resultado criarAgenda(Agenda agenda) {
        
        try(Connection con = fabrica.getConnection()) {
            PreparedStatement pStatement = con.prepareStatement("INSERT INTO BD2_agenda(nome) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            pStatement.setString(1, agenda.getNome());
            int rs = pStatement.executeUpdate();

            if (rs == 1) {

                ResultSet resultado = pStatement.getGeneratedKeys();
                agenda.setId(resultado.getInt(1));



                return Resultado.sucesso("Agenda cadastrada com sucesso!!", agenda);
                
            }

            return Resultado.erro("Houve algum erro no cadastro da agenda!!");
            
        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
        
    }

    @Override
    public Resultado listarAgenda() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarAgenda'");
    }

    @Override
    public Resultado atualizarAgenda(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizarAgenda'");
    }

    @Override
    public Resultado deletarAgenda(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletarAgenda'");
    }

}
