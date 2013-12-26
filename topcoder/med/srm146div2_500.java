public class RectangularGrid {
	public long countRectangles(int width, int height) {
		long cnt = 0;
		
		for (int y = 1; y <= height; y++) {
			for (int x = 1; x <= width; x++) {
				if (x != y) {
					int numx = width - x + 1;
					int numy = height - y + 1;
					cnt += numx*numy;
				}
			}
		}
		
		return cnt;
	}
}
