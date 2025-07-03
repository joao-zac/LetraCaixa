package org.example.demo2.model;

import java.time.LocalDate; 
import java.math.BigDecimal; 

public class LogFilme {
    private int idLog;
    private int idFilme;
    private int idUsuario;
    private LocalDate dataAssistido; 
    private BigDecimal nota;
    private String descricao;

    public LogFilme() {
        
    }

    public LogFilme(int idLog, int idFilme, LocalDate dataAssistido, BigDecimal nota, String descricao, int idUsuario) {
        this.idLog = idLog;
        this.idFilme = idFilme;
        this.idUsuario = idUsuario;
        this.dataAssistido = dataAssistido;
        this.nota = nota;
        this.descricao = descricao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int id) {
        this.idUsuario = id;
    }

    public int getIdLog() {
        return idLog;
    }

    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }

    public int getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

    public LocalDate getDataAssistido() {
        return dataAssistido;
    }

    public void setDataAssistido(LocalDate dataAssistido) {
        this.dataAssistido = dataAssistido;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "LogFilme{" +
               "idLog=" + idLog +
               ", idFilme=" + idFilme +
               ", dataAssistido=" + dataAssistido +
               ", nota=" + nota +
               ", descricao='" + (descricao != null ? descricao.substring(0, Math.min(descricao.length(), 50)) + (descricao.length() > 50 ? "..." : "") : "N/A") + '\'' +
               '}';
    }
}