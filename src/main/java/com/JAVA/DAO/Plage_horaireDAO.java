package com.JAVA.DAO;

import java.util.ArrayList;

import com.JAVA.Beans.Plage_horaire;


public interface Plage_horaireDAO {
	
	ArrayList<Plage_horaire> getAll() throws DAOException;

}
