public class ProfitCalculator {
	public int percent(String[] items) {
		double cost = 0;
		double price = 0;
		
		for (String trans : items) {
			price += Double.parseDouble(trans.split(" ")[0]);
			cost += Double.parseDouble(trans.split(" ")[1]);
		}
		
		double margin = 100*(price-cost) / price;
		return (int)margin;
	}
}
