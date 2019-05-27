package spring.database.userdatabase.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.database.userdatabase.Model.User;
import spring.database.userdatabase.Service.UserService;

@RestController
@RequestMapping("/userdatabase")
public class userController {
    @Autowired
    private UserService userService;

    @GetMapping("/add")
    public @ResponseBody
    String addNewUser(@RequestParam String username, @RequestParam String password){
        Boolean result =userService.addUser(username,password);
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
