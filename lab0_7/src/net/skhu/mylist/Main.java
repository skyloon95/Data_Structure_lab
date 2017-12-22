/*
 *���ϸ� : MyList.java
 *�ۼ��� : 2017.9.12
 *�ۼ��� : 201432014 �𼳾�
 *���� : ����̹� Ŭ����
 */

package net.skhu.mylist;

import java.util.InputMismatchException;
/**
 * @author snow
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lab0_7 : �𼳾�\n");
		
		java.util.Scanner scan = new java.util.Scanner(System.in);
		
		MyList mList = new MyList(); // MyList ��ü ����
		
		mList.print(); // ���� ����Ʈ ���
		
		while(true) {
			System.out.print("�����Ͻ� ������ �Է����ֽʽÿ� : ");
			try {
				mList.add(scan.nextInt());
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("�迭�� ���� á���ϴ�.");
				break;
			} catch(InputMismatchException e) {
				System.out.println("���� ���·θ� ���� �����մϴ�.\n");
				scan.nextLine(); // �߰����� ���� ������ ���� ���ۻ���
			} finally {
				mList.print();
			}
		}
	}

}
