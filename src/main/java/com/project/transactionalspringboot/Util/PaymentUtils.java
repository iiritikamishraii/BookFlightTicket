package com.project.transactionalspringboot.Util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.project.transactionalspringboot.Model.InsufficientAmountException;

public class PaymentUtils {

	private static Map<String, Double> paymentMap = new HashMap<>();

	static {
		paymentMap.put("acc1", 12000.0);
		paymentMap.put("acc2", 10000.0);
		paymentMap.put("acc3", 5000.0);
		paymentMap.put("acc4", 8000.0);
	}

	public static Boolean validateCredentialLimit(String accNo, double paidAmount) {

		if (paidAmount > paymentMap.get(accNo)) {
			throw new InsufficientAmountException(HttpStatus.PRECONDITION_FAILED.toString(), "Insufficient balance");
		} else {
			return true;
		}
	}

}
