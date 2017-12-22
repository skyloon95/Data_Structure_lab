package hw10_1;
/* 
 * ���ϸ�: MatrixGraphTest.java
 * �ۼ���: 2017.11.29
 * �ۼ���: 201432014 �𼳾�
 * ����: ������ ����Ʈ �׷����� �����ϰ� ������ �߰��ϴ� ���α׷�.
 */

public class ListGraph {
	private int numOfVertex;
	private Node[] list;

	public ListGraph(int numOfVertex) {	//	������
		this.numOfVertex = numOfVertex;
		this.list = new Node[this.numOfVertex];
	}

	public void addEdge(int v1, int v2) {
		if(v1<0||v1>=this.numOfVertex||v2<0||v2>=this.numOfVertex) {	//	���� ��Ż�� ���� �޽���
			System.out.println("���� ����!\n"+"�������� �ʴ� �����Դϴ�.");
		}

		else if(this.isAlreadyBeing(v1, v2)) {	//	�ߺ��� �����޽���
			System.out.println("���� ����!\n"+"�̹� �����ϴ� �����Դϴ�.");
		}

		else {	//	���� �߰�
			Node tmp = list[v1];			
			list[v1] = new Node(v2);
			list[v1].link = tmp;

			tmp = list[v2];
			list[v2] = new Node(v1);
			list[v2].link = tmp;

			System.out.println("���� ����!");
		}
	}

	public void printAdjacentVertices(int v1) {	//	 ���� ���� ���
		if(v1<0||v1>=this.numOfVertex) {	//	���� ��Ż�� ���� �޽���
			System.out.println("��� ����!\n"+"�߸� �� ���� �����Դϴ�.");
		}
		else {
			StringBuilder s = new StringBuilder("���� ���� => ");
			Node tmp = list[v1];

			while(tmp!=null) {
				s.append(tmp.vertex).append(" ");
				tmp = tmp.link;
			}

			System.out.println(s.toString());
		}
	}

	private boolean isAlreadyBeing(int v1, int v2) {	//	���� �ߺ� Ȯ��
		Node tmp = list[v1];
		boolean being = false;

		while(tmp!=null) {
			if(tmp.vertex == v2) {
				being = true;
				break;
			}
			else
				tmp = tmp.link;

		}

		return being;
	}

	private class Node{
		int vertex;
		Node link;

		public Node(int vertex) {
			this.vertex = vertex;
		}
	}
}
