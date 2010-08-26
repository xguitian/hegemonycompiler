package hegemony.exception;

@SuppressWarnings("serial")
public class IllegalCharacterException extends Exception
{
	private String illegalCharacter;
	private int line;
	private int column;

	public IllegalCharacterException(String illegalCharacter, int line, int column)
	{
		super("Illegal character \"" + illegalCharacter + "\" at line " + line +
				", column "+ column);
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
