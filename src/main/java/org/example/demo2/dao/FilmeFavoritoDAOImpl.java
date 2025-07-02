package org.example.demo2.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.example.demo2.util.ConnectionFactory;


public class FilmeFavoritoDAOImpl implements FilmeFavoritoDao {
    private Connection conn;

    public FilmeFavoritoDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void adicionarFilmeFavorito(int idUsuario, int idFilme) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("INSERT INTO filme_favorito (id_usuario, id_filme) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, idUsuario);
            st.setInt(2, idFilme);
            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection();
        }
    }

    @Override
    public void removerFilmeFavorito(int idUsuario, int idFilme) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("DELETE FROM filme_favorito WHERE id_usuario = ? AND id_filme = ?");
            st.setInt(1, idUsuario);
            st.setInt(2, idFilme);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection();
        }
    }

    @Override
    public boolean isFilmeFavorito(int idUsuario, int idFilme) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM filme_favorito WHERE id_usuario = ? AND id_filme = ?");
            st.setInt(1, idUsuario);
            st.setInt(2, idFilme);
            rs = st.executeQuery();
            boolean isFavorito = rs.next();
            return isFavorito; 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection();
        }
    }

    @Override
    public List<Integer> listarFilmesFavoritos(int idUsuario) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT id_filme FROM filme_favorito WHERE id_usuario = ?");
            st.setInt(1, idUsuario);
            rs = st.executeQuery();

            List<Integer> filmesFavoritos = new ArrayList<>();
            while (rs.next()) {
                filmesFavoritos.add(rs.getInt("id_filme"));
            }
            return filmesFavoritos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection();
        }
    }
}
