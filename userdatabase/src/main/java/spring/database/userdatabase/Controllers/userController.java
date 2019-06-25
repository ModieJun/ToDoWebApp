package spring.database.userdatabase.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.database.userdatabase.Model.User;
import spring.database.userdatabase.Service.UserService;

import javax.ws.rs.POST;

@RestController
@RequestMapping("/")
public class userController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public @ResponseBody String ping (){
        return "Awe";
    }


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public @ResponseBody
    String addNewUser(@RequestBody User newUser){
//        User newUser= new User(username,password);
        Boolean result =userService.addUser(newUser);
        if (result==false) {
            return  "User Already Exists";
        }
        return "Saved";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<User> getAllUsers(){
//        Returns Json
        return userService.getAllUsers();
    }

    @GetMapping("/{username}")
    public User getUserInfo(@PathVariable String username){
        return  userService.getUser(username);
    }




}
