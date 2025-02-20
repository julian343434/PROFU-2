using SoftwareApp.Documents.Models;

namespace SoftwareApp.Documents.Data;

public interface IFileRepository {
    public void CreateTable();
    public List<Document> GetAllFiles();
    public Document? GetFileById(int idFile);
    public void InsertFile(Document File);
    public void DeleteFile(int idFile);
}