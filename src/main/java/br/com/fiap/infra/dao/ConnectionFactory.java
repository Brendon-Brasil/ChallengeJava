package br.com.fiap.infra.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection fazerConexao() {
        try {
            return DriverManager.getConnection("jdbc:oracle:thin:@//oracle.fiap.com.br:1521/ORCL",
                    "rm559196", "fiap24");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
