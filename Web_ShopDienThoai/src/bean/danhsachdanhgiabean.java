package bean;

public class danhsachdanhgiabean {
	private String tendt;
	private String tenkh;
	private String noidung;
	
	public danhsachdanhgiabean() {
		super();
	}

	public danhsachdanhgiabean(String tendt, String tenkh, String noidung) {
		super();
		this.tendt = tendt;
		this.tenkh = tenkh;
		this.noidung = noidung;
	}

	public String getTendt() {
		return tendt;
	}

	public void setTendt(String tendt) {
		this.tendt = tendt;
	}

	public String getTenkh() {
		return tenkh;
	}

	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}

	public String getNoidung() {
		return noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

	@Override
	public String toString() {
		return "danhsachdanhgiabean [tendt=" + tendt + ", tenkh=" + tenkh + ", noidung=" + noidung + "]";
	}
	
}
