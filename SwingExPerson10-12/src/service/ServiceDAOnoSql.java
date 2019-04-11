 package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.PersonDAO;
import entity.PersonDTO;
import persistence.exception.DaoException;

public class ServiceDAOnoSql implements IService {
	
	PersonDAO dao = new PersonDAO();

	@Override
	public List<PersonDTO> findAll() throws Exception {
		List<PersonDTO> ptoList = new ArrayList<>();
		List<Map<String, Object>> myList = dao.list();
		for (Map<String, Object> myMap : myList) {
				String sid = myMap.get("_id").toString();
				String firstName = (String) myMap.get("firstName");
				String lastName = (String) myMap.get("lastName");
				int age = (int) myMap.get("age");
				PersonDTO dto = new PersonDTO (sid, firstName, lastName, age);
				ptoList.add(dto);
		}
		
		return ptoList;
	}

	@Override
	public PersonDTO getById(String id) throws Exception {
		Map<String, Object> myObject = dao.getById(id);
		String sid = myObject.get("_id").toString();
		String firstName = (String) myObject.get("firstName");
		String lastName = (String) myObject.get("lastName");
		int age = (int) myObject.get("age");
		return new PersonDTO(sid, firstName, lastName, age);
	}

	@Override
	public void create(PersonDTO dto) throws DaoException {
		Map<String, Object> person = new HashMap<>();
		String firstName = dto.getFirstName();
		String lastName = dto.getLastName();
		int age = dto.getAge();
		person.put("firstName", firstName);
		person.put("lastName", lastName);
		person.put("age", age);
		dao.create(person);
	
	}

	@Override
	public void update(PersonDTO dto) throws Exception {
		String id = dto.getId();
		Map<String, Object> person = dao.getById(id);
		String firstName = dto.getFirstName();
		String lastName = dto.getLastName();
		int age = dto.getAge();
		person.put("firstName", firstName);
		person.put("lastName", lastName);
		person.put("age", age);
		dao.update(person);
	}

	@Override
	public void delete(String id) throws Exception {
		dao.deleteById(id);

	}

}
