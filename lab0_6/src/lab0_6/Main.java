/*
 *���ϸ� : Main.java
 *�ۼ��� : 2017.9.11
 *�ۼ��� : 201432014 �𼳾�
 *���� : ����̹�Ŭ����
 */
package lab0_6;

/**
 * @author snow
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("lab0_6 : �𼳾�\n");
		
		System.out.print("2���� ������ �Է��ϼ��� : ");
		
		java.util.Scanner scan = new java.util.Scanner(System.in);
		
		int x = scan.nextInt();
		int y = scan.nextInt();
		
		MyPair pair = new MyPair(x,y);
		
		System.out.println(pair.toString());
		System.out.println("�� = "+pair.sum());
		System.out.println("��� = "+pair.average());
		
		pair.swap();
		
		System.out.println("\nswap ���� ��");
		System.out.println(pair.toString());
		System.out.println("�� = "+pair.sum());
		System.out.println("��� = "+pair.average());
	}

}
