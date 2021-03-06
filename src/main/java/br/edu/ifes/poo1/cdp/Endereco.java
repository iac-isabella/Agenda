package br.edu.ifes.poo1.cdp;

import java.io.Serializable;

public class Endereco implements Serializable {
	
	// Atributos
	
	private static final long serialVersionUID = 3404103061124224210L;

	private String rua;
	
	private String numero;
	
	private String bairro;
	
	private String cidade;
	
	private String estado;
	
	public Endereco(String rua, String numero, String bairro, String cidade, String estado){
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	// Getters and Setters

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	// Outros metodos
	
	public String toString(){
		return "\nRua: " + rua + "\nNumero: " + numero + "\nBairro: " + bairro + "\nCidade: " + cidade + "\nEstado: " + estado + "\n";
	}
	
}
