package by.project.trucking_v2;

import by.project.trucking_v2.db.Person;
import by.project.trucking_v2.db.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping(value = "", produces = "application/json")
public class TruckingV2Application {


    @Autowired
    private PersonRepository personRepository;


    public static void main(String[] args) {
        SpringApplication.run(TruckingV2Application.class, args);
       Numbers numbers = new Numbers();
       int r = numbers.sum(5);
        System.out.println(r);
    }

    @RequestMapping("/cp")
    public Person createPerson() {
        return personRepository.save(new Person());

    }

}
