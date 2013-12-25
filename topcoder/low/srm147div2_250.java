public class CCipher {
	public String decode(String cipherText, int shift) {
		String result = "";
		for (char letter : cipherText.toCharArray()) {
			int num = (int)letter - 65;
			num = (num - shift + 26) % 26;
			result = result + (char)(num + 65);
		}
		
		return result;
	}
}
