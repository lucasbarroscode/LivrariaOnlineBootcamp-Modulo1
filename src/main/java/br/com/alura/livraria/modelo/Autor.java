package br.com.alura.livraria.modelo;

import java.time.LocalDate;

public class Autor {

	private String nome;
	private String email;
	private LocalDate data;
	private String miniCV;
	
	
	public Autor() {
		
	}
	
	public Autor(String nome, String email, LocalDate data, String miniCV) {
		super();
		this.nome = nome;
		this.email = email;
		this.data = data;
		this.miniCV = miniCV;
	}
	

	@Override
	public String toString() {
		return "Autor [nome=" + nome + ", email=" + email + ", data=" + data + ", miniCV=" + miniCV + "]";
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getMiniCV() {
		return miniCV;
	}

	public void setMiniCV(String miniCV) {
		this.miniCV = miniCV;
	}


	
	
	
	
	
}
