/*
 *파일명 : Maximum.java
 *작성일 : 2017.8.29
 *작성자 : 모설아
 *설 명 : 평균, 평균값 이상인 값
 */
package lab0_2;

/**
 * @author snow
 *
 */

import java.util.Scanner; // 스캐너 클래스 추가

public class Maximum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lab0_2 : 모설아");
		
		System.out.println("10개의 정수를 입력하세요.");
		
		int[] arr = new int[10]; // 배열 선언
		
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0 ; i<10 ; i++) {
			arr[i] = scan.nextInt();
		}
		
		Average a1 = new Average(arr);
		
		a1.takeAverage();
		a1.takeOverAverages();
		double avge = a1.getAverage();
		int[] oList = a1.getOverAverages();
		
		System.out.println("평균 = "+avge);
		System.out.print("평균 이상인 값 : ");
		
		for(int i = 0; i< oList.length ; i++) {
			System.out.print(oList[i]+" ");
		}
	}

}
