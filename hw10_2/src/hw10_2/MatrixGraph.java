package hw10_2;
/* 
 * 파일명: MatrixGraph.java
 * 작성일: 2017.12.04
 * 작성자: 201432014 모설아
 * 설명: 무방향 그래프를 생성하고 연산을 수행하는 클래스
 */

import java.util.PriorityQueue;
import java.util.Queue;

public class MatrixGraph {
	private int[][] matrix;
	private int numOfVertices;
	private boolean[] visited;
	
	public MatrixGraph(int n) {
		numOfVertices = n;
		matrix = new int[numOfVertices][numOfVertices];
		visited = new boolean[this.numOfVertices];
	}
	
	public void addEdge(int v1, int v2) {
		if(!isInnerVertices(v1, v2))
			System.out.println("잘못 된 노드 입력입니다.");
		else if(!isNull(v1,v2))
			System.out.println("이미 존재하는 간선입니다");
		else {
			matrix[v1][v2] = 1;
			matrix[v2][v1] = 1;
		}
	}
	
	public boolean isNull(int v1, int v2) {
		if(matrix[v1][v2]==0&&matrix[v2][v1]==0)
			return true;
		else
			return false;
	}
	
	public void printAdjacentVertices(int v) {
		if(v>=numOfVertices)
			System.out.println("잘못 된 노드 선택입니다. 해당 노드는 존재하지 않습니다.");
		else {
			StringBuilder s = new StringBuilder();
			s.append(v).append("의 인접 정점 : ");
			for(int i = 0 ; i<numOfVertices ; ++i)
				if(matrix[v][i]==1)
				s.append(i).append(" ");
			
			System.out.println(s.toString());
		}
	}
	
	public boolean isInnerVertices(int v1,int v2) {
		return (0<=v1&&v1<=numOfVertices&&0<=v2&&v2<=numOfVertices)?true:false;
	}
	
	public void depthFirstSearch() {
		for(int i = 0 ; i < this.numOfVertices ; ++i)	//	false 로 초기화.
			this.visited[i] = false;
		
		for(int i = 0 ; i< this.numOfVertices ; ++i) {
			if(!this.visited[i])
				System.out.print(i+" ");
				dfs(i);
		}
	}
	
	private void dfs(int i) {
		this.visited[i] = true;
		
		for(int j = i+1 ; j<this.numOfVertices ; ++j) {
			if(this.matrix[i][j]==1) {
				if(!this.visited[j]) {
					System.out.print(j+" ");
					dfs(j);
				}
			}	
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
		
		q.offer(i);
		
		while(!q.isEmpty()) {
			int w = q.poll();
			for(int j = 0 ; j<this.numOfVertices ; ++j) {
				if(this.matrix[w][j]==1) {
					if(!this.visited[j]) {
						visited[j] = true;
						System.out.print(j+" ");
						q.add(j);
					}
				}
			}
		}
	}
}
