package persistence.dao;

import java.util.ArrayList;
import java.util.List;
import business.entity.Animal;
import business.entity.Person;
import exception.SqlInserterException;
import inserter.Inserter;
import persistence.exception.DaoException;
import persistence.pere.TU_Pere;

public class TestPersonDao extends TU_Pere {

	PersonDao persondao = null;
	AnimalDao animaldao = null;
	@Override
	public void setUp() throws Exception {
		super.setUp(); // !!!on met d'abord le SetUP du PERE, et APRES on rajoute...
		persondao = new PersonDao();
		animaldao = new AnimalDao();		
	}
	@Override
	public void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}
	@Override
	public Inserter getInserter() {
		// TODO Auto-generated method stub
		return super.getInserter();
	}


	public void testFindList () throws DaoException, SqlInserterException {
		List <Person> personList = new ArrayList<> ();
		personList = persondao.findList();
		int realNb = getInserter().select("select count(id) from person").getDataAsInt();
		assertEquals(persondao.findList().size(), realNb);	
	}


	public void testCreate () throws SqlInserterException, DaoException {
		int realAvant = getInserter().select("select count(id) from person").getDataAsInt();
		Animal animal2 = animaldao.findById(2); //on instancie un animal
		List <Animal> list = new ArrayList<>();//on crée la liste + on y rajoute les animaux
		list.add(animal2);
		animal2 = animaldao.findById(3);
		list.add(animal2); // la personne aura 2 animaux dans la liste
		Person p1 = new Person("Bochin", "Dominique", 55, 0, list); // on instancie la nouvelle personne
		persondao.create(p1); //on la crée dans la BDD
		int realApres = getInserter().select("select count(id) from person").getDataAsInt();
		assertEquals(realAvant+1, realApres);

		Person p2 = persondao.findById(p1.getId()); // LE TEST A FAIRE!!!
		assertNotNull(p2); // test exist?
		assertEquals(p2.getFirstName(), p1.getFirstName());
		assertNotNull(p2.getAnimaux());
		assertEquals(p2.getAnimaux().size(),p1.getAnimaux().size());
		assertEquals(p2.getAnimaux().get(0).getName(),p1.getAnimaux().get(0).getName());
		assertEquals(p2.getAnimaux().get(1).getName(),p1.getAnimaux().get(1).getName());

		List <Person> personList = new ArrayList<>();
		personList = persondao.findList();
		boolean done = false; // pour tester si la liste contient le nouvel objet
		for (Person p: personList) { 
			if (p.getId() == p1.getId()) {
				done = true;
				break;
			}
		}
		assertTrue(done); // test contient
		int realNb = getInserter().select("select count(id) from person").getDataAsInt();
		assertEquals(personList.size(), realNb); // test taille
		
		// test aux limites

		try {										
			Person p3 = new Person (null, null, 55, 0, list);
			persondao.create(p3);
		} catch (Exception ex) {
			assertNotNull(ex);
		}

		realAvant = getInserter().select("select count(id) from person").getDataAsInt();
		persondao.create(null);
		realApres = getInserter().select("select count(id) from person").getDataAsInt();
		assertEquals(realAvant, realApres); // test que la taille n'a pas bougé

	}


	public void testFindById () throws DaoException {
		Person p1 = persondao.findById(0); // il ne se passe rien, car id n'existe pas
		assertNull(p1);

		p1 = persondao.findById(5); // id existe
		assertNotNull(p1);
		assertEquals(p1.getId(),5);
	}

	public void testUpdateById () throws DaoException {
		Person p1 = persondao.findById(19);
		int newAge=29;
		p1.setAge(newAge);
		persondao.updateById(p1);
		assertEquals(persondao.findById(p1.getId()).getAge(),newAge);
		
		String name = "Emmanuel";
		p1.setFirstName(name);
		persondao.updateById(p1);
		assertEquals(persondao.findById(p1.getId()).getFirstName(), name);
				
		animaldao.updateById(null);// il ne se passe rien, car condition dans animalDao
	}

	public void testDelete () throws SqlInserterException, DaoException {
		List<Person> personList = new ArrayList<>();
		personList = persondao.findList(); // on crée la liste initiale
		
		int realAvant = getInserter().select("select count(id) from person").getDataAsInt();
		
		Animal animal2 = animaldao.findById(1);
		List <Animal> list = new ArrayList<>();
		list.add(animal2);
		Person p1 = new Person("Bochin", "Dominique", 55, 0, list); 
		persondao.create(p1); 
		
		int realApres = getInserter().select("select count(id) from person").getDataAsInt();
		assertEquals(realAvant+1, realApres); //check si la taillme de la liste +1
		
		personList = persondao.findList();
		boolean done = false; // pour tester si la liste contient le nouvel objet
		for (Person p: personList) { 
			if (p.getId() == p1.getId()) {
				done = true;
				break;
			}
		}
		assertTrue(done); // test contient
		
		realAvant = getInserter().select("select count(id) from person").getDataAsInt();
		persondao.deleteById(p1.getId());
		realApres = getInserter().select("select count(id) from person").getDataAsInt();
		assertEquals(realAvant-1, realApres); //check si la taille de la liste -1
		
	}

}
