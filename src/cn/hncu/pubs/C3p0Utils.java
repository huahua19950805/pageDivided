package cn.hncu.pubs;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Utils {
	private static DataSource ds;
	private static ThreadLocal<Connection> t=new ThreadLocal<Connection>();
	
	static{
		try {
			ds=new ComboPooledDataSource();
		} catch (Exception e) {
			throw new RuntimeException("数据库连接池加载失败！");
		}
		
	}
	
	public static DataSource getDataSource(){
		return ds;
	}

	public static Connection getCon() throws SQLException {
		Connection con=t.get();
		if(con==null){
			con=ds.getConnection();
			t.set(con);
		}
		return con;
	}
	
	public static void cleanThreadLocal(){
		t.set(null);
	}
}
