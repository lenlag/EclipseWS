package main;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ISellableItem item = new SellableItem (5, "montre", 80.5, 0.2);
		ISellableItem item2 = new SellableItem (10, "poupée", 20, 0.2);
		ISellableItem item3 = new SellableItem (22, "bonbon", 2, 0.1);
		ISellableItem item4 = new SellableItem (33, "stylo", 1, 0.2);
		
		
		Cart cart = new Cart ();
		
		cart.add(item);
		cart.add(item2);
		cart.add(item3);
		cart.add(item4);
		System.out.println(cart.toString());
		
		item = cart.getItembyId(10);
		System.out.println(item.toString());
		System.out.println();
		
		item2.setNom("voiture");
		System.out.println(cart.toString());
		
		item = cart.getItembyId(45);
		if (item != null) {
			System.out.println (item.toString());
		} else {
			System.out.println("Mon pointeur est null!!!");
		}
		
	    

		System.out.println(cart.toString());
		cart.deleteItem(22);
		System.out.println(cart.toString());
		
		cart.deleteItem(10);
		System.out.println(cart.toString());
		
		cart.deleteItem(5);
		System.out.println(cart.toString());
		
		
		
	}
}
