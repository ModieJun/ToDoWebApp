package spring.database.userdatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



//@EnableDiscoveryClient
@SpringBootApplication
public class UserdatabaseApplication  {

    public static void main(String[] args) {
        SpringApplication.run(UserdatabaseApplication.class, args);
    }

}
