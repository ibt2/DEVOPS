package com.JAVA.DAO;

import java.util.ArrayList;

import com.JAVA.Beans.Disponibilite;

public interface DisponibiliteDAO {

	ArrayList<Disponibilite> getAll_fromMed(int id_med) throws DAOException;
	
	void modif_disp(int id) throws DAOException;

}
