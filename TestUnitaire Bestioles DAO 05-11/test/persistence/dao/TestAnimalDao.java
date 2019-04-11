package persistence.dao;

import java.util.ArrayList;
import java.util.List;

import business.entity.Animal;
import business.entity.Person;
import business.entity.Specie;
import exception.SqlInserterException;
import inserter.Inserter;
import persistence.exception.DaoException;
import persistence.pere.TU_Pere;

public class TestAnimalDao extends TU_Pere  {

	AnimalDao animaldao = null; // déclaration de variable
	Specie specie1 = null;
	Animal animal1 = null;

	@Override
	public void setUp() throws Exception {
		super.setUp(); // !!!on met d'abord le SetUP du PERE, et APRES on rajoute...
		animaldao = new AnimalDao(); // !!! visibilité uniquement dans cette fonction
		specie1 = new SpecieDao().findById(1); // on donne les valeurs à nos variables
		animal1 = new Animal ("Chouchoutte", "f" , "snow-white", 0, specie1);
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


	public void testFindList () throws Exception {
		List<Animal> animalList = new ArrayList<>();
		animalList = animaldao.findList();
		int realNb = getInserter().select("select count(id) from animal").getDataAsInt();
		assertEquals(animalList.size(),realNb);
	}


	public void testCreate () throws Exception {
		int realAvant = getInserter().select("select count(id) from animal").getDataAsInt();
		animaldao.create(animal1);
		int realApres = getInserter().select("select count(id) from animal").getDataAsInt();
		assertEquals(realAvant+1, realApres); 	//la taille+1

		List<Animal> animalList = new ArrayList<>();
		animalList = animaldao.findList();
		boolean done = false; // pour tester si la liste contient le nouvel objet
		for (Animal a : animalList) { 
			if (a.getId() == animal1.getId()) {
				done = true;
				break;
			}
		}
		assertTrue(done); //contient = True

		// tests aux limites
		realAvant = getInserter().select("select count(id) from animal").getDataAsInt();
		animaldao.create(null); // il ne se passe rien, car condition dans AnimalDao
		realApres = getInserter().select("select count(id) from animal").getDataAsInt();
		assertEquals(realAvant, realApres);	//la taille n'a pas changée


		animaldao.create(animal1);
		
		try {		
		Animal animal1 = new Animal (null, null, null, 0, specie1);
		animaldao.create(animal1);
		} catch (Exception ex) {
			assertNotNull(ex);
		}
	}

	public void testFindById () throws Exception {

		animal1 = animaldao.findById(19); // il ne se passe rien, car id n'existe pas
		
		animal1 = animaldao.findById(5); // id existe
		assertNotNull(animal1);
						
		tearDown();// on reinitialise les données
		setUp(); 
		animaldao.create(animal1);
		assertNotNull(animaldao.findById(animal1.getId()));
		
		Animal animal2 = animaldao.findById(animal1.getId()); // LE TEST A FAIRE!!!
		assertNotNull(animal2); // test exist?
		assertEquals(animal2.getCoatColor(), animal1.getCoatColor());
		assertNotNull(animal2.getSpecie());
		assertEquals(animal2.getSex(),animal1.getSex());
		assertEquals(animal2.getName(),animal1.getName());
		assertEquals(animal2.getId(),animal1.getId());

	}
	
	public void testUpdateById () throws DaoException {
		animal1 = animaldao.findById(5);
		String newName = "LOuLOu";
		animal1.setName(newName);
		animaldao.updateById(animal1);
		assertEquals(animaldao.findById(animal1.getId()).getName(),newName);
		
		animaldao.updateById(null);// il ne se passe rien, car condition dans animalDao
	}

	public void testDelete () throws DaoException, SqlInserterException {
		List<Animal> animalList = new ArrayList<>();
		animalList = animaldao.findList(); // on crée la liste initiale
		
		int realAvant = getInserter().select("select count(id) from animal").getDataAsInt();
		animaldao.create(animal1);	//on crée notre animal
		int realApres = getInserter().select("select count(id) from animal").getDataAsInt();
		assertEquals(realAvant+1, realApres); //check si la taille de la liste +1
		
		animalList =  animaldao.findList(); // test si la liste contient le nouvel objet
		boolean done = false; 
		for (Animal a: animalList) { 
			if (a.getId() == animal1.getId()) {
				done = true;
				break;
			}
		}
		assertTrue(done);
		
		realAvant = getInserter().select("select count(id) from animal").getDataAsInt();
		animaldao.deleteById(animal1.getId());
		realApres = getInserter().select("select count(id) from animal").getDataAsInt();
		assertEquals(realAvant-1, realApres); //check si la taillme de la liste -1
		
		
		
	}
}
