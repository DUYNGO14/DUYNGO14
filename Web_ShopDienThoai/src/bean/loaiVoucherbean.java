package bean;

public class loaiVoucherbean {
	private long maloaivoucher;
	private String tenloaivoucher;
	
	public loaiVoucherbean() {
		super();
	}
	public loaiVoucherbean(long maloaivoucher, String tenloaivoucher) {
		super();
		this.maloaivoucher = maloaivoucher;
		this.tenloaivoucher = tenloaivoucher;
	}
	public long getMaloaivoucher() {
		return maloaivoucher;
	}
	public void setMaloaivoucher(long maloaivoucher) {
		this.maloaivoucher = maloaivoucher;
	}
	public String getTenloaivoucher() {
		return tenloaivoucher;
	}
	public void setTenloaivoucher(String tenloaivoucher) {
		this.tenloaivoucher = tenloaivoucher;
	}
	@Override
	public String toString() {
		return "loaiVoucherbean [maloaivoucher=" + maloaivoucher + ", tenloaivoucher=" + tenloaivoucher + "]";
	}
	
}
