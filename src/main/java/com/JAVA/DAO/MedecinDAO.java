package com.JAVA.DAO;

import java.util.ArrayList;
import java.util.Map;

import com.JAVA.Beans.Medecin;

public interface MedecinDAO {

	ArrayList<Medecin> getAll_Spec(int id_spec) throws DAOException;
	
	ArrayList<Medecin> getAll() throws DAOException;
	
	Map<Integer, Integer> getStat() throws DAOException;
	
	void create(Medecin med) throws DAOException;
    void delete(int id) throws DAOException; // Supprimer un médecin


}
