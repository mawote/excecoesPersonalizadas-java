package com.mawote.aplication;

import java.util.Locale;
import java.util.Scanner;

import com.mawote.model.entities.Conta;
import com.mawote.model.exception.ContaDomainException;

public class ContaProgram {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Entre com dados da conta:");
			System.out.print("Numero da conta: ");
			Integer numeroDaConta = sc.nextInt();
			System.out.print("Titular: ");
			sc.nextLine();
			String titular = sc.nextLine();
			System.out.print("Depositar: ");
			Double saldo = sc.nextDouble();
			System.out.print("Limite de levantamento: ");
			Double limiteDeLevantamento = sc.nextDouble();
			
			Conta conta = new Conta(numeroDaConta, titular, saldo, limiteDeLevantamento);
			
			System.out.println();
			System.out.print("Valor para levantar: ");
			Double valor = sc.nextDouble();
			
			conta.levantar(valor);
			System.out.println(conta);
		}
		catch(ContaDomainException e) {
			System.out.println("Erro! \n" + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
			
		
		
		sc.close();
	}

}
