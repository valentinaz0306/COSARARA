package main;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import excepciones.BolasException;
import processing.core.PApplet;

public class Main extends PApplet {

	// arraylist bolas
	private ArrayList<Bola> figuras;
	// contador
	private int CANTIDAD_FIGURAS = 20;
	private static boolean mensaje;
	
	public static void main(String[] args) {
		PApplet.main("main.Main");
		
		probarExcepciones();
	 
	}

	public void settings() {
		size(800, 800);

	}

	public void setup() {

		figuras = new ArrayList<Bola>();
		mensaje=false;

	}

	public void draw() {
		background(0);

		for (int i = 0; i < figuras.size() - 1; i++) {

			figuras.get(i).pintar();
			new Thread(figuras.get(i)).start();

		}
		
		if (mensaje) {
		fill(255);
		text("Ya no hay elementos",400,400);
		}

	}// cierra draw

	/*public void rebotar() {

		for (int i = 0; i < figuras.size(); i++) {
			Bola b = figuras.get(i);
			for (int j = 0; j < figuras.size(); i++) {
				if (i != j) {
					double distanciaB = dist(b.getPosx(), b.getPosy(), figuras.get(j).getPosx(),
							figuras.get(j).getPosy());
					if (b.getR() + figuras.get(j).getR() <= distanciaB) {
						if(b.getR()==figuras.get(j).getR()) {
							
							
						}
					}

				}
			}

		}

	}*/

	public void mousePressed() {

		for (int i = 0; i < CANTIDAD_FIGURAS; i++) {
			Bola temp = new Bola(mouseX, mouseY, this);
			figuras.add(temp);

		}

	}
	
	public static void probarExcepciones() {
		//lanzar excepcion
		
		try{
			throw new BolasException();
			
		} catch(BolasException e){
		
			System.out.println("mensaje 1");
			//JOptionPane.showMessageDialog(null, "Hello World");
			mensaje=true;
		}
		
	}

}// cierra main
