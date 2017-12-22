/*
 *���ϸ� : MyPair.java
 *�ۼ��� : 2017.9.11
 *�ۼ��� : 201432014 �𼳾�
 *���� : �� ���� �پ��� ���� Ŭ����
 */
package lab0_6;

/**
 * @author snow
 *
 */
public class MyPair {

	private int x;
	private int y;
	
	public MyPair (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	int sum () {
		return x+y;
	}
	
	double average() {
		return (double)((x+y)/2);
	}
	
	void swap() {
		int temp =x;
		x=y;
		y=temp;
	}

	@Override
	public String toString() {
		return "MyPair [x=" + x + ", y=" + y + "]";
	}
	

}
