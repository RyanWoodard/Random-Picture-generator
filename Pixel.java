import java.awt.* ; 
import javax.swing.*; 
import javax.imageio.*;
import java.io.*;
import java.util.Random;

public class Pixel{
  private int x,y,size,r1,r2,r3;
  public Pixel(int x, int y, int size){
  this.x = x;
  this.y = y;
  this.size = size;
  this.generate();
  }

    
  public void draw(Graphics g){
    Graphics2D g2d = (Graphics2D) g;
    Color col = new Color(r1,r2,r3);
    
    g2d.setColor(col);

      g2d.fillRect((int)(x),(int)y,size,size); 
    
  }
  public void generate(){
  Random rand = new Random();

  r1 = rand.nextInt(256);
  r2 = rand.nextInt(256);
  r3 = rand.nextInt(256);
  }
  


}