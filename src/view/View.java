package view;

import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("Ejecutar en orden(1,2,3,4):");
			System.out.println("1. Cargar comparendos.");
			System.out.println("2. Crear Json.");
			System.out.println("3. Cargar Json.");
			System.out.println("4. Mostrar Grafo.");
			System.out.println("5. Punto1A.");
			System.out.println("6. Punto2A.");
			System.out.println("7. Punto1C.");
			System.out.println("8. Punto2C.");
			System.out.println("9. Punto1B.");
			System.out.println("10. Punto2B.");
			System.out.println("11. Exit");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		
}
