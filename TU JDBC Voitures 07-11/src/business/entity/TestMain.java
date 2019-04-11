package business.entity;

import static org.junit.Assert.assertEquals;

import persistence.dao.AutomobileDao;
import persistence.dao.FreinDao;
import persistence.dao.MoteurDao;

public class TestMain {
	
	public static void main(String[] args) throws Exception {
	
	Moteur moteur = new Moteur(6, "Lada", "Granta", 1500);
	MoteurDao moteurdao = new MoteurDao ();
	
	moteurdao.create(moteur);
	moteur = moteurdao.findById(moteur.getId());
	System.out.println(moteur);
	
	moteurdao.deleteById(moteur.getId());
	
	AutomobileDao automobiledao = new AutomobileDao ();
	FreinDao freindao = new FreinDao();
	moteur = moteurdao.findById(2);
	Frein frein = freindao.findById(3);
	Automobile auto = new Automobile (0, "BMW", "X5", moteur, frein);
	

	String newMarque = "Subaru";
	auto.setMarque(newMarque);
	automobiledao.updateById(auto);
	
	
	
	}
	
}
