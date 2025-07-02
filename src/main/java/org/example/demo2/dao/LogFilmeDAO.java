package org.example.demo2.dao;

import java.util.List;

import org.example.demo2.model.LogFilme;

public interface LogFilmeDAO {
    void adicionarLogFilme(LogFilme logFilme);
    LogFilme buscarLogPorId(int id);
    List<LogFilme> listarTodosLogs();
    void atualizarLog(LogFilme logFilme);
    void deletarLog(int id);
}
