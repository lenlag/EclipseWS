package service;

import java.util.List;

import javax.servlet.http.HttpSession;

import entity.ListeNom;
import entity.Nom;

public class ListService {
	
	public static final String KEY = "NAME";
	
	public void add(HttpSession session, Nom nom) {
		ListeNom listeNom = (ListeNom) session.getAttribute(KEY);
		if (listeNom == null) {
			listeNom = new ListeNom();
			session.setAttribute(KEY, listeNom);
		}
		listeNom.add(nom);
	}
	
	public void delete (HttpSession session, int index) {
		ListeNom listeNom = (ListeNom) session.getAttribute(KEY);
		listeNom.delete(index);
	}
	
	public List<Nom>list(HttpSession session) {
		ListeNom listeNom = (ListeNom) session.getAttribute(KEY);
		if (listeNom == null) {
			listeNom = new ListeNom();
			session.setAttribute(KEY, listeNom);
		}
		return listeNom.getNameList();
		
	}
	
}
