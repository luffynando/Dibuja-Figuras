import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.LinkedList;
import java.io.*;

public class Programa extends JFrame implements ActionListener{

    private JLabel texto;           
    private JTextField caja2X,cajaX,cajaY, lado, caja2Y, radio, caja3X, caja3Y, ladoigual, base2, caja31X, caja31Y, tamLado, cordX1, cordX2, cordX3, cordY1, cordY2, cordY3, base, altura, caja4X, caja4Y;        
    private JButton boton, bCuadrado, bCirculo, bTIso, bTequi, bTesc, bRectangulo, bColorC, bColorCirc, bColorRect, bColorTriEq, bColorTriEs, bColorTriIs;          
	private JMenuBar mb;
    private JMenu menu1;
    private JMenuItem Abrir, Guardar, Info;
	private CanvasDibuja mc;
	private JTabbedPane pestana, triangulos;
	static JPanel colorCuad, colorCirc, colorTriEq, colorRecta, colorTriEs, colorTriIs;
	private LinkedList<Cuadrado> Cuadrados= new LinkedList<Cuadrado>();
	private LinkedList<Rectangulo> Rectangulos= new LinkedList<Rectangulo>();
	private LinkedList<Circulo> Circulos= new LinkedList<Circulo>();
	private LinkedList<Tequilatero> TriEqui= new LinkedList<Tequilatero>();
	private LinkedList<Tisoceles> TriIs= new LinkedList<Tisoceles>();
	private LinkedList<Tescaleno> TriEs= new LinkedList<Tescaleno>();
	private LinkedList<LinkedList> ListaF= new LinkedList<LinkedList>();
	private ColorSelector cambiaC= new ColorSelector();
	static JColorChooser camCuad, camCirc, camRect, camTriEq, camTriEs, camTriIs;

    public Programa() {
        super();                    // usamos el contructor de la clase padre JFrame
        configurarVentana();        // configuramos la ventana
        inicializarComponentes();   // inicializamos los atributos o componentes
    }

    private void configurarVentana() {
        this.setTitle("Dibujar Figuras v1.2");                   // colocamos titulo a la ventana
        this.setSize(1360, 705);                                 // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
		this.getContentPane().setBackground(Color.orange);
    }

    private void inicializarComponentes() {
        // creamos los componentes
		mc= new CanvasDibuja();
        boton = new JButton();
		pestana = new JTabbedPane();
        // configuramos los componentes
		pestana.setBounds(0,0,600,600);
	    mc.setBounds(600,0,760,650);
        boton.setText("Limpiar Pantalla");   // colocamos un texto al boton
        boton.setBounds(50, 605, 200, 30);  // colocamos posicion y tamanio al boton (x, y, ancho, alto)
        boton.addActionListener(this);      // hacemos que el boton tenga una accion y esa accion estara en esta clase
        // adicionamos los componentes a la ventana
		this.add(mc);
		this.add(pestana);
		this.add(boton);
		
		// Seccion menu de opciones
		mb=new JMenuBar();
        setJMenuBar(mb);
        menu1=new JMenu("Opciones");
        mb.add(menu1);
        Abrir=new JMenuItem("Abrir Archivo");
		Abrir.addActionListener(this);
        menu1.add(Abrir);
        Guardar=new JMenuItem("Guardar Archivo");
		Guardar.addActionListener(this);
        menu1.add(Guardar);
		Info=new JMenuItem("Acerca de...");
		Info.addActionListener(this);
        menu1.add(Info);
		
		//Seccion pestanas con panel
		//Pestana 1 y panel 1
		camCuad= new JColorChooser();
		camCuad.setColor(Color.gray);
		camCirc= new JColorChooser();
		camCirc.setColor(Color.gray);
		camRect= new JColorChooser();
		camRect.setColor(Color.gray);
        panelCuadrado();
		
        
		//Pestana 2 y panel 2
		panelCirculo();
		
 
        //Pestana 3 y panel 3
        panelTriangulo();
		
		
		//Pestana 4 y panel 4
		panelRectangulo();
    }
	
