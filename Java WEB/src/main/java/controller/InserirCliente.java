package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import model.ClienteDAO;


@WebServlet("/InserirCliente")
public class InserirCliente extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// recebendo os dados do formulario via parametro
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String endereco = request.getParameter("endereco");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		
		
		// criando o objeto cliente 
		Cliente objCliente =  new Cliente();
		
		// guardando os dados do formulario do objeto
		objCliente.setNome(nome);
		objCliente.setCpf(cpf);
		objCliente.setEndereco(endereco);
		objCliente.setTelefone(telefone);
		objCliente.setEmail(email);
		objCliente.setSenha(senha);
		
		// criando um objeto DAO para enviar o objeto Contato para o banco de dados
		// usando o método save da classe ContatoDAO
		ClienteDAO cdao = new ClienteDAO();		
		cdao.save(objCliente);
		
		// Redirecionando o usuario para a pagina inicial da aplicação.
		response.sendRedirect("Login.html");
		
		
	}

}
