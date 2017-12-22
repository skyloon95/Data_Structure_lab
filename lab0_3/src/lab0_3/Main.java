/*
 *���ϸ� : Main.java
 *�ۼ��� : 2017.8.31
 *�ۼ��� : 201432014 �𼳾�
 *�� �� : Main�ڵ� 
 */
package lab0_3;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author snow
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lab0_3 : �𼳾�\n");

		Scanner scan = new Scanner(System.in); // ��ĳ�� ��ü ����
		
		int lengthOfArr = 0; // �Է� ���� ����

		System.out.print("�Է��� ���� ������ �Է��ϼ��� (0 �̻��� ���� ������ �Է�) : ");

		try {
			lengthOfArr = scan.nextInt(); // ����� �Է�
			if(lengthOfArr <=0) { // ���� ���� ������ ���� throw
				throw new InputRangeException();
			}
		} catch(InputRangeException e) {
			System.err.println(e.getMessage());
		} catch(InputMismatchException e) {
			System.err.println("�Է� ���� (0�̻��� ���� ������ �Է��ؾ��մϴ�.)");
		}
		
		int[] arr = new int[lengthOfArr]; // �迭��ü ����.
		
		System.out.print(lengthOfArr +"���� ���� �Է� : ");
		
		for(int i = 0 ; i<arr.length ; i++) { // ����� �Է�
			arr[i] = scan.nextInt();
		}
		
		FindMax find = new FindMax(arr);
		
		System.out.println("�ִ밪 = "+find.getMax());
		
	}
}

class InputRangeException extends Exception {
	public InputRangeException() {
		super("�Է� ���� ���� (0�̻��� ���� ������ �Է��ؾ��մϴ�.)");
	}
}