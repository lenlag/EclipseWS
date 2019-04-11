package business.entity;


import java.io.NotSerializableException;
import java.util.ArrayList;
import java.util.List;

import persistence.dao.AnimalDao;
import persistence.dao.SpecieDao;

public class TestMainAnimal {

	public static void main(String[] args) throws  Exception {

		Specie s = new SpecieDao().findById(2);
		Animal an = new Animal ("Koshechka", "f", "multicolor", 0 , s);
		AnimalDao anDao = new AnimalDao();

		// TEST Find List
		List<Animal> animalList = new ArrayList ();
		animalList = anDao.findList();

		System.out.println("Voici les données de notre tableau : ");
		System.out.println();
		for (Animal anim : animalList) {
			System.out.println(anim);
		}
		System.out.println("\r\n");


		//TEST CREATE 
		anDao.create(an);
		System.out.println(an);

		//TEST FIND by Id
		an = anDao.findById(an.getId());
		System.out.println();
		System.out.println("Voici l'annimal correspondant à l'id demandé : ");
		System.out.println(an);
		System.out.println("\r\n");


		//Test UPDATE by id
		an.setName("machin");
		anDao.updateById(an);

		Animal an2 = anDao.findById(an.getId());
		if (an2.getName().equals(an.getName())) {
			System.out.println("Les 2 noms sont identiques");
		} else {
			System.out.println("Attenton! Les 2 noms ne sont pas identiques! Erreur!");
		}
		System.out.println();


		// TEST DELETE by id
		anDao.deleteById(an.getId());


		// TEST Find List
		animalList = new ArrayList ();
		animalList = anDao.findList();

		System.out.println("Voici les données de notre tableau après les manipulations: ");
		System.out.println();
		for (Animal anim : animalList) {
			System.out.println(anim);
		}

	}

}
