package org.example.demo2.main;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // UsuarioDAO usuarioDAO = DaoFactory.createUsuarioDAO();
        // Usuario usuario = new Usuario();
        // usuario.setNome("Felipe Alves");
        // usuarioDAO.adicionarUsuario(usuario);
        

        // usuarioDAO.deletarUsuario(1);
        // try {
        //     // Obtém a instância do FilmeDAO.
        //     // A conexão é estabelecida aqui 
        //     FilmeDAO filmeDAO = DaoFactory.createFilmeDAO();

        //     System.out.println("\n--- Listando todos os filmes ---");
        //     List<Filme> todosOsFilmes = filmeDAO.listarTodosFilmes();

        //     if (todosOsFilmes.isEmpty()) {
        //         System.out.println("Nenhum filme encontrado no banco de dados.");
        //     } else {
        //         for (Filme filme : todosOsFilmes) {
        //                 // System.out.println(filme);
        //                 System.out.println("------------------------------------");
        //                 System.out.println("ID: " + filme.getIdFilme());
        //                 System.out.println("Título: " + filme.getTitulo());
        //                 // System.out.println("URL Poster: " + filme.getUrl_poster());
        //                 // Se você quiser imprimir algo sobre o poster (byte[]), você precisaria converter ou indicar a presença
        //                 // System.out.println("Poster (bytes): " + (filme.getPoster() != null && filme.getPoster().length > 0 ? "Presente" : "Ausente"));
        //         }
        //         System.out.println("------------------------------------");
        //     }
        // } catch (SQLException e) {
        //     System.err.println("Erro durante a operação do banco de dados: " + e.getMessage());
        //     e.printStackTrace();
        // }

        
        // System.out.println("\n--- Testando buscarFilmePorId ---");

        // int idParaBuscar = 2; 
        // Filme filmeEncontrado = filmeDAO.buscarFilmePorId(idParaBuscar);

        // if (filmeEncontrado != null) {
        //     System.out.println("Filme encontrado pelo ID " + idParaBuscar + ": " + filmeEncontrado.getTitulo());
        // } else {
        //     System.out.println("Filme com ID " + idParaBuscar + " não encontrado.");
        // }
        
    }
}