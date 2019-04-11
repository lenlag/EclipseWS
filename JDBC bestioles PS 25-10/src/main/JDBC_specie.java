package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class JDBC_specie {

	public static void main(String[] args) {
		Connection cnx = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // install driver
			cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bestioles", "root", "root"); // ouvrir connexion
			Statement st = cnx.createStatement(); // recup de statement pour exec. les requetes SQL
			//st.executeQuery("SELECT * FROM SPECIE"); // que pour SELECT
			ResultSet rs = st.executeQuery("SELECT * FROM SPECIE");
			while (rs.next()) {
				String common = rs.getString("common_name");
				long id = rs.getLong("id_specie");
				String latin = rs.getString("latin_name");
				System.out.println("Common_name = " + common + " Id = " + id + " Latin name = "+ latin);
			}
			
			
			st.execute("INSERT INTO SPECIE (COMMON_NAME,LATIN_NAME) values ('Fennec','Vulpes zerda')", Statement.RETURN_GENERATED_KEYS); 
			// pour recup l'id de l'enreg nouvellement créé
			rs = st.getGeneratedKeys();
			while (rs.next()) {
				long id = rs.getLong("GENERATED_KEY");
				System.out.println("new key for Fennec is " + id);
			}
			
			
			/*st.execute("UPDATE SPECIE SET latin_name='LOUP SAUVAGE' WHERE common_name='LOUP'");
			 // nom de champs latin_name sans rien, nom de valeur 'LOUP'
					
					rs = st.executeQuery("SELECT * FROM SPECIE");
					while (rs.next()) {
						String common = rs.getString("common_name");
						long id = rs.getLong("id_specie");
						String latin = rs.getString("latin_name");
						System.out.println("Common_name = " + common + " Id = " + id + " Latin name = "+ latin);
					}*/
			
			/*st.execute("DELETE FROM SPECIE WHERE common_name='LOUP'");
			rs = st.executeQuery("SELECT * FROM SPECIE");
			while (rs.next()) {
				String common = rs.getString("common_name");
				long id = rs.getLong("id_specie");
				String latin = rs.getString("latin_name");
				System.out.println("Common_name = " + common + " Id = " + id + " Latin name = "+ latin);
			}*/
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cnx.close(); // toujours fermer la connexion
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				


		
		
	}

}
