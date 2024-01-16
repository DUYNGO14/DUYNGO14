package bean;

public class danhgiabean {
	private long madanhgia;
	private String noidung;
	private String madt;
	private long makh;
	public danhgiabean() {
		super();
	}
	public danhgiabean(long madanhgia, String noidung, String madt, long makh) {
		super();
		this.madanhgia = madanhgia;
		this.noidung = noidung;
		this.madt = madt;
		this.makh = makh;
	}
	public long getMadanhgia() {
		return madanhgia;
	}
	public void setMadanhgia(long madanhgia) {
		this.madanhgia = madanhgia;
	}
	public String getNoidung() {
		return noidung;
	}
	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}
	public String getMadt() {
		return madt;
	}
	public void setMadt(String madt) {
		this.madt = madt;
	}
	public long getMakh() {
		return makh;
	}
	public void setMakh(long makh) {
		this.makh = makh;
	}
	@Override
	public String toString() {
		return "danhgiabean [madanhgia=" + madanhgia + ", noidung=" + noidung + ", madt=" + madt + ", makh=" + makh
				+ "]";
	}
	
	
}
