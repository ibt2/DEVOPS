package com.JAVA.DAO;

import java.util.ArrayList;

import com.JAVA.Beans.RDV;

public interface RDVDAO {
	
	void create(RDV rdv) throws DAOException;
	
	ArrayList<RDV> getAll_frompat(int id_pat) throws DAOException;
	
	ArrayList<RDV> getAll_frommed(int id_med) throws DAOException;

}
