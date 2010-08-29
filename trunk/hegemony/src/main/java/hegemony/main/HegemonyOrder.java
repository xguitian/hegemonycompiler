package hegemony.main;

public class HegemonyOrder
{
	public enum Unit
	{
		ARMY ("E"), NAVY ("F");
		
		private final String symbol;
		
		Unit(String symbol)
		{
			this.symbol = symbol;
		}
		
		public String symbol() { return symbol; }
	}
	
	public enum OrderType
	{
		MOVE ("M"), SUPPORT ("A"), POLITIC_POINTS ("PP"), DECLARE_WAR ("G"), DECLARE_PEACE ("P");
	
		private final String symbol;
		
		OrderType(String symbol)
		{
			this.symbol = symbol;
		}
		
		public String symbol() { return symbol; }
	}
	
	public enum ErrorType
	{
		VALID_ORDER, WRONG_ORDER_TYPE, MISSING_UNIT, MISSING_TARGET, MISSING_AMOUNT, MISSING_SOURCE
	}
	
	private OrderType orderType;
	private Unit unit = null;
	private String source = null;
	private String target = null;
	private Integer amount = null;
	private int line;
	private ErrorType errorType;

  	public HegemonyOrder(OrderType orderType, Unit unit, String source, String target, ErrorType errorType)
	{
		this.orderType = orderType;
		this.unit = unit;
		this.source = source;
		this.target = target;
		this.errorType = errorType;
	}

  	public HegemonyOrder(OrderType orderType, String target, ErrorType errorType)
	{
		this.orderType = orderType;
		this.target = target;
		this.errorType = errorType;
	}

  	public HegemonyOrder(OrderType orderType, String target, Integer amount, ErrorType errorType)
	{
		this.orderType = orderType;
		this.target = target;
		this.amount = amount;
		this.errorType = errorType;
	}

	public OrderType getOrderType()
	{
		return orderType;
	}
	
	public Unit getUnit()
	{
		return unit;
	}
	
	public String getSource()
	{
		return source;
	}
	
	public String getNormalizedSource()
	{
		return Util.normalizeName(source);
	}
	
	public String getTarget()
	{
		return target;
	}
	
	public String getNormalizedTarget()
	{
		return Util.normalizeName(target);
	}
	
	public Integer getAmount()
	{
		return amount;
	}
	
  	public int getLine()
	{
    	return line;
  	}
  	
  	public HegemonyOrder setLine(int line)
  	{
  		this.line = line;
  		return this;
  	}
  	
  	public ErrorType getErrorType()
  	{
  		return errorType;
  	}

  	public String toString()
	{   
    	return "line "+line+", order type: "+orderType+(unit == null ? "" : (", unit: '"+unit+"'"))
			+(source == null ? "" : (", source: '"+source+"'"))+(target == null ? "" : (", target: '"+target+"'"))
			+(amount == null ? "" : (", amount: '"+amount+"'"));
  	}
  	
  	public String prettyPrintEsp()
  	{
  		return "Linea " + line + ": (" + (unit == null ? "" : unit.symbol + " " )
		+ (source == null ? "" : source + " ") + orderType.symbol + " " + (amount == null ? "" : amount + " ")
		+ (target == null ? "" : target) + ")";
  	}
}
