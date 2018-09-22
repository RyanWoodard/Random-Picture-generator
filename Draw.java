
import javax.swing.*; 
import java.awt.* ; 
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Draw extends JPanel{
  
  
  private int h, size;
  private Pixel[] pixels;
  public Draw(int h, int size){
    this.h = h;
    this.size = size;
    int across = h/size;
    this.pixels = new Pixel[across*across];
    this.populateArray(across);
    
    
    
    addKeyListener(new KeyListener() { 
      @Override  
      public void keyTyped(KeyEvent e) {  
        changeColour();
      }  
      @Override  
      public void keyReleased(KeyEvent e) {
        
      }  
      @Override  
      public void keyPressed(KeyEvent e) { 
        
      }   }); 
    setFocusable(true);
  }
  
  private void changeColour(){
    for(Pixel p: pixels){
      p.generate();
    }
    
  }
  private void populateArray(int across){
    int count = 0;
    for(int i = 0; i < across; i++){
      for(int j = 0; j < across;j++){
        int x1 = i*size;
        int y1 = j*size;
        pixels[count] = new Pixel(x1,y1,size);
        count++;       
      }
    }
    
  }
  
  
  
  
  @Override  public void paint(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    super.paint(g);
    for(Pixel p: pixels)
      p.draw(g);
  }
  
  
  public int getHeight(){
    return h;
  }
  
  
  
  public static void main(String[] args)throws InterruptedException {     
    JFrame frame = new JFrame("Random");   //Add our JPanel to the frame 
    Draw d = new Draw(700,4);     
    frame.add(d); 
    frame.setSize(d.getHeight(), d.getHeight());     
    frame.setVisible(true); 
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    while (true) {
      d.repaint();  
      Thread.sleep(1);  
    }
  }} 

