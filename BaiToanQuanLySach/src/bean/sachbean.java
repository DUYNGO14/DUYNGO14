package bean;

import java.util.Date;

public class sachbean {
	private String masach;
	private String tensach;
	private long soluong;
	private long gia;
	private String maloai;
	private String sotap;
	private String anh;
	private Date NgayNhap;
	private String tacgia;
	
	public sachbean() {
		super();
	}

	public sachbean(String masach, String tensach, long soluong, long gia, String maloai, String sotap, String anh,
			Date ngayNhap, String tacgia) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.soluong = soluong;
		this.gia = gia;
		this.maloai = maloai;
		this.sotap = sotap;
		this.anh = anh;
		NgayNhap = ngayNhap;
		this.tacgia = tacgia;
	}

	public String getMasach() {
		return masach;
	}

	public void setMasach(String masach) {
		this.masach = masach;
	}

	public String getTensach() {
		return tensach;
	}

	public void setTensach(String tensach) {
		this.tensach = tensach;
	}

	public long getSoluong() {
		return soluong;
	}

	public void setSoluong(long soluong) {
		this.soluong = soluong;
	}

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

	public String getMaloai() {
		return maloai;
	}

	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}

	public String getSotap() {
		return sotap;
	}

	public void setSotap(String sotap) {
		this.sotap = sotap;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public Date getNgayNhap() {
		return NgayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		NgayNhap = ngayNhap;
	}

	public String getTacgia() {
		return tacgia;
	}

	public void setTacgia(String tacgia) {
		this.tacgia = tacgia;
	}

	@Override
	public String toString() {
		return "sachbean [masach=" + masach + ", tensach=" + tensach + ", soluong=" + soluong + ", gia=" + gia
				+ ", maloai=" + maloai + ", sotap=" + sotap + ", anh=" + anh + ", NgayNhap=" + NgayNhap + ", tacgia="
				+ tacgia + "]";
	}
	
}
