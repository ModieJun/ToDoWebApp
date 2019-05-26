package spring.database.userdatabase.database;

import org.springframework.data.repository.CrudRepository;
import spring.database.userdatabase.Model.User;

public interface UserRepository extends CrudRepository<User,Long> {
        User findByUsername(String username);
}
