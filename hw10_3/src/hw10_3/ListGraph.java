package hw10_3;
/* 
 * ���ϸ�: ListGraph.java
 * �ۼ���: 2017.12.04
 * �ۼ���: 201432014 �𼳾�
 * ����: ������ ����Ʈ �׷����� �����ϰ� ������ �߰��ϴ� ���α׷�.
 */

import java.util.PriorityQueue;
import java.util.Queue;

public class ListGraph {
	private int numOfVertices;
	private Node[] list;
	private boolean[] visited;

	public ListGraph(int numOfVertex) {	//	������
		this.numOfVertices = numOfVertex;
		this.list = new Node[this.numOfVertices];
		this.visited = new boolean[this.numOfVertices];	
	}

	public void addEdge(int v1, int v2) {
		if(v1<0||v1>=this.numOfVertices||v2<0||v2>=this.numOfVertices) {	//	���� ��Ż�� ���� �޽���
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
		if(v1<0||v1>=this.numOfVertices) {	//	���� ��Ż�� ���� �޽���
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

	public void depthFirstSearch() {
		for(int i = 0 ; i < this.numOfVertices ; ++i)
			this.visited[i] = false;

		for(int i = 0 ; i < this.numOfVertices ; ++i) {
			if(!this.visited[i]) {
				System.out.print(i+" ");
				dfs(i);
			}
		}
	}

	private void dfs(int i) {
		visited[i] = true;
		Node p = this.list[i];

		while(p!=null) {
			if(!visited[p.vertex]) {
				System.out.print(p.vertex+" ");
				dfs(p.vertex);
			}

			p = p.link;
		}		
	}

	public void breadthFirstSearch() {
		for(int i = 0 ; i < this.numOfVertices ; ++i)
			this.visited[i] = false;

		for(int i = 0 ; i < this.numOfVertices ; ++i) {
			if(!visited[i]) {
				System.out.print(i+" ");
				bfs(i);
			}
		}
	}

	private void bfs(int i) {
		visited[i] = true;
		Queue<Integer> q = new PriorityQueue<>(this.numOfVertices);
		Node p = list[i];
		q.offer(i);

		while(!q.isEmpty()) {
			int w = q.poll();
			while(p!=null) {
				if(!this.visited[p.vertex]) {
					visited[p.vertex] = true;
					System.out.print(p.vertex+" ");
					q.add(p.vertex);
				}
				p = p.link;
			}
		}
	}

	private class Node{
		int vertex;
		Node link;

		public Node(int vertex) {
			this.vertex = vertex;
		}
	}
}
