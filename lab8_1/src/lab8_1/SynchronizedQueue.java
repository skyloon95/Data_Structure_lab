/*
 * ���ϸ� : SynchronizedQueue.java
 * �ۼ���: 2017�� 11�� 2��
 * �ۼ���: �𼳾�
 * ����: �迭�� ������ ����ȭ�� ���� ť
 */
package lab8_1;

/**
 * @author user
 *
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedQueue {
	private final Lock lock = new ReentrantLock();
	private final Condition notFull  = lock.newCondition();	//	�������� �ʾҴٴ� ����� ����
	private final Condition notEmpty = lock.newCondition();	//	������� �ʴٴ� ����� ����
	private int[] array;	//	������ ������ �迭 array
	private int capacity;	//	ť�� ũ��
	private int front = 0;	//	ť�� ���, �� ��ġ+1���� ����
	private int rear = 0;	//	ť�� ����, �� ��ġ +1�� �߰�
	
	//	���� ť�� ����� �Ű������� �޴� SynchronizedQueue ������
	public SynchronizedQueue(int capacity) {
		this.capacity = capacity;
		array = new int[capacity];	//	�����ŭ �迭 ����
	}
	
	//	ť�� ������� Ȯ��
	public boolean isEmpty() {
		return front == rear;	//	ť�� ���� ������ �������� ����Ű�� �� ��.
	}
	
	//	ť�� ���� á���� Ȯ��
	public boolean isFull() {
		return (rear + 1) % capacity == front; // ��
	}

	//	ť ����
	public void enQueue(int item) throws InterruptedException {
		lock.lock();	//	�ٸ� �����忡�� ���� �޼ҵ� ���� ���� ������ �� ���� ����.
		try {
			while (isFull()) {	//	ť�� ������ ��� ����ؼ� �ݺ�. ť�� ������ ����� while ���� ����.
				System.out.println("enQueue : ť�� �������� ��ٸ��ϴ�.");
				notFull.await();	//	���� �����尡 ���ο� ��ȣ�� �ްų� �ߴܵɶ����� ��ٸ�. notFull �ñ׳��� ���������� ���.
			}
			rear = (rear + 1) % capacity;	//	������ ��ġ��  +1 ���ش�. (����ť�̹Ƿ� rear+1 �� capacity�� ���� ������)
			array[rear] = item;	//	item�� �ٲ� rear��ġ�� �߰�.
			notEmpty.signal();	//	������� �����尡 �ִٸ� �� �����带 �ƿ�. notFull �̶�� �ñ׳��� ������.
		} finally {
			lock.unlock();	//	try������ interruptedException�� �߻��ϴ��� ������ ���� ������ Ǯ����.
		}
	}

	public int deQueue() throws InterruptedException {
		lock.lock();
		try {
			while (isEmpty()) {	//	ť�� ����մ� ��� ����ؼ� �ݺ�. ť�� ���Ұ� �߰��Ǹ� while���� ����.
				System.out.println("\t\tdeQueue : ť�� �� ��ٸ��ϴ�.");
				notEmpty.await();	//	���� �����尡 ���ο� ��ȣ�� �ްų� �ߴܵɶ����� ��ٸ�. notEmpty �ñ׳��� ���������� ���.
			}
			front = (front + 1) % capacity;	//	fornt���� +1 ���ش�.
			int item = array[front];	//	�ٲ� front ��ġ�� �ִ� ���Ҹ� item�� �����Ѵ�.
			notFull.signal();	//	������� �����尡 �ִٸ� �� �����带 �ƿ�. notEmpty ��� �ñ׳��� ������.
			return item;	//	item���� ����
		} finally {
			lock.unlock();
		}
	}
}