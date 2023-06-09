package jdbconnectivity;

import java.sql.Connection;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.SQLException;

public class CommonJdbc {
	
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		
	}
	
	public static Connection getJdbcConnection() throws SQLException{
		String config="src\\main\\java\\properties\\application.properties";
		HikariConfig hikariConfig = new HikariConfig(config);
		try (HikariDataSource dataSource = new HikariDataSource(hikariConfig)) {
			return dataSource.getConnection();
		}
	}
/*
	private static Connection physicalConnection() {
		Connection connection=null;
		FileReader fr=null;
		Properties properties=null;
		
		
		try {
			fr=new FileReader("F:\\Eclipse java\\JDBCCRUDAPPwebbased\\src\\main\\java\\properties\\application.properties");
			properties=new Properties();
			properties.load(fr);
			connection=DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("userName"),properties.getProperty("password"));
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(FileNotFoundException fe) {
			fe.printStackTrace();
		}
		catch(IOException ie) {
			ie.printStackTrace();
		}
		return connection;
	}
	*/
	public static void closeResources(Connection connection,java.sql.Statement stmt,java.util.Scanner scanner) throws SQLException{
		try {
			if(connection!=null)
				connection.close();
			if(stmt!=null)
				stmt.close();
			if(scanner!=null)
				scanner.close();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
	}
}
