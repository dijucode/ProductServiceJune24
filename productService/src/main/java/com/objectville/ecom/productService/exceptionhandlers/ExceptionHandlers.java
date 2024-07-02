package com.objectville.ecom.productService.exceptionhandlers;

import com.objectville.ecom.productService.dtos.ExceptionDto;
import com.objectville.ecom.productService.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmeticException(){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Something went wrong!!!");
        exceptionDto.setResolution("Nothing can be done!!!");
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<Void> ArrayIndexOutOfBoundException(){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException ex, WebRequest request) {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage(ex.getMessage());
        exceptionDto.setResolution("Check the product ID.");
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

}
