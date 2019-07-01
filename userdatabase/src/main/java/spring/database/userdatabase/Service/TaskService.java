package spring.database.userdatabase.Service;

import spring.database.userdatabase.Model.Task;

import java.util.List;


public interface TaskService  {
    void saveTask(Task task);
    Iterable<Task> getAllTasks( );
    void deleteTask(Task task);
}
