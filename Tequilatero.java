import javax.swing.*;
import java.awt.*;
public class Tequilatero extends Figuras implements java.io.Serializable{
	private int lado;
	private int[] corx= new int[3];
	private int[] cory= new int[3];
	private  Color Change;
	
	public Tequilatero(){
		 super();
		 lado=0;
	 }
	 
	 public Tequilatero(int cx, int cy, int lado, JColorChooser Col){
		 this.lado=lado;
		 x=cx;
		 y=cy;
		 setCordenadas(cx,cy,lado);
		 Change= Col.getColor();
		 Color= Change;
	 }
	
	public int[] getCorx(){
		return corx;
	}
	
	public int[] getCory(){
		return cory;
	}
	
	public void setCordenadas(int auxX, int auxY, int auxLado){
		int opdiv=auxLado/2;
		int opcuad= auxLado*auxLado;
		double operaiz= Math.sqrt(opcuad-(opdiv*opdiv));
		int opraiz= (int) operaiz;
		corx[0]=auxX;
		corx[1]=auxX-opdiv;
		corx[2]=auxX+opdiv;
		cory[0]=auxY-(opraiz/2);
		cory[1]=auxY+(opraiz/2);
		cory[2]=auxY+(opraiz/2);
	}
}