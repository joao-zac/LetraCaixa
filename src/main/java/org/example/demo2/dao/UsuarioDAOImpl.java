package org.example.demo2.dao;

import org.example.demo2.model.Usuario;
import org.example.demo2.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {

    private Connection conn;

    public UsuarioDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void adicionarUsuario(Usuario usuario) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("INSERT INTO usuario (nome, foto) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, usuario.getNome());
            st.setBytes(2, usuario.getFotoPerfil());
            int linhas = st.executeUpdate();
            if (linhas > 0) {
                rs = st.getGeneratedKeys();
                if (rs.next()) {
                    usuario.setIdUsuario(rs.getInt(1));
                }
            } else {
                throw new SQLException("Erro ao inserir usuário, nenhuma linha afetada.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeStatement(st);
            ConnectionFactory.closeResultSet(rs);
        }
    
    }

    @Override
    public Usuario buscarUsuarioPorNome(String nome) {
        PreparedStatement st = null;
        ResultSet rs = null;
        Usuario usuario = new Usuario();

        try {
            st = conn.prepareStatement("SELECT * FROM usuario WHERE nome = ?");
            st.setString(1, nome);
            rs = st.executeQuery();

            if (rs.next()) {
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setFotoPerfil(rs.getBytes("foto"));
            } else {
                throw new SQLException("Usuário não encontrado.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeStatement(st);
            ConnectionFactory.closeResultSet(rs);
        }

        return usuario;
    }

    @Override
    public void atualizarUsuario(Usuario usuario) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("UPDATE usuario SET nome = ?, foto = ? WHERE id_usuario = ?");
            st.setString(1, usuario.getNome());
            st.setBytes(2, usuario.getFotoPerfil());
            st.setInt(3, usuario.getIdUsuario());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeStatement(st);
        }
    }

    @Override
    public void deletarUsuario(int id) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("DELETE FROM usuario WHERE id_usuario = ?");
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeStatement(st);
        }
    }

    @Override
    public List<Usuario> listarTodosUsuarios(){
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement("select * from usuario");
            rs = st.executeQuery();

            List<Usuario> usuarios = new ArrayList<>();
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setFotoPerfil(rs.getBytes("foto"));
                usuarios.add(usuario);
            }
            return usuarios;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeStatement(st);
            ConnectionFactory.closeResultSet(rs);
        }
    }

}
