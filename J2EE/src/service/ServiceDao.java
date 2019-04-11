package service;

import java.util.List;

import business.entity.Animal;
import business.entity.Person;
import persistence.dao.AnimalDao;
import persistence.dao.PersonDao;
import persistence.dao.RaceDao;
import persistence.dao.SpecieDao;
import persistence.exception.DaoException;

public class ServiceDao {

	private AnimalDao anDao = new AnimalDao();
	private PersonDao pDao = new PersonDao();
	private RaceDao rDao = new RaceDao();
	private SpecieDao sDao = new SpecieDao();
	
	
	
	public ServiceDao () {
		
	}

	
	public List<Person> list() throws DaoException {
		List <Person> myList = pDao.findList();
		return myList;
	}
	
	
	public List<Animal> animalList(long id) throws DaoException{
		Person p = pDao.findById(id);
		return p.getAnimaux();
	}
	
	public void createPerson(Person p) throws DaoException {
		pDao.create(p);
	
	}
	public Person findById (long id) throws DaoException {
		Person p = pDao.findById(id);
		return p;
		
	}
	
	public void deletePerson(long id) throws DaoException {
		pDao.deleteById(id);
	}
	
	public void updatePerson(Person p) throws DaoException {
		pDao.updateById(p);
	}
}