	public void panelCuadrado(){
		JPanel panel1=new JPanel();
		panel1.setLayout(null);
		JLabel Cuadrado= new JLabel();
		Cuadrado.setText("Cuadrado");
		Cuadrado.setBounds(200,0,200,50);
		Font auxFont=Cuadrado.getFont(); 
		Cuadrado.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
		//Creamos y colocamos la etiqueta coordenada X
		JLabel txCordX= new JLabel();
		txCordX.setText("Inserte la coordenada x");
		txCordX.setBounds(150,100,200,25);
		//Creamos y colocamos la caja para ingresar la coordenada X
		cajaX= new JTextField();
		cajaX.setBounds(330,100,100,25);
		//Creamos y colocamos la etiqueta coordenada Y
		JLabel txCordY= new JLabel();
		txCordY.setText("Inserte la coordenada y");
		txCordY.setBounds(150,150,200,25);
		//Creamos y colocamos la caja para ingresar la coordenada Y
		cajaY= new JTextField();
		cajaY.setBounds(330,150,100,25);
		//Creamos y colocamos la etiqueta lado
		JLabel txlado= new JLabel();
		txlado.setText("Inserte el tamanio del lado");
		txlado.setBounds(150,200,200,25);
		//Creamos y colocamos la caja para ingresar el lado
		lado= new JTextField();
		lado.setBounds(330,200,100,25);
		//Creamos y colocamos la etiqueta color;
		JLabel txcolor= new JLabel();
		txcolor.setText("Cambiar color");
		txcolor.setBounds(150,250,100,25);
		//Creamos y colocamos la caja de color;
		colorCuad= new JPanel();
		colorCuad.setBounds(350,250,20,20);
		colorCuad.setBorder(BorderFactory.createLoweredBevelBorder());
		colorCuad.setBackground(Color.gray);
		//Creamos y colocamos el boton para cambiar el color;
		bColorC= new JButton();
		bColorC.setText("Color");
		bColorC.setBounds(380,250,100,25);
		bColorC.addActionListener(this);
		//Creamos y colocamos el boton para dibujar la figura
		bCuadrado=new JButton();
		bCuadrado.setText("Dibujar");
		bCuadrado.setBounds(450, 500,100,25);
		bCuadrado.addActionListener(this);
		panel1.add(Cuadrado);
		panel1.add(txCordX);
		panel1.add(cajaX);
		panel1.add(txCordY);
		panel1.add(cajaY);
		panel1.add(txlado);
		panel1.add(lado);
		panel1.add(txcolor);
		panel1.add(colorCuad);
		panel1.add(bColorC);
		panel1.add(bCuadrado);
        pestana.addTab("Cuadrado", panel1);
        pestana.setIconAt (0, new ImageIcon("icons/cuadrado.png"));
	}
	
	public void panelCirculo(){
		Font auxFont;
        JPanel panel2=new JPanel();
		panel2.setLayout(null);
		JLabel Circulo= new JLabel();
		Circulo.setText("Circulo");
		Circulo.setBounds(200,0,200,50);
		auxFont=Circulo.getFont(); 
		Circulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
		//Creamos y colocamos la etiqueta coordenada X
		JLabel txCord2X= new JLabel();
		txCord2X.setText("Inserte la coordenada x");
		txCord2X.setBounds(150,100,200,25);
		//Creamos y colocamos la caja para ingresar la coordenada X
		caja2X= new JTextField();
		caja2X.setBounds(330,100,100,25);
		//Creamos y colocamos la etiqueta coordenada Y
		JLabel txCord2Y= new JLabel();
		txCord2Y.setText("Inserte la coordenada y");
		txCord2Y.setBounds(150,150,200,25);
		//Creamos y colocamos la caja para ingresar la coordenada Y
		caja2Y= new JTextField();
		caja2Y.setBounds(330,150,100,25);
		//Creamos y colocamos la etiqueta radio
		JLabel txradio= new JLabel();
		txradio.setText("Inserte el tamanio del radio");
		txradio.setBounds(150,200,200,25);
		//Creamos y colocamos la caja para ingresar el radio
		radio= new JTextField();
		radio.setBounds(330,200,100,25);
		//Creamos y colocamos la etiqueta color;
		JLabel txcolor= new JLabel();
		txcolor.setText("Cambiar color");
		txcolor.setBounds(150,250,100,25);
		//Creamos y colocamos la caja de color;
		colorCirc= new JPanel();
		colorCirc.setBounds(350,250,20,20);
		colorCirc.setBorder(BorderFactory.createLoweredBevelBorder());
		colorCirc.setBackground(Color.gray);
		//Creamos y colocamos el boton para cambiar el color;
		bColorCirc= new JButton();
		bColorCirc.setText("Color");
		bColorCirc.setBounds(380,250,100,25);
		bColorCirc.addActionListener(this);
		//Creamos y colocamos el boton para dibujar la figura
		bCirculo=new JButton();
		bCirculo.setText("Dibujar");
		bCirculo.setBounds(450, 500,100,25);
		bCirculo.addActionListener(this);
		panel2.add(Circulo);
		panel2.add(txCord2X);
		panel2.add(caja2X);
		panel2.add(txCord2Y);
		panel2.add(caja2Y);
		panel2.add(txradio);
		panel2.add(radio);
		panel2.add(txcolor);
		panel2.add(colorCirc);
		panel2.add(bColorCirc);
		panel2.add(bCirculo);
		pestana.addTab("Circulo", panel2);
		pestana.setIconAt (1, new ImageIcon("icons/circulo.png"));
	}
	
