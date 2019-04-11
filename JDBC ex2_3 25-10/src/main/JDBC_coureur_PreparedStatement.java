package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_coureur_PreparedStatement {

	public static final String SQL_SELECT = "SELECT *, NomEquipe, NomPays FROM coureur, equipe, pays "
			+ "WHERE coureur.CodeEquipe=equipe.CodeEquipe AND coureur.CodePays=pays.CodePays "
			+ "ORDER BY NumeroCoureur ASC";
	public static final String SQL_INSERT = "INSERT INTO coureur (NomCoureur, CodeEquipe, CodePays) VALUES (?,?,?)";
	public static final String SQL_UPDATE = "UPDATE coureur SET NomCoureur=? WHERE NumeroCoureur=?";
	public static final String SQL_DELETE = "DELETE FROM coureur WHERE NumeroCoureur=?";

	public static void main(String[] args) throws Exception {

		Connection cnx = null;
		String url = "jdbc:mysql://localhost:3306/exercice2_3";
		String user = "root";
		String password="root";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnx = DriverManager.getConnection(url, user, password);

			// SQL_SELECT + affichage des FK associés aux 2 autres tableaux 
			
			PreparedStatement ps = cnx.prepareStatement(SQL_SELECT);

			ResultSet rs = ps.executeQuery();

			System.out.println("Données initiales du tab : ");
			System.out.println();

			while (rs.next()) {
				long nCoureur = rs.getLong("NumeroCoureur");
				String nomCoureur = rs.getString("NomCoureur");
				long codeEquipe = rs.getLong("CodeEquipe");
				long codePays = rs.getLong("CodePays");
				String NomEquipe = rs.getString("NomEquipe");
				String NomPays = rs.getString("NomPays");

				System.out.println("Numero du coureur : " + nCoureur + " | Nom du coureur : " 
						+ nomCoureur + " | Code de'équipe : " + codeEquipe + " | Nom d'équipe : " 
						+ NomEquipe + " | Code pays : " + codePays + " | Nom du pays : " + NomPays);

			}
			
			// SQL_INSERT + affichage
			
		/*	ps = cnx.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, "Vasiliy Zaitsev");
			ps.setLong(2, 1);
			ps.setLong(3, 3);
			ps.execute();
			rs = ps.getGeneratedKeys();
			long newId = 0L;
			
			
			System.out.println();
			System.out.println("Données du tab après l'insertion : ");
			System.out.println();
			
			
			while(rs.next()) {
				newId = rs.getLong("GENERATED_KEY");
				System.out.println("new key is : " + newId);
			}
			
			ps = cnx.prepareStatement(SQL_SELECT);
			rs = ps.executeQuery();
			
						
			while (rs.next()) {
				long nCoureur = rs.getLong("NumeroCoureur");
				String nomCoureur = rs.getString("NomCoureur");
				long codeEquipe = rs.getLong("CodeEquipe");
				long codePays = rs.getLong("CodePays");
				String NomEquipe = rs.getString("NomEquipe");
				String NomPays = rs.getString("NomPays");

				System.out.println("Numero du coureur : " + nCoureur + " | Nom du coureur : " 
						+ nomCoureur + " | Code de'équipe : " + codeEquipe + " | Nom d'équipe : " 
						+ NomEquipe + " | Code pays" + codePays + " | Nom du pays : " + NomPays);

			}
		*/
			// SQL_UPDATE + affichage
			
		/*	ps = cnx.prepareStatement(SQL_UPDATE);
			ps.setString(1, "Ivanov");
			ps.setLong(2, 3);
			ps.execute();
			
			ps = cnx.prepareStatement(SQL_SELECT);
			rs = ps.executeQuery();

			
			System.out.println();
			System.out.println("Données du tab après la mise à jour : ");
			System.out.println();
			
			
			
			while (rs.next()) {
				long nCoureur = rs.getLong("NumeroCoureur");
				String nomCoureur = rs.getString("NomCoureur");
				long codeEquipe = rs.getLong("CodeEquipe");
				long codePays = rs.getLong("CodePays");
				String NomEquipe = rs.getString("NomEquipe");
				String NomPays = rs.getString("NomPays");

				System.out.println("Numero du coureur : " + nCoureur + " | Nom du coureur : " 
						+ nomCoureur + " | Code de'équipe : " + codeEquipe + " | Nom d'équipe : " 
						+ NomEquipe + " | Code pays" + codePays + " | Nom du pays : " + NomPays);
								
			}
		*/
			
			// SQL_DELETE + affich
			
			ps = cnx.prepareStatement(SQL_DELETE);
			ps.setLong(1, 5);
			ps.execute();
			
			
			ps = cnx.prepareStatement(SQL_SELECT);
			rs = ps.executeQuery();
			
			System.out.println();
			System.out.println("Données du tab après la suppréssion : ");
			System.out.println();

			while (rs.next()) {
				long nCoureur = rs.getLong("NumeroCoureur");
				String nomCoureur = rs.getString("NomCoureur");
				long codeEquipe = rs.getLong("CodeEquipe");
				long codePays = rs.getLong("CodePays");
				String NomEquipe = rs.getString("NomEquipe");
				String NomPays = rs.getString("NomPays");

				System.out.println("Numero du coureur : " + nCoureur + " | Nom du coureur : " 
						+ nomCoureur + " | Code de'équipe : " + codeEquipe + " | Nom d'équipe : " 
						+ NomEquipe + " | Code pays : " + codePays + " | Nom du pays : " + NomPays);

			}
			
		} catch (ClassNotFoundException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
