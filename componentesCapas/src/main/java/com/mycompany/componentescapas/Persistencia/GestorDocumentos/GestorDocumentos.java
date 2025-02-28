/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.componentescapas.Persistencia.GestorDocumentos;

import com.mycompany.componentescapas.Persistencia.Persistencia.ConexionMySQL;
import com.mycompany.componentescapas.Utilidades.DTO.DocumentoDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PYKE
 */
public class GestorDocumentos {

    public void crearDocumento(DocumentoDTO documento) throws SQLException {
        String sql = "INSERT INTO documentos (titulo, contenido) VALUES (?, ?)";

        try (Connection connection = ConexionMySQL.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
             
            statement.setString(1, documento.getTitulo());
            statement.setString(2, documento.getContenido());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al crear el documento: " + e.getMessage());
            throw e;
        }
    }

    public DocumentoDTO obtenerDocumento(int id) throws SQLException {
        String sql = "SELECT * FROM documentos WHERE id = ?";
        DocumentoDTO documento = null;

        try (Connection connection = ConexionMySQL.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
             
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    documento = new DocumentoDTO();
                    documento.setId(resultSet.getInt("id"));
                    documento.setTitulo(resultSet.getString("titulo"));
                    documento.setContenido(resultSet.getString("contenido"));
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener el documento: " + e.getMessage());
            throw e;
        }

        return documento;
    }

    public List<DocumentoDTO> obtenerTodosLosDocumentos() throws SQLException {
        String sql = "SELECT * FROM documentos";
        List<DocumentoDTO> documentos = new ArrayList<>();

        try (Connection connection = ConexionMySQL.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
             
            while (resultSet.next()) {
                DocumentoDTO documento = new DocumentoDTO();
                documento.setId(resultSet.getInt("id"));
                documento.setTitulo(resultSet.getString("titulo"));
                documento.setContenido(resultSet.getString("contenido"));
                documentos.add(documento);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener todos los documentos: " + e.getMessage());
            throw e;
        }

        return documentos;
    }
    
    public boolean asignarDocumento(int clienteId, int documentoId) {
        System.out.println("ClienteId: " + clienteId + " - DocumentoId: " + documentoId);
        String sql = "INSERT INTO cliente_documento (cliente_id, documento_id) VALUES (?, ?)";

        try (Connection connection = ConexionMySQL.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Establecer los parámetros para la sentencia SQL
            statement.setInt(1, clienteId);
            statement.setInt(2, documentoId);

            // Ejecutar la actualización
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error al asignar documento: " + e.getMessage());
            return false;
        }
    }

    
    public List<DocumentoDTO> obtenerDocumentosDelCliente(int clienteId) {
        List<DocumentoDTO> documentos = new ArrayList<>();
        String sql = "SELECT documento_id FROM cliente_documento WHERE cliente_id = ?";

        try (Connection connection = ConexionMySQL.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {

            statement.setInt(1, clienteId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    documentos.add(obtenerDocumento(resultSet.getInt("documento_id")));
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener documentos del cliente: " + e.getMessage());
        }

        return documentos;
    }
}
