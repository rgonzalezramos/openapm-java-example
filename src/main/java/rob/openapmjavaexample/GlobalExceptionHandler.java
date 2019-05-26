package rob.openapmjavaexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;


@ControllerAdvice
@RequestMapping(produces = "application/json")
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionMessage> handleUncaughtException(Exception e) {
        logger.error("uncaught_exception", e);
        return new ResponseEntity<>(new ExceptionMessage("Sorry!"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static class ExceptionMessage {
        private final String message;

        public ExceptionMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
