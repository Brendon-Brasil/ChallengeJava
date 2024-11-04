package br.com.fiap.infra.dao;

import br.com.fiap.domain.RepositorioClientes;
import br.com.fiap.domain.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO implements RepositorioClientes {
    private Connection conexao;

    public ClienteDAO() {
        this.conexao = new ConnectionFactory().fazerConexao();
    }

    public Long obterId() {
        Long id = null;
        try {
            String sql = "SELECT tb_cliente_seq.NEXTVAL FROM DUAL";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                id = rs.getLong(1);
            }
            rs.close();
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    public void salvarCliente(Cliente cliente) {
        String sqlInsert = """
                INSERT INTO TB_CLIENTE VALUES (?, ?, ?, ?)
                """;

        try {
            PreparedStatement ps = conexao.prepareStatement(sqlInsert);
            ps.setLong(1, obterId());
            ps.setString(2, cliente.getNomeCliente());
            ps.setString(3, cliente.getEmailCliente());
            ps.setString(4, cliente.getEmailCliente());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void fecharConexao(){
        try {
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
