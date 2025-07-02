package org.example.demo2.model;

public class Usuario {
    private int id_usuario;
    private String nome;
    private byte [] foto_perfil;

    public Usuario() {}

    public Usuario(int id_usuario, String nome, byte [] foto_perfil) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.foto_perfil = foto_perfil;
    }

    public int getIdUsuario() {
        return id_usuario;
    }

    public void setIdUsuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte[] getFotoPerfil() {
        return foto_perfil;
    }
    
    public void setFotoPerfil(byte[] foto_perfil) {
        this.foto_perfil = foto_perfil;
    }
}
