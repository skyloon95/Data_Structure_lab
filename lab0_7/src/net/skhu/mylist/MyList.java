/*
 *파일명 : MyList.java
 *작성일 : 2017.9.12
 *작성자 : 201432014 모설아
 *내용 : 리스트 작성 
 */
package net.skhu.mylist;

import java.util.InputMismatchException;

/**
 * @author snow
 */
public class MyList {
	private int[] myList; // 정수 리스트
	private int listSize; // 리스트 최대 사이즈
	private int dataSize; // 리스트의 유효 자료 수
	
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
		
		System.out.println("현재 저장된 정수 배열\n"+str+"\n");
	}
	

}
