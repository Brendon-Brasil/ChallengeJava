package br.com.fiap.infra.dao;

import br.com.fiap.domain.RepositorioLogin;
import br.com.fiap.domain.model.Cliente;
import br.com.fiap.domain.model.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO implements RepositorioLogin {
    private Connection conexao;

    public LoginDAO() {
        this.conexao = new ConnectionFactory().fazerConexao();
    }

    public Long obterId() {
        Long id = null;
        try {
            String sql = "SELECT tb_login_seq.NEXTVAL FROM DUAL";
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

    @Override
    public Login fazerLogin(Login login) {
        String sqlSelect = """
                SELECT * FROM TB_LOGIN WHERE login = ? AND senha = ?
                """;

        try {
            PreparedStatement ps = conexao.prepareStatement(sqlSelect);
            ps.setString(1, login.getLogin());
            ps.setString(2, login.getSenha());
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                throw new RuntimeException("Login não encontrado!");
            }

            Login loginPego = new Login(rs.getString("login"), rs.getString("senha"));
            ps.close();
            rs.close();
            return loginPego;

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
