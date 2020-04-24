package io.github.rafaelmoura29.rest.controller;

import io.github.rafaelmoura29.exception.RegraNegocioException;
import io.github.rafaelmoura29.rest.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(RegraNegocioException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleRegraNegocioExceptionErrors(RegraNegocioException ex){
        String menssagemErro = ex.getMessage();
        return new ApiErrors(menssagemErro);
    }

}
