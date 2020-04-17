package io.agileintellligence.ppmtool.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Controller
@RestController
public class CustomeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler
    public final ResponseEntity<Object> handleProjectIdException(ProjectIdExeption ex, WebRequest request){
        ProjectIdExeptionResponse exeptionResponse = new ProjectIdExeptionResponse(ex.getMessage());
        return new ResponseEntity(exeptionResponse, HttpStatus.BAD_REQUEST);
    }
}
