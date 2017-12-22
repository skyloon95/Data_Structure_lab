package hw10_1;
/* 
 * 파일명: MatrixGraphTest.java
 * 작성일: 2017.11.29
 * 작성자: 201432014 모설아
 * 설명: 무방향 리스트 그래프를 생성하고 간선을 추가하는 프로그램.
 */

public class ListGraph {
	private int numOfVertex;
	private Node[] list;

	public ListGraph(int numOfVertex) {	//	생성자
		this.numOfVertex = numOfVertex;
		this.list = new Node[this.numOfVertex];
	}

	public void addEdge(int v1, int v2) {
		if(v1<0||v1>=this.numOfVertex||v2<0||v2>=this.numOfVertex) {	//	범위 이탈시 오류 메시지
			System.out.println("삽입 실패!\n"+"존재하지 않는 정점입니다.");
		}

		else if(this.isAlreadyBeing(v1, v2)) {	//	중복시 오류메시지
			System.out.println("삽입 실패!\n"+"이미 존재하는 간선입니다.");
		}

		else {	//	간선 추가
			Node tmp = list[v1];			
			list[v1] = new Node(v2);
			list[v1].link = tmp;

			tmp = list[v2];
			list[v2] = new Node(v1);
			list[v2].link = tmp;

			System.out.println("삽입 성공!");
		}
	}

	public void printAdjacentVertices(int v1) {	//	 인접 정점 출력
		if(v1<0||v1>=this.numOfVertex) {	//	범위 이탈시 오류 메시지
			System.out.println("출력 실패!\n"+"잘못 된 정점 선택입니다.");
		}
		else {
			StringBuilder s = new StringBuilder("인접 정점 => ");
			Node tmp = list[v1];

			while(tmp!=null) {
				s.append(tmp.vertex).append(" ");
				tmp = tmp.link;
			}

			System.out.println(s.toString());
		}
	}

	private boolean isAlreadyBeing(int v1, int v2) {	//	간선 중복 확인
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
