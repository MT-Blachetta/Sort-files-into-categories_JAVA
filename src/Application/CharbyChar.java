package Application;

public class CharbyChar implements Algorithm {
	
	private static final char terminator = '|';
	
public boolean stringmatch(String key, String title)
	
	{   // hier ist der Fehler NullpointerExeption
		if(key.isEmpty()|title.isEmpty())
			return false;
		
		
		String checkstring = title + terminator;
		
		int key_length = key.length();
		
		int counter = 0;
		int keypos = 0;
		
		while (true)
		{ 
			if (keypos == key_length)
			return true;
			
			//Termination
			if (checkstring.charAt(counter) == terminator)
				return false;
			
			if(key.charAt(keypos) == title.charAt(counter))
			{ 
				if(checkstring.charAt(counter+1) != terminator && (keypos < key_length - 1))
				{
				
					if (key.charAt(keypos+1) == title.charAt(counter+1))
					{
					keypos++;
					}
					else{
					keypos = 0;
					}
					
				}
				
				else
				{
				keypos++;
				}
				
				
			}
			else
			{
				keypos = 0;
			}
			
			
			
			
		     counter++;
		     
		}
		
	} 
 



}
