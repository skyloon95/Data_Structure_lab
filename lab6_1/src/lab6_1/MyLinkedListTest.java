/*
 * ���ϸ�: MyLinkedListTest.java
 * �ۼ���: 201432014 �𼳾�
 * �ۼ���: 2017�� 9�� 21��
 * ����: MyLinkedList ��ü�� �����ϰ� ����, ��� ����� �׽�Ʈ�ϴ� ���α׷�
 */
package lab6_1;

public class MyLinkedListTest {
	public static void main(String[] args) {
		System.out.println("lab6_1: �𼳾�\n");

		// ����ִ� ����Ʈ�� �����ϰ� ���
		MyLinkedList list = new MyLinkedList();
		list.printList();		 

		// ����Ʈ�� �պκп� ������ ���� �����ϰ� ���
		list.addFirst(111);
		list.printList();		 
		list.addFirst(222);
		list.printList();		 
		list.addFirst(333);
		list.printList();	

		// ����Ʈ�� ���̸� ���
		System.out.println(list.size());
	}
}
