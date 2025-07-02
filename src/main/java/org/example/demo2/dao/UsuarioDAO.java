package org.example.demo2.dao;

import org.example.demo2.model.Usuario;

public interface UsuarioDAO {
    void adicionarUsuario(Usuario usuario);
    Usuario buscarUsuarioPorNome(String nome);
    void atualizarUsuario(Usuario usuario);
    void deletarUsuario(int id);
}