	public void panelTriangulo(){
		Font auxFont;
		JPanel panel3=new JPanel();
        panel3.setLayout(null);
		JLabel Triangulo= new JLabel();
		Triangulo.setText("Triangulo");
		Triangulo.setBounds(200,0,200,50);
		auxFont=Triangulo.getFont(); 
		Triangulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
		triangulos=new JTabbedPane();
		triangulos.setBounds(25,50,550,500);
		
		//SubPanelTriangulo Isoceles{
		JPanel tiso=new JPanel();
		tiso.setLayout(null);
		//Creamos y colocamos la etiqueta coordenada X
		JLabel txCord3X= new JLabel();
		txCord3X.setText("Inserte la coordenada x");
		txCord3X.setBounds(150,50,200,25);
		//Creamos y colocamos la caja para ingresar la coordenada X
		caja3X= new JTextField();
		caja3X.setBounds(330,50,100,25);
		//Creamos y colocamos la etiqueta coordenada Y
		JLabel txCord3Y= new JLabel();
		txCord3Y.setText("Inserte la coordenada y");
		txCord3Y.setBounds(150,100,200,25);
		//Creamos y colocamos la caja para ingresar la coordenada Y
		caja3Y= new JTextField();
		caja3Y.setBounds(330,100,100,25);
		//Creamos y colocamos la etiqueta lado igual.
		JLabel txladoigual= new JLabel();
		txladoigual.setText("Tamanio de lados iguales");
		txladoigual.setBounds(150,150,200,25);
		//Creamos y colocamos la caja para ingresar el lado igual
		ladoigual= new JTextField();
		ladoigual.setBounds(330,150,100,25);
		//Creamos y colocamos la etiqueta la base.
		JLabel txbase2= new JLabel();
		txbase2.setText("Tamanio de la base");
		txbase2.setBounds(150,200,200,25);
		//Creamos y colocamos la caja para ingresar la base
		base2= new JTextField();
		base2.setBounds(330,200,100,25);
		//Creamos y colocamos la etiqueta color;
		JLabel txcolor2= new JLabel();
		txcolor2.setText("Cambiar color");
		txcolor2.setBounds(150,250,100,25);
		//Creamos y colocamos la caja de color;
		colorTriIs= new JPanel();
		colorTriIs.setBounds(350,250,20,20);
		colorTriIs.setBorder(BorderFactory.createLoweredBevelBorder());
		colorTriIs.setBackground(Color.gray);
		//Creamos y colocamos el boton para cambiar el color;
		bColorTriIs= new JButton();
		bColorTriIs.setText("Color");
		bColorTriIs.setBounds(380,250,100,25);
		bColorTriIs.addActionListener(this);
		//Creamos y colocamos el boton para dibujar la figura
		bTIso=new JButton();
		bTIso.setText("Dibujar");
		bTIso.setBounds(430, 380,100,25);
		bTIso.addActionListener(this);
		//Colocamos lo que hemos creado en el subpanel
		tiso.add(txCord3X);
		tiso.add(caja3X);
		tiso.add(txCord3Y);
		tiso.add(caja3Y);
		tiso.add(txladoigual);
		tiso.add(ladoigual);
		tiso.add(txbase2);
		tiso.add(base2);
		tiso.add(txcolor2);
		tiso.add(colorTriIs);
		tiso.add(bColorTriIs);
		tiso.add(bTIso);
		//Fin de SubPanel}
		
		
		//SubPanelTriangulo Equilatero{
		JPanel tequi=new JPanel();
		tequi.setLayout(null);
		//Creamos y colocamos la etiqueta coordenada X
		JLabel txCord31X= new JLabel();
		txCord31X.setText("Inserte la coordenada x");
		txCord31X.setBounds(150,50,200,25);
		//Creamos y colocamos la caja para ingresar la coordenada X
		caja31X= new JTextField();
		caja31X.setBounds(330,50,100,25);
		//Creamos y colocamos la etiqueta coordenada Y
		JLabel txCord31Y= new JLabel();
		txCord31Y.setText("Inserte la coordenada y");
		txCord31Y.setBounds(150,100,200,25);
		//Creamos y colocamos la caja para ingresar la coordenada Y
		caja31Y= new JTextField();
		caja31Y.setBounds(330,100,100,25);
		//Creamos y colocamos la etiqueta tamLado.
		JLabel txtamLado= new JLabel();
		txtamLado.setText("Tamanio de el lado");
		txtamLado.setBounds(150,150,200,25);
		//Creamos y colocamos la caja para ingresar el tamLado
		tamLado= new JTextField();
		tamLado.setBounds(330,150,100,25);
		//Creamos y colocamos la etiqueta color;
		JLabel txcolor= new JLabel();
		txcolor.setText("Cambiar color");
		txcolor.setBounds(150,200,100,25);
		//Creamos y colocamos la caja de color;
		colorTriEq= new JPanel();
		colorTriEq.setBounds(350,200,20,20);
		colorTriEq.setBorder(BorderFactory.createLoweredBevelBorder());
		colorTriEq.setBackground(Color.gray);
		//Creamos y colocamos el boton para cambiar el color;
		bColorTriEq= new JButton();
		bColorTriEq.setText("Color");
		bColorTriEq.setBounds(380,200,100,25);
		bColorTriEq.addActionListener(this);
		//Creamos el boton para dibujar el triangulo equilatero
		bTequi=new JButton();
		bTequi.setText("Dibujar");
		bTequi.setBounds(430, 380,100,25);
		bTequi.addActionListener(this);
		tequi.add(txCord31X);
		tequi.add(caja31X);
		tequi.add(txCord31Y);
		tequi.add(caja31Y);
		tequi.add(txtamLado);
		tequi.add(tamLado);
		tequi.add(txcolor);
		tequi.add(colorTriEq);
		tequi.add(bColorTriEq);
		tequi.add(bTequi);
		//Fin de SubPanel}
		
		
		//SubPanel para Triangulo escaleno{
		JPanel tirre=new JPanel();
		tirre.setLayout(null);
		//Creamos y colocamos la etiqueta coordenada X1
		JLabel tcordX1= new JLabel();
		tcordX1.setText("Inserte la coordenada x1");
		tcordX1.setBounds(150,50,200,25);
		//Creamos y colocamos la caja para ingresar la coordenada X1
		cordX1= new JTextField();
		cordX1.setBounds(330,50,100,25);
		//Creamos y colocamos la etiqueta coordenada Y1
		JLabel tCordY1= new JLabel();
		tCordY1.setText("Inserte la coordenada y1");
		tCordY1.setBounds(150,100,200,25);
		//Creamos y colocamos la caja para ingresar la coordenada Y1
		cordY1= new JTextField();
		cordY1.setBounds(330,100,100,25);
		//Creamos y colocamos la etiqueta coordenada X2
		JLabel tcordX2= new JLabel();
		tcordX2.setText("Inserte la coordenada x2");
		tcordX2.setBounds(150,150,200,25);
		//Creamos y colocamos la caja para ingresar la coordenada X2
		cordX2= new JTextField();
		cordX2.setBounds(330,150,100,25);
		//Creamos y colocamos la etiqueta coordenada Y2
		JLabel tCordY2= new JLabel();
		tCordY2.setText("Inserte la coordenada y2");
		tCordY2.setBounds(150,200,200,25);
		//Creamos y colocamos la caja para ingresar la coordenada Y2
		cordY2= new JTextField();
		cordY2.setBounds(330,200,100,25);
		//Creamos y colocamos la etiqueta coordenada X3
		JLabel tcordX3= new JLabel();
		tcordX3.setText("Inserte la coordenada x3");
		tcordX3.setBounds(150,250,200,25);
		//Creamos y colocamos la caja para ingresar la coordenada X3
		cordX3= new JTextField();
		cordX3.setBounds(330,250,100,25);
		//Creamos y colocamos la etiqueta coordenada Y3
		JLabel tCordY3= new JLabel();
		tCordY3.setText("Inserte la coordenada y3");
		tCordY3.setBounds(150,300,200,25);
		//Creamos y colocamos la caja para ingresar la coordenada Y3
		cordY3= new JTextField();
		cordY3.setBounds(330,300,100,25);
		//Creamos y colocamos la etiqueta color;
		JLabel txcolor3= new JLabel();
		txcolor3.setText("Cambiar color");
		txcolor3.setBounds(150,350,100,25);
		//Creamos y colocamos la caja de color;
		colorTriEs= new JPanel();
		colorTriEs.setBounds(350,350,20,20);
		colorTriEs.setBorder(BorderFactory.createLoweredBevelBorder());
		colorTriEs.setBackground(Color.gray);
		//Creamos y colocamos el boton para cambiar el color;
		bColorTriEs= new JButton();
		bColorTriEs.setText("Color");
		bColorTriEs.setBounds(380,350,100,25);
		bColorTriEs.addActionListener(this);
		//Creamos el boton para dibujar el triangulo equilatero
		bTesc=new JButton();
		bTesc.setText("Dibujar");
		bTesc.setBounds(430, 380,100,25);
		bTesc.addActionListener(this);
		tirre.add(tcordX1);
		tirre.add(cordX1);
		tirre.add(tCordY1);
		tirre.add(cordY1);
		tirre.add(tcordX2);
		tirre.add(cordX2);
		tirre.add(tCordY2);
		tirre.add(cordY2);
		tirre.add(tcordX3);
		tirre.add(cordX3);
		tirre.add(tCordY3);
		tirre.add(cordY3);
		tirre.add(txcolor3);
		tirre.add(colorTriEs);
		tirre.add(bColorTriEs);
		tirre.add(bTesc);
		
		
	    //Fin de SubPanel}
		
		
		triangulos.addTab("Isosceles",tiso);
		triangulos.addTab("Equilatero",tequi);
		triangulos.addTab("Escaleno",tirre);
		triangulos.setIconAt (0, new ImageIcon("icons/tIso.png"));
		triangulos.setIconAt (1, new ImageIcon("icons/tEqui.png"));
		triangulos.setIconAt (2, new ImageIcon("icons/tEsca.png"));
		panel3.add(triangulos);
		panel3.add(Triangulo);
        pestana.addTab("Triangulo", panel3);
        pestana.setIconAt (2, new ImageIcon("icons/triangulo.png"));
	}
	
