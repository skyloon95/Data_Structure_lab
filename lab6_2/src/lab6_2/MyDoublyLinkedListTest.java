/*
 * ���ϸ�: MyDoublyLinkedListTest.java
 * �ۼ���: �𼳾�
 * �ۼ���: 2017�� 9�� 21��
 * ����: MyDoublyLinkedList ��ü�� �����ϰ� ����, ��� ����� �׽�Ʈ�ϴ� ���α׷�
 */
package lab6_2;

import java.util.Scanner;

public class MyDoublyLinkedListTest {
	public static void main(String[] args) {
		
		System.out.println("lab6_2: �𼳾�\n");

		MyDoublyLinkedList list = new MyDoublyLinkedList();

		Scanner scan = new Scanner(System.in);
		System.out.println("�޴� ��ȣ�� �Է��ϼ���.");
		int menu = 0;
		int item = 0;
		do {
			System.out.print("1:����Ʈ��� 2:�Ǿջ��� 3:�Ǿջ��� 4:������ 8:����⿬��Ȯ�� 9:���� --->");
			menu = scan.nextInt();
			switch(menu) {
//			case 1:
//				System.out.println("����Ʈ����� �����մϴ�.");
//				System.out.println(list.toString());
//				break;
			case 2:
				System.out.println("�Ǿջ����� �����մϴ�.");
				System.out.print("������ ���� �Է�:");
				item = scan.nextInt();
				list.addFirst(item);
				break;
//			case 3:
//				System.out.println("�Ǿջ����� �����մϴ�.");
//				System.out.println("������ ���� = " + list.removeFirst());
//				break;
//			case 4:
//				System.out.println("�˻��� �����մϴ�.");
//				System.out.print("�˻��� ���� �Է�:");
//				item = scan.nextInt();
//				if(list.contains(item))
//					System.out.println("�˻� ����");
//				else
//					System.out.println("�˻� ����");
//				break;
			case 8:
				System.out.println("����� ������ Ȯ���մϴ�.");
				list.printLink();
				break;
			case 9:
				System.out.println("���α׷��� �����մϴ�.");
				break;
			default:
				System.out.println("�޴� ��ȣ ����: �޴��� �ٽ� �����ϼ���.");
			}
		} while(menu != 9);
	}
}
