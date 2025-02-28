/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.componentescapas.LogicaNegocio.Fachada;
import com.mycompany.componentescapas.Utilidades.DTO.ClienteDTO;
import com.mycompany.componentescapas.Utilidades.DTO.DocumentoDTO;
import java.util.List;


/**
 *
 * @author PYKE
 */
public interface IFachada {
    // Métodos para la gestión de documentos
    void crearDocumento(String titulo, String contenido) throws Exception;
    DocumentoDTO obtenerDocumento(int id) throws Exception;
    List<DocumentoDTO> obtenerTodosLosDocumentos() throws Exception;
    boolean asignarDocumento(int clienteId, int documentoId) throws Exception;
    List<DocumentoDTO> obtenerDocumentosDelCliente(int clienteId) throws Exception;

    // Métodos para la gestión de clientes
    void crearCliente(String nombre, String email) throws Exception;
    ClienteDTO obtenerCliente(int id) throws Exception;
    List<ClienteDTO> obtenerTodosLosClientes() throws Exception;
}
