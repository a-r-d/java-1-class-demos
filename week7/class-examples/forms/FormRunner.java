package forms;

import exceptions.CUtilities;

public class FormRunner {

	public static void main(String[] args) {

		System.out.println("About to create a form");
		SimpleForm form = new SimpleForm();
		System.out.println("Form was instatiated");
		
		//form.addBtn("ultimate button");
		
		form.setVisible(true);
		CUtilities.CenterScreen(form);
		
		
	}

}
