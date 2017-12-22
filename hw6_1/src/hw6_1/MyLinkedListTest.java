/*
 *���ϸ� : MyLinkedListTest.java
 *�ۼ��� : 201432014 �𼳾�
 *�ۼ��� : 2017.10.10
 *���� : MyLinkedList Ȱ�� 
 */
package hw6_1;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author snow
 *
 */

public class MyLinkedListTest {

	private static int select= -1; // �⺻��.
	private static Scanner scan = new Scanner(System.in);
	private static MyLinkedList list = new MyLinkedList();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hw6_1 : �𼳾�\n");

		System.out.println("==========Linked List ���� ���α׷�==========\n");

		// ���� ���� (���α׷� ���� ���ý� ���� ����)
		while(true) {
			selection();

			if(select==9) {
				break;
			}

			processing();
		}

	}
	// �޴� ���� �޼ҵ� (����ڰ� ����� �� �޴��� ���� �� �� ���� �ݺ�)
	private static void selection() {

		while(true) {
			inform();

			try {
				select = scan.nextInt();
			} catch(InputMismatchException e){
				scan.nextLine(); // �Է� ������ �߰� ���� ������ ���� ���� ����
				select = -1; // ���� ������ select default�� ����.
			}
			if((select>0&&select<=9)) {
				break;
			}
			else {
				System.out.println("\n�Է� ����\n");
			}
		}
	}

	// �⺻ �ȳ��� ��� �޼ҵ�
	private static void inform() {
		System.out.println("1)����Ʈ ���  2)�Ǿ� ����  3)�Ǿ� ����  4)�˻�  5)�ε��� ����  6)�ε��� ����  7)�� ����  8)�� ����  9)����");
		System.out.print("���Ͻô� �۾��� ���� �Է��� ���� �������ּ���. : ");
	}

	// 
	private static void processing(){
		switch(select) {
		case 1:
			System.out.println("<<����Ʈ ���>>\n"+list.toString()+"\n");
			break;

		case 2:
			try {
				System.out.print("<<�Ǿ� ����>>\n"+"�Ǿտ� ������ ������ �Է� ���ּ��� : ");
				list.addFirst(scan.nextInt());
				System.out.println("�߰��Ϸ�.\n");
			} catch(InputMismatchException e) {
				System.out.println("������ �߰� �����մϴ�\n");
				scan.nextLine();
			}
			break;

		case 3:
			try {
				System.out.println("<<�Ǿ� ����>>");
				System.out.println("���� �Ϸ�!\n������ ���� : "+list.removeFirst()+"\n");
			} catch(NullPointerException e) {
				System.out.println("����Ʈ�� ����ֽ��ϴ�. ���� ����\n");
			}
			break;

		case 4:
			try {
				System.out.print("<<�˻�>>\nã���� ���Ҹ� �Է����ּ��� : ");
				boolean asw = list.contains(scan.nextInt());
				if(asw==true) System.out.println("ã���ô� ���Ұ� �� ����Ʈ�� ���ԵǾ� �ֽ��ϴ�.\n");
				else System.out.println("ã���ô� ���Ұ� �� ����Ʈ�� ���ԵǾ� ���� �ʽ��ϴ�.\n");
			} catch(InputMismatchException e) {
				System.out.println("������ �Է� �����մϴ�. �˻�����\n");
				scan.nextLine();
			}
			break;

		case 5:
			try {
				System.out.print("<<�ε��� ����>>\n������ �ε����� ������ ���ʴ�� �Է� ���ּ��� : ");
				int idx=scan.nextInt();
				int number=scan.nextInt();
				list.add(idx, number);
				System.out.println("�߰��Ϸ�.\n");
			} catch(InputMismatchException e){
				System.out.println("�����θ� �Է����ּ���. ���� ����.\n");
				scan.nextLine();
			} catch(NullPointerException e) {
				System.out.println("�ε��� ����. ���Խ���.\n");
			}
			break;

		case 6:
			try {
				System.out.print("<<�ε��� ����>>\n������ �ε����� �Է����ּ��� : ");
				System.out.println("���� �Ϸ�!\n������ ���� : "+list.remove(scan.nextInt())+"\n");
			} catch(InputMismatchException e){
				System.out.println("�����θ� �Է����ּ���. ���� ����.\n");
				scan.nextLine();
			} catch(NullPointerException e) {
				System.out.println("�ε��� ����. ��������.\n");
			}
			break;

		case 7:
			try {
				System.out.print("<<�� ����>>\n�� ����x, y�� �Է����ּ���(ù��° x �ڿ� y�� ���Ե˴ϴ�.) : ");
				int x=scan.nextInt();
				int y=scan.nextInt();
				list.targetAdd(x, y);
				System.out.println("�߰��Ϸ�.\n");
			} catch(InputMismatchException e){
				System.out.println("�����θ� �Է����ּ���. ���� ����.\n");
				scan.nextLine();
			} catch(NullPointerException e) {
				System.out.println("x�� �������� �ʽ��ϴ�. ���Խ���.\n");
			}
			break;
			
		case 8:
			try {
				System.out.print("<<�� ����>>\n������ ���� �Է����ּ��� : ");
				list.targetRemove(scan.nextInt());
				System.out.println("���� �Ϸ�!\n");
			} catch(InputMismatchException e){
				System.out.println("�����θ� �Է����ּ���. ���� ����.\n");
				scan.nextLine();
			} catch(NullPointerException e) {
				System.out.println("�Է��Ͻ� ������ �������� �ʽ��ϴ�. ��������.\n");
			}
			break;
			
		case 9:
			break;
		}
	}
}