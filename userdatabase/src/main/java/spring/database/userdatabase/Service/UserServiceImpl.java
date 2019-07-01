package spring.database.userdatabase.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.database.userdatabase.Model.Task;
import spring.database.userdatabase.Model.User;
import spring.database.userdatabase.database.UserRepository;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public Boolean addUser(User newUser) {
        if(userRepository.findByUsername(newUser.getUsername())!=null){
            return false;
        }
//        Moved setting the user for the task into the setTask() for the User Entity
//        newUser.getTasks().forEach((task )->task.setUser(newUser) );
        userRepository.save(newUser);

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
