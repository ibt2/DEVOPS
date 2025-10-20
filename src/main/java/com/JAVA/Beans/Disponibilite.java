package com.JAVA.Beans;

public class Disponibilite {

	private int id;
	private String jour;
	private boolean disponible;
	private int id_medF;
	private int id_plgF;
	
	public Disponibilite() {
		
	}
	
	
	public Disponibilite(int id, String jour, Boolean disponible, int id_medF, int id_plgF) {
		
		this.id = id;
		this.jour = jour;
		this.disponible = disponible;
		this.id_medF = id_medF;
		this.id_plgF = id_plgF;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJour() {
		return jour;
	}
	public void setJour(String jour) {
		this.jour = jour;
	}
	public boolean getDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public int getId_medF() {
		return id_medF;
	}
	public void setId_medF(int id_medF) {
		this.id_medF = id_medF;
	}
	public int getId_plgF() {
		return id_plgF;
	}
	public void setId_plgF(int id_plgF) {
		this.id_plgF = id_plgF;
	}
	
	
}
