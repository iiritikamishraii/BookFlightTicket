package com.project.transactionalspringboot.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsufficientAmountException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8366406027294873534L;

	private String error;
	private String errorMessage;
}
