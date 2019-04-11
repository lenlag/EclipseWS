package main;

public class TestEx2 {

	public static void main(String[] args)  {

		Machine m = new Machine ();
		try {
			m.config();
			m.process(); // on peut inverser ces 2 lignes pour avoir un tel ou tel msg erreur
			m.init();
		} catch (INITException ex) {
			System.out.println("J'ai reçu une exception init");
		} catch (ProcessException ex) {
			System.out.println("J'ai reçu une exception process");
		}catch (MachineConfigException ex){
			System.out.println("J'ai reçu une erreur MachineSubSystemConfigException");
		} finally {
		} // try
		
		
	} // main

} // class
