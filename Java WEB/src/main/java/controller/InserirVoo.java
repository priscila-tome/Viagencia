package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Voo;
import model.VooDAO;


@WebServlet("/InserirVoo")
public class InserirVoo extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String destino = request.getParameter("destino");
		String data = request.getParameter("data");
		String companhiaAerea = request.getParameter("companhia");
		String aeroporto = request.getParameter("aeroporto");
		String portaoEmbarque = request.getParameter("portao");
		
		Voo objVoo =  new Voo();
		
		// guardando os dados do formulario do objeto
		objVoo.setDestino(destino);
		objVoo.setData_voo(data);
		objVoo.setCompanhia(companhiaAerea);
		objVoo.setAeroporto(aeroporto);
		objVoo.setPortao_de_embarque(portaoEmbarque);
		
		// criando um objeto DAO para enviar o objeto Contato para o banco de dados
		// usando o método save da classe ContatoDAO
		VooDAO vdao = new VooDAO();		
		vdao.save(objVoo);
		
		// Redirecionando o usuario para a pagina inicial da aplicação.
		response.sendRedirect("Login.html");
		
		
	}

}
