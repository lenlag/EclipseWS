package main;

public class TestMain {

	public static void main(String[] args) {
		Sujet s = new Sujet();
		IObservateur o1 = new Observateur1(s); //interface = qch (new de class Observateur 1)
		IObservateur o2 = new Observateur2(s);
		s.miseAJour(30,40);
	}

}