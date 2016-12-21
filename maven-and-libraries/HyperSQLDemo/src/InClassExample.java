import java.sql.Connection;
import java.sql.DriverManager;

public class Connect2DB {
	
	static String connectionString = "jdbc:hsqldb:file:db-data/mydatabase";

	public static void main(String[] args) throws Exception {

		Connection con = null;
		
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
		} catch (ClassNotFoundException e) {
			throw e;
		}
		System.out.println("Driver done loading");
		
		try {
			
			con = DriverManager.getConnection(connectionString, "SA", "");
			
			con.createStatement().executeQuery("create table if not exists " +
					" contacts (name varchar(45),email varchar(45),phone varchar(45));");
			
			con.createStatement().executeQuery("insert into contacts" +
					" values ('joe','test@tst.com','12345');");
			
			
		} catch(Exception e) {
			throw e;
		} finally {
			if(con != null) {
				con.close();
			}
			System.out.println("All work done");
		}
		
		
	}

}
