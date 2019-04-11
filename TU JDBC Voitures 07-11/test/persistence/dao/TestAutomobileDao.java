package persistence.dao;

import java.util.ArrayList;
import java.util.List;

import business.entity.Automobile;
import business.entity.Frein;
import business.entity.Moteur;
import exception.SqlInserterException;
import persistence.exception.DaoException;
import persistence.pere.TU_Pere;

public class TestAutomobileDao extends TU_Pere {

	AutomobileDao automobiledao = null;
	Automobile automobile = null;
	MoteurDao moteurdao = null;
	FreinDao freindao = null;
	Frein frein = null;
	Moteur moteur = null;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		automobiledao = new AutomobileDao();
		moteurdao = new MoteurDao();
		freindao = new FreinDao();
		moteur = moteurdao.findById(2);
		frein = freindao.findById(3);
		automobile = new Automobile(5, "BMW", "X5", moteur, frein);
	}

	public void testFindList() throws Exception {
		List<Automobile> autoList = new ArrayList<>();
		autoList = automobiledao.findList();
		int realNb = getInserter().select("select count(id) from automobile").getDataAsInt();
		assertEquals(autoList.size(), realNb);
	}

	public void testCreate() throws Exception {
		int realAvant = getInserter().select("select count(id) from automobile").getDataAsInt();
		automobiledao.create(automobile);
		int realApres = getInserter().select("select count(id) from automobile").getDataAsInt();
		assertEquals(realAvant + 1, realApres); // la taille+1

		List<Automobile> autoList = new ArrayList<>();
		autoList = automobiledao.findList();
		boolean done = false; // pour tester si la liste contient le nouvel objet
		for (Automobile a : autoList) {
			if (a.getId() == automobile.getId()) {
				done = true;
				break;
			}
		}
		assertTrue(done); // contient = True

		// tests aux limites
		realAvant = getInserter().select("select count(id) from automobile").getDataAsInt();
		automobiledao.create(null); // il ne se passe rien, car condition dans AnimalDao
		realApres = getInserter().select("select count(id) from automobile").getDataAsInt();
		assertEquals(realAvant, realApres); // la taille n'a pas changée

		try {
			Automobile automobile = new Automobile(0, null, null, null, null);
			automobiledao.create(automobile);
		} catch (Exception ex) {
			assertNotNull(ex);
		}
	}

	public void testFindById() throws Exception {

		automobile = automobiledao.findById(19); // il ne se passe rien, car id n'existe pas

		automobile = automobiledao.findById(3); // id existe
		assertNotNull(automobile);

		tearDown();// on reinitialise les données
		setUp();
		automobiledao.create(automobile);
		assertNotNull(automobiledao.findById(automobile.getId()));

		setUp();
		automobiledao.create(automobile);
		Automobile automobile2 = automobiledao.findById(automobile.getId()); // LE TEST A FAIRE!!!
		assertNotNull(automobile2); // test exist?
		assertEquals(automobile2.getId(), automobile.getId());
		assertNotNull(automobile2.getFrein());
		assertNotNull(automobile2.getMoteur());
		assertEquals(automobile2.getMarque(), automobile.getMarque());
		assertEquals(automobile2.getModele(), automobile.getModele());
		assertEquals(automobile2.getFrein().getId(), automobile.getFrein().getId());
		assertEquals(automobile2.getMoteur().getId(), automobile.getMoteur().getId());

	}

	public void testUpdateById() throws DaoException {
		automobile = automobiledao.findById(4);
		String newMarque = "Subaru";
		automobile.setMarque(newMarque);
		automobiledao.updateById(automobile);
		assertEquals(automobiledao.findById(automobile.getId()).getMarque(), newMarque);

		automobiledao.updateById(null);// il ne se passe rien, car condition dans animalDao
	}

	public void testDelete() throws DaoException, SqlInserterException {
		List<Automobile> autoList = new ArrayList<>();
		autoList = automobiledao.findList();

		int realAvant = getInserter().select("select count(id) from automobile").getDataAsInt();
		automobiledao.create(automobile);
		int realApres = getInserter().select("select count(id) from automobile").getDataAsInt();
		assertEquals(realAvant + 1, realApres); // check si la taille de la liste +1

		autoList = automobiledao.findList(); // test si la liste contient le nouvel objet
		boolean done = false;
		for (Automobile a : autoList) {
			if (a.getId() == automobile.getId()) {
				done = true;
				break;
			}
		}
		assertTrue(done);

		realAvant = getInserter().select("select count(id) from automobile").getDataAsInt();
		automobiledao.deleteById(automobile.getId());
		realApres = getInserter().select("select count(id) from automobile").getDataAsInt();
		assertEquals(realAvant - 1, realApres); // check si la taillme de la liste -1

	}

}
