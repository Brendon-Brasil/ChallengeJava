package br.com.fiap.domain;

import br.com.fiap.domain.model.Login;

public interface RepositorioLogin {
    Login fazerLogin(Login login);
    void fecharConexao();
}
