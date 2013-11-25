int numParticles = 1500;
Particle myParticles[] = new Particle[numParticles];

void setup(){
  size(500,500);
  
  for(int i=0;i<numParticles;i++){
    int particleSize = 1;//(int)random(10,40);
    if(i==numParticles-1){
      myParticles[i] = new Particle((int)random(10,width-10),(int)random(10,height-10),
                   (int)random(1,5),(int)random(1,5),
                   20,20);
    }
    else{
      myParticles[i] = new Particle((int)random(10,width-10),(int)random(10,height-10),
                         (int)random(1,5),(int)random(1,5),
                         particleSize,particleSize);
    }
  }
}


void draw(){
  background(255);
  for(int i=0;i<numParticles;i++){
    myParticles[i].draww();
    myParticles[i].drive();
    for(int j=0;j<numParticles;j++){
      if(i!=j)
        myParticles[i].checkCollisions(myParticles[j]);
    }
  }
}


public class Particle{
  float x, y, xspeed, yspeed, particleHeight, particleWidth;;
  
  Particle(float tx, float ty, float xspd, float yspd, float hght, float wdth){
    x = tx;
    y = ty;
    xspeed = xspd;
    yspeed = yspd;
    particleHeight = hght;
    particleWidth = wdth;
  }
  
  void draww(){
    fill(0,200,0);
    ellipseMode(CENTER);
    ellipse(x,y,particleHeight,particleWidth);
  }
  
  void drive(){
    x = x + xspeed;
    y = y + yspeed;
    if(x>width||x<0){
      xspeed = -xspeed;
      x = x + xspeed;
    }
    if(y>height||y<0){
      yspeed = -yspeed;
      y = y+yspeed;
    }
  }

  void checkCollisions(Particle otherParticle){
    //if collision occurs, particles swap speeds
    //to simulate momentum, scale speed inherited by ratio of otherParticleArea/particleArea
    float tempSpeed;
    float xreach = 3*particleWidth/4+2; //how far from center collision occurs
    float yreach = 3*particleHeight/4+2;
    float areaRatio = otherParticle.particleWidth*otherParticle.particleHeight/(particleWidth*particleHeight);
    if(x>otherParticle.x-xreach&&x<otherParticle.x+xreach&&y>otherParticle.y-yreach&&y<otherParticle.y+yreach){
      tempSpeed = xspeed;
      xspeed = otherParticle.xspeed*areaRatio;
      otherParticle.xspeed = tempSpeed*areaRatio;

      tempSpeed = yspeed;
      yspeed = otherParticle.yspeed*areaRatio;
      otherParticle.yspeed = tempSpeed*areaRatio;
    }
  }
}
