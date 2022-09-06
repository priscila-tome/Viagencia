import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

	public class VooDAO {
		Connection conn = null;
		PreparedStatement pstm = null;
	
		public void save(Voo voo) {
			String sql = "INSERT INTO voo(destino,data_voo,companhia,aeroporto,portao_de_embarque)" + " VALUES(?,?,?,?,?)";
			
			
			try {
				conn = Conexao.createConnectionToMySQL();
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, voo.getDestino());
				pstm.setDate(2, new Date(voo.getData_voo().getTime()));
				pstm.setString(3, voo.getCompanhia());
				pstm.setString(4, voo.getAeroporto());
				pstm.setString(5, voo.getPortao_de_embarque());
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

			
			String sql = "DELETE FROM voo WHERE id_voo = ?";
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
		
		public void update (Voo voo) {
			String sql = "UPDATE voo SET destino = ?, data_voo = ?, companhia = ?, aeroporto = ?, portao_de_embarque = ?" + "WHERE id_voo = ?";
			
			try {
				conn = Conexao.createConnectionToMySQL();
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, voo.getDestino());
				pstm.setDate(2, (Date) voo.getData_voo());
				pstm.setString(3, voo.getCompanhia());
				pstm.setString(4, voo.getAeroporto());
				pstm.setString(5, voo.getPortao_de_embarque());
				pstm.setInt(6, voo.getId_voo());
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
	
		public List<Voo> getDestinos() {
			
			String sql = "SELECT * FROM voo";
			
			List<Voo> voos = new ArrayList<Voo>();
			
			ResultSet rset = null;
			
			try {
				conn = Conexao.createConnectionToMySQL();
				pstm = conn.prepareStatement(sql);
				
				rset = pstm.executeQuery();
				
					while (rset.next()) {
						
						Voo voo = new Voo ();
						
						voo.setDestino(rset.getString("destino"));
						
						voo.setData_voo(rset.getDate("data_voo"));
						
						voo.setCompanhia(rset.getString("companhia"));
						
						voo.setAeroporto(rset.getString("aeroporto"));
						
						voo.setPortao_de_embarque(rset.getString("portao_de_embarque"));
						
						voos.add(voo);
						
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
			
			return voos;
			
		}
			
	}
