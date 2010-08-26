package hegemony.scanner;

import java_cup.runtime.*;
import cup.sym;
import hegemony.exception.IllegalCharacterException;

%%

%public
%class HegemonyScanner
%implements sym

%unicode

%line
%column

%cup
%cupdebug

%yylexthrow IllegalCharacterException 

%{
	StringBuffer string = new StringBuffer();
  
	private Symbol symbol(int type)
	{
 		return new HegemonySymbol(type, yyline+1, yycolumn+1);
	}

  	private Symbol symbol(int type, Object value)
  	{
    	return new HegemonySymbol(type, yyline+1, yycolumn+1, value);
  	}

	private void reportError(String illegalCharacter, int line, int column)
		throws IllegalCharacterException
	{
		throw new IllegalCharacterException(illegalCharacter, line, column);
	}
%}

/* main character classes */
LineTerminator = \r|\n|\r\n
WhiteSpace = [ \t\f]
UpperLetter = [A-ZÑÁÉÍÓÚ]
LowerLetter = [a-zñáéíóú]

/* identifiers */
Word = {UpperLetter}?{LowerLetter}+
Number = [0-9]+

/* hegemony character tokens */
Army = E
Navy = F
Move = M
Support = A
PoliticPoints = PP
DeclareWar = G
DeclarePeace = P

%%

/* hegemony symbols */
{Army}						{ return symbol(ARMY); }
{Navy}						{ return symbol(NAVY); }
{Move}						{ return symbol(MOVE); }
{Support}					{ return symbol(SUPPORT); }
{PoliticPoints}				{ return symbol(POLITIC_POINTS); }
{DeclareWar}				{ return symbol(DECLARE_WAR); }
{DeclarePeace}				{ return symbol(DECLARE_PEACE); }

/* names and numbers */
{Word}						{ return symbol(WORD, new String(yytext())); }
{Number}					{ return symbol(NUMBER, new Integer(yytext())); }

/* whitespace */
{WhiteSpace}                   	{ /* ignore */ }

/* end of line */
{WhiteSpace}*{LineTerminator}				{ return symbol(EOL); }

/* error fallback */
.|\n                             { reportError(yytext(), yyline + 1, yycolumn + 1); }
<<EOF>>                          { return symbol(EOF); }