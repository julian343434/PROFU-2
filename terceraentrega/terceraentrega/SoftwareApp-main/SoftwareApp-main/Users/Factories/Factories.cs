using SoftwareApp.Users.Models;

namespace SoftwareApp.Users.Factories
{
    public class AdminUserFactory : IUserFactory
    {
        public User CreateUser(int? id, string username)
        {
            return new User
            {
                Username = username
            };
        }
    }

    public class RegularUserFactory : IUserFactory
    {
        public User CreateUser(int? id, string username)
        {
            return new User
            {
                Username = username
            };
        }
    }
}
