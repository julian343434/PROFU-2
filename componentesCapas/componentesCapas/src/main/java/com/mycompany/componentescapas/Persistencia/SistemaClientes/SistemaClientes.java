/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.componentescapas.Persistencia.SistemaClientes;

import com.mycompany.componentescapas.Persistencia.Persistencia.ConexionMySQL;
import com.mycompany.componentescapas.Utilidades.DTO.ClienteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PYKE
 */
public class SistemaClientes {

    public void crearCliente(ClienteDTO cliente) throws SQLException {
        String sql = "INSERT INTO clientes (nombre, email) VALUES (?, ?)";

        try (Connection connection = ConexionMySQL.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
             
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getEmail());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al crear el cliente: " + e.getMessage());
            throw e;
        }
    }

    public ClienteDTO obtenerCliente(int id) throws SQLException {
        String sql = "SELECT * FROM clientes WHERE id = ?";
        ClienteDTO cliente = null;

        try (Connection connection = ConexionMySQL.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
             
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    cliente = new ClienteDTO();
                    cliente.setId(resultSet.getInt("id"));
                    cliente.setNombre(resultSet.getString("nombre"));
                    cliente.setEmail(resultSet.getString("email"));
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener el cliente: " + e.getMessage());
            throw e;
        }

        return cliente;
    }

    public List<ClienteDTO> obtenerTodosLosClientes() throws SQLException {
        String sql = "SELECT * FROM clientes";
        List<ClienteDTO> clientes = new ArrayList<>();

        try (Connection connection = ConexionMySQL.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
             
            while (resultSet.next()) {
                ClienteDTO cliente = new ClienteDTO();
                cliente.setId(resultSet.getInt("id"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setEmail(resultSet.getString("email"));
                clientes.add(cliente);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener todos los clientes: " + e.getMessage());
            throw e;
        }

        return clientes;
    }
}
