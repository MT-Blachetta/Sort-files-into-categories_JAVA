package Application;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import Persistence.Recorder;


public class Model {
	
	
	Matcher strcmp; 
	String[] terms;
	boolean result; 
	
	
	
	public Model ()
	{
		strcmp = new Matcher(new CharbyChar());
		result = false;
	}
	
	public void Start (File sdir, File ddir) throws IOException 
	{
		System.out.println(sdir.toString());
		
		
	
	   
	
		    
		  for(String term : terms)
		  {
			 drecusion(sdir,ddir,term); 
  	      } 
		  
					
						
	}
	
	  
	public void drecusion (File sdir, File ddir, String key) throws IOException
	{
		System.out.println(sdir.toString());
		File[] filelist;
		File root = new File( sdir.getAbsolutePath() ); 
	    filelist = root.listFiles();
	        
		
		
		
		Recorder docfile = new Recorder(ddir, sdir.getName());
		
		
	
	   
	
		    
		 
		    	System.out.println(key);
		   
		    for ( File f : filelist ) 
		    {   
		    	System.out.println(f.toString());
		    	 if(f.exists())
		         {   
		    			if(f.isDirectory())
		    			{
		    				System.out.println("is directory");
		    				drecusion(f,ddir,key);
		    			}
		    			else
		    			{
		            
			                if(strcmp.search(key, f.getName())) 
			                { 
			                	System.out.println("File recognized");
				                	result = true;
				                	try {
										movefile(f, ddir, docfile);
									} catch (IOException e) 
				                	{
										
										e.printStackTrace();   }
				                	
				                	
			                }
		    			
		    			}
		                
		        	}  
		    }
		    
		    return;
		             
		         
		  
					
						
					
	}
	
	public void initialize (File list) throws IOException
	{
       
        
		
		FileReader reader = null;
        ArrayList<String> collector = new ArrayList<String>();
        String test = "";
	
		
		try {
			reader = new FileReader(list);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	    BufferedReader buffer = new BufferedReader (reader);
	    
	    
		    
		    
			try {
		    	// hier ist der Fehler: Nullpointer Exeption
				test = buffer.readLine();
				System.out.println("Line 118");
				System.out.println(test);
				} 
			catch (IOException e) {
				e.printStackTrace();}
				
			System.out.println("Line 124");
		    if(test == null){
		    	System.out.println("Line 126");
		    collector.add("");}
		    System.out.println("Line 128");
		    
		    
		    while(test != null)
		    {
		    	 System.out.println("Line 133");
		         collector.add(test);
		         System.out.println("Line 135");
		         test = buffer.readLine();
		         System.out.println(test);
		    }
		    
		    System.out.println("Line 140");
		    terms = collector.toArray(new String[collector.size()]);
		    System.out.println("ERFOLG initialize (vorläufig)");
		    
			buffer.close();
		
		    reader.close(); 
		    
	}
	
	


public void movefile(File datei, File ziel, Recorder docfile) throws IOException
{
	Path source = datei.toPath();
	Path destin = ziel.toPath();

	Files.move(source, destin.resolve(source.getFileName()),  REPLACE_EXISTING);
	docfile.note(datei.toString(),"move successfull");
}

public void end ()
{
	terms = null;
	result = false;
}



}
