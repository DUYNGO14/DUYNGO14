package bean;

import java.sql.Date;

public class donhangbean {
	private String madt;
	private String tendt;
	private Long gia;
	private	Double kichthuocman;
	private Long pin;
	private String maloai;
	private String chip;
	private Long ram;
	private Long dungluong;
	private String anh;
	private Long soluong;
	private Long mahoadon;
	private Date ngaymua;
	public donhangbean() {
		super();
	}
	public donhangbean(String madt, String tendt, Long gia, Double kichthuocman, Long pin, String maloai, String chip,
			Long ram, Long dungluong, String anh, Long soluong, Long mahoadon, Date ngaymua) {
		super();
		this.madt = madt;
		this.tendt = tendt;
		this.gia = gia;
		this.kichthuocman = kichthuocman;
		this.pin = pin;
		this.maloai = maloai;
		this.chip = chip;
		this.ram = ram;
		this.dungluong = dungluong;
		this.anh = anh;
		this.soluong = soluong;
		this.mahoadon = mahoadon;
		this.ngaymua = ngaymua;
	}
	public String getMadt() {
		return madt;
	}
	public void setMadt(String madt) {
		this.madt = madt;
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
	public Double getKichthuocman() {
		return kichthuocman;
	}
	public void setKichthuocman(Double kichthuocman) {
		this.kichthuocman = kichthuocman;
	}
	public Long getPin() {
		return pin;
	}
	public void setPin(Long pin) {
		this.pin = pin;
	}
	public String getMaloai() {
		return maloai;
	}
	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}
	public String getChip() {
		return chip;
	}
	public void setChip(String chip) {
		this.chip = chip;
	}
	public Long getRam() {
		return ram;
	}
	public void setRam(Long ram) {
		this.ram = ram;
	}
	public Long getDungluong() {
		return dungluong;
	}
	public void setDungluong(Long dungluong) {
		this.dungluong = dungluong;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public Long getSoluong() {
		return soluong;
	}
	public void setSoluong(Long soluong) {
		this.soluong = soluong;
	}
	public Long getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(Long mahoadon) {
		this.mahoadon = mahoadon;
	}
	public Date getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}
	@Override
	public String toString() {
		return "donhangbean [madt=" + madt + ", tendt=" + tendt + ", gia=" + gia + ", kichthuocman=" + kichthuocman
				+ ", pin=" + pin + ", maloai=" + maloai + ", chip=" + chip + ", ram=" + ram + ", dungluong=" + dungluong
				+ ", anh=" + anh + ", soluong=" + soluong + ", mahoadon=" + mahoadon + ", ngaymua=" + ngaymua + "]";
	}
	
}
