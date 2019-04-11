package persistence.dao;

import java.util.ArrayList;
import java.util.List;

import business.entity.Race;
import business.entity.Specie;
import exception.SqlInserterException;
import inserter.Inserter;
import persistence.exception.DaoException;
import persistence.pere.TU_Pere;

public class TestRaceDao extends TU_Pere {

	RaceDao racedao = new RaceDao();
	Race race1 = new Race (0, "Teckel", 725, "blabla");



	@Override
	public void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
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
		List <Race> raceList = new ArrayList<>();
		raceList = racedao.findList();
		int realNb = getInserter().select("select count(id) from race").getDataAsInt(); // pour avoir le nbre réel de la liste
		assertEquals(raceList.size(), realNb);
	}


	public void testCreate () throws DaoException, SqlInserterException {
		int realAvant = getInserter().select("select count(id) from race").getDataAsInt();
		racedao.create(race1);
		int realApres = getInserter().select("select count(id) from race").getDataAsInt();
		assertEquals(realAvant+1, realApres);
		Race race2 = racedao.findById(race1.getId());
		assertNotNull(race2); // test exist?
		assertEquals(race1.getId(), race2.getId());
		assertEquals(race1.getComments(), race2.getComments());
		assertEquals(race1.getPrice(), race2.getPrice());

		List <Race> raceList = new ArrayList<>();
		raceList = racedao.findList();
		boolean done = false; // pour tester si la liste contient le nouvel objet
		for (Race s: raceList) { 
			if (s.getId() == race1.getId()) {
				done = true;
				break;
			}
		}
		assertTrue(done); // test contient
		int realNb = getInserter().select("select count(id) from race").getDataAsInt();
		assertEquals(raceList.size(), realNb); // test taille
		
		
		// test aux limites
		try {										
		Race race3 = new Race (0, null, 200, null);
		racedao.create(race3);
		} catch (Exception ex) {
			assertNotNull(ex);
		}
		
		realAvant = getInserter().select("select count(id) from race").getDataAsInt();
		racedao.create(null);
		realApres = getInserter().select("select count(id) from race").getDataAsInt();
		assertEquals(realAvant, realApres); // test que la taille n'a pas bougé
	}
	
	public void testFindById () throws DaoException {
	
		race1 = racedao.findById(9); // il ne se passe rien, car id n'existe pas
		
		
		Race race2 = racedao.findById(1);
		assertNotNull(race2);
		Race race4 = racedao.findById(1);
		assertEquals(race2.getId(), race4.getId());
				
		Race race3 = new Race (0, "Caniche", 125, "Belle");
		racedao.create(race3);
		assertNotNull(racedao.findById(race3.getId()));
		
		try {
		race3 = racedao.findById(55); //id n'existe pas
		assertNull(race3.getId()); // donc, null
		} catch (Exception ex) { //donc, on attrape une erreur si pas nul
			assertNotNull(ex);
		}
		
	}

	
	public void testUpdateById () throws DaoException {
		race1 = racedao.findById(4);
		race1.setComments("This is a very kind dog!");
		racedao.updateById(race1);
		assertEquals(race1.getComments(), "This is a very kind dog!");
		
	
		racedao.updateById(null); // on, car j'ai modifié RaceDao, cette opération fait rien, on sort de la boucle d'update
		
	}
	
	public void testDelete() throws DaoException, SqlInserterException {
		List <Race> raceList = new ArrayList<>();
		raceList = racedao.findList(); // on fait la liste initiale
		int realAvant = getInserter().select("select count(id) from race").getDataAsInt();
		racedao.create(race1); // on crée un nouvel objet dans la BDD
		int realApres = getInserter().select("select count(id) from race").getDataAsInt();
		assertEquals(realAvant+1, realApres);// on test qu'après la creation, la liste +1
		

		raceList =  racedao.findList(); // test si la liste contient le nouvel objet
		boolean done = false; 
		for (Race s: raceList) { 
			if (s.getId() == race1.getId()) {
				done = true;
				break;
			}
		}
		assertTrue(done);
		
		realAvant = getInserter().select("select count(id) from race").getDataAsInt();
		racedao.deleteById(race1.getId());
		realApres = getInserter().select("select count(id) from race").getDataAsInt();
		assertEquals(realAvant-1, realApres); // test si la taille a changé après delete
				
	}
		
}
