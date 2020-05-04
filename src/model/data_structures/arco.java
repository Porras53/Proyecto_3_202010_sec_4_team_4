package model.data_structures;

public class arco<K extends Comparable <K>, V, C> {

	private vertice <K,V,C>vInicio;
	private vertice <K,V,C>vFinal;
	private C costo;
	public vertice<K, V, C> getvInicio() {
		return vInicio;
	}
	public void setvInicio(vertice<K, V, C> vInicio) {
		this.vInicio = vInicio;
	}
	public vertice<K, V, C> getvFinal() {
		return vFinal;
	}
	public void setvFinal(vertice<K, V, C> vFinal) {
		this.vFinal = vFinal;
	}
	public C getCosto() {
		return costo;
	}
	public void setCosto(C costo) {
		this.costo = costo;
	}
	public arco(vertice<K, V, C> vInicio, vertice<K, V, C> vFinal, C costo) {
		super();
		this.vInicio = vInicio;
		this.vFinal = vFinal;
		this.costo = costo;
	}
	public boolean contiene(vertice v1, vertice v2)
	{
		if((v1.equals(vInicio)&&v2.equals(vFinal))||(v1.equals(vFinal)&&v2.equals(vInicio))) 
			return true;
			
		
		else
			return false;
	}
}
