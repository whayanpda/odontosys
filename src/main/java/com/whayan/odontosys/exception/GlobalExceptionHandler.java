package com.whayan.odontosys.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> erros = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String campo = ((FieldError) error).getField();
            String mensagem = error.getDefaultMessage();
            erros.put(campo, mensagem);
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        Map<String, String> erro = new HashMap<>();
        String mensagemErro = ex.getMostSpecificCause().getMessage();

        if (mensagemErro.contains("cpf")) {
            erro.put("erro", "Este CPF já está cadastrado no sistema.");
        } else if (mensagemErro.contains("email")) {
            erro.put("erro", "Este endereço de e-mail já está em uso.");
        } else {
            erro.put("erro", "Erro de integridade de dados ou registro duplicado.");
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }
}