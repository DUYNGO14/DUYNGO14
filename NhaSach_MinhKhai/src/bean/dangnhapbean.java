package bean;

public class dangnhapbean {
	private String tenNguoiDangNhap;
	private String matkhau;
	private int quyen;
	public dangnhapbean(String tenNguoiDangNhap, String matkhau, int quyen) {
		super();
		this.tenNguoiDangNhap = tenNguoiDangNhap;
		this.matkhau = matkhau;
		this.quyen = quyen;
	}
	public dangnhapbean() {
		super();
	}
	public String getTenNguoiDangNhap() {
		return tenNguoiDangNhap;
	}
	public void setTenNguoiDangNhap(String tenNguoiDangNhap) {
		this.tenNguoiDangNhap = tenNguoiDangNhap;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public int getQuyen() {
		return quyen;
	}
	public void setQuyen(int quyen) {
		this.quyen = quyen;
	}
	@Override
	public String toString() {
		return "dangnhapbean [tenNguoiDangNhap=" + tenNguoiDangNhap + ", matkhau=" + matkhau + ", quyen=" + quyen + "]";
	}
	
}
