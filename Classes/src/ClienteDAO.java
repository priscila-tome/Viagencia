
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

	public class ClienteDAO {
		Connection conn = null;
		PreparedStatement pstm = null;
	
		public void save(Cliente cliente) {
			String sql = "INSERT INTO cliente(cpf,nome,endereco,telefone,email,senha)" + " VALUES(?,?,?,?,?,?)";
			
			
			try {
				conn = Conexao.createConnectionToMySQL();
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, cliente.getCpf());
				pstm.setString(2, cliente.getNome());
				pstm.setString(3, cliente.getEndereco());
				pstm.setString(4, cliente.getTelefone());
				pstm.setString(5, cliente.getEmail());
				pstm.setString(6, cliente.getSenha());
				pstm.execute();	
			} 
			
			catch (Exception e) {
				e.printStackTrace();
			}
			
			finally {
				
				try {
					
					if (pstm != null) {
						pstm.close();
					}
					
					if (conn != null) {
						conn.close();
					}
				} 
				
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		public void removeById(String cpf) {

			
			String sql = "DELETE FROM cliente WHERE cpf = ?";
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cpf);
			pstm.execute();
			} 
			catch (Exception e) {
			e.printStackTrace();
			} 
			finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				}
				
				catch (Exception e) {
				e.printStackTrace();
				}
			}
		}
		
		public void update (Cliente cliente) {
			String sql = "UPDATE cliente SET nome = ?, endereco = ?, telefone = ?, email = ?, senha = ?" + "WHERE cpf = ?";
			
			try {
				conn = Conexao.createConnectionToMySQL();
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, cliente.getCpf());
				pstm.setString(2, cliente.getNome());
				pstm.setString(3, cliente.getEndereco());
				pstm.setString(4, cliente.getTelefone());
				pstm.setString(5, cliente.getEmail());
				pstm.setString(6, cliente.getSenha());
				pstm.execute();	
			} 
			
			catch (Exception e) {
				e.printStackTrace();
			}
			
			finally {
				
				try {
					
					if (pstm != null) {
						pstm.close();
					}
					
					if (conn != null) {
						conn.close();
					}
				} 
				
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
		}
	
		public List<Cliente> getClientes() {
			
			String sql = "SELECT * FROM cliente";
			
			List<Cliente> clientes = new ArrayList<Cliente>();
			
			ResultSet rset = null;
			
			try {
				conn = Conexao.createConnectionToMySQL();
				pstm = conn.prepareStatement(sql);
				
				rset = pstm.executeQuery();
				
					while (rset.next()) {
						
						Cliente cliente = new Cliente ();
						
						cliente.setCpf(rset.getString("cpf"));
						
						cliente.setNome(rset.getString("nome"));
						
						cliente.setEndereco(rset.getString("endereco"));
						
						cliente.setEmail(rset.getString("email"));
						
						clientes.add(cliente);
						
					}
			}
			
			catch (Exception e) {
				e.printStackTrace();
			}
					
			finally {
						
				try {
							
					if (pstm != null) {
						pstm.close();
					}
							
					if (conn != null) {
						conn.close();
					}
				} 
						
				catch (Exception e) {
				e.printStackTrace();
				}
			}
			
			return clientes;
			
		}
			
	}
