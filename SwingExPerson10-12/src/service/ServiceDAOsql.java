package service;

import java.util.ArrayList;
import java.util.List;

import business.entity.Person;
import entity.PersonDTO;
import persistence.dao.PersonDao;
import persistence.exception.DaoException;

public class ServiceDAOsql implements IService {

	PersonDao dao = new PersonDao();

	
	
	public ServiceDAOsql () {
		
	}
	
	public List<PersonDTO> findAll () throws Exception {
				List<PersonDTO> ptoList = new ArrayList<>();
				List<Person> personList = dao.findList();
				for (Person p : personList) {
					long id = p.getId();
					String firstName = p.getFirstName();
					String lastName = p.getLastName();
					int age = p.getAge();
					PersonDTO dto = new PersonDTO (String.valueOf(id), firstName, lastName, age);
					ptoList.add(dto);
				}
				
				return ptoList;
		
	}
	
	public PersonDTO getById (String id) throws Exception {
		Person person = dao.findById(Long.parseLong(id));
		return new PersonDTO(String.valueOf(person.getId()), person.getFirstName(), person.getLastName(), person.getAge());
				
	}
	
	public void create (PersonDTO dto) throws DaoException {
		Person person = new Person ( dto.getLastName(), dto.getFirstName(), dto.getAge(), 0, null);
		dao.create(person);
	}
	
			
	public void update (PersonDTO dto) throws Exception  {
		Person person = new Person (dto.getLastName(), dto.getFirstName(), dto.getAge(), Long.parseLong(dto.getId()), null);
		dao.updateById(person);
	}
	
	
	public void delete (String id) throws Exception {
		dao.deleteById(Long.parseLong(id));
	}
	
}
