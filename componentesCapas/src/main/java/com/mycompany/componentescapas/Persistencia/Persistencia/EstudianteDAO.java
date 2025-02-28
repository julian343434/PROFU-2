package com.mycompany.componentescapas.Persistencia.Persistencia;

import com.mycompany.componentescapas.Persistencia.Entidades.Estudiante;
import com.mycompany.componentescapas.Utilidades.FabricaObjetos.Factory;
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
public class EstudianteDAO {
    private final Factory factory;

    public EstudianteDAO() {
        this.factory = Factory.getInstance();
    }

    // Crear estudiante
    public void crearEstudiante(Estudiante estudiante) throws SQLException {
        String sql = "INSERT INTO estudiantes (nombres, apellidos) VALUES (?, ?)";

        try (Connection connection = ConexionBD.getConnection(ConfiguracionDB.TIPO_DB);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, estudiante.getNombres());
            statement.setString(2, estudiante.getApellidos());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al crear estudiante: " + e.getMessage());
            throw e;
        }
    }

    // Obtener estudiante por ID
    public Estudiante obtenerEstudiante(int id) throws SQLException {
        String sql = "SELECT * FROM estudiantes WHERE id = ?";

        try (Connection connection = ConexionBD.getConnection(ConfiguracionDB.TIPO_DB);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Estudiante estudiante = factory.crearEstudiante(
                        resultSet.getString("nombres"),
                        resultSet.getString("apellidos")
                    );
                    estudiante.setId(resultSet.getInt("id"));
                    return estudiante;
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener estudiante: " + e.getMessage());
            throw e;
        }

        return null;
    }

    // Obtener todos los estudiantes
    public List<Estudiante> obtenerTodosLosEstudiantes() throws SQLException {
        String sql = "SELECT * FROM estudiantes";
        List<Estudiante> estudiantes = new ArrayList<>();

        try (Connection connection = ConexionBD.getConnection(ConfiguracionDB.TIPO_DB);
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Estudiante estudiante = factory.crearEstudiante(
                    resultSet.getString("nombres"),
                    resultSet.getString("apellidos")
                );
                estudiante.setId(resultSet.getInt("id"));
                estudiantes.add(estudiante);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener todos los estudiantes: " + e.getMessage());
            throw e;
        }

        return estudiantes;
    }
}
