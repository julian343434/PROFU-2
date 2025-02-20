using System.Data;

namespace SoftwareApp.DatabaseServices;

    public interface IDatabaseService
{
    void ExecuteCommand(string sql, Dictionary<string, object> parameters = null);
    DataSet Query(string sql, Dictionary<string, object> parameters = null);
}
