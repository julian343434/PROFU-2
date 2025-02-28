/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.componentescapas.Persistencia.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PYKE
 */
public class ConexionPostgreSQL {
    private static final String URL = "jdbc:postgresql://localhost:5432/componentes_capas";
    private static final String USUARIO = "postgres";
    private static final String CONTRASEÑA = "";

    // Método para obtener una nueva conexión
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
    }
}
