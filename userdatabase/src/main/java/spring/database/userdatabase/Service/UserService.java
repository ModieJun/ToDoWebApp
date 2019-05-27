package spring.database.userdatabase.Service;

public interface UserService  {
    Boolean addUser(String username, String Password);
    List<User> getAllUsers();
    User getUser(String username);

}
