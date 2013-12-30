public class FixedPointTheorem {
	public double cycleRange(double R) {
		double X = 0.25;
		int numIter = 200000;
		for (int i = 0; i < numIter; i++) {
			X = R*X*(1-X);
		}
		
		numIter = 1000;
		double max = 0;
		double min = Double.POSITIVE_INFINITY;
		for (int i = 0; i < numIter; i++) {
			X = R*X*(1-X);
			if (X > max)
				max = X;
			if (X < min)
				min = X;
		}
		
		return max - min;
	}
}
