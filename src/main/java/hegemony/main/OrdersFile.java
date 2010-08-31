package hegemony.main;

public class OrdersFile 
{
  OrdersFile orders;           // next list element (optional null)
  HegemonyOrder order;         // Order of this list node

  public OrdersFile(OrdersFile of, HegemonyOrder o) {
    orders=of;
    order=o;
  }

  public OrdersFile(HegemonyOrder o) {
    orders=null;
    order=o;
  }

  public String toString() {
    if (orders!=null)
      return "> "+order+"\n"+orders;
    else 
      return "> "+order.toString()+"\n";
  }

  public int length() {
    if (orders!=null) 
      return 1+orders.length();
    else 
      return 1;
  }
 
}

