import javax.swing.*;
import java.awt.*;
public class Tescaleno extends Figuras implements java.io.Serializable{
	private int[] corx;
    private int[] cory;
    private  Color Change;	
	
	public Tescaleno(){
		super();
	}
	
	public Tescaleno(int x1, int x2, int x3, int y1, int y2, int y3, JColorChooser Col){
		super();
		corx=new int[3];
		cory=new int[3];
		corx[0]=x1;
		corx[1]=x2;
		corx[2]=x3;
		cory[0]=y1;
		cory[1]=y2;
		cory[2]=y3;
		Change= Col.getColor();
		Color= Change;
	}
	
	public int[] getCorx(){
		return corx;
	}
	
	public int[] getCory(){
		return cory;
	}
	 
}