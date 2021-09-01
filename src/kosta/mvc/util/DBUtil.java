package kosta.mvc.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	private static Properties proFile = new Properties();
	
	/**
	 * DB 로드
	 */
	static {
		try {
			proFile.load(new FileInputStream("resources/dbInfo.properties"));
			proFile.load(new FileInputStream("resources/dbQuery.properties"));
			Class.forName(proFile.getProperty("driverName"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Properties getProFile() {
		return proFile;
	}
	
	/**
	 * DB 연결
	 * @return Connection
	 */
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(proFile.getProperty("url"), proFile.getProperty("userName"), proFile.getProperty("userPass"));
	}
	
	/**
	 * DB 자원 닫기
	 */
	public static void dbClose(Connection con, PreparedStatement st, ResultSet rs) {
		try {
			if(con != null) con.close();
			if(st != null) st.close();
			if(rs != null) rs.close();			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void dbClose(Connection con, PreparedStatement st) {
		try {
			if(con != null) con.close();
			if(st != null) st.close();
						
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
