public class Time {
	public String whatTime(int seconds) {
		int hrs = (seconds/3600) % 60;
		int min = (seconds/60) % 60;
		int sec = seconds % 60;
		
		return hrs + ":" + min + ":" + sec;
		
	}
}
