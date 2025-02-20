// Services/FileService.cs
using SoftwareApp.Documents.Data;
using SoftwareApp.Documents.Models;
using System.Collections.Generic;

namespace SoftwareApp.Documents.Services;

public class FileService
{
    private readonly IFileRepository _fileRepository;

    public FileService(IFileRepository fileRepository)
    {
        _fileRepository = fileRepository;
    }

    public void CreateTable()
    {
        _fileRepository.CreateTable();
    }

    public void UploadFile(Document file)
    {
        _fileRepository.InsertFile(file);
    }

    public List<Document> GetAllFiles()
    {
        return _fileRepository.GetAllFiles();
    }

    public Document? GetFileById(int fileId)
    {
        return _fileRepository.GetFileById(fileId);
    }

    public void DeleteFile(int fileId)
    {
        _fileRepository.DeleteFile(fileId);
    }

    public byte[]? GetBytes(string path)
    {
        try
        {
            byte[] fileBytes = File.ReadAllBytes(path);
            Console.WriteLine($"El archivo se ha convertido en un arreglo de {fileBytes.Length} bytes.");
            return fileBytes;
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Ocurrió un error al leer el archivo: {ex.Message}");
            return null;
        }

    }
}

