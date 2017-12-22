/* 
 * ���ϸ�: MyBinaryTreeTest.java
 * �ۼ���: 2017.11.28
 * �ۼ���: �𼳾�
 * ����: int�� Ű���� �����ϴ� ����Ž��Ʈ���� �����ϰ� ������ �����ϴ� ���α׷� 
 */
package hw9_2;

import java.util.Scanner;

public class MyBinarySearchTreeTest { 
	public static void main(String[] args) { 
		System.out.println("hw9_2 : �𼳾�\n");

		// ���� ����Ž��Ʈ�� tree�� ����
		MyBinarySearchTree tree = new MyBinarySearchTree();

		Scanner scan = new Scanner(System.in);
		System.out.println("�޴� ��ȣ�� �Է��ϼ���.");
		int menu = 0;
		int item = 0;

		// ���Ḧ ������ ������ �ݺ��Ͽ� �޴��� �����ϰ� �׿� �´� Ʈ�� ������ ����
		do {
			System.out.print("1:��ü��ȸ 2:��ͻ��� 3:������ȸ 4:�˻� 5:�ִ밪 ��ȸ 6:���� 7:���� 9:���� --->");
			menu = scan.nextInt();
			switch(menu) {
			case 1:
				System.out.println("��ü��ȸ�� �����մϴ�.");
				System.out.println(tree.toString());		// (1)	 
				break;
			case 2:
				System.out.println("��� �˰����� �̿��� ������ �����մϴ�.");
				System.out.print("������ ���� �Է�:");		// (2)
				item = scan.nextInt();  
				tree.insert(item);
				break;				
			case 3:
				System.out.println("������ȸ�� �����մϴ�.");
				tree.printPostorder();		 		// (3)
				break;
			case 4:
				System.out.println("�˻��� �����մϴ�.");
				System.out.print("�˻��� ���� �Է�:");
				item = scan.nextInt();
				if(tree.contains(item))				// (4) 
					System.out.println("�˻� ����");
				else
					System.out.println("�˻� ����");
				break;
			case 5:
				System.out.println("�ִ밪 ��ȸ�� �����մϴ�.");
				try {
					System.out.println(tree.max());			// (5)
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6:
				System.out.println("�ݺ� �˰����� �̿��� ������ �����մϴ�.");
				System.out.print("������ ���� �Է�:");
				item = scan.nextInt();
				if(tree.add(item))				// (6)
					System.out.println("���� ����");		 
				else
					System.out.println("���� ����");
				break;
			case 7:
				System.out.println("������ �����մϴ�.");
				System.out.print("������ ���� �Է�:");
				item = scan.nextInt();
				if(tree.remove(item))				// (7)	 
					System.out.println("���� ����");
				else
					System.out.println("���� ����");
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

