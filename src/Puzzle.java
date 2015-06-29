
public class Puzzle 
{
	String word;
	char[] arr;
	public Puzzle(String a)
	{
		if(a == null || a.length() == 0)
		{
			word = " ";
			arr = null;
		}
		else
		{
			word = a;
			arr = new char[a.length()];
			for(int i = 0; i < a.length(); ++i)
			{
				if(Character.isLetter(a.charAt(i)))
				{
					arr[i] = '?';
				}
				else if(Character.isWhitespace(a.charAt(i)))
				{
					arr[i] = ' ';
				}
			}
		}
	}
	public void letsedit(char a)
	{
		for(int i = 0; i < arr.length; ++i)
		{
			if(a == word.charAt(i))
			{
				arr[i] = a;
			}
		}
	}
	public boolean didtheywin()
	{
		for(int i = 0; i < arr.length; ++i)
		{
			if(arr[i] == '?')
			{
				return false;
			}
		}
		return true;
	}
	@Override
	public String toString()
	{
		String b = "";
		for(int i = 0; i < arr.length; ++i)
		{
			b += arr[i];
		}
		return b;
	}
}
