package cn.itcast.gjp.controller;

import java.util.List;

import cn.itcast.gjp.domain.ZhangWu;
import cn.itcast.gjp.service.ZhangWuService;
                                                        
public class ZhangWuController {
	private ZhangWuService service=new ZhangWuService();
	/*校验登录状态,跳转等*/
	
	public  List<ZhangWu> selectAll(){
		return service.selectAll();}

	public  List<ZhangWu> select(String start, String end) {
		return service.select(start, end);
	}

	public  int addZhangWu(ZhangWu zw) {
		return service.addZhangWu(zw);
	}

	public  void editZhangHu(ZhangWu zw) {
		service.editZhangHu(zw);
	}

	public  int  deleteZhangWu(int zwid) {
		return service.deleteZhangWu(zwid);
	}
}