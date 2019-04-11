package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import business.entity.Specie;
import persistence.exception.DaoException;
import persistence.manager.JDBCManager;

public class SpecieDao implements IDAO<Specie> {

	public static final String SQL_SELECT = "SELECT * FROM specie";
	public static final String SQL_GETBYID = "SELECT * FROM specie WHERE id=?";
	public static final String SQL_INSERT = "INSERT INTO specie(common_name,latin_name) VALUES (?,?)";
	public static final String SQL_UPDATE = "UPDATE specie SET common_name=?, latin_name=? Where id=?";
	public static final String SQL_DELETE = "DELETE FROM specie WHERE id=?";
	
	
	@Override
	public void create(Specie pT) throws DaoException {
		if(pT == null) { // condition en cas d'objet = null, pour eviter null pointer exception
			return;
		}
		try {
			
		Connection cnx = JDBCManager.getInstance().openConection(); // open cnx
		PreparedStatement ps = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, pT.getCommonName());
		ps.setString(2, pT.getLatinName());
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
	public Specie findById(long pId) throws DaoException {
		try {
		Connection cnx = JDBCManager.getInstance().openConection(); // open cnx	
		Specie specie = null;
		PreparedStatement ps = cnx.prepareStatement(SQL_GETBYID);
		ps.setLong(1, pId);
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String common = rs.getString("common_name");
			String latin = rs.getString("latin_name");
			specie = new Specie (pId, common, latin); 
		}
						
		JDBCManager.getInstance().closeConnection(); // close cnx
		return specie;
		
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {		
		}
	}

	@Override
	public List<Specie> findList() throws DaoException {
		try {
		Connection cnx = JDBCManager.getInstance().openConection(); // on ouvre la connexion
		PreparedStatement ps = cnx.prepareStatement(SQL_SELECT);
		
		ResultSet rs = ps.executeQuery();
		List<Specie> list = new ArrayList<>();
		while (rs.next()) {
			String common = rs.getString("common_name");
			long id = rs.getLong("id");
			String latin = rs.getString("latin_name");
			list.add(new Specie(id,common,latin));
		}
		JDBCManager.getInstance().closeConnection(); // on ferme la connexion
		return list;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {		
		}
	}

	@Override
	public void updateById(Specie pT) throws DaoException {
		if (pT==null) { // condition en cas d'objet = null, pour eviter null pointer exception
			return;
		}
		try {
		Connection cnx = JDBCManager.getInstance().openConection();
		
		PreparedStatement ps = cnx.prepareStatement(SQL_UPDATE);
		ps.setString(1, pT.getCommonName());
		ps.setString(2, pT.getLatinName());
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
