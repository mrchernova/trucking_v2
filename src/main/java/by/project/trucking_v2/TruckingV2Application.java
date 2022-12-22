package by.project.trucking_v2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class TruckingV2Application {
    public static void main(String[] args) {
        SpringApplication.run(TruckingV2Application.class, args);

    }

}
