
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

	public class DestinoDAO {
		Connection conn = null;
		PreparedStatement pstm = null;
	
		public void save(Destino destino) {
			String sql = "INSERT INTO destino(pais,estado,cidade)" + " VALUES(?,?,?)";
			
			
			try {
				conn = Conexao.createConnectionToMySQL();
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, destino.getPais());
				pstm.setString(2, destino.getEstado());
				pstm.setString(3, destino.getCidade());
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

			
			String sql = "DELETE FROM destino WHERE id_destino = ?";
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
		
		public void update (Destino destino) {
			String sql = "UPDATE destino SET pais = ?, estado = ?, cidade = ?" + "WHERE id_destino = ?";
			
			try {
				conn = Conexao.createConnectionToMySQL();
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, destino.getPais());
				pstm.setString(2, destino.getEstado());
				pstm.setString(3, destino.getCidade());
				pstm.setInt(4, destino.getId_destino());
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
	
		public List<Destino> getDestinos() {
			
			String sql = "SELECT * FROM destino";
			
			List<Destino> destinos = new ArrayList<Destino>();
			
			ResultSet rset = null;
			
			try {
				conn = Conexao.createConnectionToMySQL();
				pstm = conn.prepareStatement(sql);
				
				rset = pstm.executeQuery();
				
					while (rset.next()) {
						
						Destino destino = new Destino ();
						
						destino.setPais(rset.getString("pais"));
						
						destino.setEstado(rset.getString("estado"));
						
						destino.setCidade(rset.getString("cidade"));
						
						destinos.add(destino);
						
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
			
			return destinos;
			
		}
			
	}