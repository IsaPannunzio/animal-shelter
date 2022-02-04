package com.ibm.animalshelter.exeption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;


@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ErrorMessage.Campo> campos = new ArrayList<>();

        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String nome = ((FieldError) error).getField();
            String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());

            campos.add(new ErrorMessage.Campo(nome, mensagem));
        }

        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setStatus(status.value());
        errorMessage.setDataHora(OffsetDateTime.now());
        errorMessage.setTitulo("Um ou mais campos inválidos. Preencha corretamente e tente novamente");
        errorMessage.setCampos(campos);
        return handleExceptionInternal(ex, errorMessage, headers, status, request);
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleNegocio(RuntimeException ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        ErrorMessage mensagemException = new ErrorMessage();
        mensagemException.setStatus(status.value());
        mensagemException.setDataHora(OffsetDateTime.now());
        mensagemException.setTitulo(ex.getMessage());
        return handleExceptionInternal(ex, mensagemException, new HttpHeaders(), status, request);
    }



    @ExceptionHandler({AccessDeniedException.class})
    public ResponseEntity acessDenied(SecurityException ex,HttpHeaders headers, HttpStatus status, WebRequest request){
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setStatus(status.value());
        errorMessage.setDataHora(OffsetDateTime.now());
        errorMessage.setTitulo("Acesso negado");
        return handleExceptionInternal(ex, errorMessage, headers, status, request);




    }

}
