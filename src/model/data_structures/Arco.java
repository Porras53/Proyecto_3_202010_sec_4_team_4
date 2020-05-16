package model.data_structures;

public class Arco<K extends Comparable <K>, V, C> {

	private Vertice <K,V,C>vInicio;
	private Vertice <K,V,C>vFinal;
	private C costo;
	private C costo2;
	
	public Vertice<K, V, C> getvInicio() {
		return vInicio;
	}
	
	public void setvInicio(Vertice<K, V, C> vInicio) {
		this.vInicio = vInicio;
	}
	
	public Vertice<K, V, C> getvFinal() {
		return vFinal;
	}
	
	public void setvFinal(Vertice<K, V, C> vFinal) {
		this.vFinal = vFinal;
	}
	
	public C getCosto() {
		return costo;
	}
	
	public C getCosto2() {
		return costo2;
	}
	
	public void setCosto(C costo) {
		this.costo = costo;
	}
	
	public Arco(Vertice<K, V, C> vInicio, Vertice<K, V, C> vFinal, C costo, C costo2) {
		super();
		this.vInicio = vInicio;
		this.vFinal = vFinal;
		this.costo = costo;
		this.costo2=costo2;
	}
	
	public boolean contiene(Vertice v1, Vertice v2)
	{
		if((v1.equals(vInicio)&&v2.equals(vFinal))||(v1.equals(vFinal)&&v2.equals(vInicio))) 
			return true;


		else
			return false;
	}
}
