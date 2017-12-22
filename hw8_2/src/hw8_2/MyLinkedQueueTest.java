/**
 * MyLinkedQueueTest.java
 * 201432014 �𼳾�
 * 2017.11.13
 * ���Ḯ��Ʈ�� ������ ť ����̹� Ŭ����
 */
package hw8_2;

import java.util.Scanner;

/**
 * @author skylo
 *
 */
public class MyLinkedQueueTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hw8_2 : �𼳾�\n");

		MyLinkedQueue queue = new MyLinkedQueue();
		Scanner in = new Scanner(System.in);

		int userSelect = 0;

		do {
			System.out.println("\n======MyCircularQueue======\n1. ����  2. ����  3. ��ü����  4. ����\n");
			System.out.print("�޴� ���� : ");
			userSelect = in.nextInt();

			switch(userSelect) {
			case 1:
				System.out.println("<<����>>");
				System.out.print("���� �Է� : ");
				queue.enQueue(in.nextInt());
				break;

			case 2:
				System.out.println("<<����>>");
				System.out.printf("������ ���� : %d\n", queue.deQueue());
				break;

			case 3:
				System.out.println("<<��ü ����>>");
				System.out.println(deleteAll(queue));
				break;

			case 4:
				break;

			default :
				System.out.println("�߸��� �Է��Դϴ�.\n");
			}
		}while(userSelect!=4);	
	}
	
	private static String deleteAll(MyLinkedQueue queue) {
		StringBuilder tmp = new StringBuilder();
		
		while(!(queue.isEmpty()))
			tmp.append(queue.deQueue()).append(" ");
		return tmp.toString();
	}

}
