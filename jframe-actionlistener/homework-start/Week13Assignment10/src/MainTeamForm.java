import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainTeamForm extends JFrame implements ActionListener {

	
	JButton btnOpenDbCxn = new JButton("Open Database Connection");
	JButton btnLoadTeamsList = new JButton("Load Teams List");
	
	public MainTeamForm() {
		setSize(500, 500);
		setTitle("This is an awesome Form!");
		setResizable(false);
		CUtilities.CenterScreen(this);
		// layout Manager is set to null so we can absolutely position everything.
		setLayout(null);
		
		// add our components
		addOpenDBButton();
		
		addLoadTeamsButton();

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void addLoadTeamsButton() {
		this.add(btnLoadTeamsList);
		btnLoadTeamsList.setBounds(10, 50, 200, 30);
		btnLoadTeamsList.addActionListener(this);
	}
	
	public void loadTeamsList() {
		
	}
	
	public void addOpenDBButton() {
		this.add(btnOpenDbCxn);
		// the button will flow to expand into the entire window unless you kill the layoutManager
		btnOpenDbCxn.setBounds(10, 10, 200, 30);
		
		btnOpenDbCxn.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
