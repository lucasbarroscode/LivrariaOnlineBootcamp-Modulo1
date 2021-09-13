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

import br.com.alura.livraria.modelo.Gestao;

public class GestaoDao {

	private Connection conexao;

	public GestaoDao(Connection conexao) {
		this.conexao = conexao;
	}

	public void cadastrar(Gestao gestao) {

		try {

			String sql = "insert into gestao (nome, email, data, miniCV) values (?,?,?,?)";

			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, gestao.getNome());
			ps.setString(2, gestao.getEmail());
			ps.setDate(3, Date.valueOf(gestao.getData()));
			ps.setString(4, gestao.getMini_cv());

			ps.execute();

			System.out.println("Dados Inseridos");

		} catch (SQLException e) {
			System.out.println("Erro ao se conectar ao SQL!" + e);
		}
	}

	public List<Gestao> listar() {

		try {

			String sql = "select * from gestao";

			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			List<Gestao> gestao = new ArrayList<>();

			while (rs.next()) {
				Gestao g = new Gestao();

				g.setNome(rs.getString("nome"));
				g.setEmail(rs.getString("email"));
				g.setData(rs.getDate("data").toLocalDate());
				g.setMini_cv(rs.getString("miniCV"));

				gestao.add(g);

			}
			return gestao;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
