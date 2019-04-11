package business.entity;

import java.util.ArrayList;
import java.util.List;

import persistance.dao.AnimalDao;
import persistance.dao.PersonDao;

public class TestMainPerson {

	public static void main(String[] args) throws Exception {

		AnimalDao animalDao = new AnimalDao ();

		PersonDao persDao = new PersonDao();

		// TEST Find List			
		List<Person> personList = new ArrayList<>();
		personList = persDao.findList();

		for (Person m : personList) {
			System.out.println(m);
		}

		// TEST Find by id

		Person p = persDao.findById(1);
		System.out.println();
		System.out.println("Voici la personne, correspondante à l'id demandé : ");
		System.out.println(p);
		System.out.println("\r\n");

		// TEST CREATE 
		Animal a = animalDao.findById(1);
		List <Animal> list = new ArrayList<>();
		list.add(a);
		a = animalDao.findById(2);
		list.add(a);
		p = new Person ("FILLERUP", "David", 35, 0, list);
		persDao.create(p);


		// TEST UPDATE
		p.setAge(29);
		a = animalDao.findById(3); 
		list = new ArrayList<>();
		list.add(a);
		p.setAnimaux(list);
		persDao.updateById(p);

	
		// TEST DELETE
		persDao.deleteById(p.getId());



	}

}
