
public class Principal {

	public static void main(String[] args) {
	
ClienteDAO clienteDAO = new ClienteDAO();
		
		Cliente cliente = new Cliente();
		cliente.setCpf("123.456.789-11");
		cliente.setNome("Maria");
		cliente.setEndereco("Av XVI, 123 - Bairro L");
		cliente.setTelefone("(11)91234-5678");
		cliente.setEmail("mariazinha@gmail.com");
		cliente.setSenha("12345678");
		clienteDAO.save(cliente);

	}

}
