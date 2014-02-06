package br.edu.ifes.poo1.cgt;

import java.io.IOException;

import br.edu.ifes.poo1.cdp.Endereco;
import br.edu.ifes.poo1.cdp.Usuario;
import br.edu.ifes.poo1.cgd.Persistencia;

public class Tarefas {
	
	private Usuario proprietario;
	
	Persistencia<Usuario> persist = new Persistencia<Usuario>();
	
	public Usuario getProprietario(){
		return this.proprietario;
	}
	
	public void setProprietario(Usuario proprietario) {
		this.proprietario = proprietario;
	}
	
	public Usuario criarUsuario(String nome, String idade, String telefone, Endereco endereco) {
		Usuario user = new Usuario();
		user.setNome(nome);
		user.setIdade(idade);
		user.setTelefone(telefone);
		user.setEndereco(endereco);
		return user;
	}
	
	public void setProprietario(String nome, String idade, String telefone, Endereco endereco) {
		Usuario user = criarUsuario(nome, idade, telefone, endereco);
		this.proprietario = user;
	}

	
	public void adicionarContato(String nome, String idade, String telefone, Endereco endereco){
		Usuario amigo = criarUsuario(nome, idade, telefone, endereco);
		this.proprietario.adicionarAmigo(amigo);
	}
	
	public Usuario pesquisarContato(String nome){
		return this.proprietario.pesquisarAmigo(nome);
	}
	
	public boolean removerContato(String nome){
		this.proprietario.removerAmigo(nome);
		if(this.proprietario.pesquisarAmigo(nome)!=null){
			return false;
		}
		return true;
	}
	
	public String listarContatos(){
		return this.proprietario.listarAmigos();
	}
	
	
	public boolean recuperarInfo() throws IOException {
		this.proprietario = (Usuario) this.persist.recuperarArquivo();
		if(this.proprietario == null){
			return false;
		}
		return true;
	}

	public void salvarInfo(){
		this.persist.gravarArquivo(this.proprietario);
	}

	
	
}
