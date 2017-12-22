/*
 *���ϸ� : Main.java
 *�ۼ��� : 2017.9.5
 *�ۼ��� : 201432014 �𼳾�
 *�� �� : Main�ڵ� 
 */
package lab0_5;

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
		System.out.println("lab0_5 : �𼳾�\n");

		Scanner scan = new Scanner(System.in); // ��ĳ�� ��ü ����
		
		int lengthOfArr = 0; // �Է� ���� ����
		
		int[] arr = null;

		System.out.print("�Է��� ���� ������ �Է��ϼ��� (0 �̻��� ���� ������ �Է�) : ");

		try {
			lengthOfArr = scan.nextInt(); // ����� �Է�
			if(lengthOfArr>0) {
				arr = new int[lengthOfArr]; // �迭��ü ����.
			}
			else { // ���� ���� ������ ���� throw
				throw new InputRangeException();
			}
		} catch(InputRangeException e) {
			System.err.println(e.getMessage());
			arr = new int[2]; // �迭��ü ����Ʈ�� ����.
		} catch(InputMismatchException e) {
			System.err.println("�Է� ���� (������ ������ 2���� ���� �����մϴ�.)");
			arr = new int[2]; // �迭��ü ����Ʈ�� ����.
			scan.nextLine();
		}
		
		try { // �������� �� ��� �Է� �޽������� ���� �� �� �ְ� ������ �ɱ�.
			Thread.sleep(10);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
		
		System.out.print(arr.length +"���� ���� �Է� : ");
		
		for(int i = 0 ; i<arr.length ; i++) { // ����� �Է�
			arr[i] = scan.nextInt();
		}
		
		System.out.println("�ִ밪 = "+arr[FindMax.getMaxIndex(arr)]);
		
	}
}

class InputRangeException extends Exception {
	public InputRangeException() {
		super("�Է� ���� ���� (������ ������ 2���� ���� �����մϴ�.)");
	}
}