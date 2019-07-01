package spring.database.userdatabase.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.database.userdatabase.Model.User;
import spring.database.userdatabase.Service.UserService;


@RestController
@RequestMapping("")
public class userController {
    @Autowired
    private UserService userService;

    @GetMapping(produces = "application/json")
    public String ping (){
        return "{Awe}";
    }


    @RequestMapping(value = "/add",method = RequestMethod.POST,produces = "application/json")
    public
    String addNewUser(@RequestBody User newUser){
//        User newUser= new User(username,password);
        Boolean result =userService.addUser(newUser);
        if (result==false) {
            return  "User Already Exists";
        }
        return "Saved";
    }

    @GetMapping(value = "/all",produces = "application/json")
    public Iterable<User> getAllUsers(){
//        Returns Json
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{username}",produces = "application/json")
    public User getUserInfo(@PathVariable String username){
        return  userService.getUser(username);
    }




}
