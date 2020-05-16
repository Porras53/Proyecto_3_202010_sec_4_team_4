package model.logic;

public class EstacionPolicia {
	
	


	private int id;
	private Double longitud;
	private Double latitud;
	private String direccion;
	private String descripcion;
	private String correo;
	private String servicio;
	private String horario;
	private String telefono;
	private String local;
	
	
	public EstacionPolicia(int id, Double longitud, Double latitud, String direccion, String descripcion, String correo,
			String servicio, String horario, String telefono, String local) {
		super();
		this.id = id;
		this.longitud = longitud;
		this.latitud = latitud;
		this.direccion = direccion;
		this.descripcion = descripcion;
		this.correo = correo;
		this.servicio = servicio;
		this.horario = horario;
		this.telefono = telefono;
		this.local = local;
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



	@Override
	public String toString() {
		return "EstacionPolicia [id=" + id + ", longitud=" + longitud + ", latitud=" + latitud + ", direccion="
				+ direccion + ", descripcion=" + descripcion + ", correo=" + correo + ", servicio=" + servicio
				+ ", horario=" + horario + ", telefono=" + telefono + ", local=" + local + "]";
	}



	public String getServicio() {
		return servicio;
	}



	public void setServicio(String servicio) {
		this.servicio = servicio;
	}



	public String getHorario() {
		return horario;
	}



	public void setHorario(String horario) {
		this.horario = horario;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getLocal() {
		return local;
	}



	public void setLocal(String local) {
		this.local = local;
	}
	
	
	
	
}
