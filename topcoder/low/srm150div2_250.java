public class WidgetRepairs {
	public int days(int[] arrivals, int numPerDay) {
		int total = 0;
		int numDays = 0;
		for (int day : arrivals) {
			if (total != 0 || day != 0)
				numDays++;
			
			total += day - numPerDay;
			if (total < 0)
				total = 0;
		}
		numDays += total / numPerDay;
		numDays += (total % numPerDay == 0) ? 0 : 1;
		
		return numDays;
	}
}
