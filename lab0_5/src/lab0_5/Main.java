/*
 *파일명 : Main.java
 *작성일 : 2017.9.5
 *작성자 : 201432014 모설아
 *설 명 : Main코드 
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
		System.out.println("lab0_5 : 모설아\n");

		Scanner scan = new Scanner(System.in); // 스캐너 객체 생성
		
		int lengthOfArr = 0; // 입력 정수 개수
		
		int[] arr = null;

		System.out.print("입력할 정수 갯수를 입력하세요 (0 이상의 양의 정수로 입력) : ");

		try {
			lengthOfArr = scan.nextInt(); // 사용자 입력
			if(lengthOfArr>0) {
				arr = new int[lengthOfArr]; // 배열객체 생성.
			}
			else { // 정수 범위 오류시 오류 throw
				throw new InputRangeException();
			}
		} catch(InputRangeException e) {
			System.err.println(e.getMessage());
			arr = new int[2]; // 배열객체 디폴트값 생성.
		} catch(InputMismatchException e) {
			System.err.println("입력 에러 (정수의 개수를 2개로 임의 설정합니다.)");
			arr = new int[2]; // 배열객체 디폴트값 생성.
			scan.nextLine();
		}
		
		try { // 오류문이 뜰 경우 입력 메시지보다 먼저 뜰 수 있게 딜레이 걸기.
			Thread.sleep(10);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
		
		System.out.print(arr.length +"개의 정수 입력 : ");
		
		for(int i = 0 ; i<arr.length ; i++) { // 사용자 입력
			arr[i] = scan.nextInt();
		}
		
		System.out.println("최대값 = "+arr[FindMax.getMaxIndex(arr)]);
		
	}
}

class InputRangeException extends Exception {
	public InputRangeException() {
		super("입력 범위 에러 (정수의 개수를 2개로 임의 설정합니다.)");
	}
}