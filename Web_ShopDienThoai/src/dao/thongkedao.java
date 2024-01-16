package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import bean.dienThoaiBean;
import bean.khachhangbean;
import bean.loaiVoucherbean;
import bean.voucherbean;

public class thongkedao {
	public ArrayList<dienThoaiBean> thongKeBanChay(long t) throws Exception{
		try {
			ArrayList<dienThoaiBean> ds = new ArrayList<dienThoaiBean>();
			String query="select madt,tendt,gia,maloai,anh,sum(soluongmua) as slmua from View_Thongkebanchay group by madt,tendt,gia,maloai,anh  order by slmua desc offset 0 rows fetch next ? rows only";
			Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, t);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String madt = rs.getString("madt");
				String tendt = rs.getString("tendt");
				Long gia = rs.getLong("gia");
				String maloai=rs.getString("maloai");
				String anh = rs.getString("anh");
				Long soluong = rs.getLong("slmua");
				ds.add(new dienThoaiBean(madt, tendt, gia,null, null, maloai, null, null, null, anh, soluong));
			}
			rs.close();
			conn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<khachhangbean> thongKeKhachVip(long t) throws Exception{
		ArrayList<khachhangbean> ds = new ArrayList<khachhangbean>();
		String query = "select * from KhachHang inner join ThongKeSoLanMua on KhachHang.makh=ThongKeSoLanMua.makh\r\n"
				+ "  order by soluongmua desc offset 0 rows fetch next ? rows only";
		Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setLong(1, t);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Long makh=rs.getLong("makh");
        	String hoten = rs.getString("hoten");
        	String diachi = rs.getString("diachi");
        	String sdt = rs.getString("sodt");
        	String email = rs.getString("email");
        	String tendn = rs.getString("tendangnhap");
        	String pass = rs.getString("matkhau");
        	ds.add(new khachhangbean(makh, hoten, diachi, sdt, email, tendn, pass));
		}
		conn.close();
		ps.close();
		rs.close();
		return ds;
	}
	public ArrayList<voucherbean> getVoucher() throws Exception{
		ArrayList<voucherbean> ds = new ArrayList<voucherbean>();
		String query = "select * from voucher";
		Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			long mavoucher = rs.getLong("mavoucher");
			String tenvoucher=rs.getString("tenvoucher");
			long giatri = rs.getLong("giatri");
			long soluong = rs.getLong("soluong");
			long maloaivoucher=rs.getLong("maloaivoucher");
			ds.add(new voucherbean(mavoucher, tenvoucher, giatri, soluong,maloaivoucher,0));
		}
		conn.close();
		ps.close();
		rs.close();
		return ds;
	}
	
	public ArrayList<voucherbean> getVoucher1(long maloaivoucher1) throws Exception{
		ArrayList<voucherbean> ds = new ArrayList<voucherbean>();
		String query = "select * from voucher where maloaivoucher=?";
		Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setLong(1, maloaivoucher1);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			long mavoucher = rs.getLong("mavoucher");
			String tenvoucher=rs.getString("tenvoucher");
			long giatri = rs.getLong("giatri");
			long soluong = rs.getLong("soluong");
			long maloaivoucher=rs.getLong("maloaivoucher");
			ds.add(new voucherbean(mavoucher, tenvoucher, giatri, soluong,maloaivoucher,0));
		}
		conn.close();
		ps.close();
		rs.close();
		return ds;
	}
	
	public ArrayList<voucherbean> getVouchermakh(long makh) throws Exception{
		ArrayList<voucherbean> ds = new ArrayList<voucherbean>();
		String query = "select * from View_voucher_khachhang where makh=?";
		Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setLong(1, makh);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			long mavoucher = rs.getLong("mavoucher");
			String tenvoucher=rs.getString("tenvoucher");
			long giatri = rs.getLong("giatri");
			long soluong = 1;
			long maloaivoucher=rs.getLong("maloaivoucher");
			long mavc= rs.getLong("mavc");
			ds.add(new voucherbean(mavoucher, tenvoucher, giatri, soluong,maloaivoucher,mavc));
		}
		conn.close();
		ps.close();
		rs.close();
		return ds;
	}
	public long checkVoucherMavorcher(long mavoucher1) throws Exception{
		long sl=0;
		String query = "select count(*) as sl from voucher_khachang where mavoucher=?";
		Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setLong(1, mavoucher1);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			sl = rs.getLong("sl");
		}
		conn.close();
		ps.close();
		rs.close();
		return sl;
	}
	public void insertvoucher(long mavoucher,long makh)throws Exception{
		String query="insert into voucher_khachang(mavoucher,makh) values(?,?)";
		Connection conn= new KetNoi().getConnection();
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setLong(1,mavoucher);
		ps.setLong(2,makh);
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
	public void insertvoucher1(String tenvoucher,long giatri,long soluong,long maloaivoucher)throws Exception{
		String query="insert into voucher(tenvoucher,giatri,soluong,maloaivoucher) values(?,?,?,?)";
		Connection conn= new KetNoi().getConnection();
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1,tenvoucher);
		ps.setLong(2, giatri);
		ps.setLong(3, soluong);
		ps.setLong(4, maloaivoucher);
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
	public ArrayList<loaiVoucherbean> getloaivoucher() throws Exception{
		ArrayList<loaiVoucherbean> ds = new ArrayList<loaiVoucherbean>();
		String query = "select * from loaiVoucher";
		Connection conn= new KetNoi().getConnection();
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			long maloaivoucher = rs.getLong("maloaivoucher");
			String tenloaivoucher=rs.getString("tenloaivoucher");
			ds.add(new loaiVoucherbean(maloaivoucher, tenloaivoucher));
		}
		conn.close();
		ps.close();
		rs.close();
		return ds;
	}
	public void xoavoucher(long mavc) throws Exception{
		String query = "delete voucher_khachang where mavc=?";
		Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setLong(1, mavc);
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
	public void xoavoucher_khachhang(long mavoucher) throws Exception{
		String query = "delete voucher_khachang where mavoucher=?";
		Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setLong(1, mavoucher);
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
	public void xoavoucher1(long mavoucher) throws Exception{
		String query = "delete voucher where mavoucher=?";
		Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setLong(1, mavoucher);
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
	public int Checkdienthoai(String maloai) throws Exception{
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
	public void xoadienthoaitheomaloai(String maloai) throws Exception{
		String query="delete dienthoai where maloai=?";
		Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, maloai);
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
	public void xoaloaidienthoai(String maloai) throws Exception{
		String query="delete loai where maloai=?";
		Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, maloai);
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
	public void updateloaidienthoai(String newtenloai,String maloai) throws Exception{
		String query="UPDATE loai SET tenloai=?  WHERE maloai=?";
		Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, newtenloai);
		ps.setString(2, maloai);
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
	public void updatedienthoai(String tendt,long gia,double kichthuocman,long pin,String maloai,String chip,long ram,long dungluong,String anh,long soluong,String madt) throws Exception{
		String query="update dienthoai set tendt=?,gia=?,kichthuocman=?,pin=?,maloai=?,chip=?,ram=?,dungluong=?,anh=?,soluong=? where madt=?";
		Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, tendt);
		ps.setLong(2, gia);
		ps.setDouble(3, kichthuocman);
		ps.setLong(4, pin);
		ps.setString(5,maloai);
		ps.setString(6,chip);
		ps.setLong(7, ram);
		ps.setLong(8, dungluong);
		ps.setString(9,anh);
		ps.setLong(10, soluong);
		ps.setString(11,madt);
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
	public String dinhdangtien(long l) throws Exception{
		Locale locale = new Locale("vi", "VN");
		NumberFormat format = NumberFormat.getCurrencyInstance(locale);
		return format.format(l);
	}
	public static void main(String[] args) {
		try {
			thongkedao tkdao=new thongkedao();
			System.out.println(tkdao.dinhdangtien(1899999));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 
}
