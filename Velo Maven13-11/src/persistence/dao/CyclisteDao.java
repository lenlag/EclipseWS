package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import business.entity.Cycliste;
import business.entity.Equipe;
import persistence.exception.DaoException;
import persistence.manager.JDBCManager;

public class CyclisteDao implements IDAO<Cycliste> {

	public static final String SQL_SELECT = "SELECT * FROM cycliste";
	public static final String SQL_GETBYID = "SELECT * FROM cycliste WHERE id=?";
	public static final String SQL_INSERT = "INSERT INTO cycliste(name, equipe_id, nombre_velos) VALUES (?,?,?)";
	public static final String SQL_UPDATE = "UPDATE cycliste SET name=?, equipe_id=?, nombre_velos=? Where id=?";
	public static final String SQL_DELETE = "DELETE FROM cycliste WHERE id=?";

	@Override
	public void create(Cycliste pT) throws DaoException {
		if (pT == null) {
			return;
		}
		try {
			Connection cnx = JDBCManager.getInstance().openConection();
			PreparedStatement ps = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, pT.getName());
			ps.setObject(2, pT.getEquipe().getId());
			ps.setInt(3, pT.getNombre_velos());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			while (rs.next()) {
				long id = rs.getLong("GENERATED_KEY");
				pT.setId(id);
				System.out.println("The new key is " + id);
			}
			JDBCManager.getInstance().closeConnection();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
		}

	}

	@Override
	public Cycliste findById(long pId) throws DaoException {
		EquipeDao equipeDao = new EquipeDao();
		Cycliste cycliste = null;
		try {
			Connection cnx = JDBCManager.getInstance().openConection();
			PreparedStatement ps = cnx.prepareStatement(SQL_GETBYID);
			ps.setLong(1, pId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				Equipe equipe = new Equipe();
				equipe = equipeDao.findById(rs.getLong("equipe_id"));
				int nombre_velos = rs.getInt("nombre_velos");
				cycliste = new Cycliste (pId, name, equipe, nombre_velos);
			}
			JDBCManager.getInstance().closeConnection();
			return cycliste;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
		}
		
	}

	@Override
	public List<Cycliste> findList() throws DaoException {
		try {
			Connection cnx = JDBCManager.getInstance().openConection();
			PreparedStatement ps = cnx.prepareStatement(SQL_SELECT);
			ResultSet rs = ps.executeQuery();
			List<Cycliste> list = new ArrayList<>();
			Cycliste cycliste = null;
			EquipeDao equipeDao = new EquipeDao();
			while (rs.next()) {
				long id = rs.getLong("id");
				String name = rs.getString("name");
				Equipe equipe = new Equipe();
				equipe = equipeDao.findById(rs.getLong("equipe_id"));
				int nombre_velos = rs.getInt("nombre_velos");
				cycliste = new Cycliste (id, name, equipe, nombre_velos);
				list.add(cycliste);
			}
			JDBCManager.getInstance().closeConnection();
			return list;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
		}
	}

	@Override
	public void updateById(Cycliste pT) throws DaoException {
		if (pT == null) {
			return;
		}
		try {
			Connection cnx = JDBCManager.getInstance().openConection();
			PreparedStatement ps = cnx.prepareStatement(SQL_UPDATE);
			ps.setString(1, pT.getName());
			ps.setObject(2, pT.getEquipe().getId());
			ps.setInt (3, pT.getNombre_velos());
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
