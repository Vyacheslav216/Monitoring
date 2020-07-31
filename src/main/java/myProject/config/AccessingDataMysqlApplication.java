package myProject.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AccessingDataMysqlApplication extends SpringBootServletInitializer {


    public static void main(String[]args) throws Exception {
        SpringApplication.run(AccessingDataMysqlApplication.class, args);
    }

}
/*@SpringBootApplication
public class AccessingDataMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataMysqlApplication.class, args);
    }

}*/