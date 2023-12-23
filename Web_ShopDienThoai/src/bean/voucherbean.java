package bean;

public class voucherbean {
	private Long mavoucher;
	private String tenvoucher;
	private Long giatri;
	private Long soluong;
	private long maloaivoucher;
	private long mavc;
	public voucherbean() {
		super();
	}
	public voucherbean(Long mavoucher, String tenvoucher, Long giatri,long soluong,long maloaivoucher,long mavc) {
		super();
		this.mavoucher = mavoucher;
		this.tenvoucher = tenvoucher;
		this.giatri = giatri;
		this.soluong=soluong;
		this.maloaivoucher=maloaivoucher;
		this.mavc=mavc;
	}
	
	public long getMavc() {
		return mavc;
	}
	public void setMavc(long mavc) {
		this.mavc = mavc;
	}
	public Long getMavoucher() {
		return mavoucher;
	}
	public void setMavoucher(Long mavoucher) {
		this.mavoucher = mavoucher;
	}
	public String getTenvoucher() {
		return tenvoucher;
	}
	public void setTenvoucher(String tenvoucher) {
		this.tenvoucher = tenvoucher;
	}
	public Long getGiatri() {
		return giatri;
	}
	public void setGiatri(Long giatri) {
		this.giatri = giatri;
	}
	
	public Long getSoluong() {
		return soluong;
	}
	public void setSoluong(Long soluong) {
		this.soluong = soluong;
	}
	
	public long getMaloaivoucher() {
		return maloaivoucher;
	}
	public void setMaloaivoucher(long maloaivoucher) {
		this.maloaivoucher = maloaivoucher;
	}
	@Override
	public String toString() {
		return "voucherbean [mavoucher=" + mavoucher + ", tenvoucher=" + tenvoucher + ", giatri=" + giatri
				+ ", soluong=" + soluong + ", maloaivoucher=" + maloaivoucher +", mavc=" + mavc +"]";
	}
	
	
	
}
