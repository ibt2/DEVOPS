package com.JAVA.Beans;

public class RDV {
	private int id_med;
	private int id_pat;
	private String jour;
	private int id_plg;
	
	public RDV() {
	}
	
	public RDV(int id_med, int id_pat, String jour, int id_plg) {
		
		this.id_med = id_med;
		this.id_pat = id_pat;
		this.jour = jour;
		this.id_plg = id_plg;
	}
	
	public int getId_med() {
		return id_med;
	}
	public void setId_med(int id_med) {
		this.id_med = id_med;
	}
	public int getId_pat() {
		return id_pat;
	}
	public void setId_pat(int id_pat) {
		this.id_pat = id_pat;
	}
	public String getJour() {
		return jour;
	}
	public void setJour(String jour) {
		this.jour = jour;
	}
	public int getId_plg() {
		return id_plg;
	}
	public void setId_plg(int id_plg) {
		this.id_plg = id_plg;
	}
	
	
}
