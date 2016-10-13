package forms;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SimpleForm extends JFrame {

	int width = 300;
	int height = 200;
	JButton button = null;
	
	public SimpleForm() {
		
		setTitle("This is a simple form");
		setSize(width, height);
		
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		addBtn("A button");
	}
	
	public void addBtn(String name) {
		button = new JButton(name);
		button.setVisible(true);
		button.setSize(100, 50);
		button.setLocation(50, 25);
		
		this.add(button);
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
		setSize(width, height);
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
		setSize(width, height);
	}
	
	
}