	public void panelRectangulo(){
		Font auxFont;
        JPanel panel4=new JPanel();
		panel4.setLayout(null);
		JLabel Rectangulo= new JLabel();
		Rectangulo.setText("Rectangulo");
		Rectangulo.setBounds(200,0,200,50);
		auxFont=Rectangulo.getFont(); 
		Rectangulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
		//Creamos y colocamos la etiqueta coordenada X
		JLabel txCord4X= new JLabel();
		txCord4X.setText("Inserte la coordenada x");
		txCord4X.setBounds(150,100,200,25);
		//Creamos y colocamos la caja para ingresar la coordenada X
		caja4X= new JTextField();
		caja4X.setBounds(330,100,100,25);
		//Creamos y colocamos la etiqueta coordenada Y
		JLabel txCord4Y= new JLabel();
		txCord4Y.setText("Inserte la coordenada y");
		txCord4Y.setBounds(150,150,200,25);
		//Creamos y colocamos la caja para ingresar la coordenada Y
		caja4Y= new JTextField();
		caja4Y.setBounds(330,150,100,25);
		//Creamos y colocamos la etiqueta altura
		JLabel txalt= new JLabel();
		txalt.setText("Inserte la altura");
		txalt.setBounds(150,200,200,25);
		//Creamos y colocamos la caja para ingresar la altura
		altura= new JTextField();
		altura.setBounds(330,200,100,25);
		//Creamos y colocamos la etiqueta base
		JLabel txbas= new JLabel();
		txbas.setText("Inserte la base");
		txbas.setBounds(150,250,200,25);
		//Creamos y colocamos la caja para ingresar la base
		base= new JTextField();
		base.setBounds(330,250,100,25);
		//Creamos y colocamos la etiqueta color;
		JLabel txcolor= new JLabel();
		txcolor.setText("Cambiar color");
		txcolor.setBounds(150,300,100,25);
		//Creamos y colocamos la caja de color;
		colorRecta= new JPanel();
		colorRecta.setBounds(350,300,20,20);
		colorRecta.setBorder(BorderFactory.createLoweredBevelBorder());
		colorRecta.setBackground(Color.gray);
		//Creamos y colocamos el boton para cambiar el color;
		bColorRect= new JButton();
		bColorRect.setText("Color");
		bColorRect.setBounds(380,300,100,25);
		bColorRect.addActionListener(this);
		//Creamos y colocamos el boton para dibujar la figura
		bRectangulo=new JButton();
		bRectangulo.setText("Dibujar");
		bRectangulo.setBounds(450,500,100,25);
		bRectangulo.addActionListener(this);
		panel4.add(Rectangulo);
		panel4.add(txCord4X);
		panel4.add(caja4X);
		panel4.add(txCord4Y);
		panel4.add(caja4Y);
		panel4.add(txalt);
		panel4.add(altura);
		panel4.add(txbas);
		panel4.add(base);
		panel4.add(txcolor);
		panel4.add(colorRecta);
		panel4.add(bColorRect);
		panel4.add(bRectangulo);
        pestana.addTab("Rectangulo", panel4);
		pestana.setIconAt (3, new ImageIcon("icons/rectangulo.png"));
	}
	
