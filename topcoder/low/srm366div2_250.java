public class SerialNumbers {
	public String[] sortSerials(String[] serialNumbers) {
		
		Boolean swapped = true;
		while (swapped) {
			swapped = false;
			for (int i = 0; i < serialNumbers.length-1; i++) {
				if (serialNumbers[i].length() > serialNumbers[i+1].length()) {
					String tmp = new String(serialNumbers[i]);
					serialNumbers[i] = serialNumbers[i+1];
					serialNumbers[i+1] = tmp;
					swapped = true;
				} else if (serialNumbers[i].length() == serialNumbers[i+1].length() && sumOfDigits(serialNumbers[i]) > sumOfDigits(serialNumbers[i+1])) {
					String tmp = new String(serialNumbers[i]);
					serialNumbers[i] = serialNumbers[i+1];
					serialNumbers[i+1] = tmp;
					swapped = true;
				} else if (serialNumbers[i].length() == serialNumbers[i+1].length() && sumOfDigits(serialNumbers[i]) == sumOfDigits(serialNumbers[i+1]) && compareAlpha(serialNumbers[i], serialNumbers[i+1])) {
					String tmp = new String(serialNumbers[i]);
					serialNumbers[i] = serialNumbers[i+1];
					serialNumbers[i+1] = tmp;
					swapped = true;
				}
			}
		}
		
		return serialNumbers;
	}
	
	static Boolean compareAlpha(String s0, String s1) {
		if (s0.length() != s1.length())
			return false;
		for (int i = 0; i < s0.length(); i++) {
			if ((int)s0.charAt(i) > (int)s1.charAt(i)) {
				return true;
			} else if ((int)s0.charAt(i) < (int)s1.charAt(i)) {
				return false;
			}
		}
		return false;
	}
	
	int sumOfDigits(String serial) {
		int sum = 0;
		for (int i = 0; i < serial.length(); i++) {
			if ((int)serial.charAt(i) >= (int)'0' && (int)serial.charAt(i) <= (int)'9') {
				sum += Character.getNumericValue(serial.charAt(i));
			}
		}
		return sum;
	}

}
