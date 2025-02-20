using SoftwareApp.DatabaseServices;
using SoftwareApp.Users.Models;
using System.Collections.Generic;
using System.Data;

namespace SoftwareApp.Users.Data;

public class UserRepository : IUserRepository
{
    private readonly IDatabaseService _databaseService;

    public UserRepository(IDatabaseService databaseService)
    {
        _databaseService = databaseService;
    }

    public void CreateTable()
    {
        string sql = @"
            CREATE TABLE IF NOT EXISTS Users (
                Id INTEGER PRIMARY KEY AUTOINCREMENT,
                Username TEXT NOT NULL
            );
        ";
        _databaseService.ExecuteCommand(sql);
    }

    public void InsertUser(User user)
    {
        string sql = @"
            INSERT INTO Users (Username)
            VALUES (@Username);
        ";
        var parameters = new Dictionary<string, object>
        {
            {"@Username", user.Username}
        };
        _databaseService.ExecuteCommand(sql, parameters);
    }

    public List<User> GetAllUsers()
    {
        string sql = "SELECT Id, Username FROM Users";
        var dataSet = _databaseService.Query(sql);
        var users = new List<User>();
        if (dataSet.Tables.Count > 0)
        {
            foreach (DataRow row in dataSet.Tables[0].Rows)
            {
                users.Add(new User
                {
                    Id = Convert.ToInt32(row["Id"]),
                    Username = row["Username"].ToString()
                });
            }
        }
        return users;
    }

    public User? GetUserById(int userId)
    {
        string sql = @"SELECT Id, Username FROM Users WHERE Id = @Id";
        var parameters = new Dictionary<string, object>
        {
            {"@Id", userId}
        };
        var dataSet = _databaseService.Query(sql, parameters);
        if (dataSet.Tables[0].Rows.Count > 0)
        {
            DataRow row = dataSet.Tables[0].Rows[0];
            return new User
            {
                Id = Convert.ToInt32(row["Id"]),
                Username = row["Username"].ToString()
            };
        }
        return null;
    }

    public void DeleteUser(int userId)
    {
        string sql = @"DELETE FROM Users WHERE Id = @Id";
        var parameters = new Dictionary<string, object>
        {
            {"@Id", userId}
        };
        _databaseService.ExecuteCommand(sql, parameters);
    }
}