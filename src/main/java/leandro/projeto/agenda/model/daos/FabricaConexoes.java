package leandro.projeto.agenda.model.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import leandro.projeto.agenda.utils.Env;

public class FabricaConexoes {
    

    private final String URL_DB;
    private final String DB_NAME;
    private final String DB_PASSWORD;
    private final String DB_USER;
    private final String CON_STRING;

    private Connection connection;

    private static FabricaConexoes instance;

    private FabricaConexoes(){

        // carregar dados de conexão do .env
        URL_DB = Env.get("URL_DB");
        DB_NAME = Env.get("DB_NAME");
        CON_STRING = URL_DB+"/"+DB_NAME;
        DB_USER = Env.get("DB_USER");
        DB_PASSWORD = Env.get("DB_PASSWORD");
    }

        public static FabricaConexoes getInstance() {
        if (instance != null) {
            return instance;
        }
        instance = new FabricaConexoes();
        return instance;
    }

    public Connection getConnection() throws SQLException {

            if (instance.connection == null || instance.connection.isClosed()) {
                instance.connection = DriverManager.getConnection(CON_STRING, DB_USER, DB_PASSWORD);
                return instance.connection;
            }

        throw new SQLException("Máximo de conexões");
    }
}
