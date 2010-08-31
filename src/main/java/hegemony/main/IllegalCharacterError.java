package hegemony.main;

public class IllegalCharacterError
{
	private String illegalCharacter;
	private int line;
	private int column;

	public IllegalCharacterError(String illegalCharacter, int line, int column)
	{
		this.illegalCharacter = illegalCharacter;
		this.line = line;
		this.column = column;
	}
	
	public String getIllegalCharacter() {
		return illegalCharacter;
	}
	
	public int getLine() {
		return line;
	}
	
	public int getColumn() {
		return column;
	}
	
}
