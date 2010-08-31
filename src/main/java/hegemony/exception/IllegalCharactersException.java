package hegemony.exception;

import hegemony.main.IllegalCharacterError;

import java.util.List;

@SuppressWarnings("serial")
public class IllegalCharactersException extends Exception
{
	private List<IllegalCharacterError> errors;

	public IllegalCharactersException(List<IllegalCharacterError> errors)
	{
		this.errors = errors;
	}
	
	public List<IllegalCharacterError> getErrors() {
		return errors;
	}
	
}
