package org.example.demo2.model;

public class Filme {
    private int id_filme;
    private String titulo;
    private int ano_lancamento;
    private String diretor;
    private String genero;
    private String sinopse;
    private byte[] poster;

    public Filme() {}

    public Filme(int id_filme, String titulo, int ano_lancamento, String diretor, String genero, String sinopse, byte[] poster) {
        this.id_filme = id_filme;
        this.titulo = titulo;
        this.ano_lancamento = ano_lancamento;
        this.diretor = diretor;
        this.genero = genero;
        this.sinopse = sinopse;
        this.poster = poster;
    }

    public int getIdFilme() {
        return id_filme;
    }

    public void setIdFilme(int id_filme) {
        this.id_filme = id_filme;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoLancamento() {
        return ano_lancamento;
    }

    public void setAnoLancamento(int ano_lancamento) {
        this.ano_lancamento = ano_lancamento;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
            this.sinopse = sinopse;
        }

    public byte[] getPoster() {
        return poster;
    }

    public void setPoster(byte [] poster) {
        this.poster = poster;
    }

    @Override
    public String toString() {
        return "Filme{" +
               "id_filme=" + id_filme +
               ", titulo='" + titulo + '\'' +
               ", ano_lancamento=" + ano_lancamento +
               ", diretor='" + diretor + '\'' +
               ", genero='" + genero + '\'' +
               ", sinopse='" + sinopse + '\'' +
               ", poster='" + poster + '\'' +
               '}';
    }
}
