package leandro.projeto.agenda.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.github.hugoperlin.results.Resultado;

import leandro.projeto.agenda.model.entities.Telefone;

public class JDBCTelefoneDAO implements TelefoneDAO{

    private FabricaConexoes fabrica;

    

    public JDBCTelefoneDAO(FabricaConexoes fabrica) {
        this.fabrica = fabrica;
    }

    @Override
    public Resultado criarTelefone(Telefone telefone, int idAgenda) {
        
        try (Connection con = fabrica.getConnection()){
            PreparedStatement ptsm = con.prepareStatement("INSERT INTO BD2_telefone (numero, idAgenda) VALUES(?,?)");

            ptsm.setString(1, telefone.getTelefone());
            ptsm.setInt(2, idAgenda);
            int result = ptsm.executeUpdate();

            if (result == 1) {
                return Resultado.sucesso("Telefone cadastrados!", telefone);
            }

            return Resultado.erro("Não foi possível cadastrar o telefone");
        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
    }

    @Override
    public Resultado listarTelefone() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTelefone'");
    }

    @Override
    public Resultado alterarTelefone(String telefone) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alterarTelefone'");
    }
    
}
