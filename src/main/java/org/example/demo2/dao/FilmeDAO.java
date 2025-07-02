package org.example.demo2.dao;

import org.example.demo2.model.Filme;

import java.sql.SQLException;
import java.util.List;


public interface FilmeDAO {
        Filme buscarFilmePorId(int id);
        List<Filme> listarTodosFilmes();
        List<Filme> buscarFilmesPorTitulo(String titulo);
        List<Filme> buscarFilmesPorDiretor(String diretor);

}


   