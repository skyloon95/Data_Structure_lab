/*
 * ���ϸ� : FindMax.java
 * �ۼ��� : 2017.9.2
 * �ۼ��� : 201432014 �𼳾�
 * �� �� : �ִ밪 ����
 */
package lab0_4;

import java.util.Scanner;

/**
 * @author snow
 *
 */
public class FindMax {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lab0_4 : �𼳾�\n");
		
		Scanner scan = new Scanner(System.in); // ��ĳ�� ��ü ����
		
		System.out.print("�� ������ �Է��ϼ��� : ");
		
		int num1, num2;
		
		num1 = scan.nextInt();
		num2 = scan.nextInt();
		
		System.out.println("�ִ밪 = "+maximum(num1,num2));

	}
	
	private static int maximum(int a, int b) {
		if(a>b) { // b���� a�� ũ�� a
			return a;
		}
		else { // a���� b�� ũ�� b ����
			return b;
		}
	}

}
