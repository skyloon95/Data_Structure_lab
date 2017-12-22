package hw10_1;
/* 
 * ���ϸ�: MatrixGraphTest.java
 * �ۼ���: 2017.11.29
 * �ۼ���: 201432014 �𼳾�
 * ����: ������ �׷����� �����ϰ� ������ �����ϴ� ���α׷� 
 */

import java.util.Scanner;

public class ListGraphTest { 
	public static void main(String[] args) { 
		System.out.println("hw10_1 : �𼳾�");

		// ���� �� n �Է�
		Scanner scan = new Scanner(System.in);
		System.out.print("���� �� �Է�: ");
		int n = scan.nextInt();

		// ���� ���� n�� ������ �׷����� ����
		ListGraph graph = new ListGraph(n);

		System.out.println("\n�޴� ��ȣ�� �Է��ϼ���.");
		int menu = 0;
		int item = 0;
		int v1 = 0;
		int v2 = 0;

		// ���Ḧ ������ ������ �ݺ��Ͽ� �޴��� �����ϰ� �׿� �´� �׷��� ������ ����
		do {
			System.out.print("\n1:�������� 2:����������� 3:DFS 4:BFS 5:���� --->");
			menu = scan.nextInt();
			switch(menu) {
			case 1:
				System.out.print("���� v1 �Է�: ");
				v1 = scan.nextInt();		
				System.out.print("���� v2 �Է�: ");
				v2 = scan.nextInt();
				graph.addEdge(v1, v2);
				break;
			case 2:
				System.out.print("���� �Է�:");		 
				v1 = scan.nextInt();  
				graph.printAdjacentVertices(v1);
				break;				
//			case 3:
//				System.out.println("���̿켱Ž�� ������� ������ ����մϴ�.");
//				graph.depthFirstSearch();
//				break;
//			case 4:
//				System.out.println("�ʺ�켱Ž�� ������� ������ ����մϴ�.");
//				graph.breadthFirstSearch();
//				break;
			case 5:
				System.out.println("�����մϴ�.");
				break;
			default:
				System.out.println("�޴� ��ȣ ���� - �޴��� �ٽ� �����ϼ���.");
			}
		} while(menu != 5);
	}
}
