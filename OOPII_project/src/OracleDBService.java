
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleDBService {

		static Connection db_con_obj = null;
		static PreparedStatement db_prep_obj = null;
		
		static void makeJDBCConnection() {
			 
			try {//We check that the DB Driver is available in our project.		
				Class.forName("com.mysql.jdbc.Driver"); //This code line is to check that JDBC driver is available. Or else it will throw an exception. Check it with 2. 
				System.out.println("Congrats - Seems your MySQL JDBC Driver Registered!"); 
			} catch (ClassNotFoundException e) {
				System.out.println("Sorry, couldn't found JDBC driver. Make sure you have added JDBC Maven Dependency Correctly");
				e.printStackTrace();
				return;
			}
	 
			try {
				// DriverManager: The basic service for managing a set of JDBC drivers.	 //We connect to a DBMS.
				db_con_obj = DriverManager.getConnection("jdbc:oracle:thin:@oracle12c.hua.gr:1521:orcl","it21937", "Q1xI$#rk7");// Returns a connection to the URL.
				//Attempts to establish a connection to the given database URL. The DriverManager attempts to select an appropriate driver from the set of registered JDBC drivers.
				if (db_con_obj != null) { 
					System.out.println("Connection Successful! Enjoy. Now it's time to CRUD data. ");
					
				} else {
					System.out.println("Failed to make connection!");
				}
			} catch (SQLException e) {
				System.out.println("MySQL Connection Failed!");
				e.printStackTrace();
				return;
			}
			
	 
	}
		
		static void ReadData() throws SQLException {
			db_prep_obj = db_con_obj.prepareStatement("select * from city");
			ResultSet  rs = db_prep_obj.executeQuery();

		    while (rs.next()){
		        String cityName = rs.getString("cityName");
		        int criterion1 = rs.getInt("criterion1");
		        int criterion2 = rs.getInt("criterion2");
		        int criterion3 = rs.getInt("criterion3");
		        int criterion4 = rs.getInt("criterion4");
		        int criterion5 = rs.getInt("criterion5");
		        int criterion6 = rs.getInt("criterion6");
		        int criterion7 = rs.getInt("criterion7");
		        int criterion8 = rs.getInt("criterion8");
		        int criterion9 = rs.getInt("criterion9");
		        int criterion10 = rs.getInt("criterion10");
		        double latitude = rs.getDouble("latitude");
		        double longitude = rs.getDouble("longitude");
		        System.out.println("\nCity: "+ cityName +"\ncriterion1:"+ criterion1 +"\ncriterion2:"+criterion2+"\ncriterion3:"+criterion3+"\ncriterion4:"+criterion4+"\ncriterion5:"+criterion5+"\ncriterion6:"+criterion6+"\ncriterion7:"+criterion7+"\ncriterion8:"+criterion8+"\ncriterion9:"+criterion9+"\ncriterion10:"+criterion10+"\nlatitude:"+latitude+"\nlongitude:"+longitude);
		       
		        
		        
		    }
		}
		
		static void addDataToDB(String City,int[] cityTermsVector, double[] cityGeodesicVector){
			 
			try {
				String insertQueryStatement = "INSERT  INTO  City  VALUES  (?,?,?,?,?,?,?,?,?,?,?,?,?)";
				
				//Connection db_con_obj = null;
				//PreparedStatement db_prep_obj = null;
				
				
				
				db_prep_obj = db_con_obj.prepareStatement(insertQueryStatement);
				db_prep_obj.setString(1, City);
				db_prep_obj.setInt(2, cityTermsVector[0]);
				db_prep_obj.setInt(3, cityTermsVector[1]);
				db_prep_obj.setInt(4, cityTermsVector[2]);
				db_prep_obj.setInt(5, cityTermsVector[3]);
				db_prep_obj.setInt(6, cityTermsVector[4]);
				db_prep_obj.setInt(7, cityTermsVector[5]);
				db_prep_obj.setInt(8, cityTermsVector[6]);
				db_prep_obj.setInt(9, cityTermsVector[7]);
				db_prep_obj.setInt(10, cityTermsVector[8]);
				db_prep_obj.setInt(11, cityTermsVector[9]);
				db_prep_obj.setDouble(12, cityGeodesicVector[0]);
				db_prep_obj.setDouble(13, cityGeodesicVector[1]);
				
				
				// execute insert SQL statement Executes the SQL statement in this PreparedStatement object, which must be an SQL Data Manipulation Language (DML) statement
				int numRowChanged = db_prep_obj.executeUpdate(); //either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing
				System.out.println("Rows "+numRowChanged+" changed.");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
			
	}
	

