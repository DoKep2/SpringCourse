package rest.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeGlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<EmployeeInvalidData> handleException(NoSuchEmployeeException exception){
        EmployeeInvalidData employeeInvalidData = new EmployeeInvalidData();
        employeeInvalidData.setInfo(exception.getMessage());
        return new ResponseEntity<>(employeeInvalidData, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<EmployeeInvalidData> handleException(Exception exception){
        EmployeeInvalidData employeeInvalidData = new EmployeeInvalidData();
        employeeInvalidData.setInfo(exception.getMessage());
        return new ResponseEntity<>(employeeInvalidData, HttpStatus.BAD_REQUEST);
    }
}
