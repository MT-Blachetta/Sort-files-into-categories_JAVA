package GUI;

import javax.swing.SwingUtilities;

import Application.Controller;
import Application.Model;

public class Start {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() 
		{
			
			public void run()
			
			{   Model app = new Model();
			    View gui = new View();
				Controller C = new Controller(gui, app);
			}
		
		}   );

	}

}
