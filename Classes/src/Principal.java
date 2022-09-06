import java.util.Date;

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

		DestinoDAO destinoDAO = new DestinoDAO();

		Destino destino = new Destino(); 
		destino.setPais("Brasil");
		destino.setEstado("Bahia"); 
		destino.setCidade("Salvador");
		  
		destinoDAO.save(destino);
		 

		HotelDAO hotelDAO = new HotelDAO();

		Hotel hotel = new Hotel();
		hotel.setNome("Hotel Verde");
		hotel.setEndereco("Rua do Mar, 432 - Bairro D");
		hotel.setQtdDeQuartos(100);
		hotel.setTelefone("(21) 7463-2482");
		hotel.setEmail("hotelverde@hoteis.com");

		hotelDAO.save(hotel);
		
		VooDAO vooDAO = new VooDAO();

		Voo voo = new Voo();
		voo.setDestino("Disney");
		voo.setData_voo(new Date());
		voo.setCompanhia("Blue");;
		voo.setAeroporto("Aeroporto de Guarulhos");;
		voo.setPortao_de_embarque("09A");

		vooDAO.save(voo);

	}

}
