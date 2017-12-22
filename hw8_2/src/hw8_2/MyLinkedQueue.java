/**
 * MyLinkedQueue.java
 * 201432014 모설아
 * 2017.11.13
 * 연결리스트로 구현한 Queue
 */
package hw8_2;

import java.util.NoSuchElementException;

public class MyLinkedQueue {
	private Node head;
	private Node tail;
	
	public MyLinkedQueue() {
		this.head = null;
		this.tail = null;
	}
	
	public boolean isEmpty() {
		return this.head == null&&this.tail == null;
	}
	
	public void enQueue(int item) {
		if(isEmpty()) {
			this.head = new Node(item);
			this.tail = this.head;
		} else {
			Node newNode = new Node(item);
			this.tail.link = newNode;
			this.tail = newNode;
		}
	}
	
	public int deQueue() throws NoSuchElementException{		
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		else if(this.head==this.tail) {
			int tmp = head.data;
			this.head = null;
			this.tail = null;
			return tmp;
		}
		else {
			int tmp = this.head.data;
			this.head = this.head.link;
			return tmp;
		}
	}

}

class Node{
	public int data;
	public Node link;
	
	public Node() {
	}
	
	public Node(int item) {
		this.data = item;
		this.link = null;
	}
	
	public Node(int item, Node link) {
		this.data = item;
		this.link = link;
	}
}