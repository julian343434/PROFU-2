using SoftwareApp.DatabaseServices;
using SoftwareApp.Documents.Builders;
using SoftwareApp.Documents.Data;
using SoftwareApp.Documents.Models;
using SoftwareApp.Documents.Services;
using SoftwareApp.Users.Data;
using SoftwareApp.Users.Factories;
using SoftwareApp.Users.Models;
using SoftwareApp.Users.Services;
class Program
{
    static void Main(string[] args)
    {
        string currentDirectory = Directory.GetCurrentDirectory();
        string connectionDatabase = "Data Source=SoftwareApp.db";
        var sqliteService = SqLiteDatabaseService.Initialize(connectionDatabase);
        
        IFileRepository fileRepository = new FileRepository(sqliteService);
        FileService fileService = new(fileRepository);

        byte[]? bytes = fileService.GetBytes(Path.Combine(currentDirectory, "TestFiles/Test.txt"));
        IDocumentBuilder documentBuilder = new DocumentBuilder();
        Document newFile = documentBuilder
            .SetName("Test 2")
            .SetContent(bytes ?? [])
            .SetExtension(".txt")
            .Build();

        fileService.CreateTable();
        fileService.UploadFile(newFile);
        var files = fileService.GetAllFiles();
        foreach(Document file in files){
            Console.WriteLine(file.Id + " - " + file.Content + " - " + file.Name);
        }
        
        IUserFactory adminFactory = new AdminUserFactory();
        User adminUser = adminFactory.CreateUser(1, "adminUser");
        Console.WriteLine($"Created Admin User: {adminUser.Username}");

        IUserFactory regularFactory = new RegularUserFactory();
        User regularUser = regularFactory.CreateUser(2, "regularUser");
        Console.WriteLine($"Created Regular User: {regularUser.Username}");

        IUserRepository userRepository = new UserRepository(sqliteService);
        UserService userService = new(userRepository);

        userService.CreateTable();
        userService.InsertUser(adminUser);
        userService.InsertUser(regularUser);
        var users = userService.GetUsers();
        foreach(User user in users){
            Console.WriteLine(user.Id + " - " + user.Username);
        }
    }
}