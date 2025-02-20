using SoftwareApp.Users.Data;
using SoftwareApp.Users.Models;

namespace SoftwareApp.Users.Services;

public class UserService
{
    private readonly IUserRepository _userRepository;

    public UserService(IUserRepository userRepository)
    {
        _userRepository = userRepository;
    }

    public void CreateTable()
    {
        _userRepository.CreateTable();
    }

    public void InsertUser(User User)
    {
        _userRepository.InsertUser(User);
    }
    public void DeleteUser(int idUser)
    {
        _userRepository.DeleteUser(idUser);
    }

    public List<User> GetUsers()
    {
        return _userRepository.GetAllUsers();
    }
}

