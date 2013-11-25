
class Particle {
	int WIN_WIDTH, WIN_HEIGHT, partSize, maxSpeed;
	PVector loc;
	boolean is_dead;

	Particle(int siz) {
		WIN_HEIGHT = 400;
		WIN_WIDTH = 400;
		partSize = siz;
		loc = new PVector(random(0, WIN_WIDTH-1), random(0, WIN_HEIGHT-1));
		is_dead = false;
		maxSpeed = 4;
	}
	
	public void update() {		
		if(!is_dead) {
			loc.x += (int) random(-maxSpeed, maxSpeed);
			loc.y += (int) random(-maxSpeed, maxSpeed);
			if(loc.x <= 0) {
				loc.x += maxSpeed;
			} else if(loc.x >= WIN_WIDTH) {
				loc.x -= maxSpeed;
			} else if(loc.y <= 0) {
				loc.y += maxSpeed;
			} else if(loc.y >= WIN_HEIGHT) {
				loc.y -= maxSpeed;
			}
		}
	}
	
	public void display() {
		if(is_dead) {
			fill(255, 0, 0);
		} else {
			fill(0, 0, 255);
		}
		noStroke();
		rectMode(CENTER);
		rect(loc.x, loc.y, partSize, partSize);
	}
}
