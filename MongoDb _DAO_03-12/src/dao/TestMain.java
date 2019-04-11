package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;

public class TestMain {

	public static void main(String[] args) {

		PersonDAO pdao = new PersonDAO();
		
		//TEST CREATE //
		
		Map<String, Object> map = new HashMap<>();
		map.put("firstName", "Said");
		map.put("lastName", "SAID");
		map.put("age", 23);
		
	//	pdao.create(map);

		
		//TEST DELETE //
		
	// pdao.deleteById("5c0542fc5105eb33a80af3ee");
		
		
		//TEST LIST//
		
		List<Map<String, Object>> myList = new ArrayList<>();
		myList = pdao.list();
		
		for (Map<String, Object> myMap : myList) {
		  System.out.println(myMap.get("firstName"));
		  System.out.println(myMap.get("lastName"));
		  System.out.println(myMap.get("age"));
		}
		
				
		// TEST GET BY ID//
		
		Map<String, Object> myObject = pdao.getById("5c0542d55105eb14706f2167");
		System.out.println(myObject);
		
		
		// TEST UPDATE
		myObject = pdao.getById("5c0542d55105eb14706f2167");
		myObject.put("firstName", "Tra-la-la"); // (nom de clé à modifier,  valeur)
		pdao.update(myObject);
		System.out.println(myObject);
		
	}
	

}
