package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Destino;
import model.DestinoDAO;

@WebServlet("/listarDestinos")
public class ListarDestinos extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Destino> destinos = new ArrayList<Destino>();
		DestinoDAO ddao = new DestinoDAO();		
		destinos = ddao.getDestinos();		
		req.setAttribute("listaDestinos", destinos);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("ListarDestinos.jsp");
		dispatcher.forward(req, resp);
	}

}
