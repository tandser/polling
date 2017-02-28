package ru.tandser.polling.web.exc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.web.bind.annotation.*;
import ru.tandser.polling.service.exc.NotFoundException;
import ru.tandser.polling.web.Principal;

import javax.servlet.http.HttpServletRequest;

import static org.slf4j.event.Level.WARN;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private static class ErrorInfo {
        public final String url;
        public final String cause;
        public final String details;

        public ErrorInfo(String url, Exception exc) {
            this.url     = url;
            this.cause   = exc.getClass().getSimpleName();
            this.details = exc.getLocalizedMessage();
        }
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    @ResponseBody
    public ErrorInfo catchException(HttpServletRequest req, NotFoundException exc) {
        return logAndGetErrorInfo(req, exc, WARN);
    }

    private ErrorInfo logAndGetErrorInfo(HttpServletRequest req, Exception exc, Level level) {
        Principal principal = Principal.get();

        String username = principal != null
                ? principal.getUsername()
                : "anonymous";

        switch (level) {
            default: log.debug("{}: {}, {}", username, req.getRequestURL(), exc.toString());
        }

        return new ErrorInfo(req.getRequestURL().toString(), exc);
    }
}