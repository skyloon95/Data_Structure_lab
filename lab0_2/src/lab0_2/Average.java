/*
 *���ϸ� : Average.java
 *�ۼ��� : 2017.8.29
 *�ۼ��� : �𼳾�
 *�� �� : ��� ���� 
 */
package lab0_2;

/**
 * @author snow
 *
 */
public class Average {
	private int[] arr;
	private double average;
	private int[] oList; // ��� �̻��� ������ ����
	
	public Average(int[] arr) {
		this.arr = arr;
	}
	
	public void takeAverage() { // ��� ����
		int sum = 0;
		for(int i = 0; i<arr.length; i++) {
			sum+= arr[i];
		}
		
		average = (double)sum / arr.length;
	}
	
	public double getAverage() {
		return average;
	}
	
	public void takeOverAverages() { // ��� �̻��� �� üũ.
		int count=0;
		for(int i = 0; i<arr.length; i++) { // ��� �̻� �� �� üũ
			if(arr[i]>=average) {
				count++;
			}
		}
		
		oList = new int[count]; // �迭�� �ִ� ��� �̻� ���� �� ��ŭ �迭����
		
		for(int i = 0 , j = 0; i<arr.length ; i++) { // ��� �̻� �� ����
			if(arr[i]>=average) {
				oList[j] = arr[i];
				j++;
			}
		}
	}
	
	public int[] getOverAverages() {
		return oList;
	}

}
