package br.com.alura.livraria.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.livraria.dao.GestaoDao;
import br.com.alura.livraria.factory.ConnectionFactory;
import br.com.alura.livraria.modelo.Gestao;

@WebServlet("/autores")
public class AutoresServlet extends HttpServlet {

	private GestaoDao dao;

	public AutoresServlet() {

			this.dao = new GestaoDao(new ConnectionFactory().getConnection());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("gestao", dao.listar());

		req.getRequestDispatcher("WEB-INF/jsp/autores.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		LocalDate data = LocalDate.parse(req.getParameter("data"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String miniCV = req.getParameter("cv");

		Gestao gestao = new Gestao(nome, email, data, miniCV);

		dao.cadastrar(gestao);

		resp.sendRedirect("autores");

	}

}
