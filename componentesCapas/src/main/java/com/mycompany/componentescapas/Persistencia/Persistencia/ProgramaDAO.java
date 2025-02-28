package com.mycompany.componentescapas.Persistencia.Persistencia;

import com.mycompany.componentescapas.Persistencia.Entidades.Curso;
import com.mycompany.componentescapas.Persistencia.Entidades.Programa;
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
public class ProgramaDAO {
    private final Factory factory;

    public ProgramaDAO() {
        this.factory = Factory.getInstance();
    }

    // Crear programa
    public void crearPrograma(Programa programa) throws SQLException {
        String sql = "INSERT INTO programas (nombre) VALUES (?)";

        try (Connection connection = ConexionBD.getConnection(ConfiguracionDB.TIPO_DB);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, programa.getNombre());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al crear programa: " + e.getMessage());
            throw e;
        }
    }

    // Obtener programa por ID
    public Programa obtenerPrograma(int id) throws SQLException {
        String sql = "SELECT * FROM programas WHERE id = ?";

        try (Connection connection = ConexionBD.getConnection(ConfiguracionDB.TIPO_DB);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Programa programa = factory.crearPrograma(resultSet.getString("nombre"));
                    programa.setId(resultSet.getInt("id"));
                    return programa;
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener programa: " + e.getMessage());
            throw e;
        }

        return null;
    }

    // Obtener todos los programas
    public List<Programa> obtenerTodosLosProgramas() throws SQLException {
        String sql = "SELECT * FROM programas";
        List<Programa> programas = new ArrayList<>();

        try (Connection connection = ConexionBD.getConnection(ConfiguracionDB.TIPO_DB);
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Programa programa = factory.crearPrograma(resultSet.getString("nombre"));
                programa.setId(resultSet.getInt("id"));
                programas.add(programa);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener todos los programas: " + e.getMessage());
            throw e;
        }

        return programas;
    }

    // Obtener cursos del programa
    public List<Curso> obtenerCursosDelPrograma(int programaId) throws SQLException {
        String sql = "SELECT * FROM cursos WHERE programa_id = ?";
        List<Curso> cursos = new ArrayList<>();

        try (Connection connection = ConexionBD.getConnection(ConfiguracionDB.TIPO_DB);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, programaId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Curso curso = factory.crearCurso(
                        resultSet.getString("nombre"),
                        resultSet.getInt("semestre"),
                        resultSet.getInt("programa_id")
                    );
                    curso.setId(resultSet.getInt("id"));
                    cursos.add(curso);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener cursos del programa: " + e.getMessage());
            throw e;
        }

        return cursos;
    }
}
