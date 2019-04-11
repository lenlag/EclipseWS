package persistence.dao;

import java.util.ArrayList;
import java.util.List;

import business.entity.Equipe;
import exception.SqlInserterException;
import persistence.exception.DaoException;
import persistence.pere.TU_Pere;

public class TestEquipeDao extends TU_Pere {

	EquipeDao equipeDao = null;
	Equipe equipe = null;

	@Override
	public void setUp() throws Exception {
		super.setUp(); 
		equipeDao = new EquipeDao (); 
	}

	public void test_FindList () throws DaoException, SqlInserterException {
		List<Equipe> eqList = new ArrayList<>();
		eqList = equipeDao.findList();
		int realNb = getInserter().select("select count(id) from equipe").getDataAsInt();
		assertEquals(eqList.size(),realNb);

	}

	public void test_create () throws Exception {
		equipe = new Equipe (0,"Equipe ANG", 3920);
		int realAvant = getInserter().select("select count(id) from equipe").getDataAsInt();
		equipeDao.create(equipe);
		int realApres = getInserter().select("select count(id) from equipe").getDataAsInt();
		assertEquals(realAvant+1, realApres);


		Equipe equipe2 = equipeDao.findById(equipe.getId());
		assertNotNull(equipe2);			 // test -> est-ce l'objet exist?
		assertEquals(equipe.getId(), equipe2.getId());
		assertEquals (equipe.getName(), equipe2.getName());
		assertEquals(equipe.getBudget(), equipe2.getBudget());
	

		List<Equipe> list = new ArrayList<>();
		list = equipeDao.findList();
		boolean done = false; 			// pour tester si la liste contient le nouvel objet
		for (Equipe eq : list) { 
			if (eq.getId() == equipe.getId()) {
				done = true;
				break;
			}
		}
		assertTrue(done);
		
		int realNb = getInserter().select("select count(id) from equipe").getDataAsInt();
		assertEquals(list.size(), realNb);// comparer taille de la liste vs.count(id) via req. SQL

										
					// tests aux limites (1 et 2)
		//1
		try {							
			Equipe equipe3 = new Equipe (0, null, 1300);
			equipeDao.create(equipe3);
		} catch (Exception ex) {
			assertNotNull(ex);
		}
		
		//2
		realAvant = getInserter().select("select count(id) from equipe").getDataAsInt();
		equipeDao.create(null); 
		realApres = getInserter().select("select count(id) from equipe").getDataAsInt();
		assertEquals(realAvant, realApres); // la taille n'a pas dû changer !
	}

	public void test_findById () throws DaoException {
		long id = 2;
		Equipe equipe5 = equipeDao.findById(id);
		Equipe equipe7 = equipeDao.findById(id); // càd les 2 objets sont indentiques
		assertNotNull(equipe7); // Test -> objet existe?
		assertEquals(equipe5.getId(), equipe7.getId());
		assertEquals(equipe7.getId(), id);
		

		equipe7 = equipeDao.findById(19); // il ne se passe rien, car id n'existe pas
		assertNull(equipe7); // objet ne doit pas exister
	}	

	public void test_updateById () throws DaoException {
		long id = 3;
		Equipe equipe = equipeDao.findById(id);
		long newBudget = 1789;
		equipe.setBudget(newBudget);
		equipeDao.updateById(equipe);
		assertEquals(equipeDao.findById(id).getBudget(), newBudget);
		
		long anotherBudget = 2567;
		equipe.setBudget(anotherBudget);
		equipeDao.updateById(equipe);
		assertTrue(equipeDao.findById(id).getBudget() == anotherBudget);
		assertFalse(equipeDao.findById(id).getBudget() == newBudget);
		assert(equipeDao.findById(id).getBudget()!= newBudget);

		String newName = "Equipe ANGI";
		Equipe equipe2 = equipeDao.findById(2);
		equipe2.setName(newName);
		equipeDao.updateById(equipe2);
		assertEquals(equipeDao.findById(equipe2.getId()).getName(), newName);

		equipeDao.updateById(null);		//rien ne se passe, car condition dans EquipeDao updateById
	}

	public void test_delete() throws DaoException, SqlInserterException {
		List<Equipe> list = new ArrayList<>();
		list = equipeDao.findList(); 
		equipe = new Equipe (0,"Equipe ANG", 3920);
		equipeDao.create(equipe);

		equipeDao.findById(equipe.getId());
		assertNotNull(equipe);

		int realNb = getInserter().select("select count(id) from equipe").getDataAsInt();
		assertEquals(list.size()+1,realNb); // test que le nouvel objet a été bien rajouté : list +1

		list = equipeDao.findList();
		boolean done = false; // pour tester si la liste contient le nouvel objet
		for (Equipe e :list) { 
			if (e.getId() == equipe.getId()) {
				done = true;
				break;
			}
		}
		assertTrue(done);

		int realAvant = getInserter().select("select count(id) from equipe").getDataAsInt();
		equipeDao.deleteById(equipe.getId());
		int realApres = getInserter().select("select count(id) from equipe").getDataAsInt();
		assertEquals(realAvant-1, realApres); //check si la taille de la liste est -1

		list = equipeDao.findList();
		done = false; 
		for (Equipe e :list) { 
			if (e.getId() == equipe.getId()) {
				done = true;
				break;
			}
		}
		assertFalse(done); //pour tester que la liste NE contient plus l'objet specie	
	}
}
