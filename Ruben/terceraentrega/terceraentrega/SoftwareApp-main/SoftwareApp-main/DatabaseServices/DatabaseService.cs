using Microsoft.Data.Sqlite;
using System.Data;

namespace SoftwareApp.DatabaseServices;

public class SqLiteDatabaseService : IDatabaseService
{
    private static SqLiteDatabaseService? _instance;
    private readonly string _connectionString;

    private SqLiteDatabaseService(string connectionString)
    {
        _connectionString = connectionString;
    }

    public static SqLiteDatabaseService Initialize(string connectionString)
    {
        if (_instance == null)
        {
            _instance = new SqLiteDatabaseService(connectionString);
        }
        return _instance;
    }

    public void ExecuteCommand(string sql, Dictionary<string, object>? parameters = null)
    {
        using (var connection = new SqliteConnection(_connectionString))
        {
            connection.Open();
            using (var command = new SqliteCommand(sql, connection))
            {
                if (parameters != null)
                {
                    foreach (var parameter in parameters)
                    {
                        command.Parameters.AddWithValue(parameter.Key, parameter.Value ?? DBNull.Value);
                    }
                }
                command.ExecuteNonQuery();
            }
        }
    }

    public DataSet Query(string sql, Dictionary<string, object>? parameters = null)
    {
        var dataSet = new DataSet();
        using (var connection = new SqliteConnection(_connectionString))
        {
            connection.Open();
            using (var command = new SqliteCommand(sql, connection))
            {
                if (parameters != null)
                {
                    foreach (var parameter in parameters)
                    {
                        command.Parameters.AddWithValue(parameter.Key, parameter.Value ?? DBNull.Value);
                    }
                }

                using (var reader = command.ExecuteReader())
                {
                    var dataTable = new DataTable();
                    dataTable.Load(reader);
                    dataSet.Tables.Add(dataTable);
                }
            }
        }
        return dataSet;
    }
}
