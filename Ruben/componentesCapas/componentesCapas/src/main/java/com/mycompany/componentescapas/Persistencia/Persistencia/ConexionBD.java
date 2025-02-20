/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.componentescapas.Persistencia.Persistencia;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author PYKE
 */
public class ConexionBD {

    public static Connection getConnection(String tipo) throws SQLException {
        if (tipo.equalsIgnoreCase("MySQL")) {
            return (Connection) ConexionMySQL.getConnection();
        } else if (tipo.equalsIgnoreCase("PostgreSQL")) {
            return (Connection) ConexionPostgreSQL.getConnection();
        } else {
            throw new IllegalArgumentException("Tipo de base de datos no válido");
        }
    }
}
