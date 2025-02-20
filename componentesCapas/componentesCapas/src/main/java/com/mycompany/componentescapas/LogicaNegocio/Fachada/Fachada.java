/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.componentescapas.LogicaNegocio.Fachada;

import com.mycompany.componentescapas.Persistencia.GestorDocumentos.GestorDocumentos;
import com.mycompany.componentescapas.Persistencia.SistemaClientes.SistemaClientes;
import com.mycompany.componentescapas.Utilidades.DTO.ClienteDTO;
import com.mycompany.componentescapas.Utilidades.DTO.DocumentoDTO;
import java.util.List;

/**
 *
 * @author PYKE
 */
public class Fachada implements IFachada {

    private GestorDocumentos gestorDocumentos;
    private SistemaClientes sistemaClientes;

    public Fachada() {
        this.gestorDocumentos = new GestorDocumentos();
        this.sistemaClientes = new SistemaClientes();
    }

    @Override
    public void crearDocumento(String titulo, String contenido) throws Exception {
        DocumentoDTO documento = new DocumentoDTO();
        documento.setTitulo(titulo);
        documento.setContenido(contenido);
        gestorDocumentos.crearDocumento(documento);
    }

    @Override
    public DocumentoDTO obtenerDocumento(int id) throws Exception {
        return gestorDocumentos.obtenerDocumento(id);
    }

    @Override
    public List<DocumentoDTO> obtenerTodosLosDocumentos() throws Exception {
        return gestorDocumentos.obtenerTodosLosDocumentos();
    }

    @Override
    public void crearCliente(String nombre, String email) throws Exception {
        ClienteDTO cliente = new ClienteDTO();
        cliente.setNombre(nombre);
        cliente.setEmail(email);
        sistemaClientes.crearCliente(cliente);
    }

    @Override
    public ClienteDTO obtenerCliente(int id) throws Exception {
        return sistemaClientes.obtenerCliente(id);
    }

    @Override
    public List<ClienteDTO> obtenerTodosLosClientes() throws Exception {
        return sistemaClientes.obtenerTodosLosClientes();
    }
    
    @Override
    public List<DocumentoDTO> obtenerDocumentosDelCliente(int clienteId) throws Exception {
        return gestorDocumentos.obtenerDocumentosDelCliente(clienteId);
    }

    @Override
    public boolean asignarDocumento(int clienteId, int documentoId) throws Exception {
        return gestorDocumentos.asignarDocumento(clienteId, documentoId);    
    }
}

