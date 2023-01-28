package by.project.trucking_v2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class DatabaseException extends RuntimeException{
    public DatabaseException(String login) {
        super("Пользователь [" + login + "] уже существует");
    }

}
