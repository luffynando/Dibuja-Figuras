import javax.swing.*;
import java.awt.*;
public class Circulo extends Figuras implements java.io.Serializable{
	private int radio;
	private  Color Change;
	
	public Circulo(){
		super();
		radio=0;
	}
	
	public Circulo(int cordx, int cordy, int rad, JColorChooser Col){
		super();
		x= cordx;
		y= cordy;
		radio= rad;
		Change= Col.getColor();
		Color= Change;
	}
	
	public void setRadio(int radio){
		this.radio=radio;
	}
	
	public int getRadio(){
		return radio;
	}

}