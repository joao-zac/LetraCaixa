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

    // @Override
    // public void adicionarFilme(Filme filme) {
    //     PreparedStatement st = null;
    //     ResultSet rs = null;
    //     try {
    //         st = conn.prepareStatement("insert into filme (titulo, genero, ano_lancamento, diretor, sinopse, url_poster) values (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
    //         st.setString(1, filme.getTitulo());
    //         st.setString(2, filme.getGenero());
    //         st.setInt(3, filme.getAnoLancamento());
    //         st.setString(4, filme.getDiretor());
    //         st.setString(5, filme.getSinopse());
    //         st.setString(6, filme.getUrlPoster());
    //         int linhas = st.executeUpdate();
    //         if (linhas > 0) {
    //             rs = st.getGeneratedKeys();
    //             if (rs.next()) {
    //                 filme.setidFilme(rs.getInt(1));
    //             }
    //         } else {
    //             throw new SQLException("Erro ao inserir filme, nenhuma linha afetada.");
    //         }
    //     } catch (SQLException e) {
    //         throw new RuntimeException(e);
    //     } 
    // }

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
                filme.setPoster(rs.getBytes("poster"));
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
                filme.setPoster(rs.getBytes("poster"));
                filmes.add(filme);
            }
            return filmes;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection();
        }

    }

    // @Override
    // public void deletarFilme(int id) throws SQLException {
    //     PreparedStatement st = null;
    //     try {
    //         st = conn.prepareStatement("DELETE FROM filme WHERE id = ?");
    //         st.setInt(1, id);
    //         st.executeUpdate();
    //     } catch (SQLException e) {
    //         throw new RuntimeException(e);
    //     } finally {
    //         // ConnectionFactory.closeConnection(conn, st);
    //     }
    // }

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
                filme.setPoster(rs.getBytes("poster"));
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
                filme.setPoster(rs.getBytes("poster"));
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
