package examples;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FormLoader  {
	
	public static String connectionString = "jdbc:hsqldb:file:db-data/teamsandplayers";

	public static void main(String[] args) throws Exception {
		//MainTeamForm form = new MainTeamForm();
		//form.setVisible(true);
		
		MainTeamForm2 form2 = new MainTeamForm2();
		form2.setVisible(true);
	
	}


}
