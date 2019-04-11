package objets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemLister implements ILister {

	@Override
	public List<String> list() {
		List <String> maliste = new ArrayList<>();
		maliste.add("1st element");
		maliste.add("2nd element");
		maliste.add("3rd element");
		maliste.add("coucou");
		maliste.add("Bonjour");
		
		
		
		return maliste;
		
		}

		@Override
		public void display() {
			System.out.println("F-on display de la classe MemLister");

		}

	}
