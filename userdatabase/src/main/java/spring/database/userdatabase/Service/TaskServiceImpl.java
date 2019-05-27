package spring.database.userdatabase.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.database.userdatabase.Model.Task;
import spring.database.userdatabase.database.TaskRepository;

import java.util.Collections;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void saveTask(Task task) {
        saveTask(task);
    }

    @Override
    public List<Object> getAllTasks(long id) {
        List<Object> tasks= Collections.singletonList(taskRepository.findAllByUserid(id));
        return  tasks;
    }

    @Override
    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }
}
