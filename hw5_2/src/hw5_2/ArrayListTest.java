/*
 *���ϸ� : ArrayListTest
 *�ۼ��� : 201432014 �𼳾�
 *�ۼ��� : 2017.09.21
 *���� : ArrayList Ȱ�� 
 */
package hw5_2;

/**
 * @author snow
 *
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hw5_2 : �𼳾�\n");

		//ArrayList ��ü ����
		ArrayList<Integer> list = new ArrayList<Integer>();

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
		Scanner scan = new Scanner(System.in);

		//list ��ȸ

		System.out.print("��ȸ�� �ε��� �Է� : ");
		int ipt = scan.nextInt();
		System.out.println("�ε��� "+ipt+"�� ���� = "+list.get(ipt)+"\n");




		//����

		System.out.print("777�� ������ �ε��� �Է� : ");
		ipt = scan.nextInt();
		list.set(ipt, 777);
		System.out.println(list+"\n");


		//����

		System.out.print("999�� ������ �ε��� �Է� : ");
		ipt = scan.nextInt();
		list.add(ipt, 999);
		System.out.println(list+"\n");



		//����

		System.out.print("������ �ε��� �Է� : ");
		ipt = scan.nextInt();
		int x = list.remove(ipt);
		System.out.println("�ε��� "+ipt+"�� ���� = "+x);
		System.out.println(list+"\n");

	}


}


