package persistance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import business.entity.Animal;
import business.entity.Specie;
import persistance.exception.DaoException;
import persistance.manager.JDBCManager;

public class AnimalDao implements IDAO<Animal> {
	
	public static final String SQL_INSERT = "INSERT INTO animal (name, sex, coatColor, id_specie) VALUES (?,?,?,?)";
	public static final String SQL_SELECT = "SELECT a.*, s.* FROM animal as a INNER JOIN specie as s ON a.id_specie=s.id";
	public static final String SQL_GETBYID = "SELECT a.*, s.* FROM animal as a INNER JOIN specie as s ON a.id_specie=s.id WHERE a.id=?";
	public static final String SQL_UPDATE = "UPDATE animal SET name=?, sex=?, coatColor=?, id_specie=? WHERE id=?";
	public static final String SQL_DELETE= "DELETE FROM animal WHERE id=?";

	@Override
	public void create(Animal pT) throws DaoException {
		try {
		Connection cnx = JDBCManager.getInstance().openConection();
		
		PreparedStatement ps = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1,pT.getName());
		ps.setString(2, pT.getSex());
		ps.setString(3, pT.getCoatColor());
		ps.setObject(4, pT.getSpecie().getId());
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
	public Animal findById(long pId) throws DaoException {
		try {
		Connection cnx = JDBCManager.getInstance().openConection();
		Animal animal = null;
		PreparedStatement ps = cnx.prepareStatement(SQL_GETBYID);
		ps.setLong(1, pId);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			String name = rs.getString("a.name");
			String sex = rs.getString("a.sex");
			String coatColor = rs.getString("a.coatcolor");
			long id = rs.getLong("a.id");
			Specie specie = new Specie (rs.getLong("s.id"), rs.getString("s.common_name"), rs.getString("s.latin_name"));
			animal = new Animal (name, sex, coatColor, id, specie);
			
		}
		
		JDBCManager.getInstance().closeConnection();
		return animal;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {		
		}
	}

	@Override
	public List<Animal> findList() throws DaoException {
		try {
		Connection cnx = JDBCManager.getInstance().openConection();
		List <Animal>myAnimalList = new ArrayList<>();
		PreparedStatement ps = cnx.prepareStatement(SQL_SELECT);
		ResultSet rs = ps.executeQuery();
		Animal animal = null;
		
		while (rs.next()) {
			String name = rs.getString("a.name");
			String sex = rs.getString("a.sex");
			String coatColor = rs.getString("a.coatcolor");
			long id = rs.getLong("a.id");
			Specie specie = new Specie (rs.getLong("s.id"), rs.getString("s.common_name"), rs.getString("s.latin_name"));
			animal = new Animal (name, sex, coatColor, id, specie);
			myAnimalList.add(animal);
		}
		
		JDBCManager.getInstance().closeConnection();
		return myAnimalList;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {		
		}
	}

	@Override
	public void updateById(Animal pT) throws DaoException {
		try {
		Connection cnx = JDBCManager.getInstance().openConection();
		PreparedStatement ps = cnx.prepareStatement(SQL_UPDATE);
		ps.setString(1, pT.getName());
		ps.setString(2, pT.getSex());
		ps.setString(3, pT.getCoatColor());
		ps.setObject(4, pT.getSpecie().getId());
		ps.setLong(5, pT.getId());
		ps.executeUpdate();
		
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
		JDBCManager.getInstance().openConection();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {		
		}
		
	}

}
