package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import business.entity.Automobile;
import business.entity.Frein;
import business.entity.Moteur;
import persistence.exception.DaoException;
import persistence.manager.JDBCManager;

public class AutomobileDao implements IDAO<Automobile> {

	public static final String SQL_SELECT = "SELECT a.*, f.*, m.* FROM automobile as a INNER JOIN frein as f ON a.frein_id=f.id INNER JOIN moteur as m ON a.moteur_id=m.id";
	// public static final String SQL_GETBYID = "SELECT a.*, f.*, m.* FROM
	// automobile as a INNER JOIN frein as f ON a.frein_id=f.id INNER JOIN moteur as
	// m ON a.moteur_id=m.id WHERE a.id=?"; // pas besoin d'une requete si longue !!
	public static final String SQL_GETBYID = "SELECT * FROM automobile WHERE id=?";
	public static final String SQL_INSERT = "INSERT INTO automobile(marque, modele, moteur_id, frein_id) VALUES (?,?,?,?)";
	public static final String SQL_UPDATE = "UPDATE automobile SET marque=?, modele=?, moteur_id=?, frein_id=?  Where id=?";
	public static final String SQL_DELETE = "DELETE FROM automobile WHERE id=?";

	@Override
	public void create(Automobile pT) throws DaoException {
		if (pT == null) {
			return;
		}
		try {
			Connection cnx = JDBCManager.getInstance().openConection(); // open cnx
			PreparedStatement ps = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, pT.getMarque());
			ps.setString(2, pT.getModele());
			ps.setLong(3, pT.getMoteur().getId());
			ps.setLong(4, pT.getFrein().getId());
			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			while (rs.next()) {
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
	public Automobile findById(long pId) throws DaoException {
		MoteurDao motor = new MoteurDao();
		FreinDao frein = new FreinDao();
		Automobile automobile = null;
		try {
			Connection cnx = JDBCManager.getInstance().openConection();
			PreparedStatement ps = cnx.prepareStatement(SQL_GETBYID);
			ps.setLong(1, pId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String marque = rs.getString("marque"); // par nom de champs
				String modele = rs.getString("modele");
				Moteur moteur = new Moteur();
				moteur = motor.findById(rs.getLong(4)); // aussi possible par index numéro 4
				Frein frein1 = new Frein();
				frein1 = frein.findById(rs.getLong(5));
				automobile = new Automobile(pId, marque, modele, moteur, frein1);

			}

			JDBCManager.getInstance().closeConnection();

		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
		}
		return automobile;
	}

	@Override
	public List<Automobile> findList() throws DaoException {
		try {
			Connection cnx = JDBCManager.getInstance().openConection();
			PreparedStatement ps = cnx.prepareStatement(SQL_SELECT);
			ResultSet rs = ps.executeQuery();
			List<Automobile> list = new ArrayList<>();
			Automobile automobile = null;
			while (rs.next()) {
				long id = rs.getLong("a.id");
				String marque = rs.getString("a.marque");
				String modele = rs.getString("a.modele");
				Moteur moteur = new Moteur(rs.getLong("m.id"), rs.getString("m.marque"), rs.getString("m.modele"),
						rs.getInt("m.cylindree"));
				Frein frein = new Frein(rs.getLong("f.id"), rs.getString("f.marque"), rs.getString("f.modele"));
				automobile = new Automobile(id, marque, modele, moteur, frein);
				list.add(automobile);
			}
			JDBCManager.getInstance().closeConnection(); // on ferme la connexion
			return list;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
		}
	}

	@Override
	public void updateById(Automobile pT) throws DaoException {
		if (pT == null) {
			return;
		}
		try {
			Connection cnx = JDBCManager.getInstance().openConection();
			PreparedStatement ps = cnx.prepareStatement(SQL_UPDATE);
			ps.setString(1, pT.getMarque());
			ps.setString(2, pT.getModele());
			ps.setObject(3, pT.getMoteur().getId());
			ps.setObject(4, pT.getFrein().getId());
			ps.setLong(5, pT.getId());
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
