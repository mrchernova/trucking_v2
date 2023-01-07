package by.project.trucking_v2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.logging.Logger;
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
    public NotFoundException() {
        super();

        final Logger logger = Logger.getLogger(NotFoundException.class.getName());
//        logger.fine("fine!");
        logger.info("Мы не знаем что это такое, если бы мы знали что это такое, мы не знаем что это такое");
        logger.severe("404. Such id not found");
    }
}
