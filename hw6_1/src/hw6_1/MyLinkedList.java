/*
 *파일명 : MyLinkedList.java
 *작성자 : 201432014 모설아
 *작성일 : 2017.10.10
 *내용 : MyLinkedList
 */
package hw6_1;

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
	@Override
	public String toString() {
		Node temp = head;
		StringBuffer s = new StringBuffer();
		s.append("[");
		while(temp != null) {
			s.append(temp.data);
			temp = temp.link;
			if(temp != null)
				s.append(", ");
		}
		s.append("]");

		return s.toString();
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

	//리스트 맨 앞 제거 후 리턴
	public int removeFirst() throws NullPointerException {
		if(count!=0) {
			Node temp = head;	//	헤드 값을 거장
			head = temp.link;	//	헤드에 헤드.link를 저장
			this.count--;

			return temp.data;
		} else
			throw new NullPointerException();
	}

	//매개변수로 전달받은 item이 존재하는지 boolean 형태로 결과 리턴
	public boolean contains(int item) {
		Node temp = head;
		boolean itemContain = false;
		while(temp != null) {
			if(item == temp.data) {
				itemContain = true;
				break;
			}
			else
				temp = temp.link;
		}
		return itemContain;
	}

	//원하는 인덱스에 추가
	public void add(int idx, int item) throws NullPointerException {
		Node temp = head;
		Node newNode = new Node(item);
		Node llink = null;

		if(idx<=(count)) {

			if(idx==0) {
				newNode.link = temp;
				head = newNode;

				this.count++;
			} 
			else {
				for(int i = 0; i<idx ; i++) {
					llink = temp;
					temp = temp.link;
				}

				newNode.link = temp;
				llink.link = newNode;

				this.count++;
			}
		} else
			throw new NullPointerException();
	}

	//원하는 인덱스 삭제 후 원소 리턴
	public int remove(int idx) throws NullPointerException {
		Node temp = head;
		Node llink = null;
		
		if(count==0) {
			throw new NullPointerException();
		}

		if(idx<count) {

			if(idx==0) {
				head = temp.link;
				this.count--;
				return temp.data;
			}

			else {
				for(int i = 0; i<idx ; i++) {
					llink = temp;
					temp = temp.link;
				}

				llink.link = temp.link;
				this.count--;
				return temp.data;
			}
		} else
			throw new NullPointerException();
	}

	// 사용자로부터 x, y를 입력받아 리스트의 첫번째 x 뒤에 y를 삽입(x가 없으면 삽입하지 않음)
	public void targetAdd(int target, int item) throws NullPointerException {
		Node targetIdx = searchNode(target);
		Node newNode = new Node(item);

		if(targetIdx!=null) {
			newNode.link = targetIdx.link;
			targetIdx.link = newNode;
			this.count++;
		}
		else
			throw new NullPointerException();
	}

	// 사용자로부터 x를 입력받아 리스트의 첫번째 x를 삭제(x가 없으면 삭제하지 않음)
	public void targetRemove(int item) throws NullPointerException{
		Node targetIdx = searchNode(item);
		Node temp = head;

		if(targetIdx!=null) {
			if(targetIdx==head) {
				head = temp.link;
			}
			else {
				while(temp.link.data!=targetIdx.data) {
					temp = temp.link;
				}

				temp.link = targetIdx.link;
			}
		} else
			throw new NullPointerException();

		this.count--;
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
