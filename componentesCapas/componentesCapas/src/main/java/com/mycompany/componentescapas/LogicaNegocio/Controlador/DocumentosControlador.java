/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.componentescapas.LogicaNegocio.Controlador;

import com.mycompany.componentescapas.LogicaNegocio.Fachada.Fachada;
import com.mycompany.componentescapas.LogicaNegocio.Fachada.IFachada;
import com.mycompany.componentescapas.Persistencia.GestorDocumentos.Documento;
import com.mycompany.componentescapas.Persistencia.SistemaClientes.Cliente;
import com.mycompany.componentescapas.Utilidades.DTO.ClienteDTO;
import com.mycompany.componentescapas.Utilidades.DTO.DocumentoDTO;
import java.util.List;

/**
 *
 * @author PYKE
 */
public class DocumentosControlador {
    private IFachada fachada;

    public DocumentosControlador() {
        this.fachada = new Fachada();
    }

    public void crearDocumento(String titulo, String contenido) {
        try {
            fachada.crearDocumento(titulo, contenido);
            System.out.println("Documento creado exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al crear el documento: " + e.getMessage());
        }
    }

    public DocumentoDTO obtenerDocumento(int id) {
        try {
            return fachada.obtenerDocumento(id);
        } catch (Exception e) {
            System.err.println("Error al obtener el documento: " + e.getMessage());
            return null;
        }
    }

    public List<DocumentoDTO> obtenerTodosLosDocumentos() {
        try {
            return fachada.obtenerTodosLosDocumentos();
        } catch (Exception e) {
            System.err.println("Error al obtener todos los documentos: " + e.getMessage());
            return null;
        }
    }

    public void crearCliente(String nombre, String email) {
        try {
            fachada.crearCliente(nombre, email);
            System.out.println("Cliente creado exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al crear el cliente: " + e.getMessage());
        }
    }
    
    public void crearCliente(ClienteDTO clienteDTO) {
        try {
            fachada.crearCliente(clienteDTO.getNombre(), clienteDTO.getEmail());
            System.out.println("Cliente creado exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al crear el cliente: " + e.getMessage());
        }
    }
    
    public void crearDocumento(DocumentoDTO documentoDTO) {
        try {
            fachada.crearDocumento(documentoDTO.getTitulo(), documentoDTO.getContenido());
            System.out.println("Documento creado exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al crear el Documento: " + e.getMessage());
        }
    }

    public ClienteDTO obtenerCliente(int id) {
        try {
            return fachada.obtenerCliente(id);
        } catch (Exception e) {
            System.err.println("Error al obtener el cliente: " + e.getMessage());
            return null;
        }
    }

    public List<ClienteDTO> obtenerTodosLosClientes() {
        try {
            return fachada.obtenerTodosLosClientes();
        } catch (Exception e) {
            System.err.println("Error al obtener todos los clientes: " + e.getMessage());
            return null;
        }
    }
    
    public boolean asignarDocumento(int clienteId, int documentoId) {
        try {
            return fachada.asignarDocumento(clienteId, documentoId);
        } catch (Exception e) {
            System.err.println("Error al obtener todos los clientes: " + e.getMessage());
            return false;
        }
    }
            
    public List<DocumentoDTO> obtenerDocumentosDelCliente(int clienteId) {
        try {
            return fachada.obtenerDocumentosDelCliente(clienteId);
        } catch (Exception e) {
            System.err.println("Error al obtener todos los clientes: " + e.getMessage());
            return null;
        }
    }
}
