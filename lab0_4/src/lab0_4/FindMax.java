/*
 * 파일명 : FindMax.java
 * 작성일 : 2017.9.2
 * 작성자 : 201432014 모설아
 * 설 명 : 최대값 도출
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
		System.out.println("lab0_4 : 모설아\n");
		
		Scanner scan = new Scanner(System.in); // 스캐너 객체 생성
		
		System.out.print("두 정수를 입력하세요 : ");
		
		int num1, num2;
		
		num1 = scan.nextInt();
		num2 = scan.nextInt();
		
		System.out.println("최대값 = "+maximum(num1,num2));

	}
	
	private static int maximum(int a, int b) {
		if(a>b) { // b보다 a가 크면 a
			return a;
		}
		else { // a보다 b가 크면 b 리턴
			return b;
		}
	}

}
