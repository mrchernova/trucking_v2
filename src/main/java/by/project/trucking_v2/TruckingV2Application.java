package by.project.trucking_v2;

import by.project.trucking_v2.model.Contact;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.io.*;

@SpringBootApplication
@EnableConfigurationProperties
public class TruckingV2Application {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(TruckingV2Application.class, args);

//        FileOutputStream fos = new FileOutputStream("src/main/resources/contact.data");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        Contact c = new Contact();
//        oos.writeObject(c);
//        oos.flush();
//        oos.close();


        FileInputStream fis = new FileInputStream("src/main/resources/contact.data");
        ObjectInputStream oin = new ObjectInputStream(fis);

        Contact cc = null;
        try {
            cc = (Contact) oin.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("phone=" + cc.phone);
    }

}
