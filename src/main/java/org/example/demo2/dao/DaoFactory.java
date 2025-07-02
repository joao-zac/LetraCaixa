package org.example.demo2.dao;

import org.example.demo2.util.ConnectionFactory;

public class DaoFactory {
    public static FilmeDAO createFilmeDAO() {
        return new FilmeDAOImpl(ConnectionFactory.getConnection());
    }

    public static UsuarioDAO createUsuarioDAO() {
        return new UsuarioDAOImpl(ConnectionFactory.getConnection());
    }

    public static FilmeFavoritoDao createFilmeFavoritoDAO() {
        return new FilmeFavoritoDAOImpl(ConnectionFactory.getConnection());
    }

    public static LogFilmeDAO createLogFilmeDAO() {
        return new LogFilmeDAOImp(ConnectionFactory.getConnection());
    }

}
