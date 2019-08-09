package git.leslie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = {"git.leslie.mapper"})
@SpringBootApplication
public class Mytestdome001Application {

    public static void main(String[] args) {
        SpringApplication.run(Mytestdome001Application.class, args);
    }

}
