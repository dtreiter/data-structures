public class PrefixCode {
	public String isOne(String[] words) {
		int minIndex = -1;
		for (int i = 0; i < words.length; i++) {
			String word0 = words[i];
			for (int j = 0; j < words.length; j++) {
				if (i == j)
					continue;
					
				String word1 = words[j];
				int thisIndex = -1;
				if (word0.length() < word1.length()) {
					if (word1.substring(0, word0.length()).equals(word0)) {
							thisIndex = i;
						}
						System.out.println(word0 + " : " + word1 + " : " + word1.substring(0, word0.length()));
				} else {
					if (word0.substring(0, word1.length()).equals(word1))
						thisIndex = j;
				}
				System.out.println(thisIndex + " :: " + minIndex);
				
				if ((minIndex == -1 || thisIndex < minIndex) && thisIndex != -1)
					minIndex = thisIndex;
			}
		}
		
		if (minIndex != -1)
			return "No, " + minIndex;
		return "Yes";
	}
}
