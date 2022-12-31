package by.project.trucking_v2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    public NotFoundException(Integer id) {
        super("User with id=" + id + " not found");
    }

    public NotFoundException(String login) {
        super("User with login=" + login + " not found");
    }
}
