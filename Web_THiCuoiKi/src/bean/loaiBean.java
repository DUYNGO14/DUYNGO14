package bean;

public class loaiBean {
	private String maloai;
	private String tenloai;
	public loaiBean() {
		super();
	}
	public loaiBean(String maloai, String tenloai) {
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
		return "loaibean [maloai=" + maloai + ", tenloai=" + tenloai + "]";
	}
	
}
