package br.com.alura.livraria.teste;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


import br.com.alura.livraria.modelo.Gestao;

public class TesteSelectGestão {
	
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/livraria?useTimezone=true&serverTimezone=UTC";
		String usuario = "root";
		String senha = "Lucas";
		
		try {
		
		Connection conexao = DriverManager.getConnection(url, usuario, senha);
		
		
		
		String sql = "Select * from gestao";
		
		PreparedStatement ps = conexao.prepareStatement(sql);
		
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Gestao g = new Gestao();
			
			g.setNome(rs.getString("nome"));
			g.setEmail(rs.getString("email"));
			g.setData(rs.getDate("data").toLocalDate());
			g.setMini_cv(rs.getString("miniCV"));
			
			System.out.println(g);
			
			System.out.println("------------");
			
			
		}
		
		
		}catch (SQLException e) {
			System.out.println("Erro ao se conectar ao SQL!" + e);
		}
		
		
		
	}

}