	public int validaC(int x, int y, int l){
		if (x>=0){
			if (y>=0){
				if (l>0){
					return 1;
				}
				else return 0;
			}
			else return 0;	
		}
		else return 0;
	}
	
	public int validaTEsca(int x1, int y1, int x2, int y2, int x3, int y3){
		if (x1>=0){
			if (y1>=0){
				if (x2>=0){
					if (y2>=0){
						if (x3>=0){
							if (y3>=0){
								return 1;
							}
							else return 0;
						}
						else return 0;
					}
					else return 0;
				}
				else return 0;
			}
			else return 0;
		}
		else return 0;
		
	}
	
	public int validaTIso(int x, int y, int lad, int base){
		if (x>=0){
			if (y>=0){
				if (lad>=0){
					if (base>=0){
						if (base < lad+lad){
							
							return 1;
						}
						else return 0;
					}
					else return 0;
				}
				else return 0;
			}
			else return 0;
		}
		else return 0;
	}
	
	public int validaRec(int x, int y, int lad, int base){
		if (x>=0){
			if (y>=0){
				if (lad>=0){
					if (base>=0){
						return 1;
					}
					else return 0;
				}
				else return 0;
			}
			else return 0;
		}
		else return 0;
	}
	

    @Override
    public void actionPerformed(ActionEvent e){
		JPanel panel= new JPanel();
		if (e.getSource()==bCuadrado){
			try{
				int cord1 =Integer.parseInt(cajaX.getText());
				int cord2 =Integer.parseInt(cajaY.getText());
				int ladoAux =Integer.parseInt(lado.getText());
				int x= validaC(cord1, cord2, ladoAux);
				if (x!=0){
				   Cuadrados.addLast(new Cuadrado(cord1,cord2,ladoAux,camCuad));
				   mc.dibujaCuadrado(Cuadrados);
				   mc.repaint();
				}
				else{
					JOptionPane.showMessageDialog(panel,"Upps, solo numeros positivos.");
				}
			}
			catch(Exception as){
			  JOptionPane.showMessageDialog(panel, "Upps, solo numeros enteros");	
			}
		}
		
		if (e.getSource()==bCirculo){
			try{
				int cord1 =Integer.parseInt(caja2X.getText());
				int cord2 =Integer.parseInt(caja2Y.getText());
				int radioAux =Integer.parseInt(radio.getText());
				int x= validaC(cord1, cord2, radioAux);
				if (x!=0){
				   Circulos.addLast(new Circulo(cord1,cord2,radioAux,camCirc));
				   mc.dibujaCirculo(Circulos);
				   mc.repaint();
				}
				else{
					JOptionPane.showMessageDialog(panel,"Upps, solo numeros positivos.");
				}
			}
			catch(Exception as){
			  JOptionPane.showMessageDialog(panel, "Upps, solo numeros enteros");	
			}
		}
		
		if (e.getSource()==bRectangulo){
			try{
				int cord1 =Integer.parseInt(caja4X.getText());
				int cord2 =Integer.parseInt(caja4Y.getText());
				int alturaAux =Integer.parseInt(altura.getText());
				int baseAux= Integer.parseInt(base.getText());
				int x= validaRec(cord1, cord2, alturaAux, baseAux);
				if (x!=0){
				   Rectangulos.addLast(new Rectangulo(cord1,cord2,alturaAux,baseAux, camRect));
				   mc.dibujaRectangulo(Rectangulos);
				   mc.repaint();
				}
				else{
					JOptionPane.showMessageDialog(panel,"Upps, solo numeros positivos.");
				}
			}
			catch(Exception as){
			  JOptionPane.showMessageDialog(panel, "Upps, solo numeros enteros");	
			}
		}
		
		if (e.getSource()==bTequi){
			try{
				int cord1 =Integer.parseInt(caja31X.getText());
				int cord2 =Integer.parseInt(caja31Y.getText());
				int ladAux =Integer.parseInt(tamLado.getText());
				int x= validaC(cord1, cord2, ladAux);
				if (x!=0){
				   TriEqui.addLast(new Tequilatero(cord1,cord2,ladAux, camTriEq));
				   mc.dibujaTriEqui(TriEqui);
				   mc.repaint();
				}
				else{
					JOptionPane.showMessageDialog(panel,"Upps, solo numeros positivos.");
				}
			}
			catch(Exception as){
			  JOptionPane.showMessageDialog(panel, "Upps, solo numeros enteros");	
			}
		}
		
		if (e.getSource()==bTIso){
			try{
				int cord1 =Integer.parseInt(caja3X.getText());
				int cord2 =Integer.parseInt(caja3Y.getText());
				int ladAux =Integer.parseInt(ladoigual.getText());
				int baseAux =Integer.parseInt(base2.getText());
				int x= validaTIso(cord1, cord2, ladAux, baseAux);
				if (x!=0){
				   TriIs.addLast(new Tisoceles(cord1,cord2,ladAux, baseAux, camTriIs));
				   mc.dibujaTriIso(TriIs);
				   mc.repaint();
				}
				else{
					JOptionPane.showMessageDialog(panel,"No se puede crear la figura.");
				}
			}
			catch(Exception as){
			  JOptionPane.showMessageDialog(panel, "Upps, solo numeros enteros");	
			}
		}
		
		if (e.getSource()==bTesc){
			try{
				int cordx1 =Integer.parseInt(cordX1.getText());
				int cordy1 =Integer.parseInt(cordY1.getText());
				int cordx2 =Integer.parseInt(cordX2.getText());
				int cordy2 =Integer.parseInt(cordY2.getText());
				int cordx3 =Integer.parseInt(cordX3.getText());
				int cordy3 =Integer.parseInt(cordY3.getText());
				int x= validaTEsca(cordx1, cordy1, cordx2, cordy2, cordx3, cordy3);
				if (x!=0){
				   TriEs.addLast(new Tescaleno(cordx1,cordx2,cordx3, cordy1, cordy2, cordy3, camTriEs));
				   mc.dibujaTriEsca(TriEs);
				   mc.repaint();
				}
				else{
					JOptionPane.showMessageDialog(panel,"Upps, solo numeros positivos.");
				}
			}
			catch(Exception as){
			  JOptionPane.showMessageDialog(panel, "Upps, solo numeros enteros");	
			}
		}
		
		if (e.getSource()==bColorC){
			cambiaC.enciendeCuad();
			cambiaC.setVisible(true);
		}
		
		if (e.getSource()==bColorCirc){
			cambiaC.enciendeCirc();
			cambiaC.setVisible(true);
		}
		
		if (e.getSource()==bColorRect){
			cambiaC.enciendeRect();
			cambiaC.setVisible(true);
		}
		if (e.getSource()==bColorTriEq){
			cambiaC.enciendeTriEq();
			cambiaC.setVisible(true);
		}
		if (e.getSource()==bColorTriIs){
			cambiaC.enciendeTriIs();
			cambiaC.setVisible(true);
		}
		if (e.getSource()==bColorTriEs){
			cambiaC.enciendeTriEs();
			cambiaC.setVisible(true);
		}
		
        if (e.getSource()==boton){
			int resp=JOptionPane.showConfirmDialog(null,"Ya guardo los dibujos realizados?");
				if (JOptionPane.OK_OPTION == resp){
								Cuadrados.clear();
								Circulos.clear();
								Rectangulos.clear();
								mc.limpiaPantalla();
								mc.repaint();;
                    }
				else{
					 JOptionPane.showMessageDialog(panel, "Guarde antes de ejecutar esta opcion, si no se quiere perder lo realizado");
					}
		}
		
		if (e.getSource()== Abrir){		
		    JFileChooser fileChooser=new JFileChooser();
			String nombre=" ";
	 		try
			{
	 			/*llamamos el metodo que permite cargar la ventana*/
	    		fileChooser.showOpenDialog(this);
	    		/*abrimos el archivo seleccionado*/
	 			File abre=fileChooser.getSelectedFile();

	 			if(abre!=null)
	 			{ 				
	 				nombre=fileChooser.getSelectedFile().getName();
					Archivos arch= new Archivos();
					ListaF= arch.abrirArchivo(nombre);
					if (ListaF!= null){
						Cuadrados= ListaF.get(0);
						Rectangulos= ListaF.get(1);
						Circulos= ListaF.get(2);
						TriEqui= ListaF.get(3);
						TriIs= ListaF.get(4);
						TriEs= ListaF.get(5);
						mc.dibujaCuadrado(Cuadrados);
						mc.dibujaRectangulo(Rectangulos);
						mc.dibujaCirculo(Circulos);
						mc.dibujaTriEqui(TriEqui);
						mc.dibujaTriIso(TriIs);
						mc.dibujaTriEsca(TriEs);
						mc.repaint();
					}
	 			} 			
	 		}
	 		catch(Exception ex)
			{
			  JOptionPane.showMessageDialog(null,ex+"" +
			  		"\nNo se ha encontrado el archivo",
			  		"ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource()== Guardar){
			String nombre="";
			JFileChooser file=new JFileChooser();
			try
	 		{
				file.showSaveDialog(this);
				File guarda =file.getSelectedFile();
		
				if(guarda !=null)
				{
		 			nombre=file.getSelectedFile().getName();
		 			Archivos arch= new Archivos();
					ListaF.add(Cuadrados);
					ListaF.add(Rectangulos);
					ListaF.add(Circulos);
					ListaF.add(TriEqui);
					ListaF.add(TriIs);
					ListaF.add(TriEs);
					arch.guardaArchivo(nombre, ListaF);
		 			JOptionPane.showMessageDialog(null,
		 					"El archivo se a guardado Exitosamente",
		 					"Información",JOptionPane.INFORMATION_MESSAGE);
			    }
	 		 }
	 	   catch(Exception ex)
		   {
			 JOptionPane.showMessageDialog(null,
					 "Su archivo no se ha guardado",
					 "Advertencia",JOptionPane.WARNING_MESSAGE);
		   }
		}
		
		if (e.getSource()== Info){
			JOptionPane.showMessageDialog(panel," Dibuja Figuras v1.0 \n Creado por: \n  Fernando Isidro Luna    Matricula: 201441744\n  Yazmin Francisco Lopez    Matricula: 201450312");
		}
    }
	
    public static void main(String[] args) {
        Programa V = new Programa();      // creamos una ventana
        V.setVisible(true);             // hacemos visible la ventana creada
    }
}