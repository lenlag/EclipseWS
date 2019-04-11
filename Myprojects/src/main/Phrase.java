package main;

public class Phrase {

	public String transform(String phrase) {
		int nbSpaces = 0;
		String result = "";

		for (int i = 0; i < phrase.length(); i++) {
			if (phrase.charAt(i) == ' ') {
				nbSpaces++;
			}

			if (nbSpaces == 2) {
				result += phrase.charAt(i);
				char c = phrase.charAt(i + 1);
				c = Character.toUpperCase(c);
				i++; //car i+1 dans le c
				result += c;
				nbSpaces = 0;
			} else {
				result += phrase.charAt(i);
			}
		}

		return result;
	}

	public static void main(String[] args) {

		Phrase p = new Phrase();
		System.out.println(p.transform("Je suis un concepteur développeur JAVA"));

		
	}

}
