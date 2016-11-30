
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AwesomeFormAnonInner extends JFrame{

	JButton btnWinOrLose = new JButton("Win Or Lose?");
	JLabel lblResult = new JLabel("n/a");
	
	public AwesomeFormAnonInner() {
		setSize(500, 500);
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
		
		// ANONYMOUS INNER CLASS!
		btnWinOrLose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonClicked();
			}
		});
	}
	
	public void center() {
		CUtilities.CenterScreen(this);
	}
	
}
