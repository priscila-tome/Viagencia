import java.sql.Connection;
import java.sql.DriverManager;

	public class Conexao {
		
		private static final String USERNAME = "root";

		private static final String PASSWORD = "678Priscila";
	
		private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/viagencia";
		
		public static Connection createConnectionToMySQL() throws Exception {
		
		Connection connection = DriverManager.getConnection(DATABASE_URL,USERNAME, PASSWORD);
		return connection;
		
		}
}
