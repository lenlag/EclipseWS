package main;

public class Execrice3 {

	public static String getInputString() throws Exception {
		byte[] bs = new byte[255];
		System.in.read(bs);
		
		return new String(bs);
	}
	public static int getInputInt() throws Exception {
		String s = getInputString().trim();
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		int ht, nb, ttc, ttva, tva1;
		double prixtva;
		System.out.print("Entrez le prix HT->");
		ht = getInputInt();
		System.out.println();
		System.out.print("Entrez le nombre d'articles N ->");
		nb = getInputInt();
		System.out.println();
		System.out.print("Entrez le taux TVA ->");
		ttva = getInputInt();
		System.out.println();
		tva1 = 100 + ttva;
		prixtva=ht*nb;
		ttc = (int) ((double)prixtva*tva1/100);
		System.out.println();
		System.out.print("Le montant TTC est: " + ttc);
	}

}
