/**
 * MyLinkedQueueTest.java
 * 201432014 모설아
 * 2017.11.13
 * 연결리스트로 구현한 큐 드라이버 클래스
 */
package hw8_2;

import java.util.Scanner;

/**
 * @author skylo
 *
 */
public class MyLinkedQueueTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hw8_2 : 모설아\n");

		MyLinkedQueue queue = new MyLinkedQueue();
		Scanner in = new Scanner(System.in);

		int userSelect = 0;

		do {
			System.out.println("\n======MyCircularQueue======\n1. 삽입  2. 삭제  3. 전체삭제  4. 종료\n");
			System.out.print("메뉴 선택 : ");
			userSelect = in.nextInt();

			switch(userSelect) {
			case 1:
				System.out.println("<<삽입>>");
				System.out.print("정수 입력 : ");
				queue.enQueue(in.nextInt());
				break;

			case 2:
				System.out.println("<<삭제>>");
				System.out.printf("삭제한 원소 : %d\n", queue.deQueue());
				break;

			case 3:
				System.out.println("<<전체 삭제>>");
				System.out.println(deleteAll(queue));
				break;

			case 4:
				break;

			default :
				System.out.println("잘못된 입력입니다.\n");
			}
		}while(userSelect!=4);	
	}
	
	private static String deleteAll(MyLinkedQueue queue) {
		StringBuilder tmp = new StringBuilder();
		
		while(!(queue.isEmpty()))
			tmp.append(queue.deQueue()).append(" ");
		return tmp.toString();
	}

}
