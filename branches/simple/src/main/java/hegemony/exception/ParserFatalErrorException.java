package hegemony.exception;

import hegemony.main.ParserFatalError;


@SuppressWarnings("serial")
public class ParserFatalErrorException extends Exception
{
	private ParserFatalError error;
	
	public ParserFatalErrorException(ParserFatalError error)
	{
		this.error = error;
	}
	
	public ParserFatalError getError() {
		return error;
	}
	
}
