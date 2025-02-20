using SoftwareApp.DatabaseServices;
using SoftwareApp.Documents.Models;
using System.Data;

namespace SoftwareApp.Documents.Data;

public class FileRepository : IFileRepository
{
    private readonly IDatabaseService _databaseService;

    public FileRepository(IDatabaseService databaseService)
    {
        _databaseService = databaseService;
    }

    public void CreateTable()
    {
        string sql = @"
            CREATE TABLE IF NOT EXISTS Documents (
                Id INTEGER PRIMARY KEY AUTOINCREMENT,
                Name TEXT NOT NULL,
                Content BLOB NOT NULL,
                Extension TEXT NOT NULL
            );
        ";
        _databaseService.ExecuteCommand(sql);
    }

    public void InsertFile(Document file)
    {
        string sql = @"
            INSERT INTO Documents (Name, Content, Extension)
            VALUES (@Name, @Content, @Extension);
        ";
        var parameters = new Dictionary<string, object>
        {
            {"@Name", file.Name},
            {"@Content", file.Content},
            {"@Extension", file.Extension}
        };
        _databaseService.ExecuteCommand(sql, parameters);
    }

    public List<Document> GetAllFiles()
    {
        string sql = "SELECT Id, Name, Content, Extension FROM Documents";
        var dataSet = _databaseService.Query(sql);
        var documents = new List<Document>();
        if (dataSet.Tables.Count > 0)
        {
            foreach (DataRow row in dataSet.Tables[0].Rows)
            {
                documents.Add(new Document
                {
                    Id = Convert.ToInt32(row["Id"]),
                    Name = row["Name"].ToString(),
                    Content = (byte[])row["Content"],
                    Extension = row["Extension"].ToString()
                });
            }
        }
        return documents;
    }

    public Document? GetFileById(int fileId)
    {
        string sql = @"SELECT Id, Name, Content, Extension FROM Documents WHERE Id = @idFile";
        var parameters = new Dictionary<string, object>
        {
            {"@idFile", fileId}
        };
        var dataSet = _databaseService.Query(sql, parameters);
        if (dataSet.Tables[0].Rows.Count > 0)
        {
            DataRow row = dataSet.Tables[0].Rows[0];
            return new Document
            {
                Id = Convert.ToInt32(row["Id"]),
                Name = row["Name"].ToString(),
                Content = (byte[])row["Content"],
                Extension = row["Extension"].ToString()
            };
        }
        return null;
    }

    public void DeleteFile(int fileId)
    {
        string sql = @"DELETE FROM Documents WHERE Id = @idFile";
        var parameters = new Dictionary<string, object>
        {
            {"@idFile", fileId}
        };
        _databaseService.ExecuteCommand(sql, parameters);
    }
}