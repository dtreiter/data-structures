import java.util.*;

public class Anagram {
	static boolean isAnagram(String str0, String str1) {
		HashMap<Character, Integer> letters0 = new HashMap<Character, Integer> ();
		for (char letter : str0.toCharArray()) {
			if (letters0.get(letter) != null)
				letters0.put(letter, letters0.get(letter) + 1);
			else
				letters0.put(letter, 1);
		}

		HashMap<Character, Integer> letters1 = new HashMap<Character, Integer> ();
		for (char letter : str1.toCharArray()) {
			if (letters1.get(letter) != null)
				letters1.put(letter, letters1.get(letter) + 1);
			else
				letters1.put(letter, 1);
		}
		
		if (mapsEqual(letters0, letters1))
			return true;
			
		return false;
	}

	static boolean mapsEqual(HashMap<Character, Integer> map0, HashMap<Character, Integer> map1) {
		if (map0.size() != map1.size())
			return false;
		for (Character key : map0.keySet()) {
			if (map0.get(key) != map1.get(key))
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		assert isAnagram("ward", "draw") : "Assertion 0 failed";
		assert !isAnagram("wasd", "") : "Assertion 1 failed";
		assert !isAnagram("aaa", "aa") : "Assertion 2 failed";
		assert !isAnagram("abc", "def") : "Assertion 3 failed";
		assert isAnagram("", "") : "Assertion 4 failed";
	}
}
