package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Destino;
import model.DestinoDAO;


@WebServlet("/InserirDestino")
public class InserirDestino extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String pais = request.getParameter("pais");
		String estado = request.getParameter("estado");
		String cidade = request.getParameter("cidade");
		
		
		Destino objDestino =  new Destino();
		
		
		objDestino.setPais(pais);
		objDestino.setEstado(estado);
		objDestino.setCidade(cidade);
		
		DestinoDAO ddao = new DestinoDAO();		
		ddao.save(objDestino);
		
		response.sendRedirect("index.html");
		
		
	}

}
