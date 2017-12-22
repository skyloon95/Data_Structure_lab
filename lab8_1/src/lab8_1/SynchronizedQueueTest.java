/*
 * ���ϸ� : SynchronizedQueueTest.java
 * �ۼ���: 2017�� 11�� 2��
 * �ۼ���: �𼳾�
 * ����: �ϳ��� ���� ť�� �����ϴ� ������, �Һ��� �����带 �����ϴ� ���α׷�
 */
package lab8_1;

/**
 * @author user
 *
 */
public class SynchronizedQueueTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lab8_1: �𼳾�");

		// ũ�� 5�� ���� ť�� ����
		SynchronizedQueue queue = new SynchronizedQueue(5);

		// ���� ť�� �����ϴ� ������ ������, �Һ��� �����带 ����
		Thread producer1 = new ProducerThread(queue);
		Thread consumer1 = new ConsumerThread(queue);
		Thread producer2 = new ProducerThread(queue);
		Thread consumer2 = new ConsumerThread(queue);
		
		producer1.start();
		consumer1.start();
		producer2.start();
		consumer2.start();
	}

}

class ProducerThread extends Thread {
	private SynchronizedQueue queue;

	public ProducerThread(SynchronizedQueue queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for(int i = 1; i <= 20; i++) {
			System.out.println(currentThread().getName() + ": " + i + " ����");
			try {
				queue.enQueue(i);
				sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


class ConsumerThread extends Thread {
	private SynchronizedQueue queue;

	public ConsumerThread(SynchronizedQueue queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		int sum = 0;
		try {
			sleep(3000);
			for(int i = 0; i < 20; i++) {
				int value = queue.deQueue();		
				System.out.println("\t\t\t" + currentThread().getName() + ": " + value + " �Һ�");
				sum += value;
				sleep((int) (Math.random() * 500));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("�Һ��ڰ� ����� ���� �� = " + sum);
	}
}