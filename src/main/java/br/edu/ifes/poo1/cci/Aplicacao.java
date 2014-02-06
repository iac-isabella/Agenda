package br.edu.ifes.poo1.cci;

import java.util.InputMismatchException;

import br.edu.ifes.poo1.cdp.Endereco;
import br.edu.ifes.poo1.cdp.Usuario;
import br.edu.ifes.poo1.cgt.Tarefas;
import br.edu.ifes.poo1.cih.Janela;

public class Aplicacao {
	
	private Janela window = new Janela();
	private Tarefas tarefas = new Tarefas();
	
	
	// Carrega informacoes da agenda de contatos ou inicializa a agenda
	public void load(){
		
		try{
			
			if(!tarefas.recuperarInfo()){
				String nome;
				String idade;
				String telefone;
				String rua;
				String numero;
				String bairro;
				String cidade;
				String estado;
				
				window.exibeMensagem("Informe o seu nome:");
				nome = window.lerDados();
				window.exibeMensagem("Informe a idade:");
				idade = window.lerDados();
				window.exibeMensagem("Informe o telefone:");
				telefone = window.lerDados();
				window.exibeMensagem("Informe endereco:");
				window.exibeMensagem("Rua:");
				rua = window.lerDados();
				window.exibeMensagem("Numero:");
				numero = window.lerDados();
				window.exibeMensagem("Bairro:");
				bairro = window.lerDados();
				window.exibeMensagem("Cidade:");
				cidade = window.lerDados();
				window.exibeMensagem("Estado:");
				estado = window.lerDados();
				Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado);
				
				tarefas.setProprietario(nome, idade, telefone, endereco);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	// Logica de funcionamento das tarefas da aplicacao
	public void run(){
		int opcao;
		window.imprimirMenu();
		try{
			opcao = window.lerOpcaoMenu();
		}
		catch(InputMismatchException e){
			window.exibeMensagem("Insira um valor de 1 a 5!!!");
			opcao = window.lerOpcaoMenu();
		}
		while(opcao!=5){
			switch(opcao){
				case 1:
					this.cadastrarContato();
					break;
				case 2:
					this.listarContatos();
					break;
				case 3:
					this.pesquisarContato();
					break;
				case 4:
					this.removerContato();
					break;
				default:
					window.exibeMensagem("Opcao invalida!");
			}
			
			window.imprimirMenu();
			opcao = window.lerOpcaoMenu();
		}
		tarefas.salvarInfo();
	}

	
	// Opcao 1 do menu
	public void cadastrarContato(){
		
		String nome;
		String idade;
		String telefone;
		String rua;
		String numero;
		String bairro;
		String cidade;
		String estado;
		
		window.exibeMensagem("Informe o nome do contato:");
		nome = window.lerDados();
		window.exibeMensagem("Informe a idade:");
		idade = window.lerDados();
		window.exibeMensagem("Informe o telefone:");
		telefone = window.lerDados();
		window.exibeMensagem("Informe endereco:");
		window.exibeMensagem("Rua:");
		rua = window.lerDados();
		window.exibeMensagem("Numero:");
		numero = window.lerDados();
		window.exibeMensagem("Bairro:");
		bairro = window.lerDados();
		window.exibeMensagem("Cidade:");
		cidade = window.lerDados();
		window.exibeMensagem("Estado:");
		estado = window.lerDados();
		Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado);
		
		tarefas.adicionarContato(nome, idade, telefone, endereco);
	}
	
	// Opcao 2 do menu
	public void listarContatos(){
		window.exibeMensagem("Listagem de Contatos:");
		window.exibeMensagem(tarefas.listarContatos());
	}
		
	
	// Opcao 3 do menu
	public void pesquisarContato(){
		window.exibeMensagem("Informe o nome do contato a pesquisar: ");
		String nome = window.lerDados();
		Usuario amigo;
		amigo = tarefas.pesquisarContato(nome);
		if(amigo!=null){
			window.exibeMensagem(amigo.toString());
		}
		else{
			window.exibeMensagem("Contato não encontrado.");
		}
	}
	
	
	// Opcao 4 do menu
	public void removerContato(){
		window.exibeMensagem("Informe o nome do contato a remover: ");
		String nome = window.lerDados();
		boolean situacao = tarefas.removerContato(nome);
		if(situacao){
			window.exibeMensagem("Contato removido com sucesso!");
		}
		else{
			window.exibeMensagem("Contato nao pode ser removido!");
		}
	}
	
	
}