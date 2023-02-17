package Application;

public class Matcher {

	private Algorithm Methode;
	
	public Matcher (Algorithm X)
	{
		Methode = X;
	}
	
	public boolean search (String s, String d)
	{
		boolean found = Methode.stringmatch(s, d);
		return found;
	}
}
