package org.example.demo2.model;

import java.time.LocalDate;

public class FilmeFavorito {
    private int idFavorito;
    private int idUsuario;
    private int idFilme;
    private LocalDate dataAdicionado;
    private int ordemExibicao;

    public FilmeFavorito() {
    }

    public FilmeFavorito(int idFavorito, int idUsuario, int idFilme, LocalDate dataAdicionado, int ordemExibicao) {
        this.idFavorito = idFavorito;
        this.idUsuario = idUsuario;
        this.idFilme = idFilme;
        this.dataAdicionado = dataAdicionado;
        this.ordemExibicao = ordemExibicao;
    }

    public int getIdFavorito() {
        return idFavorito;
    }

    public void setIdFavorito(int idFavorito) {
        this.idFavorito = idFavorito;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

    public LocalDate getDataAdicionado() {
        return dataAdicionado;
    }

    public void setDataAdicionado(LocalDate dataAdicionado) {
        this.dataAdicionado = dataAdicionado;
    }

    public int getOrdemExibicao() {
        return ordemExibicao;
    }

    public void setOrdemExibicao(int ordemExibicao) {
        this.ordemExibicao = ordemExibicao;
    }

    @Override
    public String toString() {
        return "FilmeFavorito{" +
                "idFavorito=" + idFavorito +
                ", idUsuario=" + idUsuario +
                ", idFilme=" + idFilme +
                ", dataAdicionado=" + dataAdicionado +
                ", ordemExibicao=" + ordemExibicao +
                '}';
    }
}
