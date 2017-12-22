/*
 *파일명 : Main.java
 *작성일 : 2017.8.31
 *작성자 : 201432014 모설아
 *설 명 : Main코드 
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
		System.out.println("lab0_3 : 모설아\n");

		Scanner scan = new Scanner(System.in); // 스캐너 객체 생성
		
		int lengthOfArr = 0; // 입력 정수 개수

		System.out.print("입력할 정수 갯수를 입력하세요 (0 이상의 양의 정수로 입력) : ");

		try {
			lengthOfArr = scan.nextInt(); // 사용자 입력
			if(lengthOfArr <=0) { // 정수 범위 오류시 오류 throw
				throw new InputRangeException();
			}
		} catch(InputRangeException e) {
			System.err.println(e.getMessage());
		} catch(InputMismatchException e) {
			System.err.println("입력 에러 (0이상의 양의 정수로 입력해야합니다.)");
		}
		
		int[] arr = new int[lengthOfArr]; // 배열객체 생성.
		
		System.out.print(lengthOfArr +"개의 정수 입력 : ");
		
		for(int i = 0 ; i<arr.length ; i++) { // 사용자 입력
			arr[i] = scan.nextInt();
		}
		
		FindMax find = new FindMax(arr);
		
		System.out.println("최대값 = "+find.getMax());
		
	}
}

class InputRangeException extends Exception {
	public InputRangeException() {
		super("입력 범위 에러 (0이상의 양의 정수로 입력해야합니다.)");
	}
}