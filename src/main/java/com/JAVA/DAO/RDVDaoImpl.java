package com.JAVA.DAO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.JAVA.Beans.Disponibilite;
import com.JAVA.Beans.RDV;

public class RDVDaoImpl implements RDVDAO {

	private DAOFactory  daoFactory;

    public RDVDaoImpl( DAOFactory daoFactory ) {
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
    public void create(RDV rdv) throws DAOException {
        final String SQL_INSERT = "INSERT INTO rdv (id_med_f, id_pat_f, jour, plg_horaire) VALUES (?, ?, ?, ?)";
        Connection connexion = null;
        PreparedStatement prepstatement = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            prepstatement = initRequestPrepare(connexion, SQL_INSERT, rdv.getId_med(), rdv.getId_pat(), rdv.getJour(), rdv.getId_plg());
            prepstatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            if (prepstatement != null) {
                try {
                    prepstatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connexion != null) {
                try {
                    connexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


	@Override
	public ArrayList<RDV> getAll_frompat(int id_pat) throws DAOException {
		
		int id_med1;
		int id_pat1;
		String jour;
		int id_plg;
		ArrayList<RDV> liste_rdv = new ArrayList<>();
		final String SQL_SELECT = "select * from rdv where id_pat_f = ?";
		Connection connexion = null;
		PreparedStatement prepstatement = null;
		ResultSet resultset = null;
		
		try {
			connexion = daoFactory.getConnection();
			prepstatement = initRequestPrepare(connexion,SQL_SELECT,id_pat);
			resultset = prepstatement.executeQuery();
			while(resultset.next()) {
				id_med1 = resultset.getInt("id_med_f");
				id_pat1 = resultset.getInt("id_pat_f");
				jour = resultset.getString("jour");
				id_plg = resultset.getInt("plg_horaire");
				
				liste_rdv.add(new RDV(id_med1,id_pat1,jour,id_plg));
			}
		} catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
		
		return liste_rdv;
	}

	@Override
	public ArrayList<RDV> getAll_frommed(int id_med) throws DAOException {
		int id_med1;
		int id_pat1;
		String jour;
		int id_plg;
		ArrayList<RDV> liste_rdv = new ArrayList<>();
		final String SQL_SELECT = "select * from rdv where id_med_F = ?";
		Connection connexion = null;
		PreparedStatement prepstatement = null;
		ResultSet resultset = null;
		
		try {
			connexion = daoFactory.getConnection();
			prepstatement = initRequestPrepare(connexion,SQL_SELECT,id_med);
			resultset = prepstatement.executeQuery();
            
			while(resultset.next()) {
				
				id_med1 = resultset.getInt("id_med_f");
				id_pat1 = resultset.getInt("id_pat_f");
				jour = resultset.getString("jour");
				id_plg = resultset.getInt("plg_horaire");
				
				liste_rdv.add(new RDV(id_med1,id_pat1,jour,id_plg));
			}
			
		} catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
		return liste_rdv;
	}

}
