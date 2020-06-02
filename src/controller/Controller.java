package controller;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.data_structures.HashLinearProbing;
import model.data_structures.HashSeparateChaining;
import model.data_structures.ListaDoblementeEncadenada;
import model.data_structures.Node;
import model.data_structures.NodoHash;
import model.data_structures.NodoHash22;
import model.logic.Comparendo;
import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}



	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String respuesta = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:
				modelo = new Modelo();
				view.printMessage("Cargando los comparendos...");

				try {


					modelo.cargarGrafo();


				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
			case 2: 
				modelo.escribirJson();
				break;
			case 3: 

				modelo.leerJson();;
				break;	
			case 4: 

				modelo.dibujarTodin();
				break;	
			
				
			case 5: 
				view.printMessage("Inserte la longitud 1: \n---------"); 
				Double longitud1 = lector.nextDouble();
				
				view.printMessage("Inserte la latitud 1: \n---------"); 
				Double latitud1 = lector.nextDouble();
				
				view.printMessage("Inserte la longitud 2: \n---------"); 
				Double longitud2 = lector.nextDouble();
				
				view.printMessage("Inserte la latitud 2: \n---------"); 
				Double latitud2 = lector.nextDouble();
				
				modelo.parteA1(longitud1, latitud1, longitud2, latitud2);
				break;	
			
			case 6: 
				view.printMessage("Inserte la cantidad M de comparendos graves que quiere ver: \n---------"); 
				Integer m = lector.nextInt();
				
				
				
				modelo.parteA2(m);
				break;	
				
				
			case 7: 
				view.printMessage("Inserte la cantidad M de comparendos graves que quiere ver: \n---------"); 
				m = lector.nextInt();
				
				
				
				modelo.parteC1(m);
				break;	
				
			case 8: 				
				modelo.parteC2();
				break;	
				
			case 9: 
				view.printMessage("Inserte la longitud 1: \n---------"); 
				longitud1 = lector.nextDouble();
				
				view.printMessage("Inserte la latitud 1: \n---------"); 
				latitud1 = lector.nextDouble();
				
				view.printMessage("Inserte la longitud 2: \n---------"); 
				longitud2 = lector.nextDouble();
				
				view.printMessage("Inserte la latitud 2: \n---------"); 
				latitud2 = lector.nextDouble();
				
				modelo.parteB1(longitud1, latitud1, longitud2, latitud2);
				break;
				
			case 10: 
				view.printMessage("Inserte la cantidad M de comparendos graves que quiere ver: \n---------"); 
				m = lector.nextInt();
				
				
				
				modelo.parteB2(m);
				break;		
				
				
			case 11: 
				view.printMessage("--------- \n Hasta pronto !! \n---------"); 
				lector.close();
				fin = true;
				break;

			default: 
				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}

	}	
}
