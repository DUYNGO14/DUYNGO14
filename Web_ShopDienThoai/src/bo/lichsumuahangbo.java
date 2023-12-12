package bo;

import java.util.ArrayList;

import bean.lichsubean;
import dao.lichsumuahangdao;

public class lichsumuahangbo {
	lichsumuahangdao lsdao= new lichsumuahangdao();
	public ArrayList<lichsubean> getLichSu(long makh1) throws Exception{
		return lsdao.getLichSu(makh1);
	}
}
