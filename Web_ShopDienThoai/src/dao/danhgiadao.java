package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.danhgiabean;
import bean.danhsachdanhgiabean;


public class danhgiadao {
	public long getMamadanhgia() throws Exception{
		 try {
        	String query = "select max(madanhgia) from danhgiasanpham";
        	Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
        	PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	return rs.getLong(1);
            }
            conn.close();
            rs.close();
        } catch (Exception e) {
        	e.printStackTrace();
        }
		 return 0;
	}
	public void insertdanhgia(String noidung,String madt,long makh) throws Exception{
		try {
			String query = "insert into danhgiasanpham(madanhgia,noidung,madt,makh) values(?,?,?,?)";
        	Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
        	PreparedStatement ps = conn.prepareStatement(query);
        	long madg = getMamadanhgia();
        	ps.setLong(1, madg+1);
        	ps.setString(2, noidung);
        	ps.setString(3, madt);
        	ps.setLong(4, makh);
        	ps.executeUpdate();
        	conn.close();
        	ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<danhgiabean> getdanhgia() throws Exception{
		ArrayList<danhgiabean> ds = new ArrayList<danhgiabean>();
		try {
			String query="select * from danhgiasanpham";
			Connection conn = new KetNoi().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				long madanhgia = rs.getLong(1);
				String noidung = rs.getString(2);
				String madt = rs.getString(3);
				long makh = rs.getLong(4);
				ds.add(new danhgiabean(madanhgia, noidung, madt, makh));
			}
			conn.close();
			ps.close();
			rs.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public ArrayList<danhgiabean> getdanhgiamadt(String madt1) throws Exception{
		ArrayList<danhgiabean> ds = new ArrayList<danhgiabean>();
		try {
			String query="select * from danhgiasanpham where madt=?";
			Connection conn = new KetNoi().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, madt1);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				long madanhgia = rs.getLong(1);
				String noidung = rs.getString(2);
				String madt = rs.getString(3);
				long makh = rs.getLong(4);
				ds.add(new danhgiabean(madanhgia, noidung, madt, makh));
			}
			conn.close();
			ps.close();
			rs.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<danhsachdanhgiabean> danhsachdanhgia() throws Exception{
		ArrayList<danhsachdanhgiabean> dsdanhgia = new ArrayList<danhsachdanhgiabean>();
		try {
			String query="select * from View_danhgiasanpham";
			Connection conn = new KetNoi().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String tendt = rs.getString(1);
				String tenkh = rs.getString(2);
				String noidung = rs.getString(3);
				dsdanhgia.add(new danhsachdanhgiabean(tendt, tenkh, noidung));
			}
			conn.close();
			ps.close();
			rs.close();
			return dsdanhgia;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		try {
			danhgiadao dgdao = new danhgiadao();
			ArrayList<danhsachdanhgiabean> dsdanhgia = dgdao.danhsachdanhgia();
			for (danhsachdanhgiabean d : dsdanhgia) {
				System.out.println(d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
