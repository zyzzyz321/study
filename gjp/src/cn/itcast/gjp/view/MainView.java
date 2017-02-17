package cn.itcast.gjp.view;

import java.util.List;
import java.util.Scanner;

import cn.itcast.gjp.controller.ZhangWuController;
import cn.itcast.gjp.domain.ZhangWu;

public class MainView {
private ZhangWuController controller=new ZhangWuController();
	
	public void run(){
		//创建scanner对象
		boolean flag= true;
		Scanner in=new Scanner (System.in);
		while(flag){
			System.out.println("--------------------------管家婆家庭记账软件--------------------------");
			System.out.println("	1.添加账务		2.编辑账务		3.删除账务		4.查询账务		5.退出系统");
			System.out.println("请输入要操作的功能序号[1-5]:");
			//接收用户的菜单选择
			int choose=Integer.parseInt(in.nextLine());
			switch(choose){
			case 1:	
				addZhangWu();
				break;
			case 2:
				editZhangWu();
				break;
			case 3:
				deleteZhangWu();
				break;
			case 4:
				selectZhangWu();
				break;
			case 5:
				System.out.println("再见");
				flag=false;
				break;
			default:
				System.out.println("输入错误");
			}
			
		}
	}

	
	public void deleteZhangWu() {
		
		Scanner in=new Scanner(System.in);
		System.out.println("请输入id：");
		int id=in.nextInt();
		System.out.println("真的要删除吗(Y/N)");
		String cherk=in.next();
		if(cherk.equals("Y")||cherk.equals("y")){
			int row=controller.deleteZhangWu(id);
			if(row!=0)
				System.out.println("删除成功");
			else
				System.out.println("删除失败");
						}
		
	}


	public void editZhangWu() {
		selectAll();
		Scanner in=new Scanner(System.in);
		ZhangWu zw=new ZhangWu();
		System.out.println("请输入ID：");
		zw.setZwid(in.nextInt());
		System.out.print("请输入新类别：");
		zw.setFlname(in.next());
		System.out.print("请输入新账户：");
		zw.setZhanghu(in.next());
		System.out.print("请输入新金额：");
		zw.setMoney(in.nextDouble());
		System.out.print("请输入新时间：");
		zw.setCreatetime(in.next());
		System.out.print("请输入新说明：");
		zw.setDescription(in.next());
		controller.editZhangHu(zw);
		System.out.println("编辑账务成功！");

	}


	public void addZhangWu() {
	 Scanner in = new Scanner(System.in);
	// ZhangWu zw = new ZhangWu();
	 System.out.print("请输入类别：");
	 //zw.setFlname(in.next());
	 String flname=in.next();
	 System.out.print("请输入账户：");
	 //zw.setZhanghu(in.next());
	 String zhanghu=in.next();
	 System.out.print("请输入金额：");
	// zw.setMoney(in.nextDouble());
	 double money=in.nextDouble();
	 System.out.print("请输入时间：");
	// zw.setCreatetime(in.next());
	 String createtime=in.next();
	 System.out.print("请输入说明：");
	// zw.setDescription(in.next());
	 String description=in.next();
	 int row=controller.addZhangWu(new ZhangWu(-1, flname, money, zhanghu, createtime, description));
	 if(row!=0)
	 System.out.println("添加账务成功！");
	 else
	 System.out.println("添加失败");
	}


	public void selectZhangWu() {
		System.out.println("1.查询所有　2.按条件查询");
		int in=Integer.parseInt(new Scanner(System.in).nextLine());
		switch(in){
		case 1:
			selectAll();
			break;
		case 2:
			select();
			break;
		default :
			System.out.println("输入错误");
		}
		
		
	}


	public void select() {
	Scanner sc=new Scanner(System.in);
	System.out.println("请输入查询起始时间：(格式\"YYY-mm-dd\")");
	String start =sc.nextLine();
	System.out.println("请输入查询结束时间："); 
	String end=sc.nextLine();
	List<ZhangWu> zhangWuList=controller.select(start,end);
	print(zhangWuList);
	}


	public  void selectAll() {
	List<ZhangWu> zhangWuList=controller.selectAll();
	print(zhangWuList);
}


	private void print(List<ZhangWu> zhangWuList) {
	for (ZhangWu zhangWu : zhangWuList) {
		System.out.println(zhangWu);
	}
}

}
