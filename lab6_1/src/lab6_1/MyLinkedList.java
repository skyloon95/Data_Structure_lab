/*
 * 파일명: MyLinkedList.java
 * 작성자: 201432014 모설아
 * 작성일: 2017년 9월 21일
 * 내용: 연결자료구조로 선형리스트를 구현한 MyLinkedList 클래스
 */
package lab6_1;


public class MyLinkedList {
	// (1) 인스턴스 변수 head 선언: 연결리스트의 첫번째 노드를 가리킴
	private Node head;	

	// (2) 기타 필요한 인스턴스 변수 선언
	private int count;


	// (3) 비어있는 리스트를 생성
	public MyLinkedList() {
		this.head = null;
		this.count = 0;
	}

	// (4) 리스트의 맨 앞에 item을 삽입
	public void addFirst(int item) {
		// data 필드가 item인 새로운 Node 객체를 생성(newNode)
		Node tmp = head;
		Node newNode = new Node(item,tmp);

		// head가 가리키는 연결리스트의 맨 앞에 newNode를 삽입
		this.head = newNode;
		
		this.count++;
	}

	// (5) 리스트의 길이를 리턴
	public int size() {
		return count;
	}

	// 리스트 원소들을 모두 출력
	public void printList() {
		Node temp = head;
		System.out.print("[");
		while(temp != null) {
			System.out.print(temp.data);
			temp = temp.link;
			if(temp != null)
				System.out.print(", ");
		}
		System.out.println("]");
	}

	// 리스트에서 item이 저장된 노드를 탐색하는 private 메소드 -- lab6_1에서는 사용하지 않음
	private Node searchNode(int item) {
		Node temp = head;
		while(temp != null) {
			if(item == temp.data)  
				return temp;		// 탐색 성공시 해당 노드 리턴
			else 
				temp = temp.link;
		}
		return temp;				// 탐색 실패시 null 리턴
	}

	// 연결리스트 노드 구조를 표현하는 private 클래스
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
	}
}


