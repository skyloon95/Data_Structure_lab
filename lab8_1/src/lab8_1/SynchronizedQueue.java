/*
 * 파일명 : SynchronizedQueue.java
 * 작성일: 2017년 11월 2일
 * 작성자: 모설아
 * 내용: 배열로 구현한 동기화된 원형 큐
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
	private final Condition notFull  = lock.newCondition();	//	가득차지 않았다는 컨디션 생성
	private final Condition notEmpty = lock.newCondition();	//	비어있지 않다는 컨디션 생성
	private int[] array;	//	정수형 변수의 배열 array
	private int capacity;	//	큐의 크기
	private int front = 0;	//	큐의 헤드, 이 위치+1에서 제거
	private int rear = 0;	//	큐의 테일, 이 위치 +1에 추가
	
	//	원형 큐의 사이즈를 매개변수로 받는 SynchronizedQueue 생성자
	public SynchronizedQueue(int capacity) {
		this.capacity = capacity;
		array = new int[capacity];	//	사이즈만큼 배열 생성
	}
	
	//	큐가 비었는지 확인
	public boolean isEmpty() {
		return front == rear;	//	큐의 헤드와 테일이 같은곳을 가리키면 빈 것.
	}
	
	//	큐가 가득 찼는지 확인
	public boolean isFull() {
		return (rear + 1) % capacity == front; // 리
	}

	//	큐 삽입
	public void enQueue(int item) throws InterruptedException {
		lock.lock();	//	다른 쓰레드에서 현재 메소드 실행 도중 접근할 수 없게 차단.
		try {
			while (isFull()) {	//	큐가 가득찬 경우 계속해서 반복. 큐에 여유가 생기면 while 문을 종료.
				System.out.println("enQueue : 큐가 가득차서 기다립니다.");
				notFull.await();	//	현재 쓰레드가 새로운 신호를 받거나 중단될때까지 기다림. notFull 시그널을 받을때까지 대기.
			}
			rear = (rear + 1) % capacity;	//	리어의 위치를  +1 해준다. (원형큐이므로 rear+1 을 capacity로 나눈 나머지)
			array[rear] = item;	//	item을 바뀐 rear위치에 추가.
			notEmpty.signal();	//	대기중인 스레드가 있다면 그 스레드를 꺠움. notFull 이라는 시그널을 보내줌.
		} finally {
			lock.unlock();	//	try문에서 interruptedException이 발생하더라도 스레드 접근 제한을 풀어줌.
		}
	}

	public int deQueue() throws InterruptedException {
		lock.lock();
		try {
			while (isEmpty()) {	//	큐가 비어잇는 경우 계소해서 반복. 큐에 원소가 추가되면 while문을 종료.
				System.out.println("\t\tdeQueue : 큐가 비어서 기다립니다.");
				notEmpty.await();	//	현재 쓰레드가 새로운 신호를 받거나 중단될때까지 기다림. notEmpty 시그널을 받을때까지 대기.
			}
			front = (front + 1) % capacity;	//	fornt값을 +1 해준다.
			int item = array[front];	//	바뀐 front 위치에 있는 원소를 item에 저장한다.
			notFull.signal();	//	대기중인 스레드가 있다면 그 스레드를 꺠움. notEmpty 라는 시그널을 보내줌.
			return item;	//	item값을 리턴
		} finally {
			lock.unlock();
		}
	}
}