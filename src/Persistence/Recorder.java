package Persistence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Recorder 
{
	
	
	PrintWriter printer;
	File report;

	public Recorder (File doc, String Name) throws IOException
	{
		int num = 2;
		report = new File(doc.getAbsolutePath() + "/" + "report of " + Name + ".txt");
		
		while  (report.exists())
		{
			
	     report = new File(doc.getAbsolutePath() + "/" + "report of " + Name + num + ".txt");
	     num++;
	     
	    }
		
		report.createNewFile();
		printer = new PrintWriter(new FileWriter(report, true), true);
		
	}
	
	public void note (String m, String b) 
	{
		printer.println(" ");
		printer.println(m);
		printer.println(b);
		printer.println(" ");
		
	}

}
