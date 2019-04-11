package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import business.entity.Animal;
import business.entity.Person;
import business.entity.Specie;
import persistence.exception.DaoException;
import persistence.manager.JDBCManager;

public class PersonDao implements IDAO<Person> {

	//constantes
	public static final String SQL_INSERT_PERSON = "INSERT INTO person (firstname, lastname, age) VALUES (?,?,?)";
	public static final String SQL_INSERT_PERSON__ANIMAL = "INSERT INTO person__animal (person_id, animal_id) VALUES (?,?)";
	public static final String SQL_SELECT_LIST = "SELECT * FROM person";
	public static final String SQL_SELECT_PERSON__ANIMAL = "SELECT pa.*,s.*,a.* FROM person__animal as pa, animal as a, specie as s WHERE pa.animal_id=a.id AND a.id_specie=s.id AND pa.person_id=?";
	public static final String SQL_SELECT_PERSON = "SELECT * FROM person WHERE id=?";
	public static final String SQL_DELETE_PERSON__ANIMAL = "DELETE FROM person__animal WHERE person_id=?";
	public static final String SQL_DELETE_PERSON = "DELETE FROM person WHERE id=?";
	public static final String SQL_UPDATE_PERSON = "UPDATE person SET lastname=?, firstname=?, age=? WHERE id=?";

	
	@Override
	public void create(Person pT) throws DaoException {
		if (pT == null) {
			return;
		}
		Connection cnx = null;
		try {
			cnx = JDBCManager.getInstance().openConection();
			PreparedStatement ps = cnx.prepareStatement(SQL_INSERT_PERSON, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, pT.getFirstName());
			ps.setString(2, pT.getLastName());
			ps.setInt (3, pT.getAge());
			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();

			while (rs.next()) {
				long id = rs.getLong("GENERATED_KEY");
				pT.setId(id);
				System.out.println("The new key is " + id);
			}
			rs.close();
			ps.close();

			for (Animal a: pT.getAnimaux()) {
				PreparedStatement ps2 = cnx.prepareStatement(SQL_INSERT_PERSON__ANIMAL);
				ps2.setLong(1, pT.getId());
				ps2.setLong(2, a.getId());
				ps2.execute();
				ps2.close();
			}

			JDBCManager.getInstance().closeConnection();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {		
		}
	}

	@Override
	public Person findById(long pId) throws DaoException {
		// TODO Auto-generated method stub
		try {
		Connection cnx = JDBCManager.getInstance().openConection();
		PreparedStatement ps = cnx.prepareStatement(SQL_SELECT_PERSON);
		ps.setLong(1, pId);
		ResultSet rs = ps.executeQuery();
		List<Animal> animaux = null;
		Person p = null;
		while (rs.next()) {
			String lastName = rs.getString("lastname");
			String firstName = rs.getString("firstname");
			int age = rs.getInt("age");
			long id = rs.getLong("id");
			p = new Person(lastName, firstName, age, id, null);


			PreparedStatement ps2 = cnx.prepareStatement(SQL_SELECT_PERSON__ANIMAL);
			ps2.setLong(1, p.getId());

			ResultSet rs2 = ps2.executeQuery();
			animaux = new ArrayList<>();
			while(rs2.next()) {
				Specie specie = new Specie (rs2.getLong("s.ID"), rs2.getString("s.common_name"), rs2.getString("s.latin_name"));
				Animal anim = new Animal (rs2.getString("a.name"), rs2.getString("a.sex"), rs2.getString("a.coatcolor"), rs2.getLong("a.id"), specie);
				animaux.add(anim);
			}
			rs2.close();
			ps2.close();
			p.setAnimaux(animaux);
			break;
		}
		rs.close();
		ps.close();

		JDBCManager.getInstance().closeConnection();
		return p;
		
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {		
		}
	}

	@Override
	public List<Person> findList() throws DaoException {
		try {
		Connection cnx = JDBCManager.getInstance().openConection();
		List <Person> myPersonList = new ArrayList<>();
		PreparedStatement ps = cnx.prepareStatement(SQL_SELECT_LIST);

		ResultSet rs = ps.executeQuery();
		List<Animal> animaux = null;
		Person p;
		while (rs.next()) {
			String lastName = rs.getString("lastname");
			String firstName = rs.getString("firstname");
			int age = rs.getInt("age");
			long id = rs.getLong("id");
			p = new Person(lastName, firstName, age, id, null);
			myPersonList.add(p);


			PreparedStatement ps2 = cnx.prepareStatement(SQL_SELECT_PERSON__ANIMAL);
			ps2.setLong(1, p.getId());

			ResultSet rs2 = ps2.executeQuery();
			animaux = new ArrayList<>();
			while(rs2.next()) {
				Specie specie = new Specie (rs2.getLong("s.ID"), rs2.getString("s.common_name"), rs2.getString("s.latin_name"));
				Animal anim = new Animal (rs2.getString("a.name"), rs2.getString("a.sex"), rs2.getString("a.coatcolor"), rs2.getLong("a.id"), specie);
				animaux.add(anim);
			} 
			rs2.close();
			ps2.close();
			p.setAnimaux(animaux);

		}
		rs.close();
		ps.close();
		JDBCManager.getInstance().closeConnection();
		return myPersonList;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {		
		}
	}

	@Override
	public void updateById(Person pT) throws DaoException {
		if (pT==null) {
			return;
		}
		try {
		Connection cnx = JDBCManager.getInstance().openConection();
		PreparedStatement ps = cnx.prepareStatement(SQL_DELETE_PERSON__ANIMAL);
		ps.setLong(1, pT.getId());
		ps.execute();


		PreparedStatement ps2 = cnx.prepareStatement(SQL_UPDATE_PERSON);
		ps2.setString(1, pT.getLastName());
		ps2.setString(2, pT.getFirstName());
		ps2.setInt(3, pT.getAge());
		ps2.setLong(4, pT.getId());
		ps2.execute();



		for (Animal a: pT.getAnimaux()) {
			PreparedStatement ps3 = cnx.prepareStatement(SQL_INSERT_PERSON__ANIMAL);
			ps3.setLong(1, pT.getId());
			ps3.setLong(2, a.getId());
			ps3.execute();
			ps3.close();
		}

		ps2.close();
		ps.close();

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
		PreparedStatement ps = cnx.prepareStatement(SQL_DELETE_PERSON__ANIMAL);
		ps.setLong(1, pId);
		ps.execute();
		ps.close();

		PreparedStatement ps2 = cnx.prepareStatement(SQL_DELETE_PERSON);
		ps2.setLong(1, pId);
		ps2.execute();
		ps2.close();
		JDBCManager.getInstance().closeConnection();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {		
		}
	}



}
