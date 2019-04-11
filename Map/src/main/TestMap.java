package main;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

	public static void main(String[] args) {
		
		Map <String, Integer> map = new HashMap <String, Integer> ();
		map.put("AAA", 0);
		map.put("BBB", 1);
		map.put("CCC", 2);
		
		map.put("BBB", 14);
		map.put("DDD", 56);
		
		for (String key: map.keySet() ) {
			Integer val = map.get(key);
			System.out.println(key + "=" + val);
		}
		
		
		
	}

}
