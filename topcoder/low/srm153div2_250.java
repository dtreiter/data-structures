public class MostProfitable {
	public String bestItem(int[] costs, int[] prices, int[] sales, String[] items) {
		int numItems = items.length;
		
		int maxProfit = 0;
		int itemSold = -1;
		for (int i = 0; i < numItems; i++) {
			if (sales[i] * (prices[i]-costs[i]) > maxProfit) {
				itemSold = i;
				maxProfit = sales[i] * (prices[i] - costs[i]);
			}
		}
		
		if (itemSold == -1)
			return "";
		else
			return items[itemSold];
	}
}
