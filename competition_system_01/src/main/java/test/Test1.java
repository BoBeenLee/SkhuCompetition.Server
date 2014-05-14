package test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;


public class Test1 {
	
	// DB Test - 1
	@Test
	public void test1() throws SQLException{
		Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1q2w3e");
		Statement stmt = connection.createStatement();
		stmt.executeUpdate("CREATE TABLE a (id int not null primary key, value varchar(20))");
		stmt.close();
		connection.close();
	}
	
	// File Test - 1
	@Test
	public void test2() throws SQLException{
		String PROPERTIES_FILE = "test/TestProperties.properties";
		String UPLOAD_PATH = null;
		
		try {
			InputStream inputstream = getClass().getClassLoader()
					.getResourceAsStream(PROPERTIES_FILE);
			Properties properties = new Properties();
			properties.load(inputstream);
			UPLOAD_PATH = properties.getProperty("UPLOAD_PATH");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(UPLOAD_PATH);
	}
	
	// Email Test - 1
	@Test
	public void test3() throws SQLException{
		
	}
}
