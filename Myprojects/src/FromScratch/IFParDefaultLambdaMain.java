package FromScratch;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class IFParDefaultLambdaMain {
	
	public static void main(String[] args) {
	
	//////////FUNCTION///////////////////////////	
		
	Function<Integer, String> intToString = (Integer a) -> String.valueOf(a);
	System.out.println(intToString.apply(2));
	
	
	Function <String, String> intToValue = (String s) -> "La valeur est " + s;
	System.out.println(intToString.andThen(intToValue).apply(2));
	
	//////////PREDICATE///////////////////////////
	
	Predicate <Integer> pair = (Integer i) -> (i % 2 == 0);
	System.out.println(pair.test(5) ? "pair" : "impair"); // si vrai = pair, sinon = impairc
	
	//////////CONSUMER///////////////////////////prend qch en param, mais renvoie rien
	
	PersonLambda person = new PersonLambda(17, "Mickael");
	System.out.println(person.toString());
	
	Integer newAge = 18;
	String newName = "Camille";
		
	Consumer <PersonLambda> modifyPerson = (pers) -> {pers.setAge(newAge); pers.setName(newName);};
	modifyPerson.accept(person);
	System.out.println(person.toString());
	
	//////////SUPPLIER///////////////////////////prend rien en param, mais renvoie qch	
	
	Supplier <Integer> random = () -> new Random().nextInt(100);
	int result = random.get();
	System.out.println("The random number (0-100) is : " + result);
	
	}

}
