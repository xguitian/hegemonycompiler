package hegemony.scanner;

import java.io.*;
import cup.parser;
import hegemony.main.OrdersFile;

/**
 * Simple test driver for the Hegemony parser. Just runs it on some
 * input files, gives no useful output.
 */
public class HegemonyParser
{

	public static void main(String argv[]) 
	{

		for (int i = 0; i < argv.length; i++)
		{
      		try 
			{
        		System.out.println("Parsing ["+argv[i]+"]");
        		HegemonyScanner s = new HegemonyScanner(new UnicodeEscapes(new FileReader(argv[i])));
        		parser p = new parser(s);
				OrdersFile of;
				of = (OrdersFile) p.parse().value;
        
        		System.out.println("No errors.");

				System.out.println("Hegemony orders dump:");
				System.out.println(of.toString());
			}
			catch (Exception e) 
			{
        		e.printStackTrace(System.out);
        		System.exit(1);
      		}
		}
	}
}

