/*
 * 파일명: MyDoublyLinkedList.java
 * 작성자: 모설아
 * 작성일: 2017년 10월 10일
 * 내용: 이중연결자료구조로 선형리스트를 구현한 MyDoublyLinkedList 클래스
 */

package hw6_3;

public class MyDoublyLinkedList {

	private Node head;	// 리스트의 첫번째 노드를 가리킬 변수
	private int count;	// 리스트의 원소 수를 나타내는 변수

	public MyDoublyLinkedList() {
		head = null;
		count = 0;
	}

	// 리스트 길이를 리턴
	public int size() {
		return count;
	}

	// 리스트의 맨 앞에 item을 삽입
	public void addFirst(int item) {

		// (1) 데이터가 item인 새로운 노드 생성
		Node newNode = new Node(item);

		// (2) 새로운 노드를 리스트의 맨 앞에 삽입
		if(head != null) {
			newNode.rlink = head;
			head.llink = newNode;
			head = newNode;
		}
		else {
			head = newNode;
		}

		// (3) 원소 수 1 증가
		count ++;

	}

	// 리스트 맨 앞 원소 삭제후 리턴
	public int removeFirst() throws NullPointerException {
		Node tmp = head;

		if(head!=null) {
			if(head.rlink!=null) {
				tmp.rlink.llink = null;
				head = tmp.rlink;
				this.count--;
			}
			else {
				head=null;
				this.count--;
			}
		} else {
			throw new NullPointerException();
		}

		return tmp.data;
	}

	// 입력받은 값 삭제.
	public void remove(int item) {
		Node tmp = head;

		if(count!=0) {
			if(head.data==item) {
				if(count==1) {
					head=null;
					this.count--;
				}
				else {
					head = tmp.rlink;
					head.llink = null;
					this.count--;
				}
			}
			else {
				while(tmp.rlink!=null) {
					tmp = tmp.rlink;
					if(tmp.data==item) {
						if(tmp.rlink!=null) {
							tmp.rlink.llink = tmp.llink;
							tmp.llink.rlink = tmp.rlink;
							this.count--;
							break;
						} else
						{
							tmp.llink.rlink = null;
							this.count--;
						}
					}

				}

			}
		}
	}


	// 리스트가 양방향연결이 제대로 이루어졌는지 확인
	public void printLink() {
		if (head == null) {
			System.out.println("공백리스트임");
		}
		else {
			// 리스트를 순방향으로 출력
			Node temp = head;
			System.out.print("리스트 길이=" + count + " 순방향 링크: ");
			while(temp.rlink != null) {
				System.out.print(temp.data + "->");
				temp = temp.rlink;
			}
			System.out.print(temp.data);

			// 리스트를 역방향으로 출력
			System.out.print(" 역방향 링크: ");
			while(temp.llink != null) {
				System.out.print(temp.data + "->");
				temp = temp.llink;
			}
			System.out.println(temp.data);
		}
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		if (head == null) {
			return "[]";
		}
		else {
			// 리스트를 순방향으로 출력
			Node temp = head;
			buffer.append("[");
			while(temp.rlink != null) {
				buffer.append(temp.data + ",");
				temp = temp.rlink;
			}
			buffer.append(temp.data+"]");
		}
		return buffer.toString();
	}

	// 이중연결리스트 노드 구조
	private class Node {
		int data;
		Node llink; 
		Node rlink;

		Node() {
			this(0, null, null);
		}
		Node(int data) {
			this(data, null, null);
		}
		Node(int data, Node llink, Node rlink) {
			this.data = data;
			this.llink = llink;
			this.rlink = rlink;
		}
	}
}
