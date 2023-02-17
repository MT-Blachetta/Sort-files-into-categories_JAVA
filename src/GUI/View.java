package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class View 
{
	
	public JFrame Window;
	public JButton Create, ChooserTextfile, ChooserDestination, ChooserSource, Next, Start;
	public JTextField textinput, categorydir, suchordner, kategorie;
	public JDialog enterfilename;
	
	enum Modus {Standard,NewFile};
	
	public View ()
	{    
		Window = new JFrame("Kategorisieren Suchen Ordnen");
		Create = new JButton("Neue Kategorie anlegen");
		ChooserTextfile = new JButton("Suchbegriffsliste wählen");
		ChooserDestination = new JButton ("Kategorie aussuchen");
		ChooserSource = new JButton ("Suchverzeichnis wählen");
		Next = new JButton("next");
		Start = new JButton("START");
		textinput = new JTextField();
		categorydir = new JTextField();
		suchordner = new JTextField();
		
		kategorie = new JTextField();
		enterfilename = new JDialog();
		
		
		
		//Platzierung der Komponenten
		
	    Window.setSize(920, 610);
		
	    //Buttons
	    
	    Create.setBounds(50, 55, 200, 75);
		ChooserTextfile.setBounds(50, 275, 200, 75);
		ChooserDestination.setBounds(50, 365, 200, 75);
		ChooserSource.setBounds(50, 455, 200, 75);
		Next.setBounds(350, 155, 150, 75);
		Start.setBounds(50, 155, 200, 75);
		
		//TextFields
		
		textinput.setBounds(300, 290, 580, 50);
		categorydir.setBounds(300, 380, 580, 50);
		suchordner.setBounds(300, 470, 580, 50);
		
		textinput.setText("textinput");
		categorydir.setText("categorydir");
		suchordner.setText("suchordner");
		
		
		
		
		kategorie.setBounds(300, 55, 300, 75);
	    
	    //Design
		
		//Font A = new Font ("Serif", Font.BOLD,10);
		Font B = new Font ("Serif", Font.BOLD,30);
		//Font C = new Font ("Serif", Font.BOLD,10);
		
		
		kategorie.setFont(B);
		
		//Anfangszustand
		textinput.setEditable(false);
		categorydir.setEditable(false);
		suchordner.setEditable(false);
		kategorie.setEditable(false);
		
		Next.setEnabled(false);
		
		Create.setActionCommand("create");
		ChooserTextfile.setActionCommand("choosertextfile");
		ChooserSource.setActionCommand("choosersource");
		ChooserDestination.setActionCommand("chooserdestination");
		Next.setActionCommand("next");
		//erweitertes Design
		//textinput.setAlignmentX(arg0);
		//textinput.setAlignmentY(arg0);
	    
	    //Fenster initialisieren
	    
		Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Window.setVisible(true);
		Window.setLocationRelativeTo(null);
		Window.setLayout(null);
		Window.getContentPane().setBackground(Color.WHITE);
		Window.getContentPane().add(Create);
		Window.getContentPane().add(ChooserTextfile);
		Window.getContentPane().add(ChooserSource);
		Window.getContentPane().add(ChooserDestination);
		Window.getContentPane().add(Next);
		Window.getContentPane().add(Start);
		Window.getContentPane().add(kategorie);
		Window.getContentPane().add(textinput);
		Window.getContentPane().add(categorydir);
		Window.getContentPane().add(suchordner);
		
		
		
	}

}
