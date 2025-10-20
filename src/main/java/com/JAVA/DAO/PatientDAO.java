package com.JAVA.DAO;

import java.util.ArrayList;

import com.JAVA.Beans.Patient;

public interface PatientDAO {

	boolean auth(int id, String pass) throws DAOException;
	
	ArrayList<Patient> getAll() throws DAOException;
}
