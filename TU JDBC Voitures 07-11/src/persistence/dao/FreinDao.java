package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import business.entity.Frein;
import business.entity.Moteur;
import persistence.exception.DaoException;
import persistence.manager.JDBCManager;

public class FreinDao implements IDAO<Frein> {
	
	public static final String SQL_SELECT = "SELECT * FROM frein";
	public static final String SQL_GETBYID = "SELECT * FROM frein WHERE id=?";
	public static final String SQL_INSERT = "INSERT INTO frein(marque, modele) VALUES (?, ?)";
	public static final String SQL_UPDATE = "UPDATE frein SET marque=?, modele=? Where id=?";
	public static final String SQL_DELETE = "DELETE FROM frein WHERE id=?";
	
	
	@Override
	public void create(Frein pT) throws DaoException {	
		if (pT == null) {
			return;
		}
		try {
		Connection cnx = JDBCManager.getInstance().openConection(); // open cnx
		PreparedStatement ps = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, pT.getMarque());
		ps.setString(2, pT.getModele());
		ps.execute();
		
		ResultSet rs = ps.getGeneratedKeys();
		while(rs.next()) {
			long id = rs.getLong("GENERATED_KEY");
			pT.setId(id);
			System.out.println("The new key is " + id);
		}
		JDBCManager.getInstance().closeConnection(); // close cnx
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {		
		}
		
	}

	@Override
	public Frein findById(long pId) throws DaoException {
		try {
		Connection cnx = JDBCManager.getInstance().openConection(); // open cnx	
		Frein frein = null; //on déclare la variable frein
		PreparedStatement ps = cnx.prepareStatement(SQL_GETBYID); // on stocke la requette SQL correspondante dans ps
		ps.setLong(1, pId); // on indique l'id en question
		
		ResultSet rs = ps.executeQuery(); // on execute le script SQL, et recupère le rs
		while (rs.next()) {							// on extrait du rs les valeurs des variables de la classe
			String marque = rs.getString("marque");
			String modele = rs.getString("modele");
			frein = new Frein(pId, marque, modele); // on initialise la variable avec les valeurs extraites
		}
						
		JDBCManager.getInstance().closeConnection(); // close cnx
		return frein; // on retourne notre variable frein
		
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {		
		}
	}

	
	@Override
	public List<Frein> findList() throws DaoException {
		try {
		Connection cnx = JDBCManager.getInstance().openConection(); // on ouvre la connexion
		PreparedStatement ps = cnx.prepareStatement(SQL_SELECT);
		
		ResultSet rs = ps.executeQuery();
		List<Frein> list = new ArrayList<>();
		while (rs.next()) {							// on extrait du rs les valeurs des variables de la classe
			long id = rs.getLong("id");
			String marque = rs.getString("marque");
			String modele = rs.getString("modele");
			list.add(new Frein(id,marque, modele)); // on rajoute dans la liste l'objet Frein avec ses propriétés
		}
		JDBCManager.getInstance().closeConnection(); // on ferme la connexion
		return list;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {		
		}
	}

	@Override
	public void updateById(Frein pT) throws DaoException {
		if (pT == null) {
			return;
		}
		try {
		Connection cnx = JDBCManager.getInstance().openConection();
		PreparedStatement ps = cnx.prepareStatement(SQL_UPDATE);
		ps.setString(1, pT.getMarque());
		ps.setString(2, pT.getModele());
		ps.setLong(3, pT.getId());
		ps.execute();
		JDBCManager.getInstance().closeConnection();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {		
		}
		
	}
		

	@Override
	public void deleteById(long pId) throws DaoException {
		try {
		Connection cnx = JDBCManager.getInstance().openConection();
		PreparedStatement ps = cnx.prepareStatement(SQL_DELETE);
		ps.setLong(1, pId);
		ps.execute();
		JDBCManager.getInstance().closeConnection();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {		
		}
	}

}
