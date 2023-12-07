package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class KetNoi {
	public static Connection cn;
	public void ketnoi() throws Exception {
		//b1. xác định HE QTCSDL
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		System.out.println("Da xac dinh he QTCSDL");
		String url="jdbc:sqlserver://NGODUY\\SQLEXPRESS:1433;databaseName=QlSach; user=sa; password=123";
		cn=DriverManager.getConnection(url);
//		System.out.println("Da ket noi oke vs csdl nhanvien");
	}
}
