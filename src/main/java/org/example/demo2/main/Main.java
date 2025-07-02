//package org.example.demo2.main;
//
//import org.example.demo2.dao.DaoFactory;
//import org.example.demo2.dao.FilmeDAO;
//import org.example.demo2.model.Filme;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//public class Main {
//
//    public static void main(String[] args) throws IOException {
//
////         UsuarioDAO usuarioDAO = DaoFactory.createUsuarioDAO();
////         Usuario usuario = new Usuario();
////         usuario.setNome("Felipe Alves");
////         usuarioDAO.adicionarUsuario(usuario);
////
//
////         usuarioDAO.deletarUsuario(1);
//        // Obtém a instância do FilmeDAO.
//        // A conexão é estabelecida aqui
//        FilmeDAO filmeDAO = DaoFactory.createFilmeDAO();
////
////        System.out.println("\n--- Listando todos os filmes ---");
////        List<Filme> todosOsFilmes = filmeDAO.listarTodosFilmes();
////
////        if (todosOsFilmes.isEmpty()) {
////            System.out.println("Nenhum filme encontrado no banco de dados.");
////        } else {
////            for (Filme filme : todosOsFilmes) {
////                    // System.out.println(filme);
////                    System.out.println("------------------------------------");
////                    System.out.println("ID: " + filme.getIdFilme());
////                    System.out.println("Título: " + filme.getTitulo());
////                    // System.out.println("URL Poster: " + filme.getUrl_poster());
////                    // Se você quiser imprimir algo sobre o poster (byte[]), você precisaria converter ou indicar a presença
////                    // System.out.println("Poster (bytes): " + (filme.getPoster() != null && filme.getPoster().length > 0 ? "Presente" : "Ausente"));
////            }
////            System.out.println("------------------------------------");
////        }
//        String caminho = "C:Users/HOME/IdeaProjects/demo2/src/main/resources/assets/posters/poderosochefao.jpeg";
//
//        System.out.println("\n--- Testando buscarFilmePorId ---");
//
//         int idParaBuscar = 1;
//         Filme filmeEncontrado = filmeDAO.buscarFilmePorId(idParaBuscar);
//
//         if (filmeEncontrado != null) {
//             System.out.println("Filme encontrado pelo ID " + idParaBuscar + ": " + filmeEncontrado.getTitulo());
//         } else {
//             System.out.println("Filme com ID " + idParaBuscar + " não encontrado.");
//         }
//
//    }
//}