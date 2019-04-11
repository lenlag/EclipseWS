package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import business.entity.Equipe;
import persistence.exception.DaoException;
import persistence.manager.JDBCManager;

public class EquipeDao implements IDAO<Equipe> {

	public static final String SQL_SELECT = "SELECT * FROM equipe";
	public static final String SQL_GETBYID = "SELECT * FROM equipe WHERE id=?";
	public static final String SQL_INSERT = "INSERT INTO equipe(name, budget) VALUES (?, ?)";
	public static final String SQL_UPDATE = "UPDATE equipe SET name=?, budget=? Where id=?";
	public static final String SQL_DELETE = "DELETE FROM equipe WHERE id=?";
	
	
	@Override
	public void create(Equipe pT) throws DaoException {
		if (pT == null) {
			return;
		}
		try {
		Connection cnx = JDBCManager.getInstance().openConection(); 
		PreparedStatement ps = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, pT.getName());
		ps.setLong(2, pT.getBudget());
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
	public Equipe findById(long pId) throws DaoException {
		try {
		Connection cnx = JDBCManager.getInstance().openConection(); 	
		Equipe equipe = null;
		PreparedStatement ps = cnx.prepareStatement(SQL_GETBYID); 
		ps.setLong(1, pId); 
		ResultSet rs = ps.executeQuery(); 
		while (rs.next()) {
			String name = rs.getString("name");
			Long budget = rs.getLong("budget");
			equipe = new Equipe(pId, name, budget);
		}
						
		JDBCManager.getInstance().closeConnection();
		return equipe;
		
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {		
		}
	}

	
	@Override
	public List<Equipe> findList() throws DaoException {
		try {
		Connection cnx = JDBCManager.getInstance().openConection();
		PreparedStatement ps = cnx.prepareStatement(SQL_SELECT);
		
		ResultSet rs = ps.executeQuery();
		List<Equipe> list = new ArrayList<>();
		while (rs.next()) {
			long id = rs.getLong("id");
			String name = rs.getString("name");
			Long budget = rs.getLong("budget");
			list.add(new Equipe(id, name, budget));
		}
		JDBCManager.getInstance().closeConnection();
		return list;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {		
		}
	}

	@Override
	public void updateById(Equipe pT) throws DaoException {
		if (pT == null) {
			return;
		}
		try {
		Connection cnx = JDBCManager.getInstance().openConection();
		PreparedStatement ps = cnx.prepareStatement(SQL_UPDATE);
		ps.setString(1, pT.getName());
		ps.setLong(2, pT.getBudget());
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
