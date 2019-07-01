package spring.database.userdatabase.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.database.userdatabase.Model.Task;
import spring.database.userdatabase.Service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class taskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    public @ResponseBody String addTodo(@RequestBody Task newtask){
        taskService.saveTask(newtask);
        return "saved";
    }

    @GetMapping("/{id}/all")
    public  @ResponseBody List<Task> getAllTodos(@PathVariable Long id){
//        List<Task> todos=taskService.getAllTasks( );

        return null;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public Iterable<Task> getAll() {
        return taskService.getAllTasks();
    }


    @DeleteMapping("/{id}")
    public void deleteTodo(@ModelAttribute Task task,@PathVariable Long id){
        taskService.deleteTask(task);
    }

}

