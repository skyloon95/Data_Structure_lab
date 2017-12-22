/*
 * MyLinkedStack.java
 * 2017.10.12
 * 201432014 �𼳾�
 * MyLinkedList ����
 */
package lab7_2;

public class MyLinkedStack {

	private Node top = null;
	
	public boolean isEmpty() {
		return top==null;
	}
	
	// ���ÿ� �߰�
	public void push(int item) {
		Node newNode = new Node(item, top);
		top = newNode;
	}
	
	// ������ ���� ���� �ִ� �����͸� �����ϰ� ������ ���� ����
	public int pop() throws NullPointerException {
		if(isEmpty()) {
			throw new NullPointerException();
		}else {
			int item = top.data;
			top = top.link;
			return item;
		}
	}
	
	// ������ ���� ���� �ִ� �����͸� ������ ���� ���� ����
	public int peek() throws NullPointerException{
		if(isEmpty()) {
			throw new NullPointerException();
		}else {
			return top.data;
		}
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
