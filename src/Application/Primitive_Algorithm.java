package Application;

public class Primitive_Algorithm implements Algorithm {
	
	
	public boolean stringmatch(String key, String title)
	
	{  //hier ist der Fehler Nullpointer Exeption
		if(key.isEmpty()||title.isEmpty())
			return false;
			
		char[] key_sequence = key.toCharArray();
		char[] title_sequence = title.toCharArray();
		int key_lenght = key_sequence.length ;
		int title_length = title_sequence.length;
		int counter = 0;
		
		while ((counter + key_lenght - 1) < title_length)
		{ 
			if (area_equals(key_sequence, title_sequence, counter ))
				return true;
		     counter++;
		     
		}
		return false;
	} 
 
	static public boolean area_equals (char[] a, char[] b, int offset) 
	{ 
		int endindex = a.length;
	    
		int suchindex = b.length;
		
	    if (offset >= suchindex)
			return false;
		
		
		
		
		for(int pointer = 0; pointer < endindex; pointer++)
		{ 
			if (a[pointer] != b[offset + pointer])
			return false;
			
		}
			
		return true;
		}

}
