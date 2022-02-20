import processing.sound.*;
PImage img;
int show =0;
int c=0;
int Images = 6;
int Musics = 6;
int x=0;
int y=0;
PImage [] song = new PImage[Images];
SoundFile [] music = new SoundFile[Musics] ;
Amplitude [] amp = new Amplitude [Musics];
void setup() {
 size(1300,900);
 tint(255, 127);
 fill(0);
  loop();
  img = loadImage("background.jpg"); // оголошення картинки
  for (int i=0; i< song.length; i++){
song[i] = loadImage("song"+i+".jpg");
}
for (int j=0; j< music.length; j++){
music[j] = new SoundFile(this, "music"+j+".mp3");
}
}

void Tooltip(int x, int y){
fill(255);
noStroke();
rect(x+300, y, 70, 250);
fill(0);
triangle(x+330, y+10, x+330, y+30, x+345, y+20);
rect(x+325, y+50, 7, 20);
rect(x+335, y+50, 7, 20);
triangle(x+325, y+90, x+325, y+110, x+340, y+100);
triangle(x+335, y+90, x+335, y+110, x+350, y+100);
rect(x+325, y+130, 20, 20);
circle(x+335, y+170, 10);
circle(x+325, y+190, 10);
circle(x+345, y+190, 10);
fill(255, 0, 0);
rect(x+325, y+210, 20, 20);
this.x=x;
this.y=y;
}

  void mouseClicked(){ 
if(mouseX>=50 && mouseY>=50 && mouseX<=350 && mouseY<=350){
noLoop();
noTint();
Tooltip(50, 50);
show=0;
}
 else if(mouseX>=470 && mouseY>=50 && mouseX<=770 && mouseY<=350){
noLoop();
noTint();
Tooltip(470, 50);
show=1;
}
else if(mouseX>=890 && mouseY>=50 && mouseX<=1190 && mouseY<=350){
noLoop();
noTint();
Tooltip(890, 50);
show=2;
}
else if(mouseX>=50 && mouseY>=470 && mouseX<=350 && mouseY<=770){
noLoop();
noTint();
Tooltip(50, 470);
show=3;
}
else if(mouseX>=470 && mouseY>=470 && mouseX<=770 && mouseY<=770){
noLoop();
noTint();
Tooltip(470, 470);
show=4;
}
else if(mouseX>=890 && mouseY>=470 && mouseX<=1190 && mouseY<=770){
noLoop();
noTint();
Tooltip(890, 470);
show=5;
}
if(mouseX>=x+330 && mouseY>=y+10 && mouseY<=y+30 && mouseX<=x+345){
  if (music[show].isPlaying()){
}
else{
  c=0;
  music[show].play();
} 
}
  if (music[show].isPlaying()){
if(mouseX>=x+325 && mouseY>=y+50 && mouseY<=y+70 && mouseX<=x+350){
    music[show].pause();
}
else if(mouseX>=x+325 && mouseY>=y+90 && mouseY<=y+110 && mouseX<=x+350){
    c+=4;
    music[show].jump(c);
}

else if(mouseX>=x+325 && mouseY>=y+130 && mouseY<=y+150 && mouseX<=x+345){
   music[show].stop();
   music[show].rate(1);
}
else if(mouseX>=x+325 && mouseY>=y+130 && mouseY<=y+150 && mouseX<=x+345){
   music[show].stop();
}
else if(mouseX>=x+325 && mouseY>=y+160 && mouseY<=y+180 && mouseX<=x+345){
   music[show].rate(0.5);
}

else if(mouseX>=x+315 && mouseY>=y+180 && mouseY<=y+200 && mouseX<=x+355){
   music[show].rate(2);
}
 else if(mouseX>=x+325 && mouseY>=y+210 && mouseY<=y+230 && mouseX<=x+355){
   loop();
   music[show].stop();
   music[show].rate(1);
}
 }
 else if(mouseX>=x+325 && mouseY>=y+210 && mouseY<=y+230 && mouseX<=x+355){
   loop();
   music[show].rate(1);
}
}

  void draw(){  
tint(255, 127);
image(img, 0, 0, width, height);
image(song[0], 50, 50);
image(song[1], 470, 50);
image(song[2], 890, 50);
image(song[3], 50, 470);
image(song[4], 470, 470);
image(song[5], 890, 470);

if(mouseX>=50 && mouseY>=50 && mouseX<=350 && mouseY<=350){
noTint();
image(song[0], 50, 50);
Tooltip(50, 50);
}
else if(mouseX>=470 && mouseY>=50 && mouseX<=770 && mouseY<=350){
noTint();
image(song[1], 470, 50);
Tooltip(470, 50);

}
else if(mouseX>=890 && mouseY>=50 && mouseX<=1190 && mouseY<=350){
noTint();
image(song[2], 890, 50);
Tooltip(890, 50);
}
else if(mouseX>=50 && mouseY>=470 && mouseX<=350 && mouseY<=770){
noTint();
image(song[3], 50, 470);
Tooltip(50, 470);
}
else if(mouseX>=470 && mouseY>=470 && mouseX<=770 && mouseY<=770){
noTint();
image(song[4], 470, 470);
Tooltip(470, 470);
}
else if(mouseX>=890 && mouseY>=470 && mouseX<=1190 && mouseY<=770){
noTint();
image(song[5], 890, 470);
Tooltip(890, 470);
}
  }

 
