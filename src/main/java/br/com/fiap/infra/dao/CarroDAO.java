package br.com.fiap.infra.dao;

import br.com.fiap.domain.RepositorioCarros;
import br.com.fiap.domain.model.Carro;
import br.com.fiap.domain.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO implements RepositorioCarros {
    private Connection conexao;

    public CarroDAO() {
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

    @Override
    public void salvarCarro(Carro carro) {
        String sqlInsert = """
                INSERT INTO TB_CARRO VALUES (?, ?, ?, ?, ?, ?)
                """;

        try {
            PreparedStatement ps = conexao.prepareStatement(sqlInsert);
            ps.setLong(1, obterId());
            ps.setString(2, carro.getModeloCarro());
            ps.setInt(3, carro.getAnoCarro());
            ps.setString(4, carro.getMarcaCarro());
            ps.setString(5, carro.getPlacaCarro());
            ps.setInt(6, carro.getIdCliente());
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

    @Override
    public List<Carro> pegarCarrosDoUsuario(Long idCliente) {
        String sqlSelect = "SELECT * FROM TB_CARRO WHERE id_cliente = ?";
        List<Carro> carros = new ArrayList<>();
        try {
            PreparedStatement statement = conexao.prepareStatement(sqlSelect);
            statement.setLong(1, idCliente);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Carro carro = new Carro();
                carro.setAnoCarro(rs.getInt("ano_carro"));
                carro.setMarcaCarro(rs.getString("marca_carro"));
                carro.setModeloCarro(rs.getString("modelo_carro"));
                carro.setPlacaCarro(rs.getString("placa_carro"));
                carro.setIdCliente(Math.toIntExact(idCliente));
                carros.add(carro);
            }

            rs.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return carros;
    }

}
