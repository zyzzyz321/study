package cn.itcast.gjp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.gjp.domain.ZhangWu;
import cn.itcast.gjp.tools.JDBCUtils;

public class ZhangWuDao {
private static QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
	public List<ZhangWu> selectAll() {
		String sql="select * from gjp_zhangwu";
		try {
			return qr.query(sql, new BeanListHandler<ZhangWu>(ZhangWu.class));
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public List<ZhangWu> select(String start, String end) {
		String sql="select * from gjp_zhangwu where createtime between ? and ?";
		Object[] params={start ,end};
		try {
			return qr.query(sql,new BeanListHandler<ZhangWu>(ZhangWu.class), params);
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public int addZhangWu(ZhangWu zw) {
		String sql="insert into gjp_zhangwu(flname,money,zhanghu,createtime,description) value (?,?,?,?,?)";
		Object[] params={zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription()};
		try {
			return qr.update(sql, params);
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public void editZhangWu(ZhangWu zw) {
		String sql="update gjp_zhangwu set flname=?,money=?,zhanghu=?,createtime=?,description=? where zwid=?";
		Object[] params={zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription(),zw.getZwid()};
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public int deleteZhangWu(int zwid) {
		String sql="delete from gjp_zhangwu where zwid=?";
		try {
			return qr.update(sql,zwid);
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
