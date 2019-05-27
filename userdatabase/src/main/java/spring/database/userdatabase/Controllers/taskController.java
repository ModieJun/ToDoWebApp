package spring.database.userdatabase.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.database.userdatabase.Service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class taskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/{id}/all")
    public  @ResponseBody List<Object> getAllTodos(@PathVariable Long id){
        List<Object> todos=taskService.getAllTasks( id);

        return todos;
    }

}

