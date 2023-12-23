package bo;

import java.util.ArrayList;

import bean.xacnhanmuaAdminbean;
import dao.xacnhandonadmindao;

public class xacnhandonhangAdminbo {
	xacnhandonadmindao xndao = new xacnhandonadmindao();
	public ArrayList<xacnhanmuaAdminbean> getdonhang() throws Exception{
		return xndao.getdonhang();
	}
	public void XacNhanDon(long MaChiTietHD) throws Exception{
		xndao.XacNhanDon(MaChiTietHD);
	}
	public ArrayList<xacnhanmuaAdminbean> getdonhangdaxacnhan() throws Exception{
		return xndao.getdonhangdaxacnhan();
	}
	public Long DoanhThu() throws Exception{
		return xndao.DoanhThu();
	}
	public xacnhanmuaAdminbean getdienthoaibanchay() throws Exception{
		return xndao.getdienthoaibanchay();
	}
}
