import java.io.*;
import javax.swing.*;
import java.util.LinkedList;
import java.awt.*;

class Archivos {
  static FileOutputStream ap;
  static FileInputStream ap2;
  static LinkedList<Cuadrado> Cuadrados= new LinkedList<Cuadrado>();
  static LinkedList<Rectangulo> Rectangulos= new LinkedList<Rectangulo>();
  static LinkedList<Circulo> Circulos= new LinkedList<Circulo>();
  static LinkedList<Tequilatero> TriEqui= new LinkedList<Tequilatero>();
  static LinkedList<Tisoceles> TriIs= new LinkedList<Tisoceles>();
  static LinkedList<Tescaleno> TriEs= new LinkedList<Tescaleno>();
  
  public static void abreArchivoEscribir(String s){
    try{
	  File f= new File(s);	
      ap= new FileOutputStream(f); 
    }
    catch(IOException e){
      System.err.println("No se abrio el archivo"+e.toString());
    }
  }

  public static void abreArchivoLeer(String s){
    try{
	  File f= new File(s);
      ap2= new FileInputStream(f);
    }
    catch(IOException e){
      System.err.println("Error .."+e.toString());
    }
	}

  public static void guardaArchivo(String s, LinkedList<LinkedList> list){
	Cuadrados= list.get(0);
	Rectangulos= list.get(1);
	Circulos= list.get(2);
	TriEqui= list.get(3);
	TriIs= list.get(4);
	TriEs= list.get(5);
    abreArchivoEscribir(s);
   try{
		ObjectOutputStream salida= new ObjectOutputStream(ap);
		salida.writeObject(Cuadrados);
		salida.writeObject(Rectangulos);
		salida.writeObject(Circulos);
		salida.writeObject(TriEqui);
		salida.writeObject(TriIs);
		salida.writeObject(TriEs);
		salida.close();
	}
    catch(IOException e){}
   }
   
   public static LinkedList<LinkedList> abrirArchivo(String s) throws ClassNotFoundException, IOException{
	abreArchivoLeer(s);
	LinkedList<LinkedList> ListaF= new LinkedList<LinkedList>();
   try{
		ObjectInputStream entrada=new ObjectInputStream(ap2);
		LinkedList<Cuadrado> lst1=(LinkedList<Cuadrado>) entrada.readObject();
		Cuadrados= lst1;
		LinkedList<Rectangulo> lst2=(LinkedList<Rectangulo>) entrada.readObject();
		Rectangulos= lst2;
		LinkedList<Circulo> lst3=(LinkedList<Circulo>) entrada.readObject();
		Circulos= lst3;
		LinkedList<Tequilatero> lst4=(LinkedList<Tequilatero>) entrada.readObject();
		TriEqui= lst4;
		LinkedList<Tisoceles> lst5=(LinkedList<Tisoceles>) entrada.readObject();
		TriIs= lst5;
		LinkedList<Tescaleno> lst6=(LinkedList<Tescaleno>) entrada.readObject();
		TriEs= lst6;
		entrada.close();
		ListaF.add(Cuadrados);
		ListaF.add(Rectangulos);
		ListaF.add(Circulos);
		ListaF.add(TriEqui);
		ListaF.add(TriIs);
		ListaF.add(TriEs);
		return ListaF;
	}
    catch(IOException e){System.err.println("Error ..");}
	return ListaF;
   }   
  }