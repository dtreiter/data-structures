public class FormatAmt {
	public String amount(int dollars, int cents) {
		String dolrev = new StringBuffer(((Integer)dollars).toString()).reverse().toString();
		String result = "";
		for (int i = 0; i < dolrev.length(); i++) {
			if (i % 3 == 0 && i != 0) {
				result += "," + dolrev.charAt(i);
			} else {
				result += dolrev.charAt(i);
			}
		}
		result = "$" + new StringBuffer(result).reverse().toString();
		if (cents < 10) {
			result += ".0" + cents;
		} else {
			result += "." + cents;
		}
		
		return result;
	}
}
