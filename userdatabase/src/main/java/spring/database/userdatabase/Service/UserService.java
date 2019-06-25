package spring.database.userdatabase.Service;

import spring.database.userdatabase.Model.User;

public interface UserService  {
    Boolean addUser(User user);
    Iterable<User> getAllUsers();
    User getUser(String username);

}
