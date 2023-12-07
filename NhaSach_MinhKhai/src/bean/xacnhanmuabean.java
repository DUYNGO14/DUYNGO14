package bean;

public class xacnhanmuabean {
	private Long machitiethd;
	private String hoten;
	private String tensach;
	private Long gia;
	private Long soluongmua;
	private Long thanhtien;
	private Boolean damua;
	
	public xacnhanmuabean() {
		super();
	}
	public xacnhanmuabean(Long maChiTietHD, String hoten, String tensach, Long gia, Long soLuongMua, Long thanhtien,
			Boolean damua) {
		super();
		machitiethd = maChiTietHD;
		this.hoten = hoten;
		this.tensach = tensach;
		this.gia = gia;
		soluongmua = soLuongMua;
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

	public String getTensach() {
		return tensach;
	}

	public void setTensach(String tensach) {
		this.tensach = tensach;
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
		return "xacnhanmuabean [MaChiTietHD=" + machitiethd + ", hoten=" + hoten + ", tensach=" + tensach + ", gia="
				+ gia + ", SoLuongMua=" + soluongmua + ", thanhtien=" + thanhtien + ", damua=" + damua + "]";
	}
	
	
}
