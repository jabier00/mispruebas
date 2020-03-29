package Main;

import java.sql.DriverManager;
import java.sql.Connection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;

import java.sql.SQLException;

public class SQL_conexion {

 	//#######################
	// MIEMBROS DE LA CLASE
	//#######################

	private Connection conn = null;
	//Statement stmt = null;
	private ResultSet rs = null;
	private int rowsAffected = 0;

	public PreparedStatement StmtParam;
	public String sQuery;

	/**
	 * Establecemos la query de la conexion
	 * y el statement para parámetros
	 * @param cquerySQL
	 */
	public void setQuery(String cquerySQL) {
		
		this.sQuery = cquerySQL;
		System.out.println(this.sQuery);
		try {
			StmtParam = conn.prepareStatement(this.sQuery);
		} catch (Exception e) {
			System.out.println("Error setQuery no controlado: " + e.toString());
			close_connection();
		}
	}

	//#######################
	// constructor SQL_conexion()
	//#######################
	public SQL_conexion() {
		this.setConnection();  // abrimos la conexión
	}

	//#######################
	// MÉTODOS DE LA CLASE
	//#######################

	/**=====================================================================
	 * método público SQL_conexion conexión al driver mySQL a bbdd localhost 
	 * @return booleano de conexión OK/KO
	 =====================================================================*/
	private boolean setConnection() {
		try {
			// 1. Establecer driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. conectamos a db
			//conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels?useTimezone=true&serverTimezone=UTC","root", "");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root", "");
			return true;
			
		} catch (SQLException eSQL) {
			System.out.println("Error SQL: " + eSQL.toString());
			close_connection();
		} catch (Exception e) {
			System.out.println("Error no controlado: " + e.toString());
			close_connection();
		}
		return false;
	}

	/**====================================================== 
	 * SQL get datos para instrucciones => select from tabla
	 * ======================================================
	 * */
	public ArrayList<Map<String, Object>> getSelectData() {

		ArrayList<Map<String, Object>> queryResult = new ArrayList<Map<String, Object>>();
		try {
			// this.setConnection();
			// this.rs = stmt.executeQuery(this.sQuery);
			// StmtParam = conn.prepareStatement(this.sQuery);
			this.rs = StmtParam.executeQuery();

			ResultSetMetaData rsmd = rs.getMetaData();
			int columncount = rsmd.getColumnCount();

			while (rs.next()) {
				Map<String, Object> row = new HashMap<String, Object>();
				for (int i = 1; i <= columncount; i++) {
					row.put(rsmd.getColumnName(i), rs.getObject(i));
				}
				queryResult.add(row);
			}

		} catch (SQLException eSQL) {
			System.out.println("Error getSelectData SQL: " + eSQL.toString() + "\nError SQL:" + this.sQuery);
		} catch (Exception e) {
			System.out.println("Error getSelectData: " + e);

		} finally {
			close_connection();
		}
		return queryResult;
	}

	/**=============================================================================== 
	 * SQL ejecutar transacciones, procedures, => insert, update, delete, execute, etc.
	 * ===============================================================================
	 * */
	public int executeNonQuery() {
		try {
			//this.setConnection();
			// this.rowsAffected = stmt.executeUpdate(this.sQuery);
			//StmtParam = conn.prepareStatement(this.sQuery);
			this.rowsAffected = StmtParam.executeUpdate();

		} catch (SQLException eSQL) {
			System.out.println("Error executeNonQuery SQL: " + eSQL.toString() + "\nError SQL:" + this.sQuery);
		} catch (Exception e) {
			System.out.println("Error executeNonQuery: " + e);
		} finally {
			close_connection();
		}
		return this.rowsAffected;
	}

	/**====================
	 * Cerrar conexión bbdd
	 ====================*/	
	private void close_connection() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (StmtParam != null) {
				StmtParam.close();
			}

			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {		
			System.out.println("Error close_connection: " + e);
		}
	}   

}
