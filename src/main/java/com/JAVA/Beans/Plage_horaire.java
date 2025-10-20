package com.JAVA.Beans;

public class Plage_horaire {
	
	private int id_plg;
	private int heure_deb;
	private int heure_fin;
	
	public Plage_horaire() {
		
	}
	
	
	public Plage_horaire(int id_plg, int heure_deb, int heure_fin) {
		super();
		this.id_plg = id_plg;
		this.heure_deb = heure_deb;
		this.heure_fin = heure_fin;
	}
	
	public int getId_plg() {
		return id_plg;
	}
	public void setId_plg(int id_plg) {
		this.id_plg = id_plg;
	}
	public int getHeure_deb() {
		return heure_deb;
	}
	public void setHeure_deb(int heure_deb) {
		this.heure_deb = heure_deb;
	}
	public int getHeure_fin() {
		return heure_fin;
	}
	public void setHeure_fin(int heure_fin) {
		this.heure_fin = heure_fin;
	}
	
	

}
