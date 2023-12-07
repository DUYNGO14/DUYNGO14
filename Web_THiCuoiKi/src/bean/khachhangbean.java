package bean;

public class khachhangbean {
	private Long makh;
	private String hoten;
	private String diachi;
	private String sdt;
	private String email;
	private String tendn;
	private String matkhau;
	public khachhangbean() {
		super();
	}
	public khachhangbean(Long makh, String hoten, String diachi, String sdt, String email, String tendn,
			String matkhau) {
		super();
		this.makh = makh;
		this.hoten = hoten;
		this.diachi = diachi;
		this.sdt = sdt;
		this.email = email;
		this.tendn = tendn;
		this.matkhau = matkhau;
	}
	public Long getMakh() {
		return makh;
	}
	public void setMakh(Long makh) {
		this.makh = makh;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTendn() {
		return tendn;
	}
	public void setTendn(String tendn) {
		this.tendn = tendn;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	@Override
	public String toString() {
		return "khachhangbean [makh=" + makh + ", hoten=" + hoten + ", diachi=" + diachi + ", sdt=" + sdt + ", email="
				+ email + ", tendn=" + tendn + ", matkhau=" + matkhau + "]";
	}
	
}
