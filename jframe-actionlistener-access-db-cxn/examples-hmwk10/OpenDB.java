import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OpenDB {

	public static void main(String[] args) throws Exception {

		String cxn = "jdbc:ucanaccess://" + System.getProperty("user.dir") + 
				"\\database\\TeamsAndPlayers1.accdb";
		
		
		Connection connection = DriverManager.getConnection(cxn);
		
		assert connection != null;
		System.out.println("Done opening db");
		
		
		String selectAll = "SELECT strTeam FROM TTeams ORDER BY strTeam";
		Statement cmd = connection.createStatement();
		ResultSet rs = cmd.executeQuery(selectAll);
		
		while(rs.next()) {
			String teamName = rs.getString(1);
			System.out.println("------> " + teamName);
		}
		
		// close this when transaction is done
		rs.close();
		cmd.close();
		
		// close this when app closes
		connection.close();
		System.out.println("DB closed up");
	}

}
