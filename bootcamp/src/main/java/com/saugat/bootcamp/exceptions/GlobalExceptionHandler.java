package com.saugat.bootcamp.exceptions;

import com.saugat.bootcamp.dto.APIErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIErrorResponse> handleResourceNotFound(ResourceNotFoundException ex, HttpServletRequest request){
        log.error("Resource_Not_Found_Error code={} message={}", HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new APIErrorResponse(
                        "404",
                        "RESOURCE_NOT_FOUND",
                        ex.getMessage(),
                        request.getRequestURI(),
                        generateRequestId()
                        )
                );
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<APIErrorResponse> accessDenied(AccessDeniedException ex, HttpServletRequest request){
        log.error("Resource_Not_Found_Error code={} message={}", HttpStatus.FORBIDDEN, ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(new APIErrorResponse(
                                "403",
                                "ACCESS_DENIED",
                                ex.getMessage(),
                                request.getRequestURI(),
                                generateRequestId()
                        )
                );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIErrorResponse> handleGeneral(Exception ex, HttpServletRequest request) {
        log.error("Unhandled_Exception msg={}", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new APIErrorResponse(
                        "503",
                        "INTERNAL_SERVER_ERROR",
                        ex.getMessage(),
                        request.getRequestURI(),
                        generateRequestId()
                        )
                );
    }

    public String generateRequestId(){
        return UUID.randomUUID().toString();
    }
}
