import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FormLoader {
	
	public static String connectionString = "jdbc:hsqldb:file:db-data/teamsandplayers";
	static Connection con;

	public static void main(String[] args) throws Exception {
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
		} catch (ClassNotFoundException e) {
			throw e;
		}
		
		
		MainTeamForm form = new MainTeamForm();
		form.setVisible(true);
		
		try {
			// will create DB if does not exist
			// "SA" is default user with hypersql
			con = DriverManager.getConnection(connectionString, "SA", "");
			
			
			
			
	        
		} catch (SQLException e) {
			throw e;
		} finally {
			con.close();
			System.out.println("Program complete");
		}
		
		
		
	}


}
