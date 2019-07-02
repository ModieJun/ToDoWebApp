package spring.database.userdatabase.Service;

import spring.database.userdatabase.Model.Task;
import spring.database.userdatabase.Model.User;



public interface TaskService  {
    void saveTask(Task task);
    Iterable<Task> getAllTasks( );
    void deleteTask(Task task);
    Iterable<Task> getAllTasksByUser(Long  userId );
}
