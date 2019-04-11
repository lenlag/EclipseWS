package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_animal_PreparedStatement {

	public static final String SQL_SELECT = "SELECT *,common_name FROM animal,specie WHERE animal.id_specie=specie.id_specie";
	public static final String SQL_INSERT = "INSERT INTO animal (name, sex, `coat-color`, id_specie) VALUES (?,?,?,?)";
	public static final String SQL_UPDATE = "UPDATE animal SET name=? WHERE id_animal=?";
	public static final String SQL_DELETE = "DELETE FROM animal WHERE id_animal=?";


	public static void main(String[] args) {

		Connection cnx = null;
		String url = "jdbc:mysql://localhost:3306/Bestioles";
		String user = "root";
		String password = "root";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnx = DriverManager.getConnection(url, user, password);

			// SQL_SELECT

			PreparedStatement ps = cnx.prepareStatement(SQL_SELECT);

			ResultSet rs = ps.executeQuery();

			System.out.println("Voici les données initiales :");
			System.out.println();

			while(rs.next()) {
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String coat_color = rs.getString("coat-color");
				String id_animal = rs.getString("id_animal");
				String id_specie = rs.getString("id_specie");
				String common_name = rs.getString("common_name");
				System.out.println("Name is : " + name + " | sex is : " + sex + " | coat-color is : " + coat_color + " | id of animal is : " + id_animal + " | id of specie is : " + id_specie +" | common_name = "+common_name);
			}

			// SQL_INSERT + affichage
/*
			ps = cnx.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, "Koshechka");
			ps.setString(2, "f");
			ps.setString(3, "Tricolore");
			ps.setLong(4, 1);
			ps.execute();
			
			rs = ps.getGeneratedKeys();
			long newId = 0L;
			
			while(rs.next()) {
				newId = rs.getLong("GENERATED_KEY");
				System.out.println("new key is : " + newId);
			}

			ps = cnx.prepareStatement(SQL_SELECT);
			rs = ps.executeQuery();

			System.out.println();
			System.out.println("Voici les données après insertion :");
			System.out.println();

			while(rs.next()) {
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String coat_color = rs.getString("coat-color");
				String id_animal = rs.getString("id_animal");
				String id_specie = rs.getString("id_specie");
				String common_name = rs.getString("common_name");
				System.out.println("Name is : " + name + " | sex is : " + sex + " | coat-color is : " + coat_color + " | id of animal is : " + id_animal + " | id of specie is : " + id_specie +" | common_name = "+common_name);
			} */
			
			// SQL_UPDATE + affichage
			
		/*	ps = cnx.prepareStatement(SQL_UPDATE);
			ps.setString(1, "Lapochka");
			ps.setLong(2, 2);
			ps.execute();
			
			
			ps = cnx.prepareStatement(SQL_SELECT);
			rs = ps.executeQuery();
			
			System.out.println();
			System.out.println("Voici les données après une mise à jour :");
			System.out.println();
			
			while(rs.next()) {
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String coat_color = rs.getString("coat-color");
				String id_animal = rs.getString("id_animal");
				String id_specie = rs.getString("id_specie");
				String common_name = rs.getString("common_name");
				System.out.println("Name is : " + name + " | sex is : " + sex + " | coat-color is : " + coat_color + " | id of animal is : " + id_animal + " | id of specie is : " + id_specie +" | common_name = "+common_name);
			}
		*/
			
			// SQL_DELETE + affichage
			
			ps = cnx.prepareStatement(SQL_DELETE);
			ps.setLong(1, 4);
			ps.execute();
			
			ps = cnx.prepareStatement(SQL_SELECT);
			rs = ps.executeQuery();
			
			System.out.println();
			System.out.println("Voici les données après une suppréssion :");
			System.out.println();

			while(rs.next()) {
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String coat_color = rs.getString("coat-color");
				String id_animal = rs.getString("id_animal");
				String id_specie = rs.getString("id_specie");
				String common_name = rs.getString("common_name");
				System.out.println("Name is : " + name + " | sex is : " + sex + " | coat-color is : " + coat_color + " | id of animal is : " + id_animal + " | id of specie is : " + id_specie +" | common_name = "+common_name);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
