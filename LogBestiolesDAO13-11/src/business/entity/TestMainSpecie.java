package business.entity;

import java.util.ArrayList;
import java.util.List;

import persistence.dao.SpecieDao;

public class TestMainSpecie {

	public static void main(String[] args) throws Exception {

		// TEST FIND LIST
		
		
		SpecieDao specieDao = new SpecieDao ();
		List <Specie> list = new ArrayList();
		list = specieDao.findList();

		System.out.println("Voici les donn�es initiales du tableau : ");
		System.out.println();
		for (Specie m : list) { 		//display list in a loop
			System.out.println(m);
		}

		// TEST CREATE	


	/*	Specie sp = new Specie(0,"Cheval","Chevalus"); //on cr�e une nouvelle instance de specie(id, commonN, latinN), mais id est pris de GENERATED_KEY, donc il est plac� par le syst�me et pas par nous
		specieDao.create(sp); // on appelle f-on create de SpecieDao

		System.out.println("\r\n");
		System.out.println("Voici les donn�es du tables apr�s l'insertion : ");
		System.out.println();

		list = specieDao.findList();
		for (Specie m : list) { 		//display list in a loop
			System.out.println(m);
		}
	*/
		
		// TEST FIND BY ID 
		
	/*	System.out.println("\r\n");
		Specie sp = specieDao.findById(2);
		System.out.println("Voici l'objet identifi� par l'id saisi :");
		System.out.println(sp);
		System.out.println("\r\n");
	*/	
		
		// TEST UPDATE BY ID
		
	/*	Specie sp = new Specie(7, "Coco Cheval", "Equus ferus caballus");
		specieDao.updateById(sp);
		
	*/	
		
	/*	Specie sp = specieDao.findById(1);
		sp.setCommonName("Tortue");
		specieDao.updateById(sp);
	*/	
	
		
		// TEST DELETE by ID
		
	//	specieDao.deleteById(5); // on ne le stocke null part, car f-on void
		
	
	}



}
