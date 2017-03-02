

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AwesomeForm extends JFrame implements ActionListener {

	JButton btnWinOrLose = new JButton("Win Or Lose?");
	JButton btnPointless = new JButton("just a pointless button");
	JLabel lblResult = new JLabel("n/a");
	
	public AwesomeForm() {
		setSize(500, 600);
		setTitle("This is an awesome Form!");
		setResizable(false);
		center();
		// layout Manager is set to null so we can absolutely position everything.
		setLayout(null);
		
		// add our components
		addButton();
		addLabel();
		
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
		btnWinOrLose.setBounds(100, 200, 200, 30);
		btnWinOrLose.addActionListener(this);
		
		
		this.add(btnPointless);
		btnPointless.setBounds(100, 450, 200, 50);
		btnPointless.addActionListener(this);
	}
	
	public void center() {
		Utilities.CenterScreen(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println("Got event");
		System.out.println(event);
		
		if(event.getSource().equals(btnWinOrLose)) {
			System.out.println("Win or lose button was the source");
		}
		
		if(event.getSource().equals(btnPointless)) {
			System.out.println("pointless button was source");
		}
		
		buttonClicked();
		
	}
	
}
