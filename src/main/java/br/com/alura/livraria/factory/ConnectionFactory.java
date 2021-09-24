package br.com.alura.livraria.factory;

import java.sql.Connection;
import java.sql.DriverManager;

import br.com.alura.livraria.dao.AutorDao;

public class ConnectionFactory {

	public Connection getConnection() {
		
		try {
			String url = "jdbc:mysql://localhost:3306/livraria?useTimezone=true&serverTimezone=UTC";
			String usuario = "root";
			String senha = "Lucas";

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			return conexao;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
