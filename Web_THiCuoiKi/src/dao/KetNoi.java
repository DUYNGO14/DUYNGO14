package dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class KetNoi {
	public void ketnoi () throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://" + serverName + ":1433;databaseName=" + nameDatabase + "; user=" + useId
				+ "; password=" + passWord;
		cn = DriverManager.getConnection(url);
		System.out.println("Kết nối oke");
	}
	public Connection getConnection() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://" + serverName + ":1433;databaseName=" + nameDatabase + "; user=" + useId
				+ "; password=" + passWord;
		cn = DriverManager.getConnection(url);
		return cn;
	}

	public static Connection cn;
	private final String serverName = "NGODUY\\SQLEXPRESS";
	private final String nameDatabase = "ShopDienThoai";
	private final String useId = "sa";
	private final String passWord = "123";
	public static void main(String[] args) {
		try {
			System.out.println(new KetNoi().getConnection());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
