package main;

public class TestMain {

	public static void main(String[] args) {

		MyThread t = new MyThread ();
		t.start (); // on le voit en 2ème place
		System.out.println("Test"); // main Thread se termine avant le Thread de t.start () // on le voir en premier
	}
}
