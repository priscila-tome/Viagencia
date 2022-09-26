package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

	public class HotelDAO {
		Connection conn = null;
		PreparedStatement pstm = null;
	
		public void save(Hotel hotel) {
			String sql = "INSERT INTO hotel(nome,endereco,qtd_de_quartos,telefone,email)" + " VALUES(?,?,?,?,?)";
			
			
			try {
				conn = Conexao.createConnectionToMySQL();
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, hotel.getNome());
				pstm.setString(2, hotel.getEndereco());
				pstm.setInt(3, hotel.getQtdDeQuartos());
				pstm.setString(4, hotel.getTelefone());
				pstm.setString(5, hotel.getEmail());
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
		
		public void removeById(int id) {

			
			String sql = "DELETE FROM hotel WHERE id_hotel = ?";
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
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
		
		public void update (Hotel hotel) {
			String sql = "UPDATE hotel SET nome = ?, endereco = ?, qtd_de_quartos = ?, telefone = ?, email = ?" + "WHERE id_hotel = ?";
			
			try {
				conn = Conexao.createConnectionToMySQL();
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, hotel.getNome());
				pstm.setString(2, hotel.getEndereco());
				pstm.setInt(3, hotel.getQtdDeQuartos());
				pstm.setString(4, hotel.getTelefone());
				pstm.setString(5, hotel.getEmail());
				pstm.setInt(6, hotel.getId_hotel());
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
	
		public List<Hotel> getDestinos() {
			
			String sql = "SELECT * FROM hotel";
			
			List<Hotel> hoteis = new ArrayList<Hotel>();
			
			ResultSet rset = null;
			
			try {
				conn = Conexao.createConnectionToMySQL();
				pstm = conn.prepareStatement(sql);
				
				rset = pstm.executeQuery();
				
					while (rset.next()) {
						
						Hotel hotel = new Hotel ();
						
						hotel.setNome(rset.getString("nome"));
						
						hotel.setEndereco(rset.getString("endereco"));
						
						hotel.setQtdDeQuartos(rset.getInt("qtd_de_quartos"));
						
						hotel.setTelefone(rset.getString("telefone"));
						
						hotel.setEmail(rset.getString("email"));
						
						hoteis.add(hotel);
						
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
			
			return hoteis;
			
		}
			
	}
