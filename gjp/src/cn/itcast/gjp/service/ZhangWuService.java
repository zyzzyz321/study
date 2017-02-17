package cn.itcast.gjp.service;

import java.util.List;

import cn.itcast.gjp.dao.ZhangWuDao;
import cn.itcast.gjp.domain.ZhangWu;

public class ZhangWuService {
private  ZhangWuDao dao = new ZhangWuDao();
	public List<ZhangWu> selectAll() {
		return dao.selectAll();
	}

	public List<ZhangWu> select(String start, String end) {
		return dao.select( start,  end);
	}

	public int addZhangWu(ZhangWu zw) {
		return dao.addZhangWu(zw);
	}

	public void editZhangHu(ZhangWu zw) {
		dao.editZhangWu(zw);
	}

	public int deleteZhangWu(int zwid) {
		return  dao.deleteZhangWu(zwid);
	}

}
