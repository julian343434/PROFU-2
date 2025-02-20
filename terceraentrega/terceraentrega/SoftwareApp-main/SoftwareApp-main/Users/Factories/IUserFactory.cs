using SoftwareApp.Users.Models;

namespace SoftwareApp.Users.Factories
{
    public interface IUserFactory
    {
        User CreateUser(int? id, string username);
    }
}
