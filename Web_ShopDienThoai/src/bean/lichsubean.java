package bean;

public class lichsubean {
 private String madt;
 private String tendt;
 private Long slmua;
 private Long gia;
 private Double ktm;
 private Long pin;
 private String chip;
 private Long ram;
 private Long dl;
 private String anh;
 private Long thanhtien;
 private Long makh;
public lichsubean() {
	super();
}
public lichsubean(String madt, String tendt, Long slmua, Long gia, Double ktm, Long pin, String chip, Long ram, Long dl,
		String anh, Long thanhtien, Long makh) {
	super();
	this.madt = madt;
	this.tendt = tendt;
	this.slmua = slmua;
	this.gia = gia;
	this.ktm = ktm;
	this.pin = pin;
	this.chip = chip;
	this.ram = ram;
	this.dl = dl;
	this.anh = anh;
	this.thanhtien = thanhtien;
	this.makh = makh;
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
public Long getSlmua() {
	return slmua;
}
public void setSlmua(Long slmua) {
	this.slmua = slmua;
}
public Long getGia() {
	return gia;
}
public void setGia(Long gia) {
	this.gia = gia;
}
public Double getKtm() {
	return ktm;
}
public void setKtm(Double ktm) {
	this.ktm = ktm;
}
public Long getPin() {
	return pin;
}
public void setPin(Long pin) {
	this.pin = pin;
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
public Long getDl() {
	return dl;
}
public void setDl(Long dl) {
	this.dl = dl;
}
public String getAnh() {
	return anh;
}
public void setAnh(String anh) {
	this.anh = anh;
}
public Long getThanhtien() {
	return thanhtien;
}
public void setThanhtien(Long thanhtien) {
	this.thanhtien = thanhtien;
}
public Long getMakh() {
	return makh;
}
public void setMakh(Long makh) {
	this.makh = makh;
}
@Override
public String toString() {
	return "lichsubean [madt=" + madt + ", tendt=" + tendt + ", slmua=" + slmua + ", gia=" + gia + ", ktm=" + ktm
			+ ", pin=" + pin + ", chip=" + chip + ", ram=" + ram + ", dl=" + dl + ", anh=" + anh + ", thanhtien="
			+ thanhtien + ", makh=" + makh + "]";
}
 
}
