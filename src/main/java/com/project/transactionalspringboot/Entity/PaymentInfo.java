package com.project.transactionalspringboot.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "PAYMENT_INFO")
public class PaymentInfo {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "paymentId")
	private String paymentId;

	@Column(name = "accountNo")
	private String accountNo;

	@Column(name = "amount")
	private double amount;

	@Column(name = "cardType")
	private String cardType;

	@JoinColumn(name = "pass_fk", referencedColumnName = "p_id")
	@Column(name = "p_id")
	private Long passengerId;

}
