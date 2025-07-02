package org.example.demo2.dao;

import java.util.List;

public interface FilmeFavoritoDao {
    void adicionarFilmeFavorito(int idUsuario, int idFilme);

    void removerFilmeFavorito(int idUsuario, int idFilme);

    boolean isFilmeFavorito(int idUsuario, int idFilme);

    List<Integer> listarFilmesFavoritos(int idUsuario);
}
