class StringToLong {
	static Long stringToLong(String s) {
		if (s.length() == 0) // empty string
			return null;
		
		byte[] sData = s.getBytes();
		byte asciiOffset = 48;
		Long result = 0l;
		boolean negative = false;

		for (int i = 0; i < sData.length; i++) {
			byte digit = sData[i];
			if (digit != 45 && (digit < 48 || digit > 57)) // invalid input
				return null;
			if (digit == 45) { // negative sign
				if (i != 0) // negative sign in middle of string
					return null;
				if (i == 0 && sData.length == 1) // just negative sign with no numbers
					return null;
				if (i == 0 && sData.length > 1)
					negative = true;
			} else {
				digit -= asciiOffset;
				result = result*10 + digit;
			}
		}
		
		if (negative)
			result = ~result + 1;

		return result;
	}

	public static void main(String args[]) {
		// some test cases
		assert (stringToLong("123") == 123) : "Assertion 0 failed";
		assert (stringToLong("000") == 0) : "Assertion 1 failed";
		assert (stringToLong("-23") == -23) : "Assertion 2 failed";
		assert (stringToLong("") == null) : "Assertion 3 failed";
		assert (stringToLong("--23") == null) : "Assertion 4 failed";
		assert (stringToLong("abc: ") == null) : "Assertion 5 failed";
		assert (stringToLong("2-3") == null) : "Assertion 6 failed";
		assert (stringToLong("-") == null) : "Assertion 6 failed";

		System.out.println("All assertions passed!");
	}
}
