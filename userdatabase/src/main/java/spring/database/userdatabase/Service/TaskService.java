package spring.database.userdatabase.Service;

import spring.database.userdatabase.Model.Task;

import java.util.List;

public interface TaskService  {
    void saveTask(Task task);
    List<Task> getAllTasks(long id);
    void deleteTask(Task task);
}
