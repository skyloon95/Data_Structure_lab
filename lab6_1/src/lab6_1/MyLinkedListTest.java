/*
 * 파일명: MyLinkedListTest.java
 * 작성자: 201432014 모설아
 * 작성일: 2017년 9월 21일
 * 내용: MyLinkedList 객체를 생성하고 삽입, 출력 기능을 테스트하는 프로그램
 */
package lab6_1;

public class MyLinkedListTest {
	public static void main(String[] args) {
		System.out.println("lab6_1: 모설아\n");

		// 비어있는 리스트를 생성하고 출력
		MyLinkedList list = new MyLinkedList();
		list.printList();		 

		// 리스트의 앞부분에 세개의 값을 삽입하고 출력
		list.addFirst(111);
		list.printList();		 
		list.addFirst(222);
		list.printList();		 
		list.addFirst(333);
		list.printList();	

		// 리스트의 길이를 출력
		System.out.println(list.size());
	}
}
