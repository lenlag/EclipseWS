package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import business.entity.Race;
import persistence.exception.DaoException;
import persistence.manager.JDBCManager;

public class RaceDao implements IDAO<Race> {

	public static final String SQL_SELECT = "SELECT * FROM race";
	public static final String SQL_GETbyId = "SELECT * FROM race WHERE id=?";
	public static final String SQL_INSERT = "INSERT INTO race (name, price, comments) VALUES (?,?,?)";
	public static final String SQL_UPDATE = "UPDATE race SET name=?, price=?, comments=? WHERE id=?";
	public static final String SQL_DELETE = "DELETE FROM race WHERE id=?";

	@Override
	public void create(Race pT) throws DaoException {
		if (pT==null) { // condition en cas d'objet = null, pour eviter null pointer exception
			return;
		}
		try {
		Connection cnx = JDBCManager.getInstance().openConection();
		PreparedStatement ps = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, pT.getName());
		ps.setInt(2, pT.getPrice());
		ps.setString(3, pT.getComments());
		ps.execute();

		ResultSet rs = ps.getGeneratedKeys();
		while(rs.next()) {
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
	public Race findById(long pId) throws DaoException {
		try {
		Connection cnx = JDBCManager.getInstance().openConection();
		Race race = null;
		
		PreparedStatement ps = cnx.prepareStatement(SQL_GETbyId);
		ps.setLong(1, pId);


		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String name = rs.getString("name");
			int price = rs.getInt("price");
			String comments = rs.getString("comments");
			race = new Race (pId, name, price, comments);
		}

		JDBCManager.getInstance().closeConnection();
		return race;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {		
		}
	}
	@Override
	public List<Race> findList() throws DaoException {
		try {
		Connection cnx = JDBCManager.getInstance().openConection();
		PreparedStatement ps = cnx.prepareStatement(SQL_SELECT);
		
		ResultSet rs = ps.executeQuery();
		
		List<Race>myRaceList = new ArrayList<>();
		while (rs.next()) {
			long id = rs.getLong("id");
			String name = rs.getString("name");
			int price = rs.getInt("price");
			String comments = rs.getString("comments");
			myRaceList.add(new Race (id, name, price, comments));
		}
		JDBCManager.getInstance().closeConnection();
		return myRaceList;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {		
		}
	}
	@Override
	public void updateById(Race pT) throws DaoException {
		if (pT==null) { // condition en cas d'objet = null, pour eviter null pointer exception
			return;
		}
		try {
		Connection cnx = JDBCManager.getInstance().openConection();
		
		PreparedStatement ps = cnx.prepareStatement(SQL_UPDATE);
		ps.setString(1, pT.getName());
		ps.setInt(2, pT.getPrice());
		ps.setString(3, pT.getComments());
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
