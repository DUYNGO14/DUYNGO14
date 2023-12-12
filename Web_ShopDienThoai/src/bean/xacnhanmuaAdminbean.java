package bean;

public class xacnhanmuaAdminbean {
	private Long machitiethd;
	private String hoten;
	private String tendt;
	private Long gia;
	private Long soluongmua;
	private Long thanhtien;
	private Boolean damua;
	public xacnhanmuaAdminbean() {
		super();
	}
	public xacnhanmuaAdminbean(Long machitiethd, String hoten, String tendt, Long gia, Long soluongmua,
			Long thanhtien, Boolean damua) {
		super();
		this.machitiethd = machitiethd;
		this.hoten = hoten;
		this.tendt = tendt;
		this.gia = gia;
		this.soluongmua = soluongmua;
		this.thanhtien = thanhtien;
		this.damua = damua;
	}
	public Long getMachitiethd() {
		return machitiethd;
	}
	public void setMachitiethd(Long machitiethd) {
		this.machitiethd = machitiethd;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	
	public String getTendt() {
		return tendt;
	}
	public void setTendt(String tendt) {
		this.tendt = tendt;
	}
	public Long getGia() {
		return gia;
	}
	public void setGia(Long gia) {
		this.gia = gia;
	}
	public Long getSoluongmua() {
		return soluongmua;
	}
	public void setSoluongmua(Long soluongmua) {
		this.soluongmua = soluongmua;
	}
	public Long getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(Long thanhtien) {
		this.thanhtien = thanhtien;
	}
	public Boolean getDamua() {
		return damua;
	}
	public void setDamua(Boolean damua) {
		this.damua = damua;
	}
	@Override
	public String toString() {
		return "xacnhanmuaAdminbean [machitiethd=" + machitiethd + ", hoten=" + hoten + ", tendt=" + tendt
				+ ", gia=" + gia + ", soluongmua=" + soluongmua + ", thanhtien=" + thanhtien + ", damua=" + damua + "]";
	}
	
}
