package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_person_PreparedStatement {

	public static final String SQL_SELECT = "SELECT * FROM person";
	public static final String SQL_INSERT = "INSERT INTO person (lastName, firstName, age) VALUES (?,?,?)";
	public static final String SQL_UPDATE = "UPDATE person SET age=? WHERE `id-person`=?";
	public static final String SQL_DELETE = "DELETE from person WHERE `id-person`=?";


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

			System.out.println("Voici les données initiales:");
			System.out.println();

			while (rs.next()) {
				String lastName = rs.getString("lastName");
				String firstName = rs.getString("firstName");
				int age = rs.getInt("age");
				long id_person = rs.getLong("id-person");


				System.out.println("Last Name is : " + lastName + " | First Name is : " + firstName + " | age is : " + age + " | id is : " + id_person);

			}
			
			// SQL_INSERT
		/*	
			ps = cnx.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, "Bowie");
			ps.setString(2, "David");
			ps.setInt(3, 78);
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
			System.out.println("Voici les données après l'insertion: ");
			System.out.println();
			

			while (rs.next()) {
				String lastName = rs.getString("lastName");
				String firstName = rs.getString("firstName");
				int age = rs.getInt("age");
				long id_person = rs.getLong("id-person");



				System.out.println("Last Name is : " + lastName + " | First Name is : " + firstName + " | age is : " + age + " | id is : " + id_person);
		*/	
				
			// SQL_UPDATE
				
		/*	ps = cnx.prepareStatement(SQL_UPDATE);
			ps.setInt(1, 18);
			ps.setLong(2, 2);
			ps.execute();
		
			
		    ps = cnx.prepareStatement(SQL_SELECT);

			rs = ps.executeQuery();

			System.out.println();
			System.out.println("Voici les données après la mise à jour: ");
			System.out.println();

			while (rs.next()) {
				String lastName = rs.getString("lastName");
				String firstName = rs.getString("firstName");
				int age = rs.getInt("age");
				long id_person = rs.getLong("id-person");

				System.out.println("Last Name is : " + lastName + " | First Name is : " + firstName + " | age is : " + age + " | id is : " + id_person);
	
			}	*/
			
			
			// SQL_DELETE
			
			ps = cnx.prepareStatement(SQL_DELETE);
			ps.setLong(1, 6);
			ps.execute();
			
			ps = cnx.prepareStatement(SQL_SELECT);
			
			rs = ps.executeQuery();
			
			System.out.println();
			System.out.println("Voici les données après une suppréssion : ");
			System.out.println();
			
			while (rs.next()) {
				String lastName = rs.getString("lastName");
				String firstName = rs.getString("firstName");
				int age = rs.getInt("age");
				long id_person = rs.getLong("id-person");
				
				System.out.println("Last Name is : " + lastName + " | First Name is : " + firstName + " | age is : " + age + " | id is : " + id_person);
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
