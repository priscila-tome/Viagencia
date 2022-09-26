package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hotel;
import model.HotelDAO;


@WebServlet("/InserirHotel")
public class InserirHotel extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// recebendo os dados do formulario via parametro
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		Integer qtdDeQuartos = Integer.parseInt(request.getParameter("qtdQuartos"));
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		
		// criando o objeto cliente 
		Hotel objHotel =  new Hotel();
		
		// guardando os dados do formulario do objeto
		objHotel.setNome(nome);
		objHotel.setEndereco(endereco);
		objHotel.setQtdDeQuartos(qtdDeQuartos);
		objHotel.setTelefone(telefone);
		objHotel.setEmail(email);
		
		// criando um objeto DAO para enviar o objeto Contato para o banco de dados
		// usando o método save da classe ContatoDAO
		HotelDAO hdao = new HotelDAO();		
		hdao.save(objHotel);
		
		// Redirecionando o usuario para a pagina inicial da aplicação.
		response.sendRedirect("index.html");
		
		
	}

}