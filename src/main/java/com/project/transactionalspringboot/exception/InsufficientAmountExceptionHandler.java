package com.project.transactionalspringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.project.transactionalspringboot.Model.GlobalError;
import com.project.transactionalspringboot.Model.InsufficientAmountException;

@RestControllerAdvice
public class InsufficientAmountExceptionHandler {

	@ExceptionHandler(InsufficientAmountException.class)
	@ResponseStatus(value = HttpStatus.PRECONDITION_FAILED)
	public GlobalError handleInsufficientAmountException(InsufficientAmountException insufficientAmountException,
			final WebRequest webRequest) {
		GlobalError globalError = new GlobalError();
		globalError.setError(insufficientAmountException.getError());
		globalError.setErrorMessage(insufficientAmountException.getErrorMessage());
		return globalError;
	}
}
