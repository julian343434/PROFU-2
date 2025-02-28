package com.mycompany.componentescapas.Persistencia.Persistencia;

import com.mycompany.componentescapas.Persistencia.Entidades.Curso;
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
public class CursoDAO {
    private final Factory factory;

    public CursoDAO() {
        this.factory = Factory.getInstance();
    }

    // Crear curso
    public void crearCurso(Curso curso) throws SQLException {
        String sql = "INSERT INTO cursos (nombre, semestre, programa_id) VALUES (?, ?, ?)";

        // Utilizamos try-with-resources para asegurar que los recursos se cierren correctamente
        try (Connection connection = ConexionBD.getConnection(ConfiguracionDB.TIPO_DB);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, curso.getNombre());
            statement.setInt(2, curso.getSemestre());
            statement.setInt(3, curso.getProgramaId());
            statement.executeUpdate();

        } catch (SQLException e) {
            // Manejar errores específicos de la base de datos
            System.err.println("Error al crear el curso: " + e.getMessage());
            throw e;
        }
    }

    // Obtener un curso por ID
    public Curso obtenerCurso(int id) throws SQLException {
        String sql = "SELECT * FROM cursos WHERE id = ?";

        try (Connection connection = ConexionBD.getConnection(ConfiguracionDB.TIPO_DB);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    Curso curso = factory.crearCurso(
                        resultSet.getString("nombre"),
                        resultSet.getInt("semestre"),
                        resultSet.getInt("programa_id")
                    );
                    curso.setId(resultSet.getInt("id"));
                    return curso;
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener el curso: " + e.getMessage());
            throw e;
        }

        // Si no se encuentra el curso, se retorna null
        return null;
    }

    // Obtener todos los cursos
    public List<Curso> obtenerTodosLosCursos() throws SQLException {
        String sql = "SELECT * FROM cursos";

        List<Curso> cursos = new ArrayList<>();

        try (Connection connection = ConexionBD.getConnection(ConfiguracionDB.TIPO_DB);
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Curso curso = factory.crearCurso(
                    resultSet.getString("nombre"),
                    resultSet.getInt("semestre"),
                    resultSet.getInt("programa_id")
                );
                curso.setId(resultSet.getInt("id"));
                cursos.add(curso);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener todos los cursos: " + e.getMessage());
            throw e;
        }

        return cursos;
    }
}
