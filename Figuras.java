import javax.swing.*;
import java.awt.*;
abstract class Figuras implements java.io.Serializable{
    protected int x;
    protected int y;
    protected Color Color;
   
   public Figuras(){
	   x=0;
	   y=0;
	   Color= new Color(217,252,248);
   }
   
   public int getX(){
	   return x;
   }
   
   public int getY(){
	   return y;
   }
   
   public Color getColorn(){
	   return Color;
   }
   
   public void setX(int corx){
	  x=corx;
   }
   
   public void setY(int cory){
	   y=cory;
   }
   
   public void setColor(Color nuevo){
	   Color= nuevo;
   }
   
}