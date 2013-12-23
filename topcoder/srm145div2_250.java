import java.util.*;

public class ImageDithering {
	public int count(String dithered, String[] screen) {
	    HashSet colors = new HashSet ();
	    for (char color : dithered.toCharArray()) {
	    	colors.add(color);
	    }
	    
		int cnt = 0;
	    for (String row : screen) {
	    	for (char color : row.toCharArray()) {
	    		if (colors.contains(color)) {
	    			cnt++;
	    		}
	    	}
	    }
    	
    	return cnt;
	}
}
