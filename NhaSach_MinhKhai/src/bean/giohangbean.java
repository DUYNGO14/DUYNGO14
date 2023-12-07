package bean;

public class giohangbean {
	private String masach;
	private String tensach;
	private String tacgia;
	private Long  soluong;
	private Long gia;
	private Long thanhtien;
	private String anh;
	public giohangbean() {
		super();
	}
	public giohangbean(String masach, String tensach, String tacgia, Long soluong, Long gia,
			String anh) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.tacgia = tacgia;
		this.soluong = soluong;
		this.gia = gia;
		this.thanhtien = soluong*gia;
		this.anh = anh;
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
	public String getTacgia() {
		return tacgia;
	}
	public void setTacgia(String tacgia) {
		this.tacgia = tacgia;
	}
	public Long getSoluong() {
		return soluong;
	}
	public void setSoluong(Long soluong) {
		this.soluong = soluong;
	}
	public Long getGia() {
		return gia;
	}
	public void setGia(Long gia) {
		this.gia = gia;
	}
	public Long getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(Long thanhtien) {
		this.thanhtien = thanhtien;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	@Override
	public String toString() {
		return "giohangbean [masach=" + masach + ", tensach=" + tensach + ", tacgia=" + tacgia + ", soluong=" + soluong
				+ ", gia=" + gia + ", thanhtien=" + thanhtien + ", anh=" + anh + "]";
	}
	
	
}
