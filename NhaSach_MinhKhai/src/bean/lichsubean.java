package bean;

public class lichsubean {
	private String masach ;
	private String tensach;
	private long soluongmua;
	private long gia;
	private long thanhtien;
	private int damua;
	private long makh;
	private String anh;
	public lichsubean() {
		super();
	}
	public lichsubean(String masach, String tensach, long soluongmua, long gia, long thanhtien, int damua, long makh,
			String anh) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.soluongmua = soluongmua;
		this.gia = gia;
		this.thanhtien = thanhtien;
		this.damua = damua;
		this.makh = makh;
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
	public long getSoluongmua() {
		return soluongmua;
	}
	public void setSoluongmua(long soluongmua) {
		this.soluongmua = soluongmua;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public int getDamua() {
		return damua;
	}
	public void setDamua(int damua) {
		this.damua = damua;
	}
	public long getMakh() {
		return makh;
	}
	public void setMakh(int makh) {
		this.makh = makh;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public long getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}
	@Override
	public String toString() {
		return "lichsubean [masach=" + masach + ", tensach=" + tensach + ", soluongmua=" + soluongmua + ", gia=" + gia
				+ ", thanhtien=" + thanhtien + ", damua=" + damua + ", makh=" + makh + ", anh=" + anh + "]";
	}
	
}
