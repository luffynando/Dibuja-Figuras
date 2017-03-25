import javax.swing.*;
import java.awt.*;
public class Cuadrado extends Figuras implements java.io.Serializable{
	private int lado;
	private  Color Change;
	
	public Cuadrado(){
		super();
		lado=0;
	}
	public Cuadrado(int cordx, int cordy, int lad, JColorChooser Col){
		super();
		x= cordx;
		y= cordy;
		lado= lad;
		Change= Col.getColor();
		Color= Change;
	}
	
	public void setLado(int lado){
		this.lado=lado;
	}
	
	public int getLado(){
		return lado;
	}

}