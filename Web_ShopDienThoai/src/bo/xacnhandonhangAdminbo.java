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
}
