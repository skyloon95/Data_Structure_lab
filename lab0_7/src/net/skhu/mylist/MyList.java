/*
 *���ϸ� : MyList.java
 *�ۼ��� : 2017.9.12
 *�ۼ��� : 201432014 �𼳾�
 *���� : ����Ʈ �ۼ� 
 */
package net.skhu.mylist;

import java.util.InputMismatchException;

/**
 * @author snow
 */
public class MyList {
	private int[] myList; // ���� ����Ʈ
	private int listSize; // ����Ʈ �ִ� ������
	private int dataSize; // ����Ʈ�� ��ȿ �ڷ� ��
	
	public  MyList () {
		this.listSize = 10;
		this.myList = new int[listSize];
		this.dataSize = 0;
	}
	
	void add (int inputInt)throws ArrayIndexOutOfBoundsException, InputMismatchException {

		myList[dataSize] = inputInt;

		dataSize++;
	}
	
	void print () {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("[");
		
		for(int i = 0 ; i<dataSize ; i++) {
			if(i==0) {
				buffer.append(myList[i]);
			}
			else {
				buffer.append(", "+myList[i]);
			}
		}
		buffer.append("]");
		
		String str = buffer.toString();
		
		System.out.println("���� ����� ���� �迭\n"+str+"\n");
	}
	

}
