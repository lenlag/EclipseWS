package persistence.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;

import business.entity.Moteur;
import persistence.exception.DaoException;
import persistence.manager.JDBCManager;

public class MoteurDao implements IDAO<Moteur> {

		public static final String SQL_SELECT = "SELECT * FROM moteur";
		public static final String SQL_GETBYID = "SELECT * FROM moteur WHERE id=?";
		public static final String SQL_INSERT = "INSERT INTO moteur(marque, modele, cylindree) VALUES (?, ?, ?)";
		public static final String SQL_UPDATE = "UPDATE moteur SET marque=?, modele=?, cylindree=? Where id=?";
		public static final String SQL_DELETE = "DELETE FROM moteur WHERE id=?";
		
		
		@Override
		public void create(Moteur pT) throws DaoException {
			if (pT == null) {
				return;
			}
			try {
			Connection cnx = JDBCManager.getInstance().openConection(); // open cnx
			PreparedStatement ps = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, pT.getMarque());
			ps.setString(2, pT.getModele());
			ps.setLong(3, pT.getCylindree());
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
		public Moteur findById(long pId) throws DaoException {
			try {
			Connection cnx = JDBCManager.getInstance().openConection(); // open cnx	
			Moteur moteur = null; //on déclare la variable moteur
			PreparedStatement ps = cnx.prepareStatement(SQL_GETBYID); // on stocke la requette SQL correspondante dans ps
			ps.setLong(1, pId); // on indique le id en question
			
			ResultSet rs = ps.executeQuery(); // on execute le script SQL, et recupère le rs
			while (rs.next()) {							// on extrait du rs les valeurs de variables de la classe
				String marque = rs.getString("marque");
				String modele = rs.getString("modele");
				int cylindree = rs.getInt("cylindree");
				moteur = new Moteur(pId, marque, modele, cylindree); // on initialise la variable avec les valeurs extraites
			}
							
			JDBCManager.getInstance().closeConnection(); // close cnx
			return moteur; // on retourne moteur.toString
			
			} catch (Exception e) {
				throw new DaoException(e);
			} finally {		
			}
		}

		
		@Override
		public List<Moteur> findList() throws DaoException {
			try {
			Connection cnx = JDBCManager.getInstance().openConection(); // on ouvre la connexion
			PreparedStatement ps = cnx.prepareStatement(SQL_SELECT);
			
			ResultSet rs = ps.executeQuery();
			List<Moteur> list = new ArrayList<>();
			while (rs.next()) {							// on extrait du rs les valeurs des variables de la classe
				long id = rs.getLong("id");
				String marque = rs.getString("marque");
				String modele = rs.getString("modele");
				int cylindree = rs.getInt("cylindree");
				list.add(new Moteur(id,marque, modele, cylindree)); // on rajoute dans la liste l'objet Voiture avec ses propriétés
			}
			JDBCManager.getInstance().closeConnection(); // on ferme la connexion
			return list;
			} catch (Exception e) {
				throw new DaoException(e);
			} finally {		
			}
		}

		@Override
		public void updateById(Moteur pT) throws DaoException {
			if (pT == null) {
				return;
			}
			try {
			Connection cnx = JDBCManager.getInstance().openConection();
			PreparedStatement ps = cnx.prepareStatement(SQL_UPDATE);
			ps.setString(1, pT.getMarque());
			ps.setString(2, pT.getModele());
			ps.setInt(3,  pT.getCylindree());
			ps.setLong(4, pT.getId());
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
