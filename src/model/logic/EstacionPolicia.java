package model.logic;

public class EstacionPolicia {
	
	private int id;
	private Double longitud;
	private Double latitud;
	private String direccion;
	private String descripcion;
	private String correo;
	
	
	public EstacionPolicia(int id, Double longitud, Double latitud, String direccion, String descripcion,
			String correo) 
	{
		this.id = id;
		this.longitud = longitud;
		this.latitud = latitud;
		this.direccion = direccion;
		this.descripcion = descripcion;
		this.correo = correo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Double getLongitud() {
		return longitud;
	}


	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}


	public Double getLatitud() {
		return latitud;
	}


	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
	
	
}
