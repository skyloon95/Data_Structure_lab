/*
 *���ϸ� : Maximum.java
 *�ۼ��� : 2017.8.29
 *�ۼ��� : �𼳾�
 *�� �� : ���, ��հ� �̻��� ��
 */
package lab0_2;

/**
 * @author snow
 *
 */

import java.util.Scanner; // ��ĳ�� Ŭ���� �߰�

public class Maximum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lab0_2 : �𼳾�");
		
		System.out.println("10���� ������ �Է��ϼ���.");
		
		int[] arr = new int[10]; // �迭 ����
		
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0 ; i<10 ; i++) {
			arr[i] = scan.nextInt();
		}
		
		Average a1 = new Average(arr);
		
		a1.takeAverage();
		a1.takeOverAverages();
		double avge = a1.getAverage();
		int[] oList = a1.getOverAverages();
		
		System.out.println("��� = "+avge);
		System.out.print("��� �̻��� �� : ");
		
		for(int i = 0; i< oList.length ; i++) {
			System.out.print(oList[i]+" ");
		}
	}

}
