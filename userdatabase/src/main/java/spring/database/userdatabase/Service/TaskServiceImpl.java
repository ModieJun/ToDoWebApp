package spring.database.userdatabase.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.database.userdatabase.Model.Task;
import spring.database.userdatabase.database.TaskRepository;

import java.util.Date;
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void saveTask(Task task) {
        task.setDueDate(new Date());
        taskRepository.save(task);
    }

    @Override
    public Iterable<Task> getAllTasks( ) {
        taskRepository.findAll().forEach((x)-> System.out.println(x.getDescription()));
        return taskRepository.findAll();
    }

    @Override
    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }
}
