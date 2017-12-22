/*
 *���ϸ� : FindMax.java
 *�ۼ��� : 2017.8.31
 *�ۼ��� : 201432014 �𼳾�
 *�� �� : �ִ� ���� 
 */
package lab0_3;

/**
 * @author snow
 *
 */
public class FindMax {

	private int[] arr;
	
	public FindMax(int[] arr) {
		this.arr = arr;
	}
	
	public int getMax() {
		int maximum = arr[0];
		
		for(int i = 0 ; i<arr.length ; i++) {
			if(arr[i]>maximum) {
				maximum = arr[i];
			}
		}
		
		return maximum;
	}
}
