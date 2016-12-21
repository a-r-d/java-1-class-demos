package examples;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;

import utilities.CListBox;
import utilities.CMessageBox;
import utilities.CUtilities;

public class MainTeamForm2 extends JFrame implements ActionListener, WindowListener {

	JButton btnOpenDbCxn = new JButton("Open Database Connection");
	JButton btnLoadTeamsList = new JButton("Load Teams List");
	CListBox listBoxTeams = null;

	static Connection con;

	public MainTeamForm2() {
		// As part of WindowListener:
		// add yourself to the window listener
		addWindowListener(this);

		setSize(500, 500);
		setTitle("This is an awesome Form!");
		setResizable(false);
		CUtilities.CenterScreen(this);
		// layout Manager is set to null so we can absolutely position
		// everything.
		setLayout(null);

		// add our components
		addOpenDBButton();

		// teams
		addLoadTeamsButton();

		// add listbox
		listBoxTeams = CUtilities.AddListBox(this, 150, 10, 250, 250);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g) {
		// hey, what happens when you don't call super>
		super.paint(g);
		CUtilities.DrawGridMarks(this, g);
	}

	private void addLoadTeamsButton() {
		this.add(btnLoadTeamsList);
		btnLoadTeamsList.setBounds(10, 50, 200, 30);
		btnLoadTeamsList.addActionListener(this);
	}

	public void loadTeamsList() {
		String query = "select * from TTeams";
		try {
			ResultSet rs = con.createStatement().executeQuery(query);
			while(rs.next()) {
				String teamName = rs.getString(2);
				listBoxTeams.AddItemToList(1, teamName, false);
			}
		} catch (Exception e) {
			CMessageBox.Show(e.getMessage(), "SQL Query error");
		}
	}

	public void addOpenDBButton() {
		this.add(btnOpenDbCxn);
		// the button will flow to expand into the entire window unless you kill
		// the layoutManager
		btnOpenDbCxn.setBounds(10, 10, 200, 30);

		btnOpenDbCxn.addActionListener(this);
	}

	public void makeConnection() {
		CUtilities.SetBusyCursor(this, true);
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
		} catch (ClassNotFoundException e) {
			CMessageBox.Show("Error finding hsqldb driver", "Oh No!");
			System.exit(1);
		}

		try {
			// will create DB if does not exist
			// "SA" is default user with hypersql
			con = DriverManager.getConnection(FormLoader.connectionString, "SA", "");
			System.out.println("DB CXN opened");
		} catch (SQLException e) {
			CMessageBox.Show("SQL Exception: " + e.getMessage(), "Fatal SQL error");
		}
		CUtilities.SetBusyCursor(this, false);
	}

	public void closeCxn() {
		if (con == null) {
			return;
		}

		try {
			if (con.isClosed() == true) {
				return;
			}
			con.close();
			System.out.println("DB CXN closed...");
		} catch (Exception error) {
			System.out.println("Error closing connection: " + error.getMessage());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Action performed... " + e.getActionCommand());
		if(e.getSource() == btnLoadTeamsList) {
			loadTeamsList();
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("Window 'activated'");

	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("Window closed.");
		closeCxn();
	}

	@Override
	public void windowClosing(WindowEvent event) {
		System.out.println("Window closing");
		closeCxn();
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("Window deactivated");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("Window opened");
		makeConnection();
	}
}
