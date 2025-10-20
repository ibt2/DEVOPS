package com.JAVA.DAO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.JAVA.Beans.Disponibilite;
import com.JAVA.Beans.Medecin;


public class DisponibiliteDaoImpl implements DisponibiliteDAO {
	
	private DAOFactory  daoFactory;

    public DisponibiliteDaoImpl( DAOFactory daoFactory ) {
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
   	public ArrayList<Disponibilite> getAll_fromMed(int id_med) throws DAOException {
   		// TODO Auto-generated method stub
   		
   			ArrayList<Disponibilite> liste_disponibilite = new ArrayList<>();
   		    final String SQL_SELECT = "SELECT * FROM Disponibilite where id_med_f = ? and disponible = 1";
   		    Connection connexion = null;
   		    PreparedStatement prepstatement = null;
   		    ResultSet resultSet = null;

   		    try {
   		        /* Récupération d'une connexion depuis la Factory */
   		        connexion = daoFactory.getConnection();
   		        prepstatement = initRequestPrepare(connexion,SQL_SELECT,id_med);
   		        resultSet = prepstatement.executeQuery();
   		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
   		        while ( resultSet.next() ) {
   		               int id = resultSet.getInt( "id_disp" );
   		               String  jour = resultSet.getString( "jour" );
   		               boolean  disponible = resultSet.getBoolean( "disponible" );
   		               int id_medecin = resultSet.getInt( "id_med_f" );
   		               int id_plg = resultSet.getInt( "id_plg_f" );
   		               
   		               /*Ajout des données dans l'ArrayList de javabean*/
   		               liste_disponibilite.add(new Disponibilite(id,jour,disponible,id_medecin,id_plg));
   		               }
   		  
   		    } catch ( SQLException e ) {
   		        throw new DAOException( e );
   		    } finally {
   		        //ClosingAll( resultSet, preparedStatement, connexion );
   		    }

   		    return liste_disponibilite;
   		}

	@Override
	public void modif_disp(int id) throws DAOException {
		
		final String SQL_SELECT = "update disponibilite set disponible = 0 where id_disp = ?";
		Connection connexion = null;
		PreparedStatement prepstatement = null;
		
		try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        prepstatement = initRequestPrepare(connexion,SQL_SELECT,id);
	        prepstatement.executeUpdate();
	        
	  
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }

		
	}


}
