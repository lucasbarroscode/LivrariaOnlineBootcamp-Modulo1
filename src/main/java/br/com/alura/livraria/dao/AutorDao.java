package br.com.alura.livraria.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.livraria.modelo.Autor;

public class AutorDao {

	private Connection conexao;

	public AutorDao(Connection conexao) {
		this.conexao = conexao;
	}

	public void cadastrar(Autor gestao) {

		try {

			String sql = "insert into gestao (nome, email, data, miniCV) values (?,?,?,?)";

			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, gestao.getNome());
			ps.setString(2, gestao.getEmail());
			ps.setDate(3, Date.valueOf(gestao.getData()));
			ps.setString(4, gestao.getMiniCV());

			ps.execute();

			System.out.println("Dados Inseridos");

		} catch (SQLException e) {
			System.out.println("Erro ao se conectar ao SQL!" + e);
		}
	}

	public List<Autor> listar() {

		try {

			String sql = "select * from gestao";

			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			List<Autor> gestao = new ArrayList<>();

			while (rs.next()) {
				Autor g = new Autor();

				g.setNome(rs.getString("nome"));
				g.setEmail(rs.getString("email"));
				g.setData(rs.getDate("data").toLocalDate());
				g.setMiniCV(rs.getString("miniCV"));

				gestao.add(g);

			}
			return gestao;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
