package hegemony.scanner.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import hegemony.scanner.HegemonyScanner;
import hegemony.scanner.UnicodeEscapes;
import hegemony.exception.IllegalCharactersException;
import hegemony.main.OrdersFile;

import cup.*;
import java_cup.runtime.Symbol;

import junit.framework.TestCase;

/**
 * Simple test driver for the java parser. Just runs it on some
 * input files and produces debug output. Needs symbol class from
 * parser. 
 */
public class TestParser extends TestCase {

  private static final String EXPECTED_FILE = "src/test/resources/parser-output.good";
  private static final String OUTPUT_FILE = "target/parser-output.actual";
  private static final String TEST_FILE = "src/test/resources/order_test.txt";

  public void testOutput() throws IOException
  {
    //Prepare stdout
    File actual = new File(OUTPUT_FILE);
    actual.delete();
    FileOutputStream fos = new FileOutputStream(OUTPUT_FILE, true);
    System.setOut(new PrintStream(fos));
    
    //Parse File
    try 
    {
      HegemonyScanner scanner = new HegemonyScanner(new UnicodeEscapes(new FileReader(TEST_FILE)));        
      parser p = new parser(scanner);
      OrdersFile of = (OrdersFile) p.parse().value;
      System.out.println(of.toString());
      System.out.println("No errors.");

    }
    catch (IllegalCharactersException e)
    {
      System.out.println("Illegal character error.");
    }
    catch (Exception e) 
    {
      e.printStackTrace(System.out);
    }

    //End cap. stdout
    fos.close();
    
    //Test Files
    File expected = new File(EXPECTED_FILE);
    assertTrue(expected.isFile());
    assertTrue(actual.isFile());
    
    //Test Lines
    BufferedReader actualContent = new BufferedReader(new FileReader(actual));
    BufferedReader expectedContent = new BufferedReader(new FileReader(expected));
    
    for (int lineNumber =1; lineNumber!=-1; lineNumber++)
    {
      String expectedLine = expectedContent.readLine();
      String actualLine = actualContent.readLine();
      assertEquals("Line " + lineNumber, expectedLine, actualLine);
      if (expectedLine == null) lineNumber = -2; //EOF
    }
  }
}
