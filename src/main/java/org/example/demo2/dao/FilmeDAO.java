package org.example.demo2.dao;

import org.example.demo2.model.Filme;

import java.sql.SQLException;
import java.util.List;


public interface FilmeDAO {
        // void adicionarFilme(Filme filme);
        Filme buscarFilmePorId(int id);
        List<Filme> listarTodosFilmes();
        // void atualizarFilme(Filme filme);
        // void deletarFilme(int id);
        List<Filme> buscarFilmesPorTitulo(String titulo);
        List<Filme> buscarFilmesPorDiretor(String diretor);
    
}


   