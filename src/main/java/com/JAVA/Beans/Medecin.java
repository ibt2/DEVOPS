package com.JAVA.Beans;

public class Medecin {
	
	private int id;
	private String nom;
	private String prenom;
	private int telephone;
	private int id_spe;
	
	public Medecin() {
		
	}
	
	
	public Medecin(int id, String nom, String prenom, int telephone, int id_spe) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.id_spe = id_spe;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public int getId_spe() {
		return id_spe;
	}
	public void setId_spe(int id_spe) {
		this.id_spe = id_spe;
	}
	
	
}
