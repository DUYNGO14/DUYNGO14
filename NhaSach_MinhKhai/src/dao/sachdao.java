package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.sachbean;

public class sachdao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public ArrayList<sachbean> getsach() throws Exception {
		ArrayList<sachbean> ds = new ArrayList<sachbean>();
		String query = "select * from sach";
		try {
			conn = new KetNoi().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				String masach = rs.getString("masach");
				String tensach = rs.getString("tensach");
				String tacgia = rs.getString("tacgia");
				Long soluong = rs.getLong("soluong");
				Long gia = rs.getLong("gia");
				String anh = rs.getString("anh");
				String maloai = rs.getString("maloai");
				ds.add(new sachbean(masach, tensach, tacgia, soluong, gia, anh, maloai));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rs.close();
		conn.close();
		return ds;
	}
	
	public ArrayList<sachbean> getsach1(int index) throws Exception {
		ArrayList<sachbean> ds = new ArrayList<sachbean>();
		String query = "select * from sach order by masach offset ? rows fetch next 15 rows only";
		try {
			conn = new KetNoi().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, (index-1)*15);
			rs = ps.executeQuery();
			while (rs.next()) {
				String masach = rs.getString("masach");
				String tensach = rs.getString("tensach");
				String tacgia = rs.getString("tacgia");
				Long soluong = rs.getLong("soluong");
				Long gia = rs.getLong("gia");
				String anh = rs.getString("anh");
				String maloai = rs.getString("maloai");
				ds.add(new sachbean(masach, tensach, tacgia, soluong, gia, anh, maloai));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rs.close();
		conn.close();
		return ds;
	}
	public ArrayList<sachbean> getmasach(String ms) throws Exception {
		ArrayList<sachbean> ds = new ArrayList<sachbean>();
		String query = "select * from sach order by masach offset ? rows fetch next 15 rows only";
		try {
			conn = new KetNoi().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, ms);
			rs = ps.executeQuery();
			while (rs.next()) {
				String masach = rs.getString("masach");
				String tensach = rs.getString("tensach");
				String tacgia = rs.getString("tacgia");
				Long soluong = rs.getLong("soluong");
				Long gia = rs.getLong("gia");
				String anh = rs.getString("anh");
				String maloai = rs.getString("maloai");
				ds.add(new sachbean(masach, tensach, tacgia, soluong, gia, anh, maloai));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rs.close();
		conn.close();
		return ds;
	}
	public ArrayList<sachbean> getMaloai(String maloai1,int index) throws Exception {
		ArrayList<sachbean> ds = new ArrayList<sachbean>();
		String query = "select * from sach where maloai=? order by masach offset ? rows fetch next 15 rows only ";
		try {
			conn = new KetNoi().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, maloai1);
			ps.setInt(2, (index-1)*15);
			rs = ps.executeQuery();
			while (rs.next()) {
				String masach = rs.getString("masach");
				String tensach = rs.getString("tensach");
				String tacgia = rs.getString("tacgia");
				Long soluong = rs.getLong("soluong");
				Long gia = rs.getLong("gia");
				String anh = rs.getString("anh");
				String maloai = rs.getString("maloai");
				ds.add(new sachbean(masach, tensach, tacgia, soluong, gia, anh, maloai));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rs.close();
		conn.close();
		return ds;
	}
	public int Count() throws Exception{
		String query = "select count(*) from sach";
		try {
			conn = new KetNoi().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rs.close();
		conn.close();
		return 0;
	}
	public int Countml(String maloai) throws Exception{
		String query = "select count(*) from sach where maloai=?";
		try {
			conn = new KetNoi().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, maloai);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rs.close();
		conn.close();
		return 0;
	}
	public ArrayList<sachbean> CheckMasach(String ms) throws Exception {
		ArrayList<sachbean> ds = new ArrayList<sachbean>();
		String query = "select * from sach where masach=?";
		try {
			conn = new KetNoi().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, ms);
			rs = ps.executeQuery();
			while (rs.next()) {
				String masach = rs.getString("masach");
				String tensach = rs.getString("tensach");
				String tacgia = rs.getString("tacgia");
				Long soluong = rs.getLong("soluong");
				Long gia = rs.getLong("gia");
				String anh = rs.getString("anh");
				String maloai = rs.getString("maloai");
				ds.add(new sachbean(masach, tensach, tacgia, soluong, gia, anh, maloai));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rs.close();
		conn.close();
		return ds;
	}
	public static void main(String[] args) {
		try {
			sachdao sdao = new sachdao();
			ArrayList<sachbean> ds = sdao.CheckMasach("b3");
			for (sachbean s : ds) {
				System.out.println(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
