/*
 *���ϸ� : MyLinkedList.java
 *�ۼ��� : 201432014 �𼳾�
 *�ۼ��� : 2017.10.10
 *���� : MyLinkedList
 */
package hw6_1;

public class MyLinkedList {
	// (1) �ν��Ͻ� ���� head ����: ���Ḯ��Ʈ�� ù��° ��带 ����Ŵ
	private Node head;	

	// (2) ��Ÿ �ʿ��� �ν��Ͻ� ���� ����
	private int count;


	// (3) ����ִ� ����Ʈ�� ����
	public MyLinkedList() {
		this.head = null;
		this.count = 0;
	}

	// (4) ����Ʈ�� �� �տ� item�� ����
	public void addFirst(int item) {
		// data �ʵ尡 item�� ���ο� Node ��ü�� ����(newNode)
		Node tmp = head;
		Node newNode = new Node(item,tmp);

		// head�� ����Ű�� ���Ḯ��Ʈ�� �� �տ� newNode�� ����
		this.head = newNode;

		this.count++;
	}

	// (5) ����Ʈ�� ���̸� ����
	public int size() {
		return count;
	}

	// ����Ʈ ���ҵ��� ��� ���
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

	// ����Ʈ���� item�� ����� ��带 Ž���ϴ� private �޼ҵ� -- lab6_1������ ������� ����
	private Node searchNode(int item) {
		Node temp = head;
		while(temp != null) {
			if(item == temp.data)  
				return temp;		// Ž�� ������ �ش� ��� ����
			else 
				temp = temp.link;
		}
		return temp;				// Ž�� ���н� null ����
	}

	//����Ʈ �� �� ���� �� ����
	public int removeFirst() throws NullPointerException {
		if(count!=0) {
			Node temp = head;	//	��� ���� ����
			head = temp.link;	//	��忡 ���.link�� ����
			this.count--;

			return temp.data;
		} else
			throw new NullPointerException();
	}

	//�Ű������� ���޹��� item�� �����ϴ��� boolean ���·� ��� ����
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

	//���ϴ� �ε����� �߰�
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

	//���ϴ� �ε��� ���� �� ���� ����
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

	// ����ڷκ��� x, y�� �Է¹޾� ����Ʈ�� ù��° x �ڿ� y�� ����(x�� ������ �������� ����)
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

	// ����ڷκ��� x�� �Է¹޾� ����Ʈ�� ù��° x�� ����(x�� ������ �������� ����)
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
	

	//���Ḯ��Ʈ ��� ������ ǥ���ϴ� private Ŭ����
	private class Node {
		int data;	 // (6) �������� ������ ������ �ʵ� data ����
		Node link;	 // (7) ���� ��� �������� ������ ��ũ �ʵ�link ����

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
