package spring.database.userdatabase.Service;

import spring.database.userdatabase.Model.User;

public interface UserService  {
    Boolean addUser(String username, String Password);
    Iterable<User> getAllUsers();
    User getUser(String username);

}
