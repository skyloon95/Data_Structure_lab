/*
 * MyLinkedStack.java
 * 2017.10.12
 * 201432014 모설아
 * MyLinkedList 구성
 */
package lab7_2;

public class MyLinkedStack {

	private Node top = null;
	
	public boolean isEmpty() {
		return top==null;
	}
	
	// 스택에 추가
	public void push(int item) {
		Node newNode = new Node(item, top);
		top = newNode;
	}
	
	// 스택의 가장 위에 있는 데이터를 삭제하고 삭제한 값을 리턴
	public int pop() throws NullPointerException {
		if(isEmpty()) {
			throw new NullPointerException();
		}else {
			int item = top.data;
			top = top.link;
			return item;
		}
	}
	
	// 스택의 가장 위에 있는 데이터를 데이터 삭제 없이 리턴
	public int peek() throws NullPointerException{
		if(isEmpty()) {
			throw new NullPointerException();
		}else {
			return top.data;
		}
	}
	
	//연결리스트 노드 구조를 표현하는 private 클래스
	private class Node {
		int data;	 // (6) 정수값을 저장할 데이터 필드 data 선언
		Node link;	 // (7) 다음 노드 참조값을 저장할 링크 필드link 선언

		Node() {
			data = 0;
			link = null;
		}

		Node(int data) {
			this.data = data;
			this.link = null;
		}

		Node(int data, Node link) {
			this.data = data;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}

	}


}
