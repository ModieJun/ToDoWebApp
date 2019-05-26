package spring.database.userdatabase.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.database.userdatabase.Model.Task;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task,Long> {
    List<Task> findAllByUserid(long userid);
}
