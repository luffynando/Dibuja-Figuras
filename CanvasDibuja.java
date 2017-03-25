import java.awt.*;
import javax.swing.*;
import java.util.LinkedList;


public class CanvasDibuja extends Canvas {
  private Color prefered;
  private LinkedList<Cuadrado> cuadrados;
  private LinkedList<Circulo> circulos;
  private LinkedList<Rectangulo> rectangulos;
  private LinkedList<Tequilatero> TriangulosEq;
  private LinkedList<Tisoceles> TriangulosIso;
  private LinkedList<Tescaleno> TriangulosEsc;
  private Color Change;
  private Cuadrado CuaAux;
  private Circulo CircAux;
  private Rectangulo RectAux;
  private Tequilatero TriEquiAux;
  private Tisoceles TriIsoAux;
  private Tescaleno TriEscaAux;

  
  public CanvasDibuja () {
		 prefered= new Color(217,252,248);
         setBackground (prefered);
		 TriangulosIso= new LinkedList<Tisoceles>();
		 TriangulosEq= new LinkedList<Tequilatero>();
		 TriangulosEsc= new LinkedList<Tescaleno>();
		 rectangulos= new LinkedList<Rectangulo>();
		 circulos= new LinkedList<Circulo>();
		 cuadrados= new LinkedList<Cuadrado>();
      }
  
  public void paint (Graphics g) {
     Graphics2D g2;
     g2 = (Graphics2D) g;
     g2.drawString ("0", 0, 10);
	 g2.drawString ("730", 730,10);
	 g2.drawString ("645", 0,645);
     if (TriangulosEq.size()!=0){
			int cuentaTriEq=0;
			while (cuentaTriEq!= TriangulosEq.size()){
				TriEquiAux= TriangulosEq.get(cuentaTriEq);
				Change= TriEquiAux.getColorn();
				g.setColor(Change);
				g.fillPolygon(TriEquiAux.getCorx(),TriEquiAux.getCory(),3);
				cuentaTriEq++;
			}
	 }
	
	 if(circulos.size()!=0){
			int cuentacirc=0;
			while(cuentacirc!=circulos.size()){
				CircAux= circulos.get(cuentacirc);
				Change= CircAux.getColorn();
				g.setColor(Change);
			    g.fillOval(CircAux.getX(), CircAux.getY(), CircAux.getRadio()*2, CircAux.getRadio()*2);
				cuentacirc++;
			}
				
	}
	if (cuadrados.size()!=0){
			int CueCua=0;
			while (CueCua!=cuadrados.size()){
					CuaAux= cuadrados.get(CueCua);
					Change= CuaAux.getColorn();
					g.setColor(Change);
					g.fillRect(CuaAux.getX(),CuaAux.getY(),CuaAux.getLado(),CuaAux.getLado());
					CueCua++;
			}
	}
	if (TriangulosEsc.size()!=0){
			int cuentaTEsc=0;
			while (cuentaTEsc!=TriangulosEsc.size()){
				TriEscaAux= TriangulosEsc.get(cuentaTEsc);
				Change= TriEscaAux.getColorn();
				g.setColor(Change);
				g.fillPolygon(TriEscaAux.getCorx(), TriEscaAux.getCory(),3);
				cuentaTEsc++;
			}
	}	
		
	if (rectangulos.size()!=0){
			int cuentaRect=0;
			while(cuentaRect!=rectangulos.size()){
				RectAux= rectangulos.get(cuentaRect);
				Change= RectAux.getColorn();
				g.setColor(Change);
				g.fillRect(RectAux.getX(), RectAux.getY(),RectAux.getAncho(), RectAux.getAltura() );
				cuentaRect++;
			}
	}
	
	if (TriangulosIso.size()!=0){
			int cuentaTIso=0;
			while (cuentaTIso!=TriangulosIso.size()){
				TriIsoAux= TriangulosIso.get(cuentaTIso);
				Change= TriIsoAux.getColorn();
				g.setColor(Change);
				g.fillPolygon(TriIsoAux.getCorx(), TriIsoAux.getCory(),3);
				cuentaTIso++;
			}
	}
  }
  
		
  public void dibujaCirculo(LinkedList<Circulo> Circ){
	  circulos= Circ;
  }
  
  public void dibujaCuadrado(LinkedList<Cuadrado> Cuad){
	  cuadrados=Cuad;
  }
  
  public void dibujaRectangulo(LinkedList<Rectangulo> Rect){
	  rectangulos=Rect;
  }
  
  public void dibujaTriEqui(LinkedList<Tequilatero> TriEq){
	  TriangulosEq= TriEq;
  }
  
   public void dibujaTriIso(LinkedList<Tisoceles> TriIs){
	  TriangulosIso= TriIs;
  }
  
   public void dibujaTriEsca(LinkedList<Tescaleno> TriEsc){
	  TriangulosEsc= TriEsc;
  }
  
  public void limpiaPantalla(){
	  cuadrados.clear();
	  circulos.clear();
	  rectangulos.clear();
	  TriangulosEq.clear();
	  TriangulosIso.clear();
	  TriangulosEsc.clear();
	  repaint();
  }
  
}

