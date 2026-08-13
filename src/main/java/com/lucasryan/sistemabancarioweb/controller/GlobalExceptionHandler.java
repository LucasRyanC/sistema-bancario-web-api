package com.lucasryan.sistemabancarioweb.controller;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> tratarRegraDeNegocioInvalida(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> tratarContaNaoEncontrada(NoSuchElementException ex) {
        return new ResponseEntity<>("Erro: Conta não encontrada no sistema.", HttpStatus.NOT_FOUND);
    }
}
