package by.project.trucking_v2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
    public NotFoundException() {
        super("Мы не знаем что это такое, если бы мы знали что это такое, мы не знаем что это такое");


    }
}
