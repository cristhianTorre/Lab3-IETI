package edu.escuelaing.ieti.demo.exception;


import edu.escuelaing.ieti.demo.controller.ServerErrorResponseDto;
import edu.escuelaing.ieti.demo.error.ErrorCodeEnum;
import org.springframework.http.HttpStatus;

public class InvalidCredentialsException extends InternalServerErrorException {

    public InvalidCredentialsException() {
        super(new ServerErrorResponseDto("User not found", ErrorCodeEnum.USER_NOT_FOUND, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }
}
