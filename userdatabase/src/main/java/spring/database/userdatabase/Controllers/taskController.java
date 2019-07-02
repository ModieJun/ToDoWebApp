package spring.database.userdatabase.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.database.userdatabase.Model.Task;
import spring.database.userdatabase.Service.TaskService;


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
    public  @ResponseBody Iterable<Task> getAllTodos(@PathVariable Long id){
        Iterable<Task> todos=taskService.getAllTasksByUser(id);
        return todos;
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

