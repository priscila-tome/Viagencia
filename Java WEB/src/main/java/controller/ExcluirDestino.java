package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DestinoDAO;

@WebServlet("/excluir")
public class ExcluirDestino extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idDestino = Integer.parseInt(req.getParameter("id"));

		DestinoDAO ddao = new DestinoDAO();

		ddao.removeById(idDestino);

		resp.sendRedirect("home");
	}

}