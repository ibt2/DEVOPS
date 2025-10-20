package com.JAVA.DAO;

import com.JAVA.Beans.Specialite;

import java.util.ArrayList;

public interface SpecialiteDAO {
	
	void create(Specialite specialite) throws DAOException;
	
	ArrayList<Specialite> getAll() throws DAOException;
	 void update(Specialite specialite) throws DAOException; // Mettre à jour une spécialité
	    void delete(int id_spe) throws DAOException;  // Supprimer une spécialité
}
