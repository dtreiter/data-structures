public class BinaryCode {
	public String[] decode(String message) {
		String[] result = getDecrypted(message);
		String first = result[0];
		String second = result[1];
		
		if (message.length() > 1) {
			// check work
			int p0, p1;
			int q = Character.getNumericValue(message.charAt(message.length() - 1));
			
			p0 = Character.getNumericValue(result[0].charAt(result[0].length() - 1));
			p1 = Character.getNumericValue(result[0].charAt(result[0].length() - 2));
			if (q != p0 + p1) {
				first = "NONE";
			}
			
			p0 = Character.getNumericValue(result[1].charAt(result[1].length() - 1));
			p1 = Character.getNumericValue(result[1].charAt(result[1].length() - 2));;	
			System.out.println(q + " = " + p0 + " + " + p1);
			if (q != p0 + p1) {
				second = "NONE";
			}
		}

		return new String[] {first, second};
	}

	String[] getDecrypted(String message) {
		if (message.length() == 1) {
			if (message.equals("0")) {
				return new String[] {"0", "NONE"};
			} else if (message.equals("1")) {
				return new String[] {"NONE", "1"};
			} else {
				return new String[] {"NONE", "NONE"};
			}
		} else if (message.length() == 2) {
			String first = "0" + message.charAt(0);
			
			int curNum = Character.getNumericValue(message.charAt(0)) - 1;
			String second = "1" + curNum;
			
			if (isImpossible(first))
				return new String[] {"NONE", second};
			if (isImpossible(second))
				return new String[] {first, "NONE"};
			
			return new String[] {first, second};
		} else {
		 	String[] prevMessage = getDecrypted(message.substring(0, message.length()-1));
		 	
		 	String firstMess = prevMessage[0];
		 	String secMess = prevMessage[1];
		 	String first, second;
		 	
		 	int q1 = Character.getNumericValue(message.charAt(message.length() - 2 ));
		 	int p0, p1, p2;
		 	
		 	if (firstMess.equals("NONE")) {
		 		first = "NONE";
		 	} else {
				p0 = Character.getNumericValue(firstMess.charAt(firstMess.length() - 2 ));
			 	p1 = Character.getNumericValue(firstMess.charAt(firstMess.length() - 1 ));
		 		p2 = q1 - p0 - p1;
		 		first = prevMessage[0] + p2;
		 	}

			if (secMess.equals("NONE")) {
		 		second = "NONE";
		 	} else {
				p0 = Character.getNumericValue(secMess.charAt(secMess.length() - 2 ));
			 	p1 = Character.getNumericValue(secMess.charAt(secMess.length() - 1 ));
		 		p2 = q1 - p0 - p1;
		 		second = prevMessage[1] + p2;
		 	}
		 	
		 	String retFirst, retSec;
		 	if (isImpossible(first)) {
				retFirst = "NONE";
			} else {
				retFirst = first;
			}
			if (isImpossible(second)) {
				retSec = "NONE";
			} else {
				retSec = second;
			}
			
			return new String[] {retFirst, retSec};
		}
	}
	
	boolean isImpossible(String message) {
		return !message.matches("[01]+");
	}
}
