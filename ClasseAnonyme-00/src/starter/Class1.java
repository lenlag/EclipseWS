package starter;

import service.Worker;

public class Class1 {

	public static void main(String[] args) {
		Worker class1 = new Worker() {	//classe anonyme se crée à la volée (utilise une instance d'interface)

			@Override
			public void work() {
				System.out.println("I am class1. I implement the 'Worker' interface");

			}
		};

		for(int i=0; i<500; i++) {
		class1.work();
		System.out.println(i);
		}
	}

}
