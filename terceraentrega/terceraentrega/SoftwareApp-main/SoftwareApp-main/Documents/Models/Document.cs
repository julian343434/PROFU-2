namespace SoftwareApp.Documents.Models;
public class Document
{
    public int? Id { get; set; }
    public string Name { get; set; } = null!;
    public byte[] Content { get; set; } = null!;
    public string Extension { get; set; } = null!;
}