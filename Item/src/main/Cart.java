package main;

public class Cart {

	private ISellableItem [] shoppingCart = new SellableItem [100];
	int nbSellableItems = 0;

	public void add ( ISellableItem x) {  // compte le nombre d'articles
		shoppingCart [nbSellableItems] = x;
		nbSellableItems++;

	} // méthode sellable item


	public String toString () {
		String s = "Panier : ";
		if (nbSellableItems > 0) { 
			s+= "SellableItems : \r\n"; // pour avoir l'en-tête

			for (int i = 0; i <nbSellableItems; i ++) {
				s += shoppingCart[i].toString() + "\r\n";	
			} // for

		} // if
		return s;
	} // méthode toString

	public ISellableItem getItembyId (int id) {
		int index = getIndexFromId(id);
		return shoppingCart[index];
	}


	/* public ISellableItem getItembyId (int id) {

		for (int i = 0; i < nbSellableItems; i ++) {
			if (shoppingCart[i].getId() == id) {
				return shoppingCart[i];
			}
		} 
		return null;
	}// méthode getItemId */

	public void setItembyId (int id, ISellableItem s) {
		int index = getIndexFromId(id);
		shoppingCart[index] = s;

	}


	/* public void setItembyId (int id, ISellableItem s) {
		for (int i = 0; i < nbSellableItems; i ++) {
			if(shoppingCart[i].getId() == id) {
				shoppingCart[i] = s;;

			}
		}

	} //méthode setItembyId */

	public void deleteItem(int id) {
		boolean done = false;
		int index = getIndexFromId(id);
		shoppingCart[index] = null;
		done = true;
		if (done = true) {
			reformate ();
			nbSellableItems--;
		} //if
	}// delete 



	/* public void deleteItem(int id) {
		boolean done = false;
		for (int i = 0; i < nbSellableItems; i ++) {
			if(shoppingCart[i].getId() == id) {
				shoppingCart[i] = null;
				break;
			}	 // if

		} // for
		if (done = true) {
			reformate ();
			nbSellableItems--;
		} //for

	}// delete */


	public void reformate () {
		for (int i = 0; i < nbSellableItems; i ++) {
			if (shoppingCart[i] == null) {
				shoppingCart[i] = shoppingCart [i+1];
				shoppingCart[i+1] = null;
			}
		}
	}

	private int getIndexFromId (int id) {
		for (int i = 0; i < nbSellableItems; i ++) {
			if(shoppingCart[i].getId() == id) {
				return i;
			}

		}
		return -1;
	}


} // class
