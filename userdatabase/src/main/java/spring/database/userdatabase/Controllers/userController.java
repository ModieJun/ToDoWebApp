package spring.database.userdatabase.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.database.userdatabase.Model.User;
import spring.database.userdatabase.database.UserRepository;

@Controller
@RequestMapping("/userdatabase")
public class userController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/add")
    public @ResponseBody String addNewUser(@RequestParam String username, @RequestParam String password){
        User user= new User(username,password);
        if (userRepository.findByUsername(user.getUsername())!=null){
            return  "User already Exists";
        }

        userRepository.save(user);

        return "Saved";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<User> getAllUsers(){
//        Returns Json
        return userRepository.findAll();
    }

    @Getmapping("/{username}")
    public String getUserInfo(@PathVariable String username){
        User user = userRepository.findByUsername(username);
        return user;
    }




}
