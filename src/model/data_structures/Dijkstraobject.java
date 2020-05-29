package model.data_structures;

public class Dijkstraobject implements Comparable<Dijkstraobject> {
	private int idOrigen;
	private double costo;
	private int  idDestino;
	public Dijkstraobject(int idOrigen, double costo, int idDestino) {
		super();
		this.idOrigen = idOrigen;
		this.costo = costo;
		this.idDestino = idDestino;
	}
	public int getIdOrigen() {
		return idOrigen;
	}
	public void setIdOrigen(int idOrigen) {
		this.idOrigen = idOrigen;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public int getIdDestino() {
		return idDestino;
	}
	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}
	@Override
	public int compareTo(Dijkstraobject o) {
		
		// TODO Auto-generated method stub
		return (int) (costo-o.getCosto());
	}

}
