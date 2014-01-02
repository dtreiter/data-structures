import java.util.*;

public class Quipu {
	public int readKnots(String knots) {
		int dashCnt = 0;
		int xCnt = 0;
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < knots.length(); i++) {
			if (knots.charAt(i) == 'X') {
				for (int j = 0; j < dashCnt-1; j++) {
					result.append("0");
				}
				dashCnt = 0;
				xCnt++;
			} else if (knots.charAt(i) == '-') {
				if(xCnt != 0)
					result.append(xCnt);
				xCnt = 0;
				dashCnt++;
			}
		}
		
		for (int j = 0; j < dashCnt-1; j++) {
			result.append("0");
		}
		if(xCnt != 0)
			result.append(xCnt);
		
		return Integer.parseInt(result.toString());
	}
}
