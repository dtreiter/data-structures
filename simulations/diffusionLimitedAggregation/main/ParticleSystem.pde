
class ParticleSystem {
	int WIN_WIDTH, WIN_HEIGHT, numParticles, partSize;
	Particle[] particles;
	
	ParticleSystem(int numPart, int prtSize) {
		WIN_HEIGHT = 400;
		WIN_WIDTH = 400;
		numParticles = numPart;
		particles = new Particle[numParticles];
		partSize = prtSize;
	}
	
	void initialize() {
		for(int i = 0; i < numParticles-1; i++) {
			particles[i] = new Particle(partSize);
		}
		// make initial dead particle
		particles[numParticles-1] = new Particle(partSize);
		particles[numParticles-1].loc = new PVector(WIN_WIDTH/2, WIN_HEIGHT/2);
		particles[numParticles-1].is_dead = true;
	}
	
	void checkCollisions() {
		float distx, disty;
		for(int i = 0; i < numParticles; i++) {
			for(int j = 0; j < numParticles; j++) {
				if(i==j || particles[j].is_dead == false)
					continue;
				distx = abs(particles[i].loc.x - particles[j].loc.x);
				disty = abs(particles[i].loc.y - particles[j].loc.y);
				if(distx < partSize && disty < partSize) {
					particles[i].is_dead = true;
					break;
				}
			}
		}
	}
	
	public void run() {
		checkCollisions();
		for(int i = 0; i < numParticles; i++) {
			particles[i].update();
			particles[i].display();
		}
	}
	
}
