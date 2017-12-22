/*
 *���ϸ� : MyListTest.java
 *�ۼ��� : 2017.9.21
 *�ۼ��� : 201432014 �𼳾�
 *���� : ����Ʈ �ۼ� �� ���� �׽�Ʈ ����̹� Ŭ����
 */
package net.skhu.mylist;

import net.skhu.mylist.MyList.ArrayIndexOutOfDataSizeException;

/**
 * @author snow
 *
 */
public class MyListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hw5_1 : �𼳾�\n");

		//MyList ��ü ����
		MyList list = new MyList();

		//list�� ����
		list.add(20);
		list.add(30);
		list.add(20);
		list.add(40);
		list.add(-999);
		list.add(50);
		list.add(90);
		list.add(10);

		//list ���� ��ü ���
		System.out.println(list);

		//list�� ũ��
		System.out.println("����Ʈ ũ�� = "+list.size()+"\n");

		//Scanner ��ü ����
		java.util.Scanner scan = new java.util.Scanner(System.in);

		//list ��ȸ
		while(true) {
			try {
				System.out.print("��ȸ�� �ε��� �Է� : ");
				int ipt = scan.nextInt();
				System.out.println("�ε��� "+ipt+"�� ���� = "+list.get(ipt)+"\n");
				break;
			} catch(ArrayIndexOutOfDataSizeException e) {
				System.out.println(e.getMessage());
			}
		}
		
		//����
		while(true) {
			try {
				System.out.print("777�� ������ �ε��� �Է� : ");
				int ipt = scan.nextInt();
				list.set(ipt, 777);
				System.out.println(list+"\n");
				break;
			} catch(ArrayIndexOutOfDataSizeException e) {
				System.out.println(e.getMessage());
			}
		}
		
		//����
		while(true) {
			try {
				System.out.print("999�� ������ �ε��� �Է� : ");
				int ipt = scan.nextInt();
				list.add(ipt, 999);
				System.out.println(list+"\n");
				break;
			} catch(ArrayIndexOutOfDataSizeException e) {
				System.out.println(e.getMessage());
			}
		}
		
		//����
		while(true) {
			try {
				System.out.print("������ �ε��� �Է� : ");
				int ipt = scan.nextInt();
				int x = list.remove(ipt);
				System.out.println("�ε��� "+ipt+"�� ���� = "+x);
				System.out.println(list+"\n");
				break;
			} catch(ArrayIndexOutOfDataSizeException e) {
				System.out.println(e.getMessage());
			}
		}

		/**
		 * �ɼ� 1
		 */
		
		//list �߰�
		for(int i = 1 ; i<=25 ; i++) {
			list.add(i);
		}
		
		//list ��ü ���
		System.out.println(list);
		
	}

}
