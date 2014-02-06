package br.edu.ifes.poo1.cdp;

import java.io.Serializable;
import java.util.ArrayList;


public class Usuario implements Serializable{
	
	// Atributos
	
	private static final long serialVersionUID = -7385714884949376161L;

	private String nome;
	
	private String idade;
	
	private String telefone;
	
	private Endereco endereco;
	
	private ArrayList<Usuario> amigos = new ArrayList<Usuario>();
	
	
	// Getters and Setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco){
		this.endereco = endereco;
	}
	
	/*
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	*/
	
	
	// Outros metodos
	
	public String toString(){
		return "\nNome: " + nome + "\nIdade: " + idade + "\nTelefone: " + telefone + endereco.toString() + "\n";
	}
	
	public void adicionarEndereco(Endereco endereco){
		this.endereco = endereco;
	}
	
	public void adicionarAmigo(Usuario amigo){
		this.amigos.add(amigo);
	}
	
	public String listarAmigos(){
		String stringAmigos = "\nAmigos:";
		for(Usuario user: this.amigos){
			stringAmigos += user.toString();
		}
		return stringAmigos;
	}
	
	public Usuario pesquisarAmigo(String nome){
		for(Usuario user: this.amigos){
			if(nome.equals(user.getNome())){
				return user;
			}
		}
		return null;
	}
	
	public void removerAmigo(String nome){
		Usuario user = pesquisarAmigo(nome);
		if(user != null){
			this.amigos.remove(user);
		}
	}
	
	
	public void inserirDadosPessoais(String nome, String idade, String telefone, Endereco endereco){
		this.setNome(nome);
		this.setIdade(idade);
		this.setTelefone(telefone);
		this.setEndereco(endereco);
	}
	
}
