
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AwesomeFormWithEvents extends JFrame implements ActionListener {

	JButton btnWinOrLose = new JButton("Win Or Lose?");
	JButton btnYesOrNo = new JButton("Yes or NO?");
	JLabel lblResult = new JLabel("n/a");
	
	public AwesomeFormWithEvents() {
		setSize(500, 500);
		setTitle("This is an awesome Form!");
		setResizable(false);
		center();
		// layout Manager is set to null so we can absolutely position everything.
		setLayout(null);
		
		// add our components
		addButton();
		addLabel();
		addButton2();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void buttonClicked() {
		double res = Math.random();
		System.out.println("Math result: " + res);
		
		if(res > 0.5) {
			lblResult.setText("Winner!");
		} else {
			lblResult.setText("Sorry you lost!");
		}
	}
	
	public void addLabel() {
		this.add(lblResult);
		lblResult.setBounds(100, 350, 300, 30);
	}
	
	public void addButton() {
		this.add(btnWinOrLose);
		// the button will flow to expand into the entire window unless you kill the layoutManager
		btnWinOrLose.setBounds(100, 100, 200, 30);
		
		btnWinOrLose.addActionListener(this);
	}
	
	public void addButton2() {
		this.add(btnYesOrNo);
		btnYesOrNo.setBounds(100, 200, 150, 30);
		
		btnYesOrNo.addActionListener(this);
	}
	
	public void center() {
		Utilities.CenterScreen(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Action event: " + 
				arg0.getActionCommand() + 
				" " + arg0.getSource());
	}
	
}
