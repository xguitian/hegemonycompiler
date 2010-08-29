package hegemony.main;

import hegemony.scanner.HegemonySymbol;

public class ParserFatalError
{
	private int line;
	private int column;

	public ParserFatalError(HegemonySymbol symbol)
	{
		this.line = symbol.getLine();
		this.column = symbol.getColumn();
	}
	
	public int getLine() {
		return line;
	}
	
	public int getColumn() {
		return column;
	}
	
}
