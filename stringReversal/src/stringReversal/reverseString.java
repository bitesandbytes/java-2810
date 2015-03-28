package stringReversal;
/**
 * @author Sauce (CS13B056)
 * CS2810- File Reading Assignment
 */
import java.io.*;
import java.util.Stack;

public class reverseString
{
	public static void main(String[] args) throws FileNotFoundException
	{
		BufferedReader in = null;
		try
		{
			in = new BufferedReader(new FileReader("inputFile.txt"));
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("No such file found.");
			System.exit(-1);
		}
		PrintWriter outObject = new PrintWriter("outputFile.txt");
		String line = null;
		try
		{
			while((line = in.readLine()) != null)
			{
				processLine(line, outObject);
				outObject.flush();
			}
			outObject.close();
		}
		catch(IOException ex)
		{
			
		}
	}
	
	
	private static void processWord(String word, PrintWriter out)
	{
		//System.out.println("Word is "+word+"\n");
		//out.write("Word is "+word+"\n");
		if(word.endsWith("."))
		{
			word = word.substring(0, word.indexOf("."));
			out.write("."+word);
			System.out.print("."+word);
		}
		else if(word.endsWith("?"))
		{
			word = word.substring(0, word.indexOf("?"));
			out.write("?"+word);
			System.out.print("?"+word);
		}
		else if(word.endsWith("!"))
		{
			word = word.substring(0, word.indexOf("!"));
			out.write("!"+word);
			System.out.print("!"+word);
		}
		else if(word.endsWith(";"))
		{
			word = word.substring(0, word.indexOf(";"));
			out.write(";"+word);
			System.out.print(";"+word);
		}
		else if(word.endsWith(","))
		{
			word = word.substring(0, word.indexOf(","));
			out.write(","+word);
			System.out.print(","+word);
		}
		else if(word.endsWith(":"))
		{
			word = word.substring(0, word.indexOf(":"));
			out.write(":"+word);
			System.out.print(":"+word);
		}
		else
		{
			out.write(" "+word);
			System.out.print(" "+word);
		}
		
	}
	
	public static void processLine(String s, PrintWriter out) 
	{
		Stack<String> stack = new Stack<String>();
		Stack<String> wordStack = new Stack<String>();
		boolean endsWithPunctuation = false;
		String endingPunctuation = null;
		boolean isLastWordProcessed = false;
		String word;
		//Push all string splits into a stack.
		for( String temp:s.split(" "))
			stack.push(temp);
		
		word = stack.pop();
		if(word.endsWith("."))
		{
			isLastWordProcessed = true;
			endingPunctuation = ".";
			endsWithPunctuation = true;
			word = word.substring(0, word.indexOf("."));
		}
		else if(word.endsWith("!"))
		{
			isLastWordProcessed = true;
			endingPunctuation = "!";
			endsWithPunctuation = true;
			word = word.substring(0, word.indexOf("!"));
		}
		else if(word.endsWith("?"))
		{
			isLastWordProcessed = true;
			endingPunctuation = "?";
			endsWithPunctuation = true;
			word = word.substring(0, word.indexOf("?"));
		}
		stack.push(word);
		while(stack.isEmpty()==false)
		{
			word = stack.pop();
			if(word.endsWith("\""))
			{
				while(stack.isEmpty()==false && (word.startsWith("\"")==false))
				{
					wordStack.push(word);
					word = stack.pop();
				}
				wordStack.push(word);
				while(wordStack.isEmpty()==false)
				{
					word = wordStack.pop();
					processWord(word, out);
				}
			}
			else
			{
				processWord(word, out);
			}
		}
		if(endsWithPunctuation)
		{
			out.write(endingPunctuation+"\n");
			System.out.print(endingPunctuation+"\n");
		}
		
	}
}
