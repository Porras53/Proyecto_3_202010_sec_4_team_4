package model.logic;

import model.data_structures.HashSeparateChaining;
import model.data_structures.*;

public class Sectores {
	

	private Double latmax;
	
	private Double latmin;
	
	private Double longmax;
	
	private Double longmin;	
	
	private Double intervalolat;
	
	private Double intervalolong;
	
	private Double n;

	private HashSeparateChaining<Integer,Sector> sectores;
	
	public Sectores(Double latmax, Double latmin, Double longmax, Double longmin, Double interlong, Double interlat , Double nn) {
		this.latmax = latmax;
		this.latmin = latmin;
		this.longmax = longmax;
		this.longmin = longmin;
		sectores= new HashSeparateChaining<Integer, Sector>();
		intervalolat=interlat;
		intervalolong=interlong;
		n=nn;
	}
	
	
	public Integer elSectorenelqueesta(Double lat, Double longi) 
	{
		
		Integer retorno=-1;
		
		if(lat>=latmin && lat<=latmax && longi>=longmin && longi<=longmax) {
			
		for(int nnn=0;nnn<n*n;nnn++) 
		{
			
			Sector actual=sectores.getSet(nnn).darCabeza();
			if(actual.verificarIntervalo(lat, longi)) 
			{
				retorno=nnn;
			}
		}
		
		}
		return retorno;
	}
	
	public Sector getSector(Integer id) 
	{
		return sectores.getSet(id).darCabeza();
	}
	
	public void agregarSector(Integer id, Sector nuevo) 
	{
		sectores.putInSet(id, nuevo);
	}
	
	public Double getLatmax() {
		return latmax;
	}

	public void setLatmax(Double latmax) {
		this.latmax = latmax;
	}

	public Double getLatmin() {
		return latmin;
	}

	public void setLatmin(Double latmin) {
		this.latmin = latmin;
	}

	public Double getLongmax() {
		return longmax;
	}

	public void setLongmax(Double longmax) {
		this.longmax = longmax;
	}

	public Double getLongmin() {
		return longmin;
	}

	public void setLongmin(Double longmin) {
		this.longmin = longmin;
	}
	
	
	
}
