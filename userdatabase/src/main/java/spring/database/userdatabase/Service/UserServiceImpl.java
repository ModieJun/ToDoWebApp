package spring.database.userdatabase.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.database.userdatabase.Model.User;
import spring.database.userdatabase.database.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public Boolean addUser(String username, String Password) {
        if(userRepository.findByUsername(username)!=null){
            return false;
        }
        User user = new User(username,Password);
        userRepository.save(user);

        return true;
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }
}
