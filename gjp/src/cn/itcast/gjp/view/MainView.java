package cn.itcast.gjp.view;

import java.util.List;
import java.util.Scanner;

import cn.itcast.gjp.controller.ZhangWuController;
import cn.itcast.gjp.domain.ZhangWu;

public class MainView {
private ZhangWuController controller=new ZhangWuController();
	
	public void run(){
		//����scanner����
		boolean flag= true;
		Scanner in=new Scanner (System.in);
		while(flag){
			System.out.println("--------------------------�ܼ��ż�ͥ�������--------------------------");
			System.out.println("	1.�������		2.�༭����		3.ɾ������		4.��ѯ����		5.�˳�ϵͳ");
			System.out.println("������Ҫ�����Ĺ������[1-5]:");
			//�����û��Ĳ˵�ѡ��
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
				System.out.println("�ټ�");
				flag=false;
				break;
			default:
				System.out.println("�������");
			}
			
		}
	}

	
	public void deleteZhangWu() {
		
		Scanner in=new Scanner(System.in);
		System.out.println("������id��");
		int id=in.nextInt();
		System.out.println("���Ҫɾ����(Y/N)");
		String cherk=in.next();
		if(cherk.equals("Y")||cherk.equals("y")){
			int row=controller.deleteZhangWu(id);
			if(row!=0)
				System.out.println("ɾ���ɹ�");
			else
				System.out.println("ɾ��ʧ��");
						}
		
	}


	public void editZhangWu() {
		selectAll();
		Scanner in=new Scanner(System.in);
		ZhangWu zw=new ZhangWu();
		System.out.println("������ID��");
		zw.setZwid(in.nextInt());
		System.out.print("�����������");
		zw.setFlname(in.next());
		System.out.print("���������˻���");
		zw.setZhanghu(in.next());
		System.out.print("�������½�");
		zw.setMoney(in.nextDouble());
		System.out.print("��������ʱ�䣺");
		zw.setCreatetime(in.next());
		System.out.print("��������˵����");
		zw.setDescription(in.next());
		controller.editZhangHu(zw);
		System.out.println("�༭����ɹ���");

	}


	public void addZhangWu() {
	 Scanner in = new Scanner(System.in);
	// ZhangWu zw = new ZhangWu();
	 System.out.print("���������");
	 //zw.setFlname(in.next());
	 String flname=in.next();
	 System.out.print("�������˻���");
	 //zw.setZhanghu(in.next());
	 String zhanghu=in.next();
	 System.out.print("�������");
	// zw.setMoney(in.nextDouble());
	 double money=in.nextDouble();
	 System.out.print("������ʱ�䣺");
	// zw.setCreatetime(in.next());
	 String createtime=in.next();
	 System.out.print("������˵����");
	// zw.setDescription(in.next());
	 String description=in.next();
	 int row=controller.addZhangWu(new ZhangWu(-1, flname, money, zhanghu, createtime, description));
	 if(row!=0)
	 System.out.println("�������ɹ���");
	 else
	 System.out.println("���ʧ��");
	}


	public void selectZhangWu() {
		System.out.println("1.��ѯ���С�2.��������ѯ");
		int in=Integer.parseInt(new Scanner(System.in).nextLine());
		switch(in){
		case 1:
			selectAll();
			break;
		case 2:
			select();
			break;
		default :
			System.out.println("�������");
		}
		
		
	}


	public void select() {
	Scanner sc=new Scanner(System.in);
	System.out.println("�������ѯ��ʼʱ�䣺(��ʽ\"YYY-mm-dd\")");
	String start =sc.nextLine();
	System.out.println("�������ѯ����ʱ�䣺"); 
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
