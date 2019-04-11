package persistence.dao;

import java.util.ArrayList;
import java.util.List;

import business.entity.Moteur;
import exception.SqlInserterException;
import persistence.exception.DaoException;
import persistence.pere.TU_Pere;

public class TestMoteurDao extends TU_Pere {
	MoteurDao moteurdao = null; // on déclare la variable ici, sinon elle sera invisible pour les méthodes
	
	@Override
	public void setUp() throws Exception { //chargé avant l'execution de chaque méthode de test
		super.setUp(); // SUPER VA DEVANT!!!
		moteurdao = new MoteurDao (); // on initialise la variable
	}

	public void testFindList () throws DaoException, SqlInserterException {
		List<Moteur> motorList = new ArrayList<>();
		motorList = moteurdao.findList();
		int realNb = getInserter().select("select count(id) from moteur").getDataAsInt();
		assertEquals(motorList.size(),realNb);
	
	}
	
	public void testCreate () throws Exception {
		Moteur moteur1 = new Moteur(6, "Lada", "Granta", 1500);
		int realAvant = getInserter().select("select count(id) from moteur").getDataAsInt();
		moteurdao.create(moteur1);
		int realApres = getInserter().select("select count(id) from moteur").getDataAsInt();
		assertEquals(realAvant+1, realApres);
		
		
		Moteur moteur2 = moteurdao.findById(moteur1.getId());
		assertNotNull(moteur2); // test exist?
		assertEquals(moteur1.getId(), moteur2.getId());
		assertEquals (moteur1.getMarque(), moteur2.getMarque());
		assertEquals(moteur1.getModele(), moteur2.getModele());
		assertEquals(moteur1.getCylindree(), moteur2.getCylindree());
		
		List<Moteur> list = new ArrayList<>();
		list = moteurdao.findList();
		boolean done = false; // pour tester si la liste contient le nouvel objet
		for (Moteur m : list) { // impossible assertEquals(list.contains(object), car findlist() crée un nouvel objet list.add(new Specie(id,common,latin), et ce N'EST PAS LE MEME OBJET
			if (m.getId() == moteur1.getId()) {//comparer par rapport à l'id - que ça reference la même chose
				done = true;
				break;
			}
		}
		assertTrue(done);
		int realNb = getInserter().select("select count(id) from moteur").getDataAsInt();
		assertEquals(list.size(), realNb);
						
		// test aux limites

		try {										
			Moteur moteur3 = new Moteur (0, null, null, 1300);
			moteurdao.create(moteur3);
		} catch (Exception ex) {
			assertNotNull(ex);
		}
	
		realAvant = getInserter().select("select count(id) from moteur").getDataAsInt();
		moteurdao.create(null); // rien se passe car condition dans MoteurDao
		realApres = getInserter().select("select count(id) from moteur").getDataAsInt();
		assertEquals(realAvant, realApres); // la taille n'a pas dû changer !
	}
	
	public void testFindById () throws DaoException {
		Moteur moteur1 = moteurdao.findById(5);
		Moteur moteur7 = moteurdao.findById(5); // càd les 2 objets sont indentiques
		assertEquals(moteur1.getId(), moteur7.getId());
		assertEquals(moteur1.getId(), 5);
		assertNotNull(moteur7); // Test existe?
		
		moteur7 = moteurdao.findById(19); // il ne se passe rien, car id n'existe pas
		assertNull(moteur7);
	}	
	
	public void testUpdateById () throws DaoException {
		Moteur moteur = moteurdao.findById(2);
		int cylindree1 = 1600;
		moteur.setCylindree(cylindree1);
		moteurdao.updateById(moteur);
		assertEquals(moteurdao.findById(2).getCylindree(), cylindree1);
		
		Moteur moteur2 = moteurdao.findById(2);
		int cylindree2 = 1900;
		moteur2.setCylindree(cylindree2);
		moteurdao.updateById(moteur2);
		assertTrue(moteurdao.findById(2).getCylindree() == cylindree2);
		assertFalse(moteurdao.findById(2).getCylindree() == cylindree1);
		assert(moteurdao.findById(2).getCylindree() != cylindree1);
		
		String newMarque = "Infinity";
		moteur2.setMarque(newMarque);
		moteurdao.updateById(moteur2);
		assertEquals(moteurdao.findById(moteur2.getId()).getMarque(), newMarque);
		
		String newModele = "HV1557";
		moteur2.setModele(newModele);
		moteurdao.updateById(moteur2);
		assertEquals(moteurdao.findById(moteur2.getId()).getModele(), newModele);
		
		moteurdao.updateById(null);//ok, car j'ai rajouté une condition au code updateById
	}
	
	public void testDelete() throws DaoException, SqlInserterException {
		List<Moteur> list = new ArrayList<>();
		list = moteurdao.findList(); 
		Moteur moteur1 = new Moteur(6, "Lada", "Granta", 1500);
		moteurdao.create(moteur1);
		
		moteurdao.findById(moteur1.getId());
		assertNotNull(moteur1);
		
		int realNb = getInserter().select("select count(id) from moteur").getDataAsInt();
		assertEquals(list.size()+1,realNb); // test que le nouvel objet a été bien rajouté : list +1

		list = moteurdao.findList();
		boolean done = false; // pour tester si la liste contient le nouvel objet
		for (Moteur m :list) { // impossible assertEquals(list.contains(object), car findlist() crée un nouvel objet list.add(new Specie(id,common,latin), et ce N'EST PAS LE MEME OBJET
			if (m.getId() == moteur1.getId()) {//comparer par rapport à l'id - que ça reference la même chose
				done = true;
				break;
			}
		}
		assertTrue(done);
		
		int realAvant = getInserter().select("select count(id) from moteur").getDataAsInt();
		moteurdao.deleteById(moteur1.getId());
		int realApres = getInserter().select("select count(id) from moteur").getDataAsInt();
		assertEquals(realAvant-1, realApres); //check si la taille de la liste -1
		
		list = moteurdao.findList();
		done = false; 
		for (Moteur m :list) { 
			if (m.getId() == moteur1.getId()) {
				done = true;
				break;
			}
		}
		assertFalse(done); //pour tester que la liste NE contient plus l'objet specie
		// assertNull(specie); => pas bon test! car l'objet existe toujours. c'est l'enregistrement dans la bdd qui n'existe plus

		
		moteurdao.deleteById(355); // pourquoi pas d'erreur? => parce que ça ne fait rien à la BDD, ça renvoie null et pas une exception - on peut tester si la taille de la liste n'a pas changé
			
	}
}
