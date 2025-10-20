package com.JAVA.DAO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.JAVA.Beans.Medecin;


public class MedecinDaoImpl implements MedecinDAO {

	private DAOFactory  daoFactory;

    public MedecinDaoImpl( DAOFactory daoFactory ) {
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
	public ArrayList<Medecin> getAll_Spec(int id_spec) throws DAOException {
		// TODO Auto-generated method stub
		
			ArrayList<Medecin> liste_medecin = new ArrayList<>();
		    final String SQL_SELECT = "SELECT * FROM Medecin where id_spe_f = ?";
		    Connection connexion = null;
		    PreparedStatement prepstatement = null;
		    ResultSet resultSet = null;

		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        prepstatement = initRequestPrepare(connexion,SQL_SELECT,id_spec);
		        resultSet = prepstatement.executeQuery();
		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
		        while ( resultSet.next() ) {
		               int id = resultSet.getInt( "id_med" );
		               String  nom = resultSet.getString( "nom" );
		               String  prenom = resultSet.getString( "prenom" );
		               int telephone = resultSet.getInt( "telephone" );
		               int id_spe = resultSet.getInt( "id_spe_f" );
		               
		               /*Ajout des données dans l'ArrayList de javabean*/
		               liste_medecin.add(new Medecin(id,nom,prenom,telephone,id_spe));
		               }
		  
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		        //ClosingAll( resultSet, preparedStatement, connexion );
		    }

		    return liste_medecin;
		}

	@Override
	public ArrayList<Medecin> getAll() throws DAOException {
		
		ArrayList<Medecin> liste_medecin = new ArrayList<>();
	    final String SQL_SELECT = "SELECT * FROM Medecin";
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
	               int id = resultSet.getInt( "id_med" );
	               String  nom = resultSet.getString( "nom" );
	               String  prenom = resultSet.getString( "prenom" );
	               int telephone = resultSet.getInt( "telephone" );
	               int id_spe = resultSet.getInt( "id_spe_f" );
	               
	               /*Ajout des données dans l'ArrayList de javabean*/
	               liste_medecin.add(new Medecin(id,nom,prenom,telephone,id_spe));
	               }
	  
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }

		
		// TODO Auto-generated method stub
		return liste_medecin;
	}

	@Override
	public Map<Integer, Integer> getStat() throws DAOException {
		
		Map<Integer, Integer> data = new HashMap<>();
		final String SQL_SELECT = "SELECT id_spe_f, COUNT(*) AS count FROM medecin GROUP BY id_spe_f";
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
	               
	        	data.put(resultSet.getInt("id_spe_f"), resultSet.getInt("count"));
	               
	               }
	  
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }

		
		return data;
	}

	@Override
	public void create(Medecin med) throws DAOException {
		
	    final String SQL_INSERT = "insert into Medecin values(0,?,?,?,?)";
	    Connection connexion = null;
	    PreparedStatement prepstatement = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        prepstatement = initRequestPrepare(connexion,SQL_INSERT,med.getNom(),med.getPrenom(),med.getTelephone(),med.getId_spe());
	        prepstatement.executeUpdate();
	        
	  
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
		
		
	}

	 @Override
	    public void delete(int id) throws DAOException {
	        String query = "DELETE FROM medecin WHERE id_med = ?";

	        try (Connection connection = daoFactory.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	            preparedStatement.setInt(1, id);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            throw new DAOException("Erreur lors de la suppression du médecin", e);
	        }
	    }
    
    
}
