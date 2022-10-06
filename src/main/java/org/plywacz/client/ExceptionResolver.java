package org.plywacz.client;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.PrintWriter;
import java.io.StringWriter;

@ControllerAdvice
@Log4j2
class ExceptionResolver extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    ResponseEntity<Object> handleThrowable(Exception ex, WebRequest request) {
        log.error("Unhandled exception occurred", ex);
        return handleExceptionInternal(ex, convertStackTraceFrom(ex), new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    private String convertStackTraceFrom(Exception e){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString();
    }
}
