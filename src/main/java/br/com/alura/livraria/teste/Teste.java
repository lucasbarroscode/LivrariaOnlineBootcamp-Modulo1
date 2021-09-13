package br.com.alura.livraria.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import br.com.alura.livraria.dao.GestaoDao;
import br.com.alura.livraria.modelo.Gestao;

public class Teste {

	public static void main(String[] args) {
		
		
		try {
			
			String url = "jdbc:mysql://localhost:3306/livraria?useTimezone=true&serverTimezone=UTC";
			String usuario = "root";
			String senha = "Lucas";
			
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			
			GestaoDao dao = new GestaoDao(conexao);
			
			Gestao gestao = new Gestao("AAA", "email", LocalDate.now(), "eeee");
			
			dao.cadastrar(gestao);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
