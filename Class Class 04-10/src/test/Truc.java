package test;

public class Truc {
	
	public Truc () {
		System.out.println("Je suis le constr. de la classe Truc");
	}

	public static void main(String[] args) throws Exception { // laisser que Exception, supp les autres
//	Truc t = new Truc ();
	
	Class <?> maklass = Class.forName("test.Truc");
	maklass.newInstance();// on instanie la m�taclass; c�d on cr�e un objet, donn� par FQN
	
	
	
	}

}
