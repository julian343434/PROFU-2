using SoftwareApp.Users.Models;

namespace SoftwareApp.Users.Data;

public interface IUserRepository {
    public void CreateTable();
    public List<User> GetAllUsers();
    public User? GetUserById(int idUser);
    public void InsertUser(User user);
    public void DeleteUser(int idUser);
}