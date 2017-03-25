import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class ColorSelector extends JFrame implements ChangeListener {
    JColorChooser Colores; // Declaramos el JColorChooser con el nombre de Colores
	private int banCuad;
	private int banCirc;
	private int banRect;
	private int banTriEq;
	private int banTriEs;
	private int banTriIs;
    
	public ColorSelector(){
        setTitle("Color de figura"); // Título de la ventana.
        setDefaultCloseOperation(HIDE_ON_CLOSE); // Termina la ejecución al cerrar.
        Colores = new JColorChooser(); // Agrega el objeto JColorChooser.
        Colores.getSelectionModel().addChangeListener(this); // Agrega los eventos de cambios.
        Colores.setMaximumSize(new Dimension(100,100)); // Determina el tamaño.
        setLayout(new BorderLayout()); // Cuestiones de posición sobre el JFrame.
        add(Colores, BorderLayout.CENTER); // Agrega al JFrame
        pack();
		banCuad=banCirc=banRect=banTriEq=banTriEs=banTriIs=0;
    }
	
	public void enciendeCuad(){
		banCuad=1;
		banCirc=banRect=banTriEq=banTriEs=banTriIs=0;
	}
	
	public void enciendeCirc(){
		banCirc=1;
		banCuad=banRect=banTriEq=banTriEs=banTriIs=0;
	}
	
	public void enciendeTriEq(){
		banTriEq=1;
		banCuad=banCirc=banRect=banTriEs=banTriIs=0;
	}
	
	public void enciendeRect(){
		banRect=1;
		banCuad=banCirc=banTriEq=banTriEs=banTriIs=0;
	}
	
	public void enciendeTriEs(){
		banTriEs=1;
		banCuad=banCirc=banRect=banTriEq=banTriIs=0;
	}
	
	public void enciendeTriIs(){
		banTriIs=1;
		banCuad=banCirc=banRect=banTriEq=banTriEs=0;
	}
	
    @Override
    public void stateChanged(ChangeEvent e){
		if (banCuad!=0){
			Programa.colorCuad.setBackground(Colores.getColor());
			Programa.camCuad= Colores;
			}
		if (banCirc!=0){
			Programa.colorCirc.setBackground(Colores.getColor());
			Programa.camCirc= Colores;
		}
		if (banTriEq!=0){
			Programa.colorTriEq.setBackground(Colores.getColor());
			Programa.camTriEq=Colores;
		}
		if (banRect!=0){
			Programa.colorRecta.setBackground(Colores.getColor());
			Programa.camRect= Colores;
		}
		if (banTriEs!=0){
			Programa.colorTriEs.setBackground(Colores.getColor());
			Programa.camTriEs= Colores;
		}
		if (banTriIs!=0){
			Programa.colorTriIs.setBackground(Colores.getColor());
			Programa.camTriIs= Colores;
		}
    } 
}