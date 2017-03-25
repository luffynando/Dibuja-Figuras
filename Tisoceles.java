import javax.swing.*;
import java.awt.*;
public class Tisoceles extends Figuras implements java.io.Serializable{
    private int lados;
	private int base;
	private int[] corx;
	private int[] cory;
	private  Color Change;
	
	public Tisoceles(){
		 super();
		 lados=0;
		 base=0;
    }
	
	public Tisoceles(int cx, int cy, int lados, int base, JColorChooser Col){
		 super();
		 corx= new int[3];
		 cory=new int[3];
		 this.lados=lados;
		 this.base=base;
		 x=cx;
		 y=cy;
		 setCordenadas(cx,cy,lados, base);
		 Change= Col.getColor();
		 Color= Change;
	}
	
	public int[] getCorx(){
		return corx;
	}
	
	public int[] getCory(){
		return cory;
	}
	
	public void setCordenadas(int cx, int cy, int auxlados, int auxbase){
		int opdiv= auxbase/2;
		int cuadl= auxlados*auxlados;
		int cuadb= opdiv*opdiv;
		double operaiz= Math.sqrt(cuadl-cuadb);
		int opraiz= (int) operaiz;
		corx[0]=cx;
		corx[1]=cx-opdiv;
		corx[2]=cx+opdiv;
		cory[0]=cy-(opraiz/2);
		cory[1]=cy+(opraiz/2);
		cory[2]=cy+(opraiz/2);
	}

}