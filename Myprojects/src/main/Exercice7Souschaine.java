package main;

public class Exercice7Souschaine {

	public static String getInputString() throws Exception {
		byte[] bs = new byte[255];
		System.in.read(bs);
		
		return new String(bs).trim();
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String s1;
		System.out.print("Entrez la premi�re cha�ne ->");
		s1 = getInputString();
		System.out.println();
		
		String s2;
		System.out.print("Entrez la sous-cha�ne � rechercher ->");
		s2 = getInputString();
		System.out.println();
		
		
		if (s1.contains(s2)) {
			System.out.println("La sous-cha�ne est pr�sente dans la premi�re cha�ne");
		} else {
			System.out.println("Cette sous-cha�ne n'a pas �t� detect�e dans la premi�re cha�ne" );
		}
}		
}

