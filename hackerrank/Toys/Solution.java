import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String params = in.nextLine();
		String[] params_split = params.split(" ");

		int money = Integer.parseInt(params_split[1]);

		String prices = in.nextLine();
		String[] prices_split = prices.split(" ");
		int[] costs = new int[prices_split.length];
		for (int i = 0; i < prices_split.length; i++) {
			costs[i] = Integer.parseInt(prices_split[i]);
		}
		Arrays.sort(costs);

		int numToys = 0;
		for (int cost : costs) {
			if (money - cost >= 0) {
				money -= cost;
				numToys++;
			} else
				break;
		}

		System.out.println(numToys);
	}
}

