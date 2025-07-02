package org.example.demo2.dao;

import org.example.demo2.model.Filme;
import org.example.demo2.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class FilmeDAOImpl implements FilmeDAO {

    private Connection conn;

    public FilmeDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Filme buscarFilmePorId(int id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM filme WHERE id_filme = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            Filme filme = new Filme();
            if (rs.next()) {

                filme.setIdFilme(rs.getInt("id_filme"));
                filme.setTitulo(rs.getString("titulo"));
                filme.setGenero(rs.getString("genero"));
                filme.setAnoLancamento(rs.getInt("ano_lancamento"));
                filme.setDiretor(rs.getString("diretor"));
                filme.setSinopse(rs.getString("sinopse"));
                filme.setPoster(rs.getString("poster"));
            }
                return filme;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection();
        }
    }

    @Override
    public List<Filme> listarTodosFilmes() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM filme");
            rs = st.executeQuery();

            List<Filme> filmes = new ArrayList<>();
            while (rs.next()) {
                Filme filme = new Filme();
                filme.setIdFilme(rs.getInt("id_filme"));
                filme.setTitulo(rs.getString("titulo"));
                filme.setGenero(rs.getString("genero"));
                filme.setAnoLancamento(rs.getInt("ano_lancamento"));
                filme.setDiretor(rs.getString("diretor"));
                filme.setSinopse(rs.getString("sinopse"));
                filme.setPoster(rs.getString("poster"));
                filmes.add(filme);
            }
            return filmes;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection();
        }

    }

    public List<Filme> buscarFilmesPorTitulo(String titulo) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM filme WHERE titulo LIKE ?");
            st.setString(1, "%" + titulo + "%");
            rs = st.executeQuery();

            List<Filme> filmes = new ArrayList<>();
            while (rs.next()) {
                Filme filme = new Filme();
                filme.setIdFilme(rs.getInt("id"));
                filme.setTitulo(rs.getString("titulo"));
                filme.setGenero(rs.getString("genero"));
                filme.setAnoLancamento(rs.getInt("ano_lancamento"));
                filme.setDiretor(rs.getString("diretor"));
                filme.setSinopse(rs.getString("sinopse"));
                filme.setPoster(rs.getString("poster"));
                filmes.add(filme);
            }
            return filmes;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection();
        }
    }

    public List<Filme> buscarFilmesPorDiretor(String diretor) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM filme WHERE diretor LIKE ?");
            st.setString(1, "%" + diretor + "%");
            rs = st.executeQuery();

            List<Filme> filmes = new ArrayList<>();
            while (rs.next()) {
                Filme filme = new Filme();
                filme.setIdFilme(rs.getInt("id"));
                filme.setTitulo(rs.getString("titulo"));
                filme.setGenero(rs.getString("genero"));
                filme.setAnoLancamento(rs.getInt("ano_lancamento"));
                filme.setDiretor(rs.getString("diretor"));
                filme.setSinopse(rs.getString("sinopse"));
                filme.setPoster(rs.getString("poster"));
                filmes.add(filme);
            }
            return filmes;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection();
        }
    }
}
