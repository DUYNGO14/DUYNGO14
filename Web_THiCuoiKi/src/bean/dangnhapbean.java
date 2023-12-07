package bean;

public class dangnhapbean {
	private String tenNguoiDangNhap;
	private String matkhau;
	private Long quyen;
	public dangnhapbean(String tenNguoiDangNhap, String matkhau, Long quyen) {
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
	public Long getQuyen() {
		return quyen;
	}
	public void setQuyen(Long quyen) {
		this.quyen = quyen;
	}
	@Override
	public String toString() {
		return "dangnhapbean [tenNguoiDangNhap=" + tenNguoiDangNhap + ", matkhau=" + matkhau + ", quyen=" + quyen + "]";
	}
	
}
