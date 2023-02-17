package Application;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import GUI.View;

public class Controller 
{
	
	 static File CategoryList, Source, Destination;
	        View v;
	        Model m;
        
        
        
       public Controller(View v, Model m)
        {
        	this.v = v;
        	this.m = m;	
        	ChooseListener cl = new ChooseListener();
        	v.ChooserSource.addActionListener(cl);
        	v.ChooserDestination.addActionListener(cl);
        	v.ChooserTextfile.addActionListener(cl);
        	v.Start.addActionListener(new StartListener());
        	
        }
  //--------------------------------------------------------------------------------------------     
       class ChooseListener implements ActionListener 
       {
    	  public void actionPerformed(ActionEvent e)
    	   {
    		   switch(e.getActionCommand())
    		   {
    		   case "choosertextfile":  
						    		   { JFileChooser chooser = new JFileChooser();
						    		        FileNameExtensionFilter filter = new FileNameExtensionFilter (".txt", "txt");
						    		            chooser.setFileFilter(filter);
						    		            chooser.setAcceptAllFileFilterUsed(false);
						    		   
						    		        int rueckgabeWert = chooser.showOpenDialog(v.Window);
						    		        
						    		      
						    		        if(rueckgabeWert == JFileChooser.APPROVE_OPTION)
						    		        {
						    		             CategoryList = chooser.getSelectedFile();
						    		        	
						    		        	v.textinput.setText(CategoryList.getAbsolutePath());
						    		        }
						    		   }                      break;
						    		   
    		   
    		   case "choosersource": { JFileChooser choos = new JFileChooser();
		        
	       
	        
								        choos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
								        
    		                            choos.setAcceptAllFileFilterUsed(true);
								        int rW = choos.showOpenDialog(v.Window);
								        
								        
								        if(rW == JFileChooser.APPROVE_OPTION)
								        {
								             Source = choos.getSelectedFile();
								        	
								        	v.suchordner.setText(Source.getAbsolutePath());
								        }
									                    
	   
    		                         }               break;
    		   
    		   
    		   
    		   
    		   
    		   
    		   
    		   
    		   
    		   
    		   
    		   case "chooserdestination": { JFileChooser chood = new JFileChooser();
		        
    	       
   	        
										    chood.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
									        chood.setAcceptAllFileFilterUsed(false);
									        int rW = chood.showOpenDialog(v.Window);
									        
									        
									        if(rW == JFileChooser.APPROVE_OPTION)
									        {
									             Destination = chood.getSelectedFile();
									        	
									        	v.categorydir.setText(Destination.getAbsolutePath());
									        }
										                       break;
							
							              }
    		   default: return;
    		   }
    	   }
       }
       
       
       class StartListener implements ActionListener 
       {
    	   public void actionPerformed (ActionEvent e)
    	   {
    		   boolean cond1 = false;
    		   boolean cond2 = false;
    		   boolean cond3 = false;
    		   
    				   if(CategoryList != null && CategoryList.isFile())
    			       cond1 = true;
    		           
    		           if(Source != null && Source.isDirectory())
    		           cond2 = true;
    		           
    		           if(Destination != null && Destination.isDirectory())
    		           cond3 = true;
    		           
    		           if(cond1 && cond2 && cond3)
    		           { 
    		        	   boolean yes = false;
    		        	   String result;
    		        	
    		        	   try {
							m.initialize(CategoryList);
							m.Start(Source, Destination);
							yes = m.result;
							m.end();
						   } 
    		        	   catch (IOException e1) 
    		        	   {
							 JOptionPane.showMessageDialog(
		    		   					v.Window,
		    		   					"Es ist ein Fehler beim Zugriff der Dateien aufgetreten !",
		    		   					"FEHLER",
		    		   					JOptionPane.OK_OPTION
		    		   		        );
							e1.printStackTrace();
						}
    		        	 
    		        	   if (yes)
    		        	   {
    		        		   result = "Übereinstimmungen gefunden !";
    		        	   }
    		        	   else
    		        	   {
    		        		   result = "keine passenden Dateien gefunden";
    		        	   }
    		        	   
    		        	  JOptionPane.showMessageDialog( v.Window,
    		        			  "Aktion erfolgreich ausgeführt:  " + result ,
    		  					"Mitteilung",
    		  					JOptionPane.PLAIN_MESSAGE
    		  		        );
    		           }
    		           else
    		           {
    		        	   JOptionPane.showMessageDialog(
    		   					v.Window,
    		   					"Es sind ungültige Angaben vorhanden !",
    		   					"FEHLER",
    		   					JOptionPane.OK_OPTION
    		   		        );
    		           }
    		   
    			   
    		   
    	   }
       }
       
       class TextConfirmListener implements ActionListener 
       {
    	   public void actionPerformed (ActionEvent e)
    	   {
    	   String s = v.kategorie.getText();
    			  
    	   if (s.isEmpty())
    			   {
    		   JOptionPane.showMessageDialog(
	   					v.Window,
	   					"Bitte mindestens einen Buchstaben angeben !",
	   					"FEHLER",
	   					JOptionPane.OK_OPTION
	   		        );
    			   }
    	   else
    	   {
    		    s = "s";
    	   }
    	  
    	   }
      }
}
