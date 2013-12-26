public class ExerciseMachine {
	public int getPercentages(String time) {
		String[] splitTime = time.split(":");
		int duration = 3600*Integer.parseInt(splitTime[0]) + 60*Integer.parseInt(splitTime[1]) + Integer.parseInt(splitTime[2]);
		
		int cnt = 0;
		for (int sec = 1; sec < duration; sec++) {
			if ((100*sec) % duration == 0)
				cnt++;
		}
		
		return cnt;
	}
}
