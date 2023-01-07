//package by.project.trucking_v2.exception;
//
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice
//public class AwesomeExceptionHandler extends ResponseEntityExceptionHandler {
//    @ExceptionHandler(NotFoundException.class)
//    protected ResponseEntity<AwesomeException> handleThereIsNoSuchUserException() {
//        return new ResponseEntity<>(new AwesomeException("Мы не знаем что это такое, если бы мы знали что это такое, мы не знаем что это такое"), HttpStatus.NOT_FOUND);
//    }
//
//    @Data
//    @AllArgsConstructor
//    private static class AwesomeException {
//        private String message;
//    }
//}
