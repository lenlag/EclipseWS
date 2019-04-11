package main;

public class TU1_Ex1 {
	
	String myString = "";
	
	public TU1_Ex1() {
		
	}
		
	public String getMyString() {
		return myString;
	}


	public void setMyString(String myString) {
		this.myString = myString;
	}


	public void purge () {
		myString = "";
	}
	
	public void append (String s) {
		myString = myString.concat(s);
	}
	
	public void decrement () {
		myString = myString.substring(0, myString.length()-1);
	}

	
}
