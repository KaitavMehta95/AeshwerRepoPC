package CommandPattern;
/*
 * We have concrete command classes BuyStock and SellStock implementing Order interface which will do actual command processing. 
 */
public class SellStock implements Order {
	
	private Stock abcStock;

	   public SellStock(Stock abcStock){
	      this.abcStock = abcStock;
	   }

	   public void execute() {
	      abcStock.sell();
	   }
}