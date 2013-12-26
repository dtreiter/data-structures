import java.util.*;

public class PeopleCircle {
	public String order(int numMales, int numFemales, int K) {
		String[] circle = new String[numMales + numFemales];
		Arrays.fill(circle, "M");
		
		int insert = -1;
		for (int i = 1; i <= numFemales; i++) {
			for (int j = 0; j < K; j++) {
				insert++;
				insert = (insert%circle.length + circle.length) % circle.length;
				while (circle[insert].equals("F")) {
					insert++;
					insert = (insert%circle.length + circle.length) % circle.length;
				}
			}
			
			insert = (insert%circle.length + circle.length) % circle.length;
			circle[insert] = "F";
		}

		StringBuilder builder = new StringBuilder();
		for (String s : circle) {
			builder.append(s);
		}
		
		return builder.toString();
	}
}
