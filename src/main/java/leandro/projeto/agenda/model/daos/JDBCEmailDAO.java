package leandro.projeto.agenda.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.github.hugoperlin.results.Resultado;

import leandro.projeto.agenda.model.entities.Email;

public class JDBCEmailDAO implements EmailDAO{

    private FabricaConexoes fabrica;

    

    public JDBCEmailDAO(FabricaConexoes fabrica) {
        this.fabrica = fabrica;
    }

    @Override
    public Resultado criarEmail(Email email, int idAgenda) {
        
        try (Connection con = fabrica.getConnection()){
            PreparedStatement ptsm = con.prepareStatement("INSERT INTO BD2_email (email, idAgenda) VALUES(?,?)");

            ptsm.setString(1, email.getEmail());
            ptsm.setInt(2, idAgenda);
            int result = ptsm.executeUpdate();

            if (result == 1) {
                return Resultado.sucesso("Email cadastrado com sucesso!", email);
            }

            return Resultado.erro("Não foi possível cadastrar o email");
        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }

    }

    @Override
    public Resultado listarEmail() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarEmail'");
    }

    @Override
    public Resultado alterarEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alterarEmail'");
    }
    
}
