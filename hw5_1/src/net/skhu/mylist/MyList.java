/*
 *���ϸ� : MyList.java
 *�ۼ��� : 2017.9.21
 *�ۼ��� : 201432014 �𼳾�
 *���� : ����Ʈ �ۼ� �� ����
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

	//���ο� ���� �߰�
	public void add (int inputInt)throws ArrayIndexOutOfBoundsException, InputMismatchException {
		if(dataSize == listSize-1) {
			this.increaseListSize();
		}
		myList[dataSize] = inputInt;

		dataSize++;
	}



	//���� ����
	public int get (int idx) throws ArrayIndexOutOfDataSizeException {
		if(idx>=dataSize||idx<0) {    
			throw new ArrayIndexOutOfDataSizeException();
		}
		return myList[idx];
	}

	//���� ġȯ
	public void set (int idx, int number) throws ArrayIndexOutOfDataSizeException, InputMismatchException {
		if(idx>=dataSize||idx<0) {
			throw new ArrayIndexOutOfDataSizeException();
		}
		myList[idx] = number;
	}

	//���� ����
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

	//����Ʈ ������ ����
	public int size() {
		return dataSize;
	}

	//���� ���� �� ����
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

	//����Ʈ ũ�� �ʰ��� ����Ʈ ũ�� �ι� ����
	private void increaseListSize () {
		int listSize = this.listSize;
		this.listSize *= 2;
		int[] myList = new int[this.listSize];
		for(int i = 0 ; i<listSize ; i++) {
			myList[i] = this.myList[i];
		}
		this.myList = myList;

		System.out.println("����Ʈ�� ��ȭ�����̹Ƿ� ����Ʈ ũ�⸦ �ι�� �ø��ϴ�.\n"+listSize+"=>"+this.listSize+"\n");
	}

	//toString �������̵�
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

	//����ڰ� ȣ���� �ε����� ���� ������ �߻��Ͽ����� �˷��ִ� Ŀ���� �ͼ���
	class ArrayIndexOutOfDataSizeException extends Exception{
		@Override
		public String getMessage() {
			return String.format("�ε��� ������ �߸� �Ǿ����ϴ�. ���� ����Ʈ ũ��� %d �Դϴ�.", dataSize);
		}
	}
}
