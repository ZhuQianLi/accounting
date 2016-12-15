package cn.edu.zust.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtil {
	public static DataSource dataSource;
	static{
		dataSource = new ComboPooledDataSource("mysql");
	}
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static DataSource getDataSource(){
		return dataSource;
	}
	
}
