package persistence.dao;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import business.entity.Race;
import business.entity.Specie;
import exception.SqlInserterException;
import inserter.Inserter;
import junit.framework.TestCase;
import persistence.dao.SpecieDao;
import persistence.exception.DaoException;
import persistence.manager.JDBCManager;
import persistence.pere.TU_Pere;

public class TestSpecieDao extends TU_Pere {

	SpecieDao speciedao = new SpecieDao();
	
	@Override
	public void setUp() throws Exception {
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
		List<Specie> list = new ArrayList<>();
		list = speciedao.findList();
		//assertEquals (list.size(),5); // pas bon, utiliser inserter pour calculer la taille du fichier
		int realNb = getInserter().select("select count(id) from specie").getDataAsInt();
		assertEquals(list.size(),realNb);
	
	}
	
	public void testCreate () throws Exception {
		Specie specie = new Specie (0, "cheval", "chevalus");
		int realAvant = getInserter().select("select count(id) from specie").getDataAsInt();
		speciedao.create(specie);
		int realApres = getInserter().select("select count(id) from specie").getDataAsInt();
		assertEquals(realAvant+1, realApres);
		
		Specie specie2 = speciedao.findById(specie.getId());
		assertNotNull(specie2);
		assertEquals(specie.getId(), specie2.getId());
		assertEquals(specie.getCommonName(), specie2.getCommonName());
		assertEquals(specie.getLatinName(), specie2.getLatinName());
		
		List<Specie> list = new ArrayList<>();
		list = speciedao.findList();
		boolean done = false; // pour tester si la liste contient le nouvel objet
		for (Specie s:list) { // impossible assertEquals(list.contains(object), car findlist() crée un nouvel objet list.add(new Specie(id,common,latin), et ce N'EST PAS LE MEME OBJET
			if (s.getId() == specie.getId()) {//comparer par rapport à l'id - que ça reference la même chose
				done = true;
				break;
			}
		}
		assertTrue(done);
		int realNb = getInserter().select("select count(id) from specie").getDataAsInt();
		assertEquals(list.size(), realNb);
						
		realAvant = getInserter().select("select count(id) from specie").getDataAsInt();
		speciedao.create(null);
		realApres = getInserter().select("select count(id) from specie").getDataAsInt();
		assertEquals(realAvant, realApres);
	}
	
	public void testFindById () throws DaoException {
		Specie specie3 = speciedao.findById(1);
		Specie specie4 = speciedao.findById(1);
		assertEquals(specie3.getId(), specie4.getId());
		assertNotNull(specie3);
		
		specie3 = speciedao.findById(19); // il ne se passe rien, car id n'existe pas
		
	}
	
	
	public void testUpdateById () throws DaoException {
		Specie specie = speciedao.findById(2);
		specie.setCommonName("Wof-wof");
		speciedao.updateById(specie);
		assertEquals(speciedao.findById(2).getCommonName(), "Wof-wof");
		
		Specie specie2 = speciedao.findById(2);
		specie2.setCommonName("Chien");
		speciedao.updateById(specie2);
		assertTrue(speciedao.findById(2).getCommonName().equalsIgnoreCase("Chien"));
		assertFalse(speciedao.findById(2).getCommonName().equalsIgnoreCase("Wof-wof"));
		
		speciedao.updateById(null);//ok, car j'ai rajouté une condition au code updateById
	}
	
	public void testDelete() throws DaoException, SqlInserterException {
		List<Specie> list = new ArrayList<>();
		list = speciedao.findList(); // on fait la liste initiale
		Specie specie = new Specie (0, "Snail", "Escargotus"); // on instancie le nouv. objet
		speciedao.create(specie); // on crée le nouvel objet dans la BDD
		speciedao.findById(specie.getId());
		assertNotNull(specie);
		int realNb = getInserter().select("select count(id) from specie").getDataAsInt();
		assertEquals(list.size()+1,realNb); // test que le nouvel objet a été bien rajouté : list +1

		list = speciedao.findList();
		boolean done = false; // pour tester si la liste contient le nouvel objet
		for (Specie s:list) { // impossible assertEquals(list.contains(object), car findlist() crée un nouvel objet list.add(new Specie(id,common,latin), et ce N'EST PAS LE MEME OBJET
			if (s.getId() == specie.getId()) {//comparer par rapport à l'id - que ça reference la même chose
				done = true;
				break;
			}
		}
		assertTrue(done);
		
		speciedao.deleteById(specie.getId());
		assertEquals(list.size(),realNb);
		
		list = speciedao.findList();
		done = false; 
		for (Specie s:list) { 
			if (s.getId() == specie.getId()) {
				done = true;
				break;
			}
		}
		assertFalse(done); //pour tester que la liste ne contient plus l'objet specie
		// assertNull(specie); => pas bon test! car l'objet existe toujours. c'est l'enregistrement dans la bdd qui n'existe plus

		
		speciedao.deleteById(355); // pourquoi pas d'erreur? => parce que ça ne fait rien à la BDD, ça renvoie null et pas une exception - on peut tester si la taille de la liste n'a pas changé
			
	}

}
