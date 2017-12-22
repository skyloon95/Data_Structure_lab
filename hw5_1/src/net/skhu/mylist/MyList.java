/*
 *파일명 : MyList.java
 *작성일 : 2017.9.21
 *작성자 : 201432014 모설아
 *내용 : 리스트 작성 및 수정
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

	//새로운 원소 추가
	public void add (int inputInt)throws ArrayIndexOutOfBoundsException, InputMismatchException {
		if(dataSize == listSize-1) {
			this.increaseListSize();
		}
		myList[dataSize] = inputInt;

		dataSize++;
	}



	//원소 리턴
	public int get (int idx) throws ArrayIndexOutOfDataSizeException {
		if(idx>=dataSize||idx<0) {    
			throw new ArrayIndexOutOfDataSizeException();
		}
		return myList[idx];
	}

	//원소 치환
	public void set (int idx, int number) throws ArrayIndexOutOfDataSizeException, InputMismatchException {
		if(idx>=dataSize||idx<0) {
			throw new ArrayIndexOutOfDataSizeException();
		}
		myList[idx] = number;
	}

	//원소 삽입
	public void add(int idx, int number) throws ArrayIndexOutOfDataSizeException, InputMismatchException {
		if(idx>dataSize||idx<0) {
			throw new ArrayIndexOutOfDataSizeException();
		}
		if(dataSize == listSize-1) {
			this.increaseListSize();
		}
		for(int i = dataSize ; i>=idx ; i--) {
			myList[i+1] = myList[i];
		}

		myList[idx] = number;
		dataSize++;
	}

	//리스트 사이즈 리턴
	public int size() {
		return dataSize;
	}

	//원소 제거 후 리턴
	public int remove (int idx) throws ArrayIndexOutOfDataSizeException {
		if(idx>=dataSize||idx<0) {
			throw new ArrayIndexOutOfDataSizeException();
		}
		int tmp = myList[idx];

		for(int i = idx ; i<dataSize ; i++) {
			myList[i] = myList[i+1];
		}
		myList[dataSize--] = 0;

		return tmp;
	}

	//리스트 크기 초과시 리스트 크기 두배 증가
	private void increaseListSize () {
		int listSize = this.listSize;
		this.listSize *= 2;
		int[] myList = new int[this.listSize];
		for(int i = 0 ; i<listSize ; i++) {
			myList[i] = this.myList[i];
		}
		this.myList = myList;

		System.out.println("리스트가 포화상태이므로 리스트 크기를 두배로 늘립니다.\n"+listSize+"=>"+this.listSize+"\n");
	}

	//toString 오버라이드
	@Override
	public String toString () {
		StringBuffer buffer = new StringBuffer();

		buffer.append("[");

		buffer.append(myList[0]);

		for(int i = 1 ; i<dataSize ; i++) {
			buffer.append(", "+myList[i]);
		}
		buffer.append("]");

		String str = buffer.toString();

		return str;
	}

	//사용자가 호출한 인덱스가 논리적 오류가 발생하였음을 알려주는 커스텀 익셉션
	class ArrayIndexOutOfDataSizeException extends Exception{
		@Override
		public String getMessage() {
			return String.format("인덱스 범위가 잘못 되었습니다. 현재 리스트 크기는 %d 입니다.", dataSize);
		}
	}
}
