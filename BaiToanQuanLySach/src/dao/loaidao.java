package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import bean.loaibean;

public class loaidao {
	public ArrayList<loaibean> getloai() throws Exception{
		 //Tao ra mang luu all don vi
		     ArrayList<loaibean> ds= new ArrayList<loaibean>();
		    //B1: Ket noi vao csdl
		        KetNoi kn= new KetNoi();
		        kn.ketnoi();
		        //B2: tao cau lenh sql
		        String sql="select * from loai";
		        //b3: Tao cau lenh PreparedStatement
		        PreparedStatement cmd=kn.cn.prepareStatement(sql);
		        //b4: thuc hien cau lenh
		        ResultSet rs= cmd.executeQuery();
		        //b5: Duyet rs
		        while(rs.next()) {
		            String maloai=rs.getString("maloai");
		            String tenloai=rs.getString("tenloai");
		            ds.add(new loaibean(maloai, tenloai));
		        }
		        rs.close();
		        kn.cn.close();
		        cmd.close();
		     return ds;
		 }
}
