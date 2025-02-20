package com.mycompany.componentescapas.Persistencia.Persistencia;

import com.mycompany.componentescapas.Persistencia.Entidades.EstudianteCurso;
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
public class EstudianteCursoDAO {
    private final Factory factory;

    public EstudianteCursoDAO() {
        this.factory = Factory.getInstance();
    }

    // Crear EstudianteCurso
    public void crearEstudianteCurso(EstudianteCurso estudianteCurso) throws SQLException {
        String sql = "INSERT INTO estudiante_curso (estudiante_id, curso_id) VALUES (?, ?)";

        try (Connection connection = ConexionBD.getConnection(ConfiguracionDB.TIPO_DB);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, estudianteCurso.getEstudianteId());
            statement.setInt(2, estudianteCurso.getCursoId());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al crear EstudianteCurso: " + e.getMessage());
            throw e;
        }
    }

    // Obtener un EstudianteCurso por ID
    public EstudianteCurso obtenerEstudianteCurso(int id) throws SQLException {
        String sql = "SELECT * FROM estudiante_curso WHERE id = ?";

        try (Connection connection = ConexionBD.getConnection(ConfiguracionDB.TIPO_DB);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    EstudianteCurso estudianteCurso = factory.crearEstudianteCurso(
                        resultSet.getInt("estudiante_id"),
                        resultSet.getInt("curso_id")
                    );
                    estudianteCurso.setId(resultSet.getInt("id"));
                    return estudianteCurso;
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener EstudianteCurso: " + e.getMessage());
            throw e;
        }

        return null;
    }

    // Obtener todos los cursos de un estudiante
    public List<EstudianteCurso> obtenerCursosDelEstudiante(int estudianteId) throws SQLException {
        String sql = "SELECT * FROM estudiante_curso WHERE estudiante_id = ?";

        List<EstudianteCurso> cursos = new ArrayList<>();

        try (Connection connection = ConexionBD.getConnection(ConfiguracionDB.TIPO_DB);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, estudianteId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    EstudianteCurso estudianteCurso = factory.crearEstudianteCurso(
                        resultSet.getInt("estudiante_id"),
                        resultSet.getInt("curso_id")
                    );
                    estudianteCurso.setId(resultSet.getInt("id"));
                    cursos.add(estudianteCurso);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener los cursos del estudiante: " + e.getMessage());
            throw e;
        }

        return cursos;
    }

    // Obtener todos los estudiantes de un curso
    public List<EstudianteCurso> obtenerEstudiantesDelCurso(int cursoId) throws SQLException {
        String sql = "SELECT * FROM estudiante_curso WHERE curso_id = ?";

        List<EstudianteCurso> estudiantes = new ArrayList<>();

        try (Connection connection = ConexionBD.getConnection(ConfiguracionDB.TIPO_DB);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, cursoId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    EstudianteCurso estudianteCurso = factory.crearEstudianteCurso(
                        resultSet.getInt("estudiante_id"),
                        resultSet.getInt("curso_id")
                    );
                    estudianteCurso.setId(resultSet.getInt("id"));
                    estudiantes.add(estudianteCurso);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener los estudiantes del curso: " + e.getMessage());
            throw e;
        }

        return estudiantes;
    }
}
