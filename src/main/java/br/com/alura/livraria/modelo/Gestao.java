package br.com.alura.livraria.modelo;

import java.time.LocalDate;

public class Gestao {

	private String nome;
	private String email;
	private LocalDate data;
	private String mini_cv;
	
	
	public Gestao() {
		
	}
	
	public Gestao(String nome, String email, LocalDate data, String mini_cv) {
		super();
		this.nome = nome;
		this.email = email;
		this.data = data;
		this.mini_cv = mini_cv;
	}
	



	@Override
	public String toString() {
		return "Gestao [nome=" + nome + ", email=" + email + ", data=" + data + ", mini_cv=" + mini_cv + "]";
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
	public String getMini_cv() {
		return mini_cv;
	}
	public void setMini_cv(String mini_cv) {
		this.mini_cv = mini_cv;
	}

	
	
	
	
	
}
