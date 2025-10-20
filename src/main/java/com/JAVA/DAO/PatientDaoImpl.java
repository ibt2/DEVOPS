package com.JAVA.DAO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.JAVA.Beans.Medecin;
import com.JAVA.Beans.Patient;

public class PatientDaoImpl implements PatientDAO {

	private DAOFactory  daoFactory;

    public PatientDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    
    public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
	    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
	    for ( int i = 0; i < objets.length; i++ ) {
	        preparedStatement.setObject( i + 1, objets[i] );
	    }
	    return preparedStatement;
	}
	
    
	@Override
	public boolean auth(int id, String pass) throws DAOException {
		boolean bool = false;
		String  password = null;
		final String SQL_SELECT = "Select password from Patient where id_pat = ?";
		Connection connexion = null;
		PreparedStatement prepstatement = null;
		ResultSet resultset = null;
		
		try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        prepstatement = initRequestPrepare(connexion,SQL_SELECT,id);
	        resultset = prepstatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if(!resultset.next()) {
	        	bool = false;
	        }
	        else {
	        	
	               password = resultset.getString( "password" );
	               bool = password.equals(pass);
	               }
	  
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }

		
		return bool;
	}

	@Override
	public ArrayList<Patient> getAll() throws DAOException {
		ArrayList<Patient> liste_pat = new ArrayList<>();
	    final String SQL_SELECT = "SELECT * FROM Patient";
	    Connection connexion = null;
	    PreparedStatement prepstatement = null;
	    ResultSet resultSet = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        prepstatement = initRequestPrepare(connexion,SQL_SELECT);
	        resultSet = prepstatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        while ( resultSet.next() ) {
	               int id = resultSet.getInt( "id_pat" );
	               String  nom = resultSet.getString( "nom" );
	               String  prenom = resultSet.getString( "prenom" );
	               int telephone = resultSet.getInt( "telephone" );
	               String pass = resultSet.getString( "password" );
	               
	               /*Ajout des données dans l'ArrayList de javabean*/
	               liste_pat.add(new Patient(id,nom,prenom,telephone,pass));
	               }
	  
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }

		
		return liste_pat;
	}

}
