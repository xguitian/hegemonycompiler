package hegemony.scanner;

import java.io.*;
import java_cup.runtime.Symbol;


/**
 * Simple test driver for the java lexer. Just runs it on some
 * input files and produces debug output. Needs symbol class from
 * parser. 
 */
public class TestLexer {

  public static void main(String argv[]) {

    for (int i = 0; i < argv.length; i++) {
      try {
        System.out.println("Lexing ["+argv[i]+"]");
        HegemonyScanner scanner = new HegemonyScanner(new UnicodeEscapes(new FileReader(argv[i])));
                
        Symbol s;
        do {
          s = scanner.debug_next_token();
          System.out.println("token: "+s);
        } while (s.sym != sym.EOF);
        
        System.out.println("No errors.");
      }
      catch (Exception e) {
        e.printStackTrace(System.out);
        System.exit(1);
      }
    }
  }
}
