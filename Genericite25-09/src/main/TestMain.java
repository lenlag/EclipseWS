package main;

public class TestMain {

	public static void main(String[] args) {

		String maString = "NNN";
		Integer i = 18;
		
		Solo<String, Integer> s = new Solo<>(maString, i); //do not pass primitive objecte into a generic type declarations! no int!! Integer OK etc...
		System.out.println(s.getValue() + " " + s.getValeur());
				
		Person angie = new Person ("Bellucci","Angie", 15 );
		Person natalia = new Person("MARTYNOVA", "Natalia", 29);
		Solo <Person, Person> soloPers = new Solo <Person, Person> (angie, natalia);
		System.out.println (soloPers.getValeur().getName() + " " + soloPers.getValue().getName());
		
		

	}

}
