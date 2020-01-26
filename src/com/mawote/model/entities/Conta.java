package com.mawote.model.entities;

import com.mawote.model.exception.ContaDomainException;

public class Conta {
	
	private Integer numeroDaConta;
	private String titular;
	private Double saldo;
	private Double limiteDeLevantamento;
	
	public Conta() {
	}

	public Conta(Integer numeroDaConta, String titular, Double saldo, Double limiteDeLevantamento) {
		this.numeroDaConta = numeroDaConta;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteDeLevantamento = limiteDeLevantamento;
	}

	public Integer getNumeroDaConta() {
		return numeroDaConta;
	}

	public void setNumeroDaConta(Integer numeroDaConta) {
		this.numeroDaConta = numeroDaConta;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getLimiteDeLevantamento() {
		return limiteDeLevantamento;
	}

	public void setLimiteDeLevantamento(Double limiteDeLevantamento) {
		this.limiteDeLevantamento = limiteDeLevantamento;
	}
	
	public void depositar(Double valor) {
		this.saldo += valor;
	}
	public void levantar(Double valor) throws ContaDomainException{
		if(saldo < valor) {
			throw new ContaDomainException("Saldo Inferir para realizar a Operaçao solicitada!");
		}
		if(valor > limiteDeLevantamento) {
			throw new ContaDomainException("A solicitacao excedeu o limite de levantamento");
		}
		this.saldo -= valor;
	}
	
	@Override
	public String toString() {
		return "Numero da Conta: "
				+getNumeroDaConta()
				+", Titular: "
				+getTitular()
				+", Saldo: "
				+String.format("%.2f%n", getSaldo());
	}
}
