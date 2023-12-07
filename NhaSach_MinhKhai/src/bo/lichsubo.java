package bo;

import java.util.ArrayList;

import javax.websocket.Session;

import bean.lichsubean;
import dao.lichsudao;

public class lichsubo {
	lichsudao lsdao = new lichsudao();
	public ArrayList<lichsubean> getLichSu(long makh) throws Exception{
		return lsdao.getLichSu(makh);
	}
	public static void main(String[] args) {
		try {
			lichsubo lsdao = new lichsubo();
			ArrayList<lichsubean> ds = lsdao.getLichSu(23);
			for (lichsubean s : ds) {
				System.out.println(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
