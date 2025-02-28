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
public class ConexionMySQL {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/componentes_capas_mysql";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "";

    // Método para obtener una nueva conexión
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
    }
}
