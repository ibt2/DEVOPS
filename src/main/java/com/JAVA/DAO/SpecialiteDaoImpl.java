package com.JAVA.DAO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.JAVA.Beans.Specialite;
import com.JAVA.DAO.SpecialiteDAO;


public class SpecialiteDaoImpl implements SpecialiteDAO {

	private DAOFactory  daoFactory;

    public SpecialiteDaoImpl( DAOFactory daoFactory ) {
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
	public ArrayList<Specialite> getAll() throws DAOException {
		// TODO Auto-generated method stub
		
			ArrayList<Specialite> liste_specialite = new ArrayList<>();
		    final String SQL_SELECT = "SELECT * FROM specialite";
		    Connection connexion = null;
		    Statement statement = null;
		    ResultSet resultSet = null;

		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        statement = connexion.createStatement();
		        resultSet = statement.executeQuery(SQL_SELECT);
		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
		        while ( resultSet.next() ) {
		               int id_spe = resultSet.getInt( "id_spe" );
		               String  nom = resultSet.getString( "nom" );
		               
		               /*Ajout des données dans l'ArrayList de javabean*/
		               liste_specialite.add(new Specialite(id_spe,nom));
		               }
		  
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		        //ClosingAll( resultSet, preparedStatement, connexion );
		    }

		    return liste_specialite;
		}


	@Override
	public void create(Specialite specialite) throws DAOException {
		
		String nom_spe = specialite.getNom();
		final String SQL_SELECT = "insert into specialite(nom) values(?)";
		PreparedStatement prepstatement = null;
	    Connection connexion = null;
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        prepstatement = initRequestPrepare(connexion,SQL_SELECT,nom_spe);
	        prepstatement.executeUpdate();
	      
	       
	  
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
		
		
	}
	 // Mettre à jour une spécialité
    @Override
    public void update(Specialite specialite) throws DAOException {
        String query = "UPDATE specialite SET nom = ? WHERE id_spe = ?";

        try (Connection connection = daoFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, specialite.getNom());
            preparedStatement.setInt(2, specialite.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur lors de la mise à jour de la spécialité", e);
        }
    }

    // Supprimer une spécialité
    @Override
    public void delete(int id_specialite) throws DAOException {
        String query = "DELETE FROM specialite WHERE id_spe = ?";

        try (Connection connection = daoFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id_specialite);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur lors de la suppression de la spécialité", e);
        }
    }

}
