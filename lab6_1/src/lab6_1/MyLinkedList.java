/*
 * ���ϸ�: MyLinkedList.java
 * �ۼ���: 201432014 �𼳾�
 * �ۼ���: 2017�� 9�� 21��
 * ����: �����ڷᱸ���� ��������Ʈ�� ������ MyLinkedList Ŭ����
 */
package lab6_1;


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

	// ���Ḯ��Ʈ ��� ������ ǥ���ϴ� private Ŭ����
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
	}
}


