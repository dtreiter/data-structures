
ParticleSystem myParticles;
int BGCOLOR = 220;

void setup() {
	size(400, 400);
	background(BGCOLOR);
	myParticles = new ParticleSystem(3000, 4);
	myParticles.initialize();
}

void draw() {
	background(BGCOLOR);
	myParticles.run();
}
