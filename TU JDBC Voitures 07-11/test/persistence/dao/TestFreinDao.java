package persistence.dao;

import java.util.ArrayList;
import java.util.List;

import business.entity.Frein;
import exception.SqlInserterException;
import persistence.exception.DaoException;
import persistence.pere.TU_Pere;

public class TestFreinDao extends TU_Pere {
	FreinDao freindao = null; // on déclare la variable ici, sinon elle sera invisible pour les méthodes
	
	@Override
	public void setUp() throws Exception { //chargé avant l'execution de chaque méthode de test
		super.setUp(); // SUPER VA DEVANT!!!
		freindao = new FreinDao (); // on initialise la variable
	}

	public void testFindList () throws DaoException, SqlInserterException {
		List<Frein> freinList = new ArrayList<>();
		freinList = freindao.findList();
		int realNb = getInserter().select("select count(id) from frein").getDataAsInt();
		assertEquals(freinList.size(),realNb);
	
	}
	
	public void testCreate () throws Exception {
		Frein frein1 = new Frein (0, "KAMAZ", "20PTZ");
		int realAvant = getInserter().select("select count(id) from frein").getDataAsInt();
		freindao.create(frein1);
		int realApres = getInserter().select("select count(id) from frein").getDataAsInt();
		assertEquals(realAvant+1, realApres);
		
		
		Frein frein2 = freindao.findById(frein1.getId());
		assertNotNull(frein2); // test exist?
		assertEquals(frein1.getId(), frein2.getId());
		assertEquals (frein1.getMarque(), frein2.getMarque());
		assertEquals(frein1.getModele(), frein2.getModele());
				
		List<Frein> list = new ArrayList<>();
		list = freindao.findList();
		boolean done = false; // pour tester si la liste contient le nouvel objet
		for (Frein f : list) { // impossible assertEquals(list.contains(object), car findlist() crée un nouvel objet list.add(new Specie(id,common,latin), et ce N'EST PAS LE MEME OBJET
			if (f.getId() == frein1.getId()) {//comparer par rapport à l'id - que ça reference la même chose
				done = true;
				break;
			}
		}
		assertTrue(done);
		int realNb = getInserter().select("select count(id) from frein").getDataAsInt();
		assertEquals(list.size(), realNb);
						
		// test aux limites
		
		
		try {										
			Frein frein3 = new Frein (0, null, null);
			freindao.create(frein3);
		} catch (Exception ex) {
			assertNotNull(ex);
		}
	
		realAvant = getInserter().select("select count(id) from frein").getDataAsInt();
		freindao.create(null); // rien se passe car condition dans MoteurDao
		realApres = getInserter().select("select count(id) from frein").getDataAsInt();
		assertEquals(realAvant, realApres); // la taille n'a pas dû changer !
	}
	
	public void testFindById () throws DaoException {
		int newId = 5;
		Frein frein4 = freindao.findById(newId);
		Frein frein9 = freindao.findById(newId); // càd les 2 objets sont indentiques
		assertEquals(frein4.getId(), frein9.getId());
		assertEquals(frein4.getId(), newId);
		assertNotNull(frein9); // Test existe?
		
		frein9 = freindao.findById(19); // il ne se passe rien, car id n'existe pas
		assertNull(frein9);
	}	
	
	public void testUpdateById () throws DaoException {
		Frein frein = freindao.findById(3);
		String newMarque = "XYZ";
		frein.setMarque(newMarque);
		freindao.updateById(frein);
		assertEquals(freindao.findById(frein.getId()).getMarque(), newMarque);
		
		Frein frein2 = freindao.findById(3);
		String anotherMarque = "WABC";
		frein2.setMarque(anotherMarque);
		freindao.updateById(frein2);
		assertEquals(freindao.findById(frein2.getId()).getMarque(), anotherMarque);
		assertTrue(freindao.findById(frein2.getId()).getMarque().equals(anotherMarque));
		assertFalse(freindao.findById(frein2.getId()).getMarque().equals(newMarque));
		assert(freindao.findById(frein2.getId()).getMarque() != newMarque);
		
		String newModele = "CGCH125";
		frein2.setModele(newModele);
		freindao.updateById(frein2);
		assertEquals(freindao.findById(frein2.getId()).getModele(), newModele);
		
		freindao.updateById(null);//ok, car j'ai rajouté une condition au code updateById
	}
	
	public void testDelete() throws DaoException, SqlInserterException {
		List<Frein> list = new ArrayList<>();
		list = freindao.findList(); 
		Frein frein1 = new Frein (0, "KAMAZ", "20PTZ");
		freindao.create(frein1);
		
		freindao.findById(frein1.getId());
		assertNotNull(frein1);
		
		int realNb = getInserter().select("select count(id) from frein").getDataAsInt();
		assertEquals(list.size()+1,realNb); // test que le nouvel objet a été bien rajouté : list +1

		list = freindao.findList();
		boolean done = false; // pour tester si la liste contient le nouvel objet
		for (Frein f :list) { // impossible assertEquals(list.contains(object), car findlist() crée un nouvel objet list.add(new Specie(id,common,latin), et ce N'EST PAS LE MEME OBJET
			if (f.getId() == frein1.getId()) {//comparer par rapport à l'id - que ça reference la même chose
				done = true;
				break;
			}
		}
		assertTrue(done);
		
		int realAvant = getInserter().select("select count(id) from frein").getDataAsInt();
		freindao.deleteById(frein1.getId());
		int realApres = getInserter().select("select count(id) from frein").getDataAsInt();
		assertEquals(realAvant-1, realApres); //check si la taille de la liste -1
		
		list = freindao.findList();
		done = false; 
		for (Frein f :list) { 
			if (f.getId() == frein1.getId()) {
				done = true;
				break;
			}
		}
		assertFalse(done); //pour tester que la liste NE contient plus l'objet specie
		// assertNull(specie); => pas bon test! car l'objet existe toujours. c'est l'enregistrement dans la bdd qui n'existe plus

		
		freindao.deleteById(355); // pourquoi pas d'erreur? => parce que ça ne fait rien à la BDD, ça renvoie null et pas une exception - on peut tester si la taille de la liste n'a pas changé
			
	}
	

}
