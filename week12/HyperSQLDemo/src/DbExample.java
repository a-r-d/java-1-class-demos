import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class DbExample {

    static Connection con;
    
    // What is JDBC ?? Java Database Connectivity API (Application Programming Interface)
    // ---> https://docs.oracle.com/javase/tutorial/jdbc/overview/
    // JDBC is an API that enables us to talk to many different types of data stores.
    // anything under java.sql is part of JDBC
    // jdbc protocol - hsqldb type - file type - path to resource
    static String connectionString = "jdbc:hsqldb:file:db-data/mydatabase";
    
	public static void main(String[] args) throws Exception {
	    
		String createContacts = readToString("sql/contacts.sql");
		String populateContacts = readToString("sql/populate-contacts.sql");
		
		System.out.println("Attempting to create contacts DB ... ");
		
		
		// this loads the DB driver
		// explained here: http://stackoverflow.com/questions/5992126/loading-jdbc-driver
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
		} catch (ClassNotFoundException e) {
			throw e;
		}
		
		try {
			// will create DB if does not exist
			// "SA" is default user with hypersql
			con = DriverManager.getConnection(connectionString, "SA", "");
			
			// create table
			con.createStatement()
					.executeUpdate(createContacts);
			
			// add contacts
			con.createStatement()
					.executeUpdate(populateContacts);
			
			// select everything
			PreparedStatement pst = con.prepareStatement("select * from contacts");
	        pst.clearParameters();
	        ResultSet rs = pst.executeQuery();
	        
	        List<Contact> contacts = new ArrayList<>();
	        while(rs.next()){
	        	contacts.add(new Contact(
	        			rs.getString(1), 
	        			rs.getString(2), 
	        			rs.getString(3)
	        		)
    			);
	        }
			
	        for(Contact c : contacts) {
	        	System.out.println(c);
	        }
	        
		} catch (SQLException e) {
			throw e;
		} finally {
			con.close();
		}
	}
	
	public static String readToString(String fname) throws Exception {
		File file = new File(fname);
		String string = FileUtils.readFileToString(file, "utf-8");
		return string;
	}
	
	
}
