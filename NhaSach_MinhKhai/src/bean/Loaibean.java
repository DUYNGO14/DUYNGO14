package bean;

public class Loaibean {
	private String maloai;
	private String tenloai;
	public Loaibean() {
		super();
	}
	public Loaibean(String maloai, String tenloai) {
		super();
		this.maloai = maloai;
		this.tenloai = tenloai;
	}
	public String getMaloai() {
		return maloai;
	}
	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}
	public String getTenloai() {
		return tenloai;
	}
	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}
	@Override
	public String toString() {
		return "Loaibean [maloai=" + maloai + ", tenloai=" + tenloai + "]";
	}
	
}
