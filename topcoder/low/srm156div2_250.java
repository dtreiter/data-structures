import java.util.*;

public class DiskSpace {
	public int minDrives(int[] used, int[] total) {
		Arrays.sort(total);
		
		int free = 0;
		int taken = 0;
		for (int data : used) {
			taken += data;
		}
		
		int numDrives = 0;
		for (int i = total.length-1; i >= 0; i--) {
			free += total[i];
			numDrives++;
			if (free >= taken)
				break;
		}
		
		return numDrives;
	}
}
