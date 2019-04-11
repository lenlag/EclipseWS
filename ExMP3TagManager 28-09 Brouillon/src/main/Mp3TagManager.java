package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Mp3TagManager {
	
	private String path = "mp3/muzik.mp3";
	private String title;
	private String author;
	private String album;
	private String year;
	private int style;
	private String comment;
	
	
		
	// constructeurs
	public Mp3TagManager () {	
	}
	
		
	public Mp3TagManager(String path) {	
		this.path = path;
	} 


		
	//getters and setters
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getAlbum() {
		return album;
	}


	public void setAlbum(String album) {
		this.album = album;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public int getStyle() {
		return style;
	}


	public void setStyle(int style) {
		this.style = style;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}

	
	public void writeTags() throws Mp3TagException {
		
	}
	
	
	public void readTags() throws IOException {
		
	}
	
	public void read () { // il faut écrire cette fonction et l'appeler depuis le constructeur
		
	}
	
} // class
