import javax.swing.*;
import java.awt.*;
public class Rectangulo extends Figuras implements java.io.Serializable{
	private int altura;
	private int base;
	private  Color Change;
	
	public Rectangulo(){
		super();
		altura=0;
		base=0;
	}
	
	public Rectangulo(int cordx, int cordy, int alt, int bas, JColorChooser Col){
		super();
		x= cordx;
		y= cordy;
		altura= alt;
		base= bas;
		Change= Col.getColor();
		Color= Change;
	}
	
	public void setAltura(int altura){
		this.altura=altura;
	}	
	
	public void setAncho(int ancho){
		this.base=ancho;
	}
	
	public int getAltura(){
		return altura;
	}
	
	public int getAncho(){
		return base;
	}

}