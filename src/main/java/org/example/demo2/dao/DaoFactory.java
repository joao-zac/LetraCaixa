package org.example.demo2.dao;

import org.example.demo2.util.ConnectionFactory;

public class DaoFactory {
    public static FilmeDAO createFilmeDAO() {
        return new FilmeDAOController(ConnectionFactory.getConnection());
    }

    public static UsuarioDAO createUsuarioDAO() {
        return new UsuarioDAOController(ConnectionFactory.getConnection());
    }

}
