package business.entity;

import java.util.ArrayList;
import java.util.List;

import persistance.dao.RaceDao;

public class TestMainRace {

	public static void main(String[] args) throws Exception {


		//	Race race = new Race (0, "Chihuahua", 750 , "Trop choux!");
		RaceDao racedao = new RaceDao();


		// TEST CREATE
		//	racedao.create(race);

		//TEST FIND by id
		Race race = racedao.findById(4);
		System.out.println(race);

		// TEST FindList
		List <Race> raceList = new ArrayList<>();
		raceList = racedao.findList();
		for (Race m : raceList) {
			System.out.println(m);
		}

		// TEST UPDATE
		/*	Race race1 = new Race (2,"TECKEL-TECKEL", 330, "Pas très bas sur patte");
		racedao.updateById(race1);
		 */	
		// TEST DELETE

		//	racedao.deleteById(2);


		// TEST FindList
		
		raceList = racedao.findList();
		for (Race m : raceList) {
			System.out.println(m);
		}

	}

}
