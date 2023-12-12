package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.dienThoaiBean;

public class dienThoaiDao {
	public ArrayList<dienThoaiBean> getdienthoai() throws Exception {
		ArrayList<dienThoaiBean> ds = new ArrayList<dienThoaiBean>();
		String query = "select * from dienthoai";
		try {
			Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String madt = rs.getString("madt");
				String tendt = rs.getString("tendt");
				Long gia = rs.getLong("gia");
				Double kichthuocman=rs.getDouble("kichthuocman");
				Long pin = rs.getLong("pin");
				String maloai = rs.getString("maloai");
				String chip = rs.getString("chip");
				Long ram = rs.getLong("ram");
				Long dungluong = rs.getLong("dungluong");
				String anh = rs.getString("anh");
				Long soluong = rs.getLong("soluong");
				
				ds.add(new dienThoaiBean(madt, tendt, gia, kichthuocman, pin, maloai, chip, ram, dungluong, anh, soluong));
			}
			
			rs.close();
			conn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<dienThoaiBean> getdienthoai1(int index) throws Exception{
		try {
			ArrayList<dienThoaiBean> ds = new ArrayList<dienThoaiBean>();
			String query="select * from dienthoai order by madt offset ? rows fetch next 16 rows only";
			Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, (index-1)*16);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String madt = rs.getString("madt");
				String tendt = rs.getString("tendt");
				Long gia = rs.getLong("gia");
				Double kichthuocman=rs.getDouble("kichthuocman");
				Long pin = rs.getLong("pin");
				String maloai = rs.getString("maloai");
				String chip = rs.getString("chip");
				Long ram = rs.getLong("ram");
				Long dungluong = rs.getLong("dungluong");
				String anh = rs.getString("anh");
				Long soluong = rs.getLong("soluong");
				ds.add(new dienThoaiBean(madt, tendt, gia, kichthuocman, pin, maloai, chip, ram, dungluong, anh, soluong));
			}
			rs.close();
			conn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<dienThoaiBean> getdienthoai2(int index) throws Exception{
		try {
			ArrayList<dienThoaiBean> ds = new ArrayList<dienThoaiBean>();
			String query="select * from dienthoai order by madt offset ? rows fetch next 8 rows only";
			Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, (index-1)*4);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String madt = rs.getString("madt");
				String tendt = rs.getString("tendt");
				Long gia = rs.getLong("gia");
				Double kichthuocman=rs.getDouble("kichthuocman");
				Long pin = rs.getLong("pin");
				String maloai = rs.getString("maloai");
				String chip = rs.getString("chip");
				Long ram = rs.getLong("ram");
				Long dungluong = rs.getLong("dungluong");
				String anh = rs.getString("anh");
				Long soluong = rs.getLong("soluong");
				ds.add(new dienThoaiBean(madt, tendt, gia, kichthuocman, pin, maloai, chip, ram, dungluong, anh, soluong));
			}
			rs.close();
			conn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public dienThoaiBean TimdienthoaiMa(String madt1) throws Exception{
		try {
			dienThoaiBean ds = null;
			String query="select * from dienthoai where madt=?";
			Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, madt1);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				String madt = rs.getString("madt");
				String tendt = rs.getString("tendt");
				Long gia = rs.getLong("gia");
				Double kichthuocman=rs.getDouble("kichthuocman");
				Long pin = rs.getLong("pin");
				String maloai = rs.getString("maloai");
				String chip = rs.getString("chip");
				Long ram = rs.getLong("ram");
				Long dungluong = rs.getLong("dungluong");
				String anh = rs.getString("anh");
				Long soluong = rs.getLong("soluong");
				ds=new  dienThoaiBean(madt, tendt, gia, kichthuocman, pin, maloai, chip, ram, dungluong, anh, soluong);
			}
			rs.close();
			conn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<dienThoaiBean> getMaLoai(String maloai1,int index) throws Exception{
		try {
			ArrayList<dienThoaiBean> ds = new ArrayList<dienThoaiBean>();
			String query="select * from dienthoai where maloai=? order by madt offset ? rows fetch next 16 rows only";
			Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, maloai1);
			ps.setInt(2, (index-1)*16);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String madt = rs.getString("madt");
				String tendt = rs.getString("tendt");
				Long gia = rs.getLong("gia");
				Double kichthuocman=rs.getDouble("kichthuocman");
				Long pin = rs.getLong("pin");
				String maloai = rs.getString("maloai");
				String chip = rs.getString("chip");
				Long ram = rs.getLong("ram");
				Long dungluong = rs.getLong("dungluong");
				String anh = rs.getString("anh");
				Long soluong = rs.getLong("soluong");
				ds.add(new dienThoaiBean(madt, tendt, gia, kichthuocman, pin, maloai, chip, ram, dungluong, anh, soluong));
			}
			rs.close();
			conn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public int Count() throws Exception{
		String query = "select count(*) from dienthoai";
		try {
			Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	public int Countml(String maloai) throws Exception{
		String query = "select count(*) from dienthoai where maloai=?";
		try {
			Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, maloai);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	public ArrayList<dienThoaiBean> getTenDienThoai(String tendt1,int index) throws Exception{
		try {
			ArrayList<dienThoaiBean> ds = new ArrayList<dienThoaiBean>();
			String query="  select * from dienthoai where tendt like ? order by madt offset ? rows fetch next 16 rows only";
			Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, "%"+tendt1+"%");
			/* ps.setString(2, "%"+tendt1+"%"); */
			ps.setInt(2, (index-1)*16);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String madt = rs.getString("madt");
				String tendt = rs.getString("tendt");
				Long gia = rs.getLong("gia");
				Double kichthuocman=rs.getDouble("kichthuocman");
				Long pin = rs.getLong("pin");
				String maloai = rs.getString("maloai");
				String chip = rs.getString("chip");
				Long ram = rs.getLong("ram");
				Long dungluong = rs.getLong("dungluong");
				String anh = rs.getString("anh");
				Long soluong = rs.getLong("soluong");
				ds.add(new dienThoaiBean(madt, tendt, gia, kichthuocman, pin, maloai, chip, ram, dungluong, anh, soluong));
			}
			rs.close();
			conn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public int CountTimkiem(String tendt1) throws Exception{
		try {
			ArrayList<dienThoaiBean> ds = new ArrayList<dienThoaiBean>();
			String query="  select count(*) from dienthoai where tendt like ? ";
			Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, "%"+tendt1+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public void insertdienthoai(String madt, String tendt, Long gia, Double kichthuocman, Long pin, String maloai, String chip,
			Long ram, Long dungluong, String anh, Long soluong)throws Exception{
		String query="insert into dienthoai(madt,tendt,gia,kichthuocman,pin,maloai,chip,ram,dungluong,anh,soluong) values(?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn= new KetNoi().getConnection();
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, madt);
		ps.setString(2, tendt);
		ps.setLong(3,gia);
		ps.setDouble(4, kichthuocman);
		ps.setLong(5, pin);
		ps.setString(6, maloai);
		ps.setString(7, chip);
		ps.setLong(8, ram);
		ps.setLong(9, dungluong);
		ps.setString(10, anh);
		ps.setLong(11,soluong);
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
	public void updateSoluong(String madt,long soluongnew) throws Exception{
		String query="update dienthoai set soluong=? where madt=?";
		Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setLong(1, soluongnew);
        ps.setString(2, madt);
        ps.executeUpdate();
        ps.close();
        conn.close();
	}
	public void deleteDienThoai(String madt)throws Exception{
		String query="delete from dienthoai where madt=?";
		Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, madt);
        ps.executeUpdate();
        ps.close();
        conn.close();
	}
	public static void main(String[] args) {
		try {
			dienThoaiDao dtdao = new dienThoaiDao();
			dtdao.deleteDienThoai("a");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
