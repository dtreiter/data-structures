import java.util.*;

public class YahtzeeScore {
	public int maxPoints(int[] toss) {
		HashMap <Integer, Integer> nums = new HashMap <Integer, Integer> ();
		for (int die : toss) {
			if (nums.get(die) != null) {
				nums.put(die, nums.get(die) + 1);
			} else {
				nums.put(die, 1);
			}
		}
		
		int max = 0;
		for (int die : toss) {
			int score = die * nums.get(die);
			if (score > max) {
				max = score;
			}
		}
		
		return max;
	}
}
