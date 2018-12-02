package helpers;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import context.Usuario;
import log.Log;

public class DBHelper {

	public static Connection conx = null;

	public static void DBConnect() {
		try {
			Class.forName("com.microsoft.sqlserver.SQLServerDriver");
			String dbURL = "jdbc:sqlserver://localhost\\sqlexpress";
			String user = "sa";
			String pass = "root";
			conx = DriverManager.getConnection(dbURL, user, pass);
			DatabaseMetaData ds = (DatabaseMetaData) conx.getMetaData();
			System.out.println(ds.getDriverName());
		} catch (Exception ex) {
			try {
				if (conx != null && !conx.isClosed()) {
					conx.close();
				}
			} catch (Exception e) {
				Log.info(e.getMessage());
			}
		}
	}

	public static void DBClose() {
		try {
			conx.close();
		} catch (Exception ex) {
			Log.info(ex.getMessage());
		}
	}
	
	public static void executeQuery(String query) {
		try {
			PreparedStatement preSt = conx.prepareStatement(query);
			preSt.execute();
			ResultSet rs = preSt.executeQuery();
/*			while (rs.next()) {
			}
*/			
		}catch(Exception ex) {
			
		}
	}
}
