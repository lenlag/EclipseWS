package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JDBC2_specie_PreparedStatement {
	
public static final String SQL_SELECT = "SELECT * FROM specie";
public static final String SQL_INSERT = "INSERT INTO SPECIE (COMMON_NAME,LATIN_NAME) values (?,?)";
public static final String SQL_UPDATE = "UPDATE specie SET common_name=? WHERE id_specie=?";
public static final String SQL_DELETE = "DELETE FROM specie WHERE id_specie=?";


	public static void main(String[] args) {
		
		
		Connection cnx = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // install driver
			cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bestioles", "root", "root"); // ouvrir connexion
			PreparedStatement st = cnx.prepareStatement(SQL_SELECT); 
			
		/*	ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String common = rs.getString("common_name");
				long id = rs.getLong("id_specie");
				String latin = rs.getString("latin_name");
				System.out.println("Common_name = " + common + " Id = " + id + " Latin name = "+ latin);
			} */
			
				
			
		/*	st = cnx.prepareStatement(SQL_INSERT,Statement.RETURN_GENERATED_KEYS);// pour recup l'id!! desormais au niveau de PreparedStatement
			st.setString(1, "Perroquet");
			st.setString(2, "Psittacus");
			st.execute(); 
			
			ResultSet rs = st.getGeneratedKeys();
			while (rs.next()) {
				long id = rs.getLong("GENERATED_KEY");
				System.out.println("new key is " + id);
			}
						
			st = cnx.prepareStatement(SQL_UPDATE);
			st.setString(1, "Chouchoute");
			st.setLong(2, 10);	
			
			st.execute();
			
			st = cnx.prepareStatement(SQL_SELECT); 
			rs = st.executeQuery();
			while (rs.next()) {
				String common = rs.getString("common_name");
				long id = rs.getLong("id_specie");
				String latin = rs.getString("latin_name");
				System.out.println("Common_name = " + common + " Id = " + id + " Latin name = "+ latin);
			}	*/
				
			st = cnx.prepareStatement(SQL_DELETE);
			st.setInt(1, 13);
			st.execute();
			
			st = cnx.prepareStatement(SQL_SELECT); 
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String common = rs.getString("common_name");
				long id = rs.getLong("id_specie");
				String latin = rs.getString("latin_name");
				System.out.println("Common_name = " + common + " Id = " + id + " Latin name = "+ latin);
			}
			
			
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
