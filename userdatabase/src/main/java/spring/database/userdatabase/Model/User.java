package spring.database.userdatabase.Model;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String username;
    private String password;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<Task> tasks;

    public User() {
        System.err.println("Invoked empty");
    }

    public User(String username, String password,Task... tasks) {
        System.err.println("Invoked");
        this.username=username;
        this.password=password;
        this.tasks= Stream.of(tasks).collect(Collectors.toSet());
        this.tasks.forEach(x->x.setUser(this));
    }


    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
        this.tasks.forEach((task -> task.setUser(this)));
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
