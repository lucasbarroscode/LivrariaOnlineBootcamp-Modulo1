package br.com.alura.livraria.teste;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;


import br.com.alura.livraria.modelo.Autor;

public class TesteInsereGestão {
	
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/livraria?useTimezone=true&serverTimezone=UTC";
		String usuario = "root";
		String senha = "Lucas";
		
		try {
		
		Connection conexao = DriverManager.getConnection(url, usuario, senha);
		
		Autor g = new Autor("Lucas",
				"lucasemail",
				LocalDate.now(),
				"aaaaaa");
		
		String sql = "insert into gestao (nome, email, data, miniCV) values (?,?,?,?)";
		
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, g.getNome());
		ps.setString(2, g.getEmail());
		ps.setDate(3, Date.valueOf(g.getData()));
		ps.setString(4, g.getMiniCV());
		
		ps.execute();
		
		System.out.println("Dados Inseridos");
		
		
		}catch (SQLException e) {
			System.out.println("Erro ao se conectar ao SQL!" + e);
		}
		
		
		
	}

}
