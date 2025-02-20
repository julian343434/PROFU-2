using SoftwareApp.Documents.Models;
namespace SoftwareApp.Documents.Builders;

public interface IDocumentBuilder
{
    IDocumentBuilder SetId(int? id);
    IDocumentBuilder SetName(string name);
    IDocumentBuilder SetContent(byte[] content);
    IDocumentBuilder SetExtension(string extension);
    Document Build();
}

