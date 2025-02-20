using SoftwareApp.Documents.Models;

namespace SoftwareApp.Documents.Builders;

public class DocumentBuilder : IDocumentBuilder
{
    private readonly Document _document = new Document();

    public IDocumentBuilder SetId(int? id)
    {
        _document.Id = id;
        return this;
    }

    public IDocumentBuilder SetName(string name)
    {
        _document.Name = name;
        return this;
    }

    public IDocumentBuilder SetContent(byte[] content)
    {
        _document.Content = content;
        return this;
    }

    public IDocumentBuilder SetExtension(string extension)
    {
        _document.Extension = extension;
        return this;
    }

    public Document Build()
    {
        return _document;
    }
}
