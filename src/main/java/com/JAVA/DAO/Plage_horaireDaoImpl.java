package com.JAVA.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.JAVA.Beans.Plage_horaire;

public class Plage_horaireDaoImpl implements Plage_horaireDAO {

	private DAOFactory  daoFactory;

    public Plage_horaireDaoImpl( DAOFactory daoFactory ) {
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
	public ArrayList<Plage_horaire> getAll() throws DAOException {
		
		ArrayList<Plage_horaire> liste_plg = new ArrayList<>();
		final String SQL_SELECT = "Select * from plage_horaire";
		Connection connexion = null;
		PreparedStatement prepstatement = null;
		ResultSet resultset = null;
		
		try {
			/*Récupération d'une connexion depuis la DAOFactory*/
			connexion = daoFactory.getConnection();
			prepstatement = initRequestPrepare(connexion,SQL_SELECT);
			resultset = prepstatement.executeQuery();
			while(resultset.next()) {
				int id = resultset.getInt("id_plg");
				int heure_deb = resultset.getInt("heure_deb");
				int heure_fin = resultset.getInt("heure_fin");
				
				liste_plg.add(new Plage_horaire(id,heure_deb,heure_fin));
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
		        //ClosingAll( resultSet, preparedStatement, connexion );
		    }
		
		
		return liste_plg;
	}

}
