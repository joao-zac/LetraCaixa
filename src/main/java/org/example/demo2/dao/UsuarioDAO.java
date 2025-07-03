package org.example.demo2.dao;

import org.example.demo2.model.Usuario;

import java.util.List;

public interface UsuarioDAO {
    void adicionarUsuario(Usuario usuario);
    Usuario buscarUsuarioPorNome(String nome);
    List<Usuario> listarTodosUsuarios();
    void atualizarUsuario(Usuario usuario);
    void deletarUsuario(int id);
}
