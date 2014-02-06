package br.edu.ifes.poo1.cih;

import java.util.Scanner;

public class Janela {
	
	private Scanner scan;

	public void imprimirMenu(){
		System.out.println("	.: Menu :.\n");
		System.out.println("1 - Cadastrar Contato.");
		System.out.println("2 - Listar Contatos.");
		System.out.println("3 - Pesquisar Contato.");
		System.out.println("4 - Excluir Contato.");
		System.out.println("5 - Sair");
		
	}
	
	public int lerOpcaoMenu(){
		scan = new Scanner(System.in);
		int opcao;
		opcao = scan.nextInt();
		return opcao;
	}
	
	public String lerDados(){
		scan = new Scanner(System.in);
		String string;
		string = scan.nextLine();
		return string;
	}
	
	public void exibeMensagem(String msg){
		System.out.println(msg);
	}
	
}
