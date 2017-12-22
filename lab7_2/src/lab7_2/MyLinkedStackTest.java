/*
 * MyLinkedStackTest.java
 * 2017.10.12
 * 201432014 �𼳾�
 * MyLinkedList Ȱ��
 */
package lab7_2;

public class MyLinkedStackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lab7_2 : �𼳾�\n");

		MyLinkedStack stk = new MyLinkedStack();
		java.util.Scanner scan = new java.util.Scanner(System.in);
		int select = 0;
		
		System.out.println("========LinkedStack ������=======\n");
		do {
			System.out.print("1)����  2)����  3)��ȸ  4)��ü����  5)����\n�޴� ���� : ");

			select = scan.nextInt();

			switch(select) {
			case 1:
				System.out.println("<<����>>");
				System.out.print("���� �� ���� �Է� : ");
				stk.push(scan.nextInt());
				System.out.println("���� �Ϸ�!\n");
				break;

			case 2:
				System.out.println("<<����>>");
				try {
					System.out.println("���� �Ϸ�\n������ ���� : "+stk.pop()+"\n");
				} catch(NullPointerException e) {
					System.out.println("���� ����!\n������ ������ϴ�.\n");
				}
				break;

			case 3:
				System.out.println("<<��ȸ>>");
				try {
					System.out.println("���� �ֻ��� ���� : "+stk.peek()+"\n");
				} catch(NullPointerException e) {
					System.out.println("��ȸ ����\n������ ������ϴ�.\n");
				}
				break;

			case 4:
				System.out.println("<<��ü ����>>");
				try {
					popAll(stk);
				} catch(NullPointerException e) {
					System.out.println("\n������ ���������� ��������ϴ�.\n");
				}
				break;
				
			case 5:
				System.out.println("���α׷� ����");
				break;

			default:
				System.out.println("�߸� �����ϼ̽��ϴ�.\n");
				break;

			}

		} while(select!=5);

	}

	private static void popAll(MyLinkedStack stk) throws NullPointerException{
		if(stk.isEmpty()) {
			System.out.println("���� ����!\n������ ������ϴ�.\n");
		} else {
			System.out.println("���� ����");
			while(true) {
				System.out.print(stk.pop()+" ");
			}
		}
	}

}
