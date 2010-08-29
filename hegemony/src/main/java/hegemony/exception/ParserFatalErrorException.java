package hegemony.exception;


@SuppressWarnings("serial")
public class ParserFatalErrorException extends Exception
{
	public ParserFatalErrorException(String message)
	{
		super(message);
	}
}
