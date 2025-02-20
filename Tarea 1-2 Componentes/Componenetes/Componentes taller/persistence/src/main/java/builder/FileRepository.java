package builder;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import config.DatabaseConfig;

public class FileRepository {
    private final DatabaseConfig databaseConfig;

    public FileRepository(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
    }

    public void createTable(){
        String createTable = "CREATE TABLE IF NOT EXISTS FILE("
                                + "ID INT PRIMARY KEY,"
                                + "NAME VARCHAR(255),"
                                + "CONTENT BLOB)";
        try(Connection con = databaseConfig.getConnection();
            PreparedStatement ps = con.prepareStatement(createTable)){
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertFile(int id, String name, File file){
        String insertFile = "INSERT INTO FILE (ID, NAME, CONTENT) VALUES(?,?,?)";

        try(Connection con = databaseConfig.getConnection();
            PreparedStatement ps = con.prepareStatement(insertFile);
            FileInputStream fileInputStream = new FileInputStream(file)){
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setBinaryStream(3, fileInputStream, (int) file.length());
            ps.executeUpdate();
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public File retrieveFile(int id, String outputPath) throws SQLException, IOException {
        String querySQL = "SELECT NAME, CONTENT FROM FILE WHERE ID = ?";

        try (Connection conn = databaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(querySQL)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String fileName = rs.getString("NAME");
                    byte[] fileBytes = rs.getBytes("CONTENT");

                    File outputFile = new File(outputPath + fileName);
                    try (ByteArrayInputStream bis = new ByteArrayInputStream(fileBytes);
                         ByteArrayOutputStream bos = new ByteArrayOutputStream()) {

                        int data;
                        while ((data = bis.read()) != -1) {
                            bos.write(data);
                        }

                        outputFile.createNewFile();
                        try (java.io.FileOutputStream fos = new java.io.FileOutputStream(outputFile)) {
                            fos.write(bos.toByteArray());
                        }

                        return outputFile;
                    }
                }
            }
        }
        return null;
    }
}
