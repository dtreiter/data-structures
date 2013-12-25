public class DivisorDigits {
	public int howMany(int number) {
		int cnt = 0;
		
		String numstr = ((Integer)number).toString();
		for (char num : numstr.toCharArray()) {
			int div = Character.getNumericValue(num);
			if (div != 0) {
				if (number % div == 0)
					cnt++;
			}
		}
		return cnt;
	}
}
