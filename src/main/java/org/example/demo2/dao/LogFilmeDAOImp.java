package org.example.demo2.dao;

import org.example.demo2.model.LogFilme;
import org.example.demo2.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LogFilmeDAOImp implements LogFilmeDAO {

    private Connection conn;

    public LogFilmeDAOImp(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void adicionarLogFilme(LogFilme logFilme) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("INSERT INTO log_filme (id_filme, data_assistido, nota, review, id_log, id_usuario) VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, logFilme.getIdFilme());
            st.setDate(2, Date.valueOf(logFilme.getDataAssistido()));
            st.setBigDecimal(3, logFilme.getNota());
            st.setString(4, logFilme.getDescricao());
            st.setInt(5, logFilme.getIdLog());
            st.setInt(6, logFilme.getIdUsuario());
            int linhas = st.executeUpdate();
            if (linhas > 0) {
                rs = st.getGeneratedKeys();
                if (rs.next()) {
                    logFilme.setIdLog(rs.getInt(1));
                }
            } else {
                throw new SQLException("Erro ao inserir log de filme, nenhuma linha afetada.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeStatement(st);
            ConnectionFactory.closeResultSet(rs);
        }
    }

    @Override
    public LogFilme buscarLogPorId(int id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM log_filme WHERE id_log = ?");
            st.setInt(1, id);
            
            rs = st.executeQuery();
            LogFilme logFilme = new LogFilme();
            if (rs.next()) {
                logFilme.setIdLog(rs.getInt("id_log"));
                logFilme.setIdFilme(rs.getInt("id_filme"));
                logFilme.setIdUsuario(rs.getInt("id_usuario"));
                logFilme.setDataAssistido(rs.getDate("data_assistido").toLocalDate());
                logFilme.setNota(rs.getBigDecimal("nota"));
                logFilme.setDescricao(rs.getString("review"));
            } 
            return logFilme;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeStatement(st);
            ConnectionFactory.closeResultSet(rs);
        }
    }

    @Override
    public List<LogFilme> listarTodosLogs() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM log_filme");
            rs = st.executeQuery();

            List<LogFilme> logs = new ArrayList<>();
            while (rs.next()) {
                LogFilme logFilme = new LogFilme();
                logFilme.setIdLog(rs.getInt("id_log"));
                logFilme.setIdFilme(rs.getInt("id_filme"));
                logFilme.setIdUsuario(rs.getInt("id_usuario"));
                logFilme.setDataAssistido(rs.getDate("data_assistido").toLocalDate());
                logFilme.setNota(rs.getBigDecimal("nota"));
                logFilme.setDescricao(rs.getString("review"));
                logs.add(logFilme);
            }
            return logs;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeStatement(st);
            ConnectionFactory.closeResultSet(rs);
        }
    }

    @Override
    public void atualizarLog(LogFilme logFilme) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("UPDATE log_filme SET data_assistido = ?, nota = ?, review = ? WHERE id_log = ?");
            st.setDate(1, Date.valueOf(logFilme.getDataAssistido()));
            st.setBigDecimal(2, logFilme.getNota());
            st.setString(3, logFilme.getDescricao());
            st.setInt(4, logFilme.getIdLog());
            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeStatement(st);
        }
    }

    @Override
    public void deletarLog(int id) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("DELETE FROM log_filme WHERE id_log = ?");
            st.setInt(1, id);
            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeStatement(st);
        }
    }

}
