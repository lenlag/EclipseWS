package persistence.dao;

import java.util.ArrayList;
import java.util.List;
import business.entity.Cycliste;
import business.entity.Equipe;
import exception.SqlInserterException;
import persistence.exception.DaoException;
import persistence.pere.TU_Pere;

public class TestCyclisteDao extends TU_Pere {
	
	CyclisteDao cyclisteDao = null;
	Cycliste cycliste = null;
	EquipeDao equipeDao = null;
	Equipe equipe = null;
	

	@Override
	public void setUp() throws Exception {
		super.setUp();
		cyclisteDao = new CyclisteDao();
		equipeDao = new EquipeDao ();
		equipe = equipeDao.findById(3);
		cycliste = new Cycliste(0, "Ivanov", equipe, 7);
	}

	public void testFindList() throws Exception {
		List<Cycliste> cList = new ArrayList<>();
		cList = cyclisteDao.findList();
		int realNb = getInserter().select("select count(id) from cycliste").getDataAsInt();
		assertEquals(cList.size(), realNb);
	}

	public void testcreate() throws Exception {
		int realAvant = getInserter().select("select count(id) from cycliste").getDataAsInt();
		cyclisteDao.create(cycliste);
		int realApres = getInserter().select("select count(id) from cycliste").getDataAsInt();
		assertEquals(realAvant + 1, realApres); 

		List<Cycliste> cList = new ArrayList<>();
		cList = cyclisteDao.findList();
		boolean done = false; 
		for (Cycliste c : cList) {
			if (c.getId() == cycliste.getId()) {
				done = true;
				break;
			}
		}
		assertTrue(done); 

		// tests aux limites
		realAvant = getInserter().select("select count(id) from cycliste").getDataAsInt();
		cyclisteDao.create(null);
		realApres = getInserter().select("select count(id) from cycliste").getDataAsInt();
		assertEquals(realAvant, realApres); 

		try {
			Cycliste cycliste = new Cycliste(0, null, equipe, 7);
			cyclisteDao.create(cycliste);
		} catch (Exception ex) {
			assertNotNull(ex);
		}
	}

	public void testFindById() throws Exception {

		cycliste = cyclisteDao.findById(19); // il ne se passe rien, car id n'existe pas

		cycliste = cyclisteDao.findById(3); // id existe
		assertNotNull(cycliste);

		tearDown();// on reinitialise les données
		setUp();
		cyclisteDao.create(cycliste);
		assertNotNull(cyclisteDao.findById(cycliste.getId()));

		setUp();
		cyclisteDao.create(cycliste);
		Cycliste cycliste2 = cyclisteDao.findById(cycliste.getId()); 
		assertNotNull(cycliste2); // test exist?
		assertEquals(cycliste2.getId(), cycliste.getId());
		assertNotNull(cycliste2.getEquipe());
		assertEquals(cycliste2.getName(), cycliste.getName());
		assertEquals(cycliste2.getNombre_velos(), cycliste.getNombre_velos());
		assertEquals(cycliste2.getEquipe().getId(), cycliste.getEquipe().getId());
		
	}

	public void testupdateById() throws DaoException {
		cycliste = cyclisteDao.findById(5);
		String newName = "Ivanov";
		cycliste.setName(newName);;
		cyclisteDao.updateById(cycliste);
		assertEquals(cyclisteDao.findById(cycliste.getId()).getName(), newName);

		cyclisteDao.updateById(null);// il ne se passe rien, car condition dans cyclisteDao
	}

	public void test_delete() throws DaoException, SqlInserterException {
		List<Cycliste> cList = new ArrayList<>();
		cList = cyclisteDao.findList();

		int realAvant = getInserter().select("select count(id) from cycliste").getDataAsInt();
		cyclisteDao.create(cycliste);
		int realApres = getInserter().select("select count(id) from cycliste").getDataAsInt();
		assertEquals(realAvant + 1, realApres); // check si la taille de la liste +1

		cList = cyclisteDao.findList(); // test si la liste contient le nouvel objet
		boolean done = false;
		for (Cycliste c : cList) {
			if (c.getId() == cycliste.getId()) {
				done = true;
				break;
			}
		}
		assertTrue(done);

		realAvant = getInserter().select("select count(id) from cycliste").getDataAsInt();
		cyclisteDao.deleteById(cycliste.getId());
		realApres = getInserter().select("select count(id) from cycliste").getDataAsInt();
		assertEquals(realAvant - 1, realApres); // check si la taillme de la liste -1

	}


}
