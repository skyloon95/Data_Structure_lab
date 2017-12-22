/*
 *StackTest.java
 *201432014 �𼳾�
 *2017.10.27
 *Stack Ŭ���� ����غ��� 
 */
package lab7_3;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author skylo
 *
 */
public class StackTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lab7_3 : �𼳾�\n");

		Stack stack = new Stack();
		Scanner scan = new Scanner(System.in);

		int select = 0;

		do {
			System.out.println("======MyArrayStack ������======\n");
			System.out.print("1:����  2:����  3:��ȸ  4:��ü����  5:����\n�޴� ���� �Է�==>");
			select = scan.nextInt();

			switch(select) {
			case 1:
				System.out.println("\n<<����>>");
				System.out.print("������ ���� ���� �Է� : ");
				stack.push(scan.nextInt());
				System.out.println("���� �Ϸ�\n\n");
				break;

			case 2:
				System.out.println("\n<<����>>");
				System.out.println("������ ���� : "+stack.pop()+"\n\n");
				break;

			case 3:
				System.out.println("\n<<��ȸ>>");
				System.out.println("���� top ���� : "+stack.peek()+"\n\n");
				break;

			case 4:
				System.out.println("\n<<��ü����>>");
				System.out.println(popAll(stack));
				System.out.println("������ ������ϴ�.\n\n");
				break;

			case 5:
				break;

			default:
				System.out.println("�߸��� �޴������Դϴ�.\n");
			}

		}while(select != 5);
	}

	private static String popAll(Stack stack) {
		StringBuilder tmp = new StringBuilder();

		while(!stack.isEmpty()) {
			tmp.append(stack.pop()).append(" ");
		}

		return "������ ���� : "+tmp.toString();
	}
}
